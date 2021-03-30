
package services;

import DAO.marriageDAO;
import entities.people;
import entities.marriage;

import java.util.List;




public class marriageService {
    private marriageDAO marrDAO = new marriageDAO();

    //public marriage findByIdOrder(int id) {
    //    return marrDAO.findById(id);}

    public void saveMarriage(marriage wed) {
        marrDAO.save(wed);
    }

    public void updateMarriage(marriage wed) {
        marrDAO.update(wed);
    }

    public void deleteMarriage(marriage wed) {
        marrDAO.delete(wed);
    }

    public List<marriage> loadAllMarriage() {
        return marrDAO.loadAll();
    }



}