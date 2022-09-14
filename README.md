#  My first Spring app : new concepts & takes

## Maven

Maven focuses on the simplification and standardization of the building process, taking care of the following:

- Builds
- Documentation
- Dependencies
- Reports
- SCMS (Simple Content Management System)
- Distribution
- Releases
- Mailing List

For this project I used this tool for building the project template. Another very popular tool for similar purposes is Gradle.

### Maven vs Gradle

Both have their pros and cons, but simply put: Maven is more opinionated. If you want to something less standard you have to fight maven for it. Gradle is much less opiniated and you can do pretty much whatever you want. Both approaches have its advantages.

## Dependency Injection in Spring

Dependency Injection is a specific form of Inversion of Control. It is a more formalized design pattern, whereby dependencies of an object are injected by an assembler. DI is generally performed in three major styles: constructor injection, property (setter) injection, or, sometimes, interface injection. IoC and DI are often used interchangeably.

Benefits:

- Cleaner code
- Effective decoupling of dependencies
- Increased testability

### The Spring IoC Container:

Core Spring Modules:

- ```spring-core```
- ```spring-beans```
- ```spring-context```
- ```spring-context-support```
- ```spring-expression```

In Spring, objects managed by the IoC container are called beans. The IoC container handles the assembly and lifecycles of Spring beans. Beans are defined in the configuration metadata consumed by the container, which instantiates and assembles them in order to compose your application.

So instead of doing:

```java
import dev.first.repository.PersonRepository;
import dev.first.service.PersonService;

public class Main {

    public static void main(String[] args) {

        PersonService service = new PersonService(new PersonRepository());
        System.out.println(service.read());

    }

}
```

That would return 

```
[Person{age=29, name='Lucas', surname='Stocker'}]
```

We can do:

```java
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
```

Which returns exactly the same

```
[Person{age=29, name='Lucas', surname='Stocker'}]
```

### Configuration of metadata:

Spring supports three forms of configuration of metadata to configure your beans:

- XML-based configuration metadata.
- Annotation-based configuration metadata
- Java-based configuration metadata

In this project we opted to use the Java-based approach, which is basically annotation-based with some extras:

Java-based configuration option enables you to write most of your Spring configuration without XML but with the help of few Java-based annotations.

### Java based Annotations 

- ```@Configuration ``` : Using @Configuration annotation indicates that Spring IoC container can use it as a source of Beans definitions.
- ```@Bean``` : Using the @Bean tells Spring that method will return an object which should be registered as a bean in Spring application context.

In this project we didn't make use of the @Bean annotation because we told the configuration class **AppConfig** to scan for components using the @ComponentScan annotation and telling it to look inside the **dev.first** package for Components.

- ```@Service``` : Spring @Service annotation is a specialization of @Component annotation. Spring Service annotation can be applied only to classes. It is used to mark the class as a service provider.
- ```@Repository``` : @Repository Annotation is a specialization of @Component annotation which is used to indicate that the class provides the mechanism for storage, retrieval, update, delete and search operation on objects. Though it is a specialization of @Component annotation, so Spring Repository classes are autodetected by spring framework through classpath scanning.










