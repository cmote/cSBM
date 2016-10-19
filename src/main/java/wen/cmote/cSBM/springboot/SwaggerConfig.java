package wen.cmote.cSBM.springboot;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.RequestHandledEvent;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
	 *
	 */
	@Bean
	public Docket testApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("wen.cmote.cSBM.springboot"))
				.paths(PathSelectors.any()).build();
	}
	
	private ApiInfo	apiInfo() {
		ApiInfo apiInfo = new ApiInfo("SpringBoot Demo", //大标题：title
				"Spring boot + swagger + mybatis + druid", // 小标题：description
				"1.0", // 版本：version
				"NO terms of service", // ServiceUrl方面：termsOfServiceUrl
				"admin@cmote.wen", // 接触许可证：contact license, 
				"cmoteBlog", // 链接显示文字
				"http://www.raye.wang/" // 网站链接licenseUrl
			);
		return apiInfo;
	}
}
