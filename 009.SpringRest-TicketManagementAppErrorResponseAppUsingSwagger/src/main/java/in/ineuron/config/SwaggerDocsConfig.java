package in.ineuron.config;

import java.util.Collections;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
public class SwaggerDocsConfig {
	
	public Docket createDoc() {
		return new Docket(DocumentationType.SWAGGER_2).// UI Screen type
				select(). // to specify RestControllers
				apis(RequestHandlerSelectors.basePackage("in.ineuron.RestController"))// base packages for// RestController
				.paths(PathSelectors.regex("/api/tourist.*")).// To specify the request paths
				build()// build the docket object
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("divs", "http://www.ineuron.ai/course", "divs@ineuron.ai@gmail.com");
		return new ApiInfo("TouristInfo", "Gives information about tourist activities", "3.4.RELEASE", "http:", contact,
				"GNU PUBLIC", "http://apache.org/license/guru",Collections.emptyList());
	}
}
