FROM maven:3-openjdk-17
ADD . /etc/exampleplugin/
RUN cd /etc/exampleplugin/ \
  && mvn clean package
# common for all images
ENV MAVEN_HOME /usr/share/maven
