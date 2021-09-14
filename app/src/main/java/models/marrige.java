package models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "marrige")
public class marrige {

    private int id;
    private int wife_id;
    private int husband_id;
    private Date marriage_date;
    private Date divorce_date;

    public marrige() {}

    public marrige(int id,
                   int wife_id,
                   int husband_id,
                  Date marriage_date,
                  Date divorce_date)
    {
        this.id = id;
        this.wife_id = wife_id;
        this.husband_id = husband_id;
        this.marriage_date = marriage_date;
        this.divorce_date = divorce_date;
    }

    @Id
    @Column(name = "id")
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Column(name = "wife_id")
    public int getWife_id() {return wife_id;}
    public void setWife_id(int wife_id) {this.wife_id = wife_id;}

    @Column(name = "husband_id")
    public int getHusband_id() {return husband_id;}
    public void setHusband_id(int husband_id) {this.husband_id = husband_id;}

    @Column(name = "marrige_date")
    public Date getMarriage_date() {return marriage_date;}
    public void setMarriage_date(Date marriage_date) {this.marriage_date = marriage_date;}

    @Column(name = "divorce_date")
    public Date getDivorce_date() {return divorce_date;}
    public void setDivorce_date(Date divorce_date) {this.divorce_date = divorce_date;}
}
