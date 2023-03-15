package pl.kurs.test7boardandpawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Test7BoardAndPawnApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test7BoardAndPawnApplication.class, args);
    }

}
