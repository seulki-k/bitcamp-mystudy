package bitcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;
import bitcamp.app2.Controller04_1_Interceptor1;
import bitcamp.app2.Controller04_1_Interceptor2;
import bitcamp.app2.Controller04_1_Interceptor3;
import bitcamp.app2.Controller04_1_Interceptor4;

@EnableWebMvc
@ComponentScan("bitcamp.app2")
public class App2Config implements WebMvcConfigurer {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver vr = new InternalResourceViewResolver(
        "/WEB-INF/jsp/",
        ".jsp"
        );
    return vr;
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    urlPathHelper.setRemoveSemicolonContent(false);
    configurer.setUrlPathHelper(urlPathHelper);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 인터셉터를 적용할 경로를 지정하지 않으면 모든 request handler에 대해 적용된다.
    registry.addInterceptor(new Controller04_1_Interceptor1());

    registry.addInterceptor(new Controller04_1_Interceptor2())
    .addPathPatterns("/c04_1/*");

    registry.addInterceptor(new Controller04_1_Interceptor3())
    .addPathPatterns("/c04_1/**");

    registry.addInterceptor(new Controller04_1_Interceptor4())
    .addPathPatterns("/c04_1/**")
    .excludePathPatterns("/c04_1/a/**");

  }
}
