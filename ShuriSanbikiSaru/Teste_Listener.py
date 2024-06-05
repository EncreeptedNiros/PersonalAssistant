from vosk import Model, KaldiRecognizer
import pyaudio
import requests
import json
import winsound

model = Model('pt/vosk-model-small-pt-0.3')
recognizer = KaldiRecognizer(model, 16000)

cap = pyaudio.PyAudio()
stream = cap.open(format=pyaudio.paInt16, channels=1, rate=16000, input=True, frames_per_buffer=8192)
stream.start_stream()
flag = 0
wake = json.dumps({'text': 'sombra'})
wakeresponse = json.dumps({'responsetext': 'olá senhor'})
while True:
    data = stream.read(4096)
    if recognizer.AcceptWaveform(data):

        if flag == 0:
            info = json.loads(recognizer.FinalResult())
            if info == json.loads(wake):
                response = requests.post('https://localhost:7199/Responses/', json = wakeresponse, verify = False)
                flag = 1
        elif flag == 1:
        
            info = json.loads(recognizer.FinalResult())
            response = requests.post('https://localhost:7199/Interpretation/', json = info, verify = False)
            print(info)
            print(response.status_code)
            flag = 0