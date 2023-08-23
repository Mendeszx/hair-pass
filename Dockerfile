FROM openjdk:17-alpine

WORKDIR /app

COPY target/hair-pass-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

LABEL maintainer="hair-pass-app"

CMD ["java", "-jar", "app.jar"]
