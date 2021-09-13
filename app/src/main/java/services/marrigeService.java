package services;

import models.people;
import models.marrige;

import DAO.peopleDAO;
import DAO.marrigeDAO;

import java.util.Date;
import java.util.List;


public class marrigeService {
    private marrigeDAO mDAO = new marrigeDAO();

    public marrige findById(int id) {
        return mDAO.findById(id);
    }

    public void savePeople(marrige m) {
        mDAO.save(m);
    }

    public void updatePeople(marrige m) {
        mDAO.update(m);
    }

    public void deletePeople(marrige m) { mDAO.delete(m); }

    public List<marrige> loadAllMarriges() { return mDAO.loadAll(); }
}
