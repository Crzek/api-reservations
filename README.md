# Microservicios con Java

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


## Requerimientos

Para poder desarrollar las distintas cosas que se veran a lo largo del curso necesitas tener instalado:
- [Java](https://www.oracle.com/ar/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

Si no tiene algunas de estas herramientas instaladas en su computadora, siga las instrucciones en la documentación oficial de cada herramienta.

## Como chequeamos si cumplimos los requerimientos?

Si instaló en su computadora algunas de estas herramientas anteriormente o instaló todas las herramientas ahora, verifique si todo funciona bien.
- Para comprobar si la version de Java es 17 o superior que tiene instalada tienes que usar el siguiente comando:
   ````
   % java -version
   openjdk 17.0.6 2023-01-17 LTS
   OpenJDK Runtime Environment Microsoft-7209853 (build 17.0.6+10-LTS)
   OpenJDK 64-Bit Server VM Microsoft-7209853 (build 17.0.6+10-LTS, mixed mode, sharing)
   ````
- Para comprobar si la version de Maven es 3.0.0 o superior. Puedes ver qué versión de Maven tienes que usar el siguiente comando:
   ````
   % mvn --version
   Apache Maven 3.0.0
   Maven home: /usr/share/maven
   ````
- Para comprobar si la versión de Docker en su computadora es 18.09.0 o superior. Puede verificar la versión de Docker usando el siguiente comando:
   ````
   % docker --version
   Docker version 18.09.0, build 369ce74a3c
   ````

## Como ejecutar el microservicio de catalogo?

Para ejecutar el microservicio, siga estos pasos:

1. Ejecuta el comando `docker-compose up` en el directorio donde tengas guardado el archivo `docker-compose.yml`
2. Verica si el microservicio se encuentra funcionando, puedes hacerlo ingregando al [Swagger](http://localhost:6070/api/flights/catalog/documentation)
