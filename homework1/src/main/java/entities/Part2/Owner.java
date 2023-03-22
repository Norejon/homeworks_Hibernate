package entities.Part2;

import javax.persistence.*;

@Entity
@Table(name = "owner_table")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    private Car car;
}
