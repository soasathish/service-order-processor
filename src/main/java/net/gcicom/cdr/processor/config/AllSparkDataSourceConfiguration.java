package net.gcicom.cdr.processor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"net.gcicom.cdr.processor.repository"}, entityManagerFactoryRef = "allsparkEntityMF" , transactionManagerRef = "defaultTm")
public class AllSparkDataSourceConfiguration {
	
}
