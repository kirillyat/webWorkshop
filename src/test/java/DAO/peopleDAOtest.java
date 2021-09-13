package DAO;

import entities.people;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class peopleDAOtest {

    @Test
    public void testHuman() {
        people human = new people();
        peopleDAO humanDAO = new peopleDAO();

        human.set_name("Test");
        humanDAO.save(human);
        /*
         * Checking save function
         */
        Assert.assertNotNull(human);

        /*
         * Checking findById function
         */
        int id = human.get_id();
        people human2 = humanDAO.findById(id);
        Assert.assertEquals(human, human2);

        /*
         * Checking update function
         */
        human.set_name("Test human2");
        humanDAO.update(human);
        Assert.assertEquals(human.get_name(), "Test human2");

        /*
         * Checking delete function
         */
        humanDAO.delete(human);
        people human3 = humanDAO.findById(id);
        Assert.assertNull(human3);
    }

}