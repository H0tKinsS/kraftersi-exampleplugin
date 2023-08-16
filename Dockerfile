FROM eclipse-temurin:17-jdk
ADD . /etc/exampleplugin/
RUN apt-get update \
  && apt-get install -y ca-certificates curl git --no-install-recommends \
  && rm -rf /var/lib/apt/lists/* \
  && ls \
  && cd /etc/exampleplugin/ \
  && ls
RUN wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz \
  && tar -xvf apache-maven-3.6.3-bin.tar.gz \
  && mv apache-maven-3.6.3 /opt/ \
  && M2_HOME='/opt/apache-maven-3.6.3' \
  && PATH="$M2_HOME/bin:$PATH" \
  && export PATH \
  && mvn --version
# common for all images
ENV MAVEN_HOME /usr/share/maven
