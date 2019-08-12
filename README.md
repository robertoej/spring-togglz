# Togglz + Spring Boot Example
This project exemplifies how to integrate [Togglz](https://www.togglz.org/) and Spring Boot applications. It uses a redis server to maintain feature states, thus, it builds and starts up when running the project. In addition, it enables feature flag management via console.
### Running the project
In order to run the application, run the following commands:
```
mvn clean package
docker-compose build
docker-compose up
```
The application runs on port 8080.
### Managing features flags
The feature flag management console is avaialable at the path `/togglz-console`. In order to access it, the user must be authenticated. The credentials are:
```
user: admin
password: secret
```
**Warning**: *sharing access credentials is not recommended in production environments at all*.
### API Spec
The only available API is `/time/now`. When the feature flag `NOW_API` is available, it will return a text based representation of the current time. Otherwise, it will return a message indicating that the API is disabled.
