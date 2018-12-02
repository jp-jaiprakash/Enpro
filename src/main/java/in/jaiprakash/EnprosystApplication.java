package in.jaiprakash;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class EnprosystApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnprosystApplication.class, args);
	}
	
	@Bean
	public Docket allApi(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("ALL Services").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("in.jaiprakash.controllers"))
				.paths(regex("/.*")).build();
	}

	/**
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Jai Prakash")
				.description("Services")
				.contact("jai")
				.version("1.0").build();
	}
}
