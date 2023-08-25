FROM openjdk:17-alpine

ENV DB_URL=value1
ENV DB_USER=value2
ENV DB_PASSWORD=value3

WORKDIR /app

COPY target/hair-pass-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

LABEL maintainer="hair-pass-app"

CMD ["java", "-jar", "app.jar"]
