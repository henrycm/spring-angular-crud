Instrucciones
==============

Prerequisitos
--------------
- Gradle: https://gradle.org/
- NodeJS: https://nodejs.org/en/ Solo si se quiere actualizar y ensamblar el frontend.

Ejecutar la aplicacion
--------------
Ejecutar: **gradle build && java -jar build/libs/facturacion-1.0.0.jar**


Ejecutar la aplicacion en el IDE
--------------
La aplicacion consiste en un backend en java y un frontend en JavaScript (React). La forma de trabajar en react es con NodeJS para tener hotReload and React dev tools. El artefacto final es bundle.js que contiene todo el frontend.

- Start el backend en el IDE
- Instalar los paquetes del projecto frontend (solo la primera vez), estando en directorio *frontend*: npm install
- Start el frontend con Node, estando en directorio *"frontend"*: **npm start**
- El frontend se ejecuta en http://localhost:3000, tiene un proxy para llamar el backend -> htttp://localhost:8080


Ensamblado
--------------
En el momednto de ensamblar **gradle build** se ejecuta la tarea de gradle **copyFront** que copia el contenido de *frontend/app* to *build/resources/main/static*
