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

Run the application
--------------
- Start the backend: **gradle clean bootRun**
- From *"frontend"* directory:
- **npm install**
- **npm start**
- The front end will start at http://localhost:4200, with a proxy to access the backend -> htttp://localhost:8080


Assembly process
--------------
When assembling **copyFront** is executed copying the contents from *frontend/app* to *build/resources/main/static*

Test
--------------
Run **gradle clean test**