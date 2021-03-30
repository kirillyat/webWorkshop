package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Entity
@Table(name = "people")
public class people {

    private int id;
    private String name;
    private int mother_id;
    private int father_id;
    private Date birth_date;
    private Date death_date;
    private String description;
    private String address;


    public people() {
    }

    public people(int id, String name, int mother_id, int father_id, Date birth_date, Date death_date, String description, String address) {
        this.id = id;
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
    public int get_id() {
        return id;
    }

    public void setHuman_id(int id) {
        this.id = id;
    }


    @Column(name = "name")
    public String get_name() {
        return name;
    }

    public void setHuman_name(String name) {
        this.name = name;
    }


    @Column(name = "mother_id")
    public int get_mother_id() {
        return mother_id;
    }

    public void set_mother_id(int mother_id) {
        this.mother_id = mother_id;
    }


    @Column(name = "father_id")
    public int get_father_id() {
        return father_id;
    }

    public void set_father_id(int father_id) {
        this.father_id = father_id;
    }


    @Column(name = "birth_date")
    public Date get_birth_date() {
        return birth_date;
    }

    public void set_birth_date(java.sql.Date birth_date) {
        this.birth_date = birth_date;
    }


    @Column(name = "death_date")
    public Date get_death_date() {
        return death_date;
    }

    public void set_death_date(java.sql.Date death_date) {
        this.death_date = death_date;
    }


    @Column(name = "description")
    public String get_description() {
        return description;
    }

    public void set_description(String description) {
        this.description = description;
    }


    @Column(name = "address")
    public String get_address() {
        return address;
    }

    public void set_address(String address) {
        this.address = address;
    }

}