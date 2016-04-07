package be.hubrussel.brainstorm2015wa2;

import be.hubrussel.brainstorm.dao.*;
import be.hubrussel.brainstorm.service.BrainstormSessieService;
import be.hubrussel.brainstorm.service.BrainstormSessieServiceImpl;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;     


@Configuration
public class ApplicationConfig {
    
    @Bean
    public BasicDataSource datasource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/brainstorm13");
        ds.setUsername("brainstorm13user");
        ds.setPassword("brainstorm13userpw");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        ds.setDefaultTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
        return ds;
    }
    
    @Bean (destroyMethod="close")
    public SessionFactory sessionFactory() throws Exception{
    	LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(datasource());
        sf.setPackagesToScan(new String[]{"be.hubrussel.brainstorm.domain"});
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        sf.setHibernateProperties(hibernateProperties);
        sf.afterPropertiesSet();                 // omdat deze configuratie wijze ...
        return (SessionFactory) sf.getObject();  // nog wat scherpe kantjes heeft
    }
    
    @Bean
    public PersoonDao persoonDao(){
        return new PersoonHibernateDao();
    }
    
    @Bean
    public HibernateTransactionManager transactionManager() throws Exception{
        return new HibernateTransactionManager(sessionFactory());
    }
    
    @Bean
    public BrainstormSessieService brainstormSessieService(){
        BrainstormSessieService bss = new BrainstormSessieServiceImpl();
        return bss;
    }
}
