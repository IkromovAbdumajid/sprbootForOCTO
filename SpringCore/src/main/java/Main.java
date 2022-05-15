import entity.Car;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {


        // xml beans nasyroyka qilib chaqirb malumot korsatish
        //      ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//       Student student= context.getBean(Student.class);
//       Car car = context.getBean(Car.class);
//        car.setModel("class");
//        student.setAge(23);
//        System.out.println(car);
//        System.out.println(student);


// @Beans @Configuration bilan create qilganda chaqirib malumot olish
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Student student = context.getBean(Student.class);
//        Car car = context.getBean(Car.class);
//        System.out.println(student);
//        System.out.println(car);


    }
}
