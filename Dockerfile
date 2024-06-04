FROM maven:3.9.6-amazoncorretto-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -Dmaven.test.skip

FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar /app/application.jar

EXPOSE 8080

CMD ["java", "-jar", "application.jar"]