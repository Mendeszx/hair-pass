FROM adoptopenjdk:17-jdk-hotspot

WORKDIR /app

COPY target/meu-projeto-spring.jar app.jar

CMD ["java", "-jar", "app.jar"]
