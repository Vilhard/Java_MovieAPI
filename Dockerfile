FROM gradle:jdk17 AS gradle
WORKDIR /app
COPY . .
RUN gradle bootJar

FROM openjdk:17 as runtime
WORKDIR /app
ENV PORT 8080
ENV SPRING_PROFILE production
ENV DATABASE_URL ""
ENV ISSUER_URL "http://localhost:8083/auth/realms/demo"
ENV JWKS_URI "http://keycloak:8080/auth/realms/demo/protocol/openid-connect/certs"
ENV CLIENT_ID "client-id"
ENV CLIENT_SECRET "client-secret"
ENV DDL_AUTO "create"
ENV APP_ORIGIN "http://localhost:3000"
COPY --from=gradle /app/build/libs/*.jar /app/app.jar
RUN chown -R 1000:1000 /app
USER 1000:1000
ENTRYPOINT ["java", "-jar", "app.jar"]
