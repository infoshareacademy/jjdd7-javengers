FROM jboss/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin123 --silent
ADD target/web.war opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh","-b","0.0.0.0","-bmanagement","0.0.0.0"]