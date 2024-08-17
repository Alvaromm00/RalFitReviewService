# Usa una imagen base de OpenJDK
FROM openjdk:18-oraclelinux7

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR generado por Maven en el contenedor
COPY review-0.0.1-SNAPSHOT.jar /app/review.jar

# Copia el la BBDD al contenedor
COPY reviewsRalfit.db /app/reviewsRalfit.db

# Expone el puerto en el que se ejecuta la aplicación
EXPOSE 8081

# Define el comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/review.jar"]
