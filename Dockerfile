FROM openjdk:17
COPY ./target/AulaEmprendimiento-0.0.1-SNAPSHOT.jar /
WORKDIR /
ENTRYPOINT ["java","-jar","AulaEmprendimiento-0.0.1-SNAPSHOT.jar"]