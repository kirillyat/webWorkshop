package models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table (name="people")
public class people {
    private int id;
    private String name;
    private int mother_id;
    private int father_id;
    private Date birth_date;
    private Date death_date;
    private String description;
    private String address;


    public people() {}

    public people(String name,
                  int mother_id,
                  int father_id,
                  Date birth_date,
                  Date death_date,
                  String description,
                  String address)
    {
        this.name = name;
        this.mother_id = mother_id;
        this.father_id = father_id;
        this.birth_date = birth_date;
        this.death_date = death_date;
        this.description = description;
        this.address = address;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Column(name = "name")
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Column(name = "mother_id")
    public int getMother_id() {return mother_id;}
    public void setMother_id(int mother_id) {this.mother_id = mother_id;}

    @Column(name = "father_id")
    public int getFather_id() {return father_id;}
    public void setFather_id(int father_id) {this.father_id = father_id;}

    @Column(name = "birth_date")
    public Date getBirth_date() {return birth_date;}
    public void setBirth_date(Date birth_date) {this.birth_date = birth_date;}

    @Column(name = "death_date")
    public Date getDeath_date() {return death_date;}
    public void setDeath_date(Date death_date) {this.death_date = death_date;}

    @Column(name = "description")
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    @Column(name = "address")
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
