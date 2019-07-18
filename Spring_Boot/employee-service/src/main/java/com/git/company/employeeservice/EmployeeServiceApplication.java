package com.git.company.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Employee-Service")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.git.company.employeeservice"))
               .paths(PathSelectors.ant("/employee-service/*"))
                .build();
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Employee Service")
                .description("APIs to manage employee details")
                .contact("Soundarya Khanapur")
                .build();
    }
    
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found")  // 404
    public static class EmployeeNotFoundException extends RuntimeException {
        
    }
    
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Looks like Employee is already deleted or does not exist")  // 404
    public static class EmployeeAlreadyDeletedException extends RuntimeException {
        
    }
    
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee does not exist")  // 404
    public static class EmployeeDoesNotExistException extends RuntimeException {
        
    }
}
