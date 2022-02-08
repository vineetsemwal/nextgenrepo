package com.example.customerms;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;


@Configuration
public class CustomMongoConfiguration extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongo.database}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }


    /*
    optional
    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
*/

}
