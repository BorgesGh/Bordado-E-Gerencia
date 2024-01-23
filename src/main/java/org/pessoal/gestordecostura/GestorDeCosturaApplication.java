package org.pessoal.gestordecostura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GestorDeCosturaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestorDeCosturaApplication.class, args);
    }

}
