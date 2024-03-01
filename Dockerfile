FROM openjdk:8

WORKDIR /usrapp/bin

ARG PORT_WEB 
ENV PORT_WEB $PORT_WEB

ENV PORT 46000

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.eci.arep.ASE.app.SparkWebServer"]