FROM maven:3.9 as builder
COPY .  /code/
WORKDIR /code
RUN mvn package

FROM eclipse-temurin:17.0.6_10-jre
COPY --from=builder /code/target/*.jar /usr/app/app.jar
WORKDIR /usr/app
CMD [ "java", "-jar", "app.jar" ]

# "--spring.mail.username= ","spring.mail.password="]