
package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import services.peopleService;
import models.people;
import java.util.List;


@Controller
public class peopleController {

    peopleService pService = new peopleService();

    @GetMapping("/peopleList")
    public String peopleListPage(Model model) {
        List<people> peopleList = pService.loadAllPeople();
        model.addAttribute("peopleList", peopleList);
        return "peopleList";
    }

    @GetMapping("/human")
    public String humanPage(@RequestParam(name = "id", required = true) int id,
                             Model model) {
        people human = pService.findById(id);

        if (human == null) {
            model.addAttribute("error_msg", "No human with id  " + id);
            return "error";
        }
        model.addAttribute("human", human);

        return "human";
    }


    @PostMapping("/humanDelete")
    public String humanDeletePage(@RequestParam(name = "id", required = true) Integer id, Model model){
        people p = pService.findById(id);
        pService.deletePeople(p);
        return "redirect:/peopleList";
    }


    @PostMapping("/humanAdd")
    public String humanAddPage(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id == null) {
            model.addAttribute("human", new people());
            return "humanAdd";
        }

        people client = pService.findById(id);
        if (client == null) {
            model.addAttribute("error_msg", "No human with id " + id);
            return "error";
        }

        model.addAttribute("human", client);
        return "humanAdd";
    }

    @PostMapping("/humanSave")
    public String humanSavePage(@RequestParam(name = "id", required = false) Integer id,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "phone") String address,
                                 Model model) {
        people human = null;

        if (id != null) {
            human = pService.findById(id);
            if (human != null) {
                human.setName(name);
                human.setAddress(address);
                pService.updatePeople(human);
            }
        }
        if (human == null) {
            //human = new people(address, name, null);
            pService.savePeople(human);
        }

        return String.format("redirect:/human?id=%d", human.getId());
    }


}
