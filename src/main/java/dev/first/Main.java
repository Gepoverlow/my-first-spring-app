package dev.first;

import dev.first.config.AppConfig;
import dev.first.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService service = applicationContext.getBean("personService", PersonService.class);

        System.out.println(service.read());

    }

}

