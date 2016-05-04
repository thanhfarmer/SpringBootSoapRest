package com.cubetech.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.cubetech.utils.Constant;

@EnableWs
@Configuration
public class ApplicationConfig extends WsConfigurerAdapter {
         
    private static final String SCHEMA_LOCATION = "META-INF/schemas/bridgesms.xsd";
    private static final String PORTTYPE_NAME = "moPort";
 
    @Bean
    public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(false);
        return new ServletRegistrationBean(servlet, "/soap/*");
    }
 
    @Bean(name = "moReceiver")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema getSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(PORTTYPE_NAME); 
        wsdl11Definition.setLocationUri("/soap/mo");
        wsdl11Definition.setTargetNamespace(Constant.NAMESPACE_URI);
        wsdl11Definition.setSchema(getSchema);
        return wsdl11Definition;
    }       
 
    @Bean
    public XsdSchema getSchema() {
        return new SimpleXsdSchema(new ClassPathResource(SCHEMA_LOCATION));
    }
 
}