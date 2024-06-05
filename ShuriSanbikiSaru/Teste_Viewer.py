import cv2
import mediapipe as mp
from mediapipe.python.solutions.drawing_utils import _normalized_to_pixel_coordinates
import math
import numpy as np

import requests
import json

video = cv2.VideoCapture(0)
hands = mp.solutions.hands
Hands = hands.Hands(max_num_hands=2)
mpDwaw = mp.solutions.drawing_utils
flag = 0
contador = 0
contador1 = 0
while True:
    success, img = video.read()
    frameRGB = cv2.cvtColor(img,cv2.COLOR_BGR2RGB)
    results = Hands.process(frameRGB)
    handPoints = results.multi_hand_landmarks
    h, w, _ = img.shape
    pontos = []
    
    if handPoints:
        for points in handPoints:
            mpDwaw.draw_landmarks(img, points,hands.HAND_CONNECTIONS)
            #podemos enumerar esses pontos da seguinte forma
            for id, cord in enumerate(points.landmark):
                cx, cy = int(cord.x * w), int(cord.y * h)
                cv2.putText(img, str(id), (cx, cy + 10), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (255, 0, 0), 2)
                pontos.append((cx,cy))
            dedos = [8,12,16,20]
            
            if pontos:
                if flag == 0:
                    if pontos[6][1] - pontos[4][1] > -10 and pontos[6][1] - pontos[4][1] < 10 and pontos[20][1] > pontos[17][1] and pontos[16][1] > pontos[13][1] and pontos[12][1] > pontos[9][1] and pontos[8][1] > pontos[5][1] and pontos[5][0] - pontos[17][0] > 50 and pontos[5][0] - pontos[17][0] < 250 and flag == 0:
                        flag = 1
                elif flag == 1:
                    if pontos[12][0] - pontos[8][0] < 15 and pontos[12][0] - pontos[8][0] > -15 and pontos[20][1] > pontos[18][1] and pontos[16][1] > pontos[14][1] and pontos[12][1] < pontos[11][1] and pontos[8][1] < pontos[7][1]:
                        if contador == 0 and contador1 == 0:
                            info = json.dumps({'text': '#hand1'})
                        elif contador == 1 and contador1 == 0:
                            info = json.dumps({'text': '#hand2'})
                        elif contador == 0 and contador1 == 1:
                            info = json.dumps({'text': '#hand3'})
                        elif contador == 1 and contador1 == 1:
                            info = json.dumps({'text': '#hand4'})
                        response = requests.post('https://localhost:7199/Interpretation/', json = json.loads(info), verify = False)
                        print(info)
                        flag = 0
                        contador = 0
                        contador1 = 0
                    elif pontos[20][0] - pontos[8][0] < -90 and pontos[20][0] - pontos[8][0] > -180 and pontos[20][1] < pontos[18][1] and pontos[16][1] > pontos[14][1] and pontos[12][1] > pontos[11][1] and pontos[8][1] < pontos[7][1]:
                        contador = 1
                    elif pontos[20][1] < pontos[18][1] and pontos[16][1] < pontos[14][1] and pontos[12][1] < pontos[10][1] and pontos[8][1] - pontos[4][1] < 0 and pontos[8][1] - pontos[4][1] > -50:
                        contador1 = 1
                    elif pontos[12][0] - pontos[8][0] < -120 and pontos[20][1] > pontos[18][1] and pontos[16][1] > pontos[14][1] and pontos[12][1] < pontos[11][1] and pontos[8][1] < pontos[7][1]:
                        print('sei lá')
                        flag = 0
                        contador = 0
                        contador1 = 0

            
            cv2.rectangle(img, (80, 10), (200,110), (255, 0, 0), -1)
            cv2.rectangle(img, (220,10), (340,110), (255, 0, 0), -1)
            cv2.rectangle(img, (380,10), (500,110), (255, 0, 0), -1)
            cv2.putText(img,str(flag),(100,100),cv2.FONT_HERSHEY_SIMPLEX,4,(255,255,255),5)
            cv2.putText(img,str(contador),(240,100),cv2.FONT_HERSHEY_SIMPLEX,4,(255,255,255),5)
            cv2.putText(img,str(contador1),(400,100),cv2.FONT_HERSHEY_SIMPLEX,4,(255,255,255),5)
            
            print(pontos[8][1] - pontos[4][1])
    cv2.imshow('Imagem',img)
    if cv2.waitKey(5) & 0xFF == ord('q'):
        break
