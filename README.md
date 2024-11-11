<h1 align="center">Practicando con Java: Challenge Conversor de Monedas</h1>

<h2>Descripción del proyecto</h2>

Este es un proyecto de consola en Java que permite convertir entre diversas divisas utilizando la **Exchange Rate API** para obtener las tasas de cambio.
El programa permite realizar conversiones entre varias monedas, ver el historial de conversiones y guardarlo en un archivo JSON.

<h2>Funcionalidades</h2>

- Conversión entre monedas como Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL), Peso Colombiano (COP), Euro (EUR) y Peso Chileno (CLP).
- Opción para que el usuario ingrese su propio par de divisas y realice conversiones personalizadas.
- Visualización del historial de conversiones realizadas.
- Guardado del historial de conversiones en un archivo `historial.json`.

<h2>Requisitos</h2>

- **Java 17 o superior** (el proyecto fue desarrollado y probado con Java 17)
- **Google Gson** para la serialización y deserialización del archivo JSON.

<h2>Instalación</h2>

1. Clona el repositorio en tu máquina local:
    ```bash
    git clone https://github.com/tu-usuario/conversor-de-moneda.git
    ```

2. Entra en el directorio del proyecto:
    ```bash
    cd conversor-de-moneda
    ```

3. Asegúrate de tener el JDK de Java 17 o superior instalado. Si no lo tienes, puedes descargarlo e instalarlo desde la página oficial de [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

4. Compila y ejecuta el proyecto:
    ```bash
    javac -cp . ConversorDeMoneda.java ConsultaMoneda.java GeneradorDeArchivoJson.java Principal.java Conversion.java
    java -cp . Principal
    ```

<h2>Uso</h2>

Una vez que ejecutes el programa, verás el siguiente menú donde podrás elegir la opción deseada:

*****************************************
Bienvenido a nuestro conversor de monedas
*** Escriba el número de la opción deseada ***
1) Dólar a Peso Argentino
2) Peso Argentino a Dólar
3) Dólar a Real Brasileño
4) Real Brasileño a Dólar
5) Dólar a Peso Colombiano
6) Peso Colombiano a Dólar
7) Dólar a Euro
8) Euro a Dólar
9) Dólar a Peso Chileno
10) Peso Chileno a Dólar
11) Mostrar historial de conversiones
12) Guardar historial en archivo JSON
13) Salir
Eliga una opción:

<h2>Autores del proyecto</h2>
Este "Practicando con Java: Challenge Conversor de Monedas" es desarrollado por Alexis Vergara, Chileno, principiante en el mundo de la programación.
