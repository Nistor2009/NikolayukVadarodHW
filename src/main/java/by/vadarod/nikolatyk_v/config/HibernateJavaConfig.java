package by.vadarod.nikolatyk_v.config;

import by.vadarod.nikolatyk_v.entity.*;
import by.vadarod.nikolatyk_v.entity.Record;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateJavaConfig {
    private final static StandardServiceRegistryBuilder serviceRegistryBuilder;
    private final static Configuration configuration;

    static{
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/VadarodProject");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "1322");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.jcache.JCacheRegionFactory");
        properties.setProperty("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
        properties.setProperty("hibernate.javax.cache.uri", "META-INF/config/ehcache.xml");
        properties.setProperty("hibernate.javax.cache.use_query_cache", "true");

        configuration = new Configuration();
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(PrimeClient.class);
        configuration.addAnnotatedClass(SportServ.class);
        configuration.addAnnotatedClass(Building.class);
        configuration.addAnnotatedClass(SmallBuilding.class);
        configuration.addAnnotatedClass(Visitor.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Visit.class);
        configuration.addAnnotatedClass(Record.class);
        serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(properties);
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
        return sessionFactory;
    }
}
