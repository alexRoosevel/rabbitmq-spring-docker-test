FROM openjdk:11

WORKDIR /app

COPY target/*.jar /app/

EXPOSE 9000

ENTRYPOINT exec java -jar /app/*.jar --server.port=9000



