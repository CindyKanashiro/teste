package com.example.wswork;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    //Certifique-se de adaptar o valor de allowedOrigins com o domínio real do seu frontend. O método allowCredentials(true)
    // indica que as credenciais (como cookies) podem ser incluídas nas solicitações.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/carros/**")
                .allowedOrigins("http://seu-dominio.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }

    //Você também pode configurar CORS diretamente nos métodos dos controladores. Isso é útil se você precisar de
    // regras diferentes para diferentes partes do seu aplicativo.
    //EX:
    //public class CarroController {
    //@CrossOrigin(origins = "http://seu-dominio.com")
    //@GetMapping
    //public List<Carro> listarCarros() {
    // ...
    //}
    // Outros métodos do controlador...
    //}

    //Usando @CrossOrigin em nível de método, você pode personalizar as configurações CORS para métodos específicos.
}
