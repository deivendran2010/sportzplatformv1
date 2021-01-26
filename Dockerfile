FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 7777

ADD /target/sportzplatform.jar sportzplatform.jar
ENTRYPOINT ["java","-jar","sportzplatform.jar"]