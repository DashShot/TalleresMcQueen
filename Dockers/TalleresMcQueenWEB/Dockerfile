# Imagen base
FROM openjdk:11

# Se crea el directorio de trabajo
RUN mkdir /usr/src/TMQWeb

# Se establece el directorio de trabajo
WORKDIR /usr/src/TMQWeb

# Se copia el .jar al directorio
COPY ./.jar /usr/src/TMQWeb

# Indicamos un puerto de apertura para conectarnos
EXPOSE 8443

# Se inicia la aplicacion
CMD [ "java", "-jar", "./TalleresMcQueen-0.1.0-SNAPSHOT.jar"]
