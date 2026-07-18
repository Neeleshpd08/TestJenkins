FROM selenium/standalone-chrome:latest

USER root

RUN apt-get update && apt-get install -y \
    maven \
    openjdk-17-jdk

WORKDIR /app

COPY . .

CMD ["mvn", "clean", "test"]