FROM maven:3.9 as builder
COPY TalleresMCQueen/ /code/
WORKDIR /code
RUN mvn package

FROM openjdk:17-jre
COPY --from=builder /code/target/*.jar /usr/app/app.jar
WORKDIR /usr/app
CMD [ "java", "-jar", "app.jar" ] 
