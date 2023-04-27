# Imagen base
FROM openjdk:17

# Se crea el directorio de trabajo
RUN mkdir /usr/src/TMQWeb

# Se establece el directorio de trabajo
WORKDIR /usr/src/TMQWeb

# Se copia el .jar al directorio
COPY ./TalleresMcQueen-0.1.0-SNAPSHOT.jar /usr/src/TMQWeb

# Indicamos un puerto de apertura para conectarnos
EXPOSE 8443

# Se inicia la aplicacion
CMD [ "java", "-jar", "./TalleresMcQueen-0.1.0-SNAPSHOT.jar"]
