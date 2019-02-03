package net.homenet

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class App01Application implements WebMvcConfigurer {
    static void main(String[] args) {
        SpringApplication.run(App01Application, args)
    }

    @Override
    void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login")
    }

    @Override
    void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ReaderHandlerMethodArgumentResolver())
    }
}
