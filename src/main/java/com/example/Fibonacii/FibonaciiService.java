package com.example.Fibonacii;

import com.example.Fibonacii.resources.Fibonacii;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.auth.basic.BasicAuthProvider;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;
import com.yammer.dropwizard.migrations.MigrationsBundle;

public class FibonaciiService extends Service<FibonaciiConfiguration> {
    public static void main(String[] args) throws Exception {
        new FibonaciiService().run(args);
    }
    @Override
    public void initialize(Bootstrap<FibonaciiConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<FibonaciiConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(FibonaciiConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });        
    }
    @Override
    public void run(FibonaciiConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {

        environment.addResource(new Fibonacii());
    }
}
