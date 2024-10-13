FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN adduser -D appuser

COPY target/*.jar app.jar

RUN chown appuser:appuser app.jar

USER appuser

EXPOSE 8080

CMD ["java", "-jar", "app.jar"] 
