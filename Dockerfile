FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /app
COPY app/pom.xml .
COPY app/src src/
RUN mvn clean package

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]