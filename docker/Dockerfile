FROM tomcat:8.5.11
MAINTAINER Borgy Manotoy <borgymanotoy@ujeaze.com>

# Copy configurations (Tomcat users, Manager app)
ADD tomcat-users.xml /usr/local/tomcat/conf/
ADD context.xml /usr/local/tomcat/webapps/manager/META-INF/
#ADD spring-mvc-xml-demo.war /usr/local/tomcat/webapps/
