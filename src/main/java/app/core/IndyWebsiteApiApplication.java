package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.core.filters.TokenFilter;
import app.core.services.CreateDatabaseService;
import app.core.sessions.SessionContext;

@SpringBootApplication
@EnableTransactionManagement
public class IndyWebsiteApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(IndyWebsiteApiApplication.class, args);
		CreateDatabaseService service = ctx.getBean(CreateDatabaseService.class);
		//service.createDatabase();
	}
	
	@Bean
	public FilterRegistrationBean<TokenFilter> tokenFilterRegistration(SessionContext sessionContext){
		FilterRegistrationBean<TokenFilter> filterRegistrationBean = new FilterRegistrationBean<TokenFilter>();
		TokenFilter tokenFilter = new TokenFilter(sessionContext);
		filterRegistrationBean.setFilter(tokenFilter);
		filterRegistrationBean.addUrlPatterns("/user/*");
		filterRegistrationBean.addUrlPatterns("/admin/*");
		return filterRegistrationBean;
	}

}
