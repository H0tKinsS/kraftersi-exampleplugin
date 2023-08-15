FROM eclipse-temurin:17-jdk
ADD . /etc/exampleplugin/
RUN apt-get update \
  && apt-get install -y ca-certificates curl git --no-install-recommends \
  && rm -rf /var/lib/apt/lists/* \
  && ls \
  && cd /etc/exampleplugin/ \
  && ls
RUN mvn clean package
# common for all images
ENV MAVEN_HOME /usr/share/maven
