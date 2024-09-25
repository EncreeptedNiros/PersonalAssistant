#Usando OpenJDK como imagem base
FROM openjdk as Builder

RUN mkdir /app

COPY . /app

WORKDIR /app

RUN javac main.java

CMD java main