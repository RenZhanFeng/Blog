
package cr.ms.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import cr.ms.interceptor.LoginInterceptor;

/**
 * 拦截配置
 * 
 * @author Clown
 *
 */
@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

//	@Bean
//	public LoginInterceptor getLoginInterceptor() {
//		return new LoginInterceptor();
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// 对所有路径应用拦截器，除了 /index.html
//		registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");
//	}
	
	/**
	 * 配置全跨域
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//所有請求都允許跨域
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*");
		
	}
	
	/**
	 * 文件上传临时路径
	 */
	@Bean
	MultipartConfigElement MultipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setLocation("/usr/share/nginx/html/blogServer/cache");
		return factory.createMultipartConfig();
	}
	
	
	/**
	 * 配置图片保存路径
	 * @param registry
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "/api/file/");
        registry.addResourceHandler("/cache/**").addResourceLocations("file:/cache");
    }
	
	/**
     * 配置日期格式化
     * @param registry
     */
	@Override
		public void addFormatters(FormatterRegistry registry) {
			registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
		}


}
