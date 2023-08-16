FROM maven:3-openjdk-17
WORKDIR /etc/exampleplugin/
ADD . /etc/exampleplugin/
RUN cd /etc/exampleplugin/ \
  && mvn clean package
VOLUME /etc/exampleplugin

