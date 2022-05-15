import entity.Car;
import entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Car car() {
        return new Car();
    }

    @Bean
    public Student student() {
        return new Student();
    }
}
