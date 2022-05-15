package entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String name;
    private String model;
    private boolean active;
    private int year;
//    @Required
//    public void setYear(int year){
//this.year=year;
//    }

}
