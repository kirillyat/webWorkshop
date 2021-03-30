package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "marriage")
public class marriage {

    private int wife_id;
    private int husband_id;
    private Date marriage_date;
    private Date divorce_date;


    public marriage() {
    }

    public marriage(int wife_id, int husband_id, Date marriage_date, Date divorce_date) {
        this.wife_id = wife_id;
        this.husband_id = husband_id;
        this.marriage_date = marriage_date;
        this.divorce_date = divorce_date;
    }


    @Column(name = "wife_id")
    public int get_wife_id() {
        return wife_id;
    }

    public void set_wife_id(int wife_id) {
        this.wife_id = wife_id;
    }

    @Column(name = "husband_id")
    public int get_husband_id() {
        return husband_id;
    }

    public void set_husband_id(int husband_id) {
        this.husband_id = husband_id;
    }

    @Column(name = "marriage_date")
    public Date get_marriage_date() {
        return marriage_date;
    }

    public void set_marriage_date(Date marriage_date) {
        this.marriage_date = marriage_date;
    }


    @Column(name = "divorce_date")
    public Date get_divorce_date() {
        return divorce_date;
    }

    public void set_divorce_date(Date divorce_date) {
        this.divorce_date = divorce_date;
    }
}