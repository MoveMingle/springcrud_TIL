package org.doit.ik;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;




@SpringBootApplication
public class Ss00Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ss00Demo2Application.class, args);
	}
			
	@Bean
	   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
	      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	      sqlSessionFactoryBean.setDataSource(dataSource);
	      //Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/**/*.xml");
	      //sqlSessionFactoryBean.setMapperLocations(res);        
	      return sqlSessionFactoryBean.getObject(); 
	   }

	   @Bean
	   public InternalResourceViewResolver setupViewResolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setPrefix("/WEB-INF/views/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   } 
	
	
	
	

}
