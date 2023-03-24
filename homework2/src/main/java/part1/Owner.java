package part1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "owner_car",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> cars = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "dl_id",referencedColumnName = "id")
    private DriverLicense driverLicense;

    public Owner(String name, List<Car> cars, DriverLicense driveLicense) {
        this.name = name;
        this.cars = cars;
        this.driverLicense = driveLicense;
    }
}
