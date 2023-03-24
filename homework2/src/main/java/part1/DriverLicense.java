package part1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class DriverLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String series;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "driverLicense",fetch = FetchType.LAZY)
    private Owner owner;

    public DriverLicense(String series) {
        this.series = series;
    }

    public DriverLicense(String series, Owner owner) {
        this.series = series;
        this.owner = owner;
    }
}
