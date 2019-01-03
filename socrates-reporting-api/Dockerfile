FROM openjdk:8-jdk-slim
ENV PORT 5020
EXPOSE 5020
COPY target/socrates-reporting-api-0.0.1-SNAPSHOT.jar /opt/
WORKDIR /opt
CMD ["java","-jar","socrates-reporting-api-0.0.1-SNAPSHOT.jar"]