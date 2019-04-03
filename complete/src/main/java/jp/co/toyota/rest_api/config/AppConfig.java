package jp.co.toyota.rest_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.toyota.rest_api.domain.service.CalculationService;
import jp.co.toyota.rest_api.domain.service.Calculator;

@Configuration
public class AppConfig {

	@Bean
	Calculator calculator() {
		return new CalculationService();
	}

}
