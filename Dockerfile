# Use a imagem base do OpenJDK 17
FROM eclipse-temurin:17-jre-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Adicione um usuário não privilegiado
RUN adduser -D appuser

# Copie o arquivo JAR para o contêiner
COPY target/*.jar app.jar

# Altere a propriedade do arquivo JAR para o usuário não privilegiado
RUN chown appuser:appuser app.jar

# Mude para o usuário não privilegiado
USER appuser

# Exponha a porta da aplicação
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
