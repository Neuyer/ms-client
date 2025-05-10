package com.fiap.client.infrastructure.config;

import liquibase.command.CommandResults;
import liquibase.command.CommandScope;
import liquibase.command.core.UpdateCommandStep;
import liquibase.command.core.helpers.DbUrlConnectionCommandStep;
import liquibase.exception.LiquibaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LiquibaseMongoDBConfig {
    //mongodb://localhost:17017/liquibase-db
    @Value("${spring.data.mongodb.uri}")
    private String connectionUrl;

    //db-json/master.json
    @Value("${spring.liquibase.change-log.classpath}")
    private String changeLogFile;

    /** Execute the update when start the application. > v.4.21 **/
    @Bean
    public CommandResults liquibaseUpdate() {
        try {
            return new CommandScope("update")
                    .addArgumentValue(UpdateCommandStep.CHANGELOG_FILE_ARG, changeLogFile)
                    .addArgumentValue(DbUrlConnectionCommandStep.URL_ARG, connectionUrl)
                    .execute();
        } catch (LiquibaseException e) {
            log.error("error running liquibase {}", e.getMessage());
            throw new IllegalStateException(e);
        }
    }
}