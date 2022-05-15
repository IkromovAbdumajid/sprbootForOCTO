import entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
    @Autowired
    Car car;

    public void test() {
        car.setModel("qanisan");
        car.setActive(true);
        car.setName("BMW");
        System.out.println(car);
    }
}
