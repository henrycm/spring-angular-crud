spring-angular-crud
==============
The goal is to put together some cool technologies/libraries to create modern web applications, including:
- Spring core
- Spring boot
- Spring data
- Spring security
- Gatling (load testing)
- Activemq
- Angular, Anglular-cli
- Aws deployment

Prerequisites
--------------
- Gradle: https://gradle.org/
- NodeJS: https://nodejs.org/en/ To assemble the frontend

Running the application
--------------
 **gradle build && java -jar build/libs/facturacion-1.0.0.jar**


Run the application from the IDE
--------------
- Start the backend from the IDE
- From *"frontend"* directory:
- **npm install**
- **npm start**
- The front end will start at http://localhost:3000, with a proxy to access the backend -> htttp://localhost:8080


Assembly process
--------------
When assembling **copyFront** is executed copying the contents from *frontend/app* to *build/resources/main/static*
