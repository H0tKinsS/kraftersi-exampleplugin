FROM adoptopenjdk/maven-openjdk11:latest
ADD . /etc/exampleplugin/
RUN apt-get update \
  && apt-get install -y ca-certificates curl git --no-install-recommends \
  && rm -rf /var/lib/apt/lists/*
RUN cd /etc/exampleplugin/ \
  && mvn clean package
# common for all images
ENV MAVEN_HOME /usr/share/maven
