import pyttsx3
import requests
import json
import time

engine = pyttsx3.init('sapi5')
lastid = 0
vol = 1.0
ppm = 180
urli = 'https://localhost:7199/response?'
firstrun = 0

engine.setProperty('rate', ppm)
engine.setProperty('volume', vol)
while True:
    #response = '{"id":0, "response":"Qual foi, sua piranha"}'
    urli = 'https://localhost:7199/response?skip='+str(lastid)+'&take=1' 
    response = requests.get(urli, verify = False)
    
    if response.text == '[]':
        print("Não existe conteudo")
        time.sleep(1)
    else:
        response = json.loads(response.content)
        print(response)
        response = response[0]
        if firstrun == 0:
            lastid = -1
            firstrun = 1
        if lastid <= response["id"]:
            if response["responsetext"] == "vou falar mais baixo":
                if vol > 0:
                    vol = vol - 0.2
                    engine.setProperty('volume', vol)
                    engine.say(response["responsetext"])
                    engine.runAndWait()
                    lastid = response["id"] +1
                else:
                    engine.say("Não consigo falar mais baixo")
                    engine.runAndWait()
                    lastid = response["id"] + 1
            elif response["responsetext"] == "vou falar mais alto":
                if vol < 1:
                    vol = vol + 0.2
                    engine.setProperty('volume', vol)
                    engine.say(response["responsetext"])
                    engine.runAndWait()
                    lastid = response["id"] + 1
                else:
                    engine.say("Não consigo falar mais alto")
                    engine.runAndWait()
                    lastid = response["id"] + 1
            else:
                engine.say(response["responsetext"])
                engine.runAndWait()
                lastid = response["id"] + 1
    