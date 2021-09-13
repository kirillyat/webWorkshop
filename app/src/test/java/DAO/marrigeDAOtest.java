package DAO;


import models.marrige;
import models.people;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;


public class marrigeDAOtest {
    @Test
    public void testMarrige() {
        people p = new people();
        peopleDAO pDAO = new peopleDAO();

        p.setName("Test Client");

        pDAO.save(p);

        people p2 = new people();
        peopleDAO pDAO2 = new peopleDAO();

        p.setName("Test Client 2");

        pDAO.save(p2);

        marrige m = new marrige();
        marrigeDAO mDAO = new marrigeDAO();

        m.setWife_id(1);
        m.setHusband_id(2);


        Assert.assertNotNull(m);

        int im = m.getId();
        marrige m2 = m;
        Assert.assertEquals(m, m2);


        Assert.assertEquals(m2.getId(), im);
    }

}

