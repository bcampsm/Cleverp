package com.example.cleverp.controladors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
*Classe on implementarem diferents mètodes de la interface WebMvcConfigurer per
*configurar el fluxe del MVC de la nostra aplicació
 */
@Configuration //Indica al sistema que és una classe de configuració
public class ConfiguracioWeb implements WebMvcConfigurer {

    /*En aquest mètode definirem les pàgines que mostrarem a l'usuari quan es produeixi un esdeveniment,
     *sense passar per un controlador.
    */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registre) {
        //registre.addViewController("/base").setViewName("index"); //Mostrem la pàgina incial que reanomenen com a index, quan encara no ens hem autenticat
        registre.addViewController("/login"); //Mostrem la pàgina login quan l'usuari no ha pogut autenticar-se
        registre.addViewController("/error403").setViewName("error403");
        registre.addViewController("/error404").setViewName("error404");
    }
    

}
