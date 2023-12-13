package agencias.service.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Agencia de vuelos service API")
                        .version("0.1.0")
                        .description("API documentation")
                        .termsOfService("http://swagger-io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}