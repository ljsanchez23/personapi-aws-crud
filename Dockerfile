FROM eclipse-temurin:17.0.12_7-jdk

EXPOSE 8080

WORKDIR /app

COPY ./build/libs/personapi.jar /app/personapi.jar

ENTRYPOINT ["java", "-jar", "/app/personapi.jar"]