FROM eclipse-temurin:17.0.13_11-jdk

WORKDIR /root

# Instalar Gradle
RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://services.gradle.org/distributions/gradle-7.6-bin.zip -P /tmp && \
    unzip /tmp/gradle-7.6-bin.zip -d /opt && \
    ln -s /opt/gradle-7.6/bin/gradle /usr/bin/gradle

COPY ./settings.gradle /root
COPY ./build.gradle /root/

# Descargar las dependencias con Gradle
RUN gradle build --refresh-dependencies --no-daemon


# COPIAR EL ARCHIVO JAR AL CONTENEDOR
COPY build/libs/Sena-Market-0.0.1-SNAPSHOT.jar /root/app.jar

# LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
ENTRYPOINT ["java", "-jar", "/root/app.jar"]

