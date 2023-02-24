package com.curso.springboothorario;

import com.curso.springboothorario.interceptors.HorarioInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    @Autowired
    //@Qualifier("horario")
    private HorarioInterceptor horarioInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(horarioInterceptor).excludePathPatterns("/cerrado");
    }
}
