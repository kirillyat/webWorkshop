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
    private java.sql.Date birth_date;
    private java.sql.Date death_date;
    private String description;
    private String address;


    public people() {
    }

    public people(int id, String name, int mother_id, int father_id, java.sql.Date birth_date, java.sql.Date death_date, String description, String address) {
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

    public void setClient_id(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String get_name() {
        return name;
    }

    public void setClient_name(String name) {
        this.name = name;
    }

    @Column(name = "client_phone")
    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Orders> getClient_orders() {
        return client_orders;
    }

    public void setClient_orders(List<Orders> client_orders) {
        this.client_orders = client_orders;
    }
}