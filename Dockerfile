FROM maven:3-openjdk-17
ADD . /etc/exampleplugin/
RUN apt update \
  && apt install -y ca-certificates curl git --no-install-recommends \
  && rm -rf /var/lib/apt/lists/*
RUN cd /etc/exampleplugin/ \
  && mvn clean package
# common for all images
ENV MAVEN_HOME /usr/share/maven
