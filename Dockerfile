# 1. Java 21 런타임 환경 사용
FROM openjdk:21-jdk-slim

# 2. 애플리케이션 JAR 파일을 컨테이너로 복사
ARG JAR_FILE=target/racosme-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# 3. 컨테이너 시작 시 실행할 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]
