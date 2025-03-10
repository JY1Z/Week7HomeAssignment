FROM maven:3.9.4-eclipse-temurin-21 AS build
LABEL authors="Jiayu"

WORKDIR /app

COPY pom.xml /app/

COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/timetracker.jar"]

#ENTRYPOINT ["top", "-b"]