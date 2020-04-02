/*
 * package cr.clown.blog.config;
 * 
 * import java.nio.charset.Charset; import java.util.Collections; import
 * java.util.List;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.converter.HttpMessageConverter; import
 * org.springframework.http.converter.StringHttpMessageConverter; import
 * org.springframework.web.servlet.config.annotation.
 * ContentNegotiationConfigurer; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * 
 *//**
	 * 解决中文乱码
	 * 
	 * @author Clown
	 *
	 *//*
		 * @Configuration public class WebConfig implements WebMvcConfigurer {
		 * 
		 * @Bean public HttpMessageConverter<String> responseBodyConverter(){
		 * StringHttpMessageConverter shmc = new
		 * StringHttpMessageConverter(Charset.forName("UTF-8"));
		 * shmc.setSupportedMediaTypes(Collections.singletonList(MediaType.
		 * APPLICATION_JSON_UTF8)); return shmc; }
		 * 
		 * @Override public void
		 * configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		 * converters.add(responseBodyConverter()); }
		 * 
		 * @Override public void
		 * configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		 * configurer.favorPathExtension(false); } }
		 */