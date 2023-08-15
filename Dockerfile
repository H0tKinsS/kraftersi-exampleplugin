FROM eclipse-temurin:17-jdk

RUN apt-get update \
  && apt-get install -y ca-certificates curl git --no-install-recommends \
  && rm -rf /var/lib/apt/lists/* \
  && ls
# common for all images
ENV MAVEN_HOME /usr/share/maven
