package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.exemplebeans.FakeDataSource;
import guru.springframework.sfgdi.exemplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//V1
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
//V2 pour MultiplePropertyFiles
/*@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})*/
public class PropertyConfig {

    //Test Env Properties
    @Autowired
    Environment env;

    @Value("${afcepf.username}")
    String user;

    @Value("${afcepf.password}")
    String password;

    @Value("${afcepf.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        //Test PropertySource
       // fakeDataSource.setUser(user);
        //Test Env Properties
        fakeDataSource.setUser(env.getProperty("JAVA_HOME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    //Test Multiple Property Files
    @Value("${afcepf.jms.username}")
    String jmsUsername;

    @Value("${afcepf.jms.password}")
    String jmsPassword;

    @Value("${afcepf.jms.url}")
    String jmsUrl;

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUsername);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return fakeJmsBroker;
    }








//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties(){
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        return propertySourcesPlaceholderConfigurer;
//    }
}
