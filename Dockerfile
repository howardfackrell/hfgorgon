FROM quay.octanner.io/base/oct-java:8-oraclejdk


RUN wget https://services.gradle.org/distributions/gradle-3.1-bin.zip
RUN unzip gradle-3.1-bin.zip

COPY . /

RUN gradle-3.1/bin/gradle build -x test

CMD java -jar build/libs/hfgorgon-0.0.1-SNAPSHOT.jar --server.port=$PORT