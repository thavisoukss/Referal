# FROM openjdk:17-jdk
#
# # Set timezone
# # Always have Bangkok timezone file beside Dockerfile
# #COPY Bangkok /etc/localtime
# RUN echo "Asia/Bangkok" > /etc/timezone && date
#
# # Fix DNS resolution issues when nss is not installed
# RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf
#
# # Set DNS cache to 10 seconds (Cache is permanent by default). Network hosts are volatile in Docker clusters.
# RUN grep '^networkaddress.cache.ttl=' /usr/local/openjdk-17/conf/security/java.security || echo 'networkaddress.cache.ttl=10' >> /usr/local/openjdk-11/conf/security/java.security
#
# ENV APP_HOME /usr/apps
# WORKDIR $APP_HOME
#
# ENV PORT 9035
# EXPOSE $PORT
# COPY target/*.jar ./
#
# ENTRYPOINT ["sh", "-c"]
# CMD ["exec java -jar $(ls | grep .jar -m 1)"]

FROM eclipse-temurin:17.0.6_10-jre-alpine

# Labels
LABEL author="Ibank infomation service"

# Set the timezone to GMT+7
ENV TZ=Asia/Bangkok

# Copy the application JAR file to the container
RUN mkdir /app
COPY ./target/*.jar /app/run.jar

# Expose port 4400 for the container
EXPOSE 2100

# Set the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "-Duser.timezone=GMT+7","/app/run.jar"]