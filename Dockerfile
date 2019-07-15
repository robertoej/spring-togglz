FROM maven:3.6.0-jdk-8-alpine

COPY ./target/togglz*.jar togglz-app.jar

CMD java -jar togglz-app.jar