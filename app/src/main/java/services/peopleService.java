package services;

import models.people;
import models.marrige;

import DAO.peopleDAO;
import DAO.marrigeDAO;

import java.util.List;

public class peopleService {
    private peopleDAO pDAO = new peopleDAO();

    public people findById(int id) {
        return pDAO.findById(id);
    }

    public void savePeople(people p) {
        pDAO.save(p);
    }

    public void updatePeople(people p) {
        pDAO.update(p);
    }

    public void deletePeople(people p) { pDAO.delete(p); }

    public List<people> loadAllPeople() {
        return pDAO.loadAll();
    }

}
