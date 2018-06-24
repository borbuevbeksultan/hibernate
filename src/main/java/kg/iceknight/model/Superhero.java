package kg.iceknight.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "superhero")
public class Superhero {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "superhero", fetch = FetchType.LAZY)
    private List<Skill> skills;

    public Superhero() {
    }

    public Superhero(String name) {
        this.name = name;
    }

//    public Long getId() {
//        System.out.println("get id " + id);
//        return id;
//    }
//
//    public void setId(Long id) {
//        System.out.println("set id " + id);
//        this.id = id;
//    }
//
//    public String getName() {
//        System.out.println("getName " + name);
//        return name;
//    }
//
//    public void setName(String name) {
//        System.out.println("setName " + name);
//        this.name = name;
//    }

}
