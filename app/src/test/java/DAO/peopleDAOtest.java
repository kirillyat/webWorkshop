package DAO;

import models.people;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class peopleDAOtest {
    @Test
    public void testPeople() {
        people p = new people();
        peopleDAO pDAO = new peopleDAO();

        p.setName("Test Client");

        pDAO.save(p);
        /*
         * Checking save function
         */
        Assert.assertNotNull(p);

        /*
         * Checking findById function
         */
        int id = p.getId();
        people p2 = p;
        Assert.assertEquals(p, p2);

        /*
         * Checking update function
         */
        p2.setName("Test Client2");
        pDAO.update(p);
        Assert.assertEquals(p.getName(), "Test Client2");

        /*
         * Checking delete function
         */
        pDAO.delete(p);
        people p3 = pDAO.findById(id);
        Assert.assertNull(p3);
    }
}
