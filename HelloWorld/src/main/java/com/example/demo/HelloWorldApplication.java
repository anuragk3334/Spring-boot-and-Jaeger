package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.MDCScopeManager;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	// @Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.debug("Debugging log");
		log.info("Info log");
		log.warn("Hey, This is a warning!");
		log.error("Oops! We have an Error. OK");

	}

	@Bean
	public io.opentracing.Tracer init() {

		SamplerConfiguration samplerConfig = SamplerConfiguration.fromEnv().withType("const").withParam(1);
		ReporterConfiguration reporterConfig = ReporterConfiguration.fromEnv().withLogSpans(true);
		MDCScopeManager scopeManager = new MDCScopeManager.Builder().build();
		Configuration config = Configuration.fromEnv("boot-service-a").withSampler(samplerConfig)
				.withReporter(reporterConfig);
		return config.getTracer();

		
		//return new JaegerTracer.Builder("boot-service-c").withScopeManager(scopeManager).build();

	}

}
