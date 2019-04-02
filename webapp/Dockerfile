FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/ROOT.jar
COPY ${JAR_FILE} app.jar
<<<<<<< HEAD
=======

>>>>>>> 6f51d686235ae7528b44cfd899492e5f7ab48d79
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
