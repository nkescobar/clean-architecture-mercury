FROM openjdk:17-alpine
ENV TZ=America/Bogota
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENV APP_FILE applications-app-service-1.1.jar
ENV APP_HOME /usr/apps
EXPOSE 8080
RUN mkdir -p $APP_HOME
COPY applications/app-service/build/libs/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]