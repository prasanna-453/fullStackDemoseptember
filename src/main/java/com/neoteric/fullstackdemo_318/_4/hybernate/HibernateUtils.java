package com.neoteric.fullstackdemo_318._4.hybernate;


import com.neoteric.fullstackdemo_318._4.model.AccountEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            Configuration configuration=new Configuration();

            Properties properties=new Properties();
            properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL,"jdbc:mysql://@localhost:3606/bank");
            properties.put(Environment.USER,"root");
            properties.put(Environment.PASS,"neoteric");
            properties.put(Environment.DIALECT,"org.hybernate.dilect");
            properties.put(Environment.SHOW_SQL,true);

            configuration.setProperties(properties);

            configuration.addAnnotatedClass(AccountEntity.class);
            ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder ()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        }


        return sessionFactory;
    }
}
