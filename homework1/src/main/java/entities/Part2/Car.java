package entities.Part2;

import javax.persistence.*;

@Entity
@Table(name = "car_table")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String model;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    private int power;
    private int price;
    private int year;
}
