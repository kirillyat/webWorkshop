package services;

import DAO.peopleDAO;
import entities.people;

import java.util.List;

public class peopleService {
    private peopleDAO people_DAO_inst = new peopleDAO();

    public people findByIdHuman(int id) {
        return people_DAO_inst.findById(id);
    }

    public void saveHuman(people Human) {
        people_DAO_inst.save(Human);
    }

    public void updateHuman(people human) {
        people_DAO_inst.update(human);
    }

    public void deleteHuman(people human) {
        people_DAO_inst.delete(human);
    }

    public List<people> loadAllPeople() {
        return people_DAO_inst.loadAll();
    }
}