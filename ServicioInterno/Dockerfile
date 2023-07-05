# Imagen base
FROM openjdk:11

# Se crea el directorio de trabajo
RUN mkdir /usr/src/TMQIntServ

# Se establece el directorio de trabajo
WORKDIR /usr/src/TMQIntServ

# Se copia el .jar al directorio
COPY ./InternalService-0.0.1-SNAPSHOT.jar /usr/src/TMQIntServ

# Se inicia la aplicacion y se especifica el correo usado
CMD [ "java", "-jar", "./InternalService-0.0.1-SNAPSHOT.jar", "--spring.mail.username= ","spring.mail.password="]