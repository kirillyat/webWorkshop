package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import services.marrigeService;
import models.marrige;


import java.util.List;
import java.util.Date;


@Controller
public class MarriageController {
    marrigeService mService = new marrigeService();

    @GetMapping("/marriages")
    public String marriagesPage(Model model) {
        List<marrige> marriages = mService.loadAllMarriges();
        model.addAttribute("marriages", marriages);
        return "marriages";
    }


    @GetMapping("/marriage")
    public String marriagePage(@RequestParam(name = "id", required = true) int id,
                            Model model) {
        marrige marriage = mService.findById(id);

        if (marriage  == null) {
            model.addAttribute("error_msg", "No marriage with id  " + id);
            return "error";
        }
        model.addAttribute("marriage", marriage );

        return "marriage";
    }

    @PostMapping("/marriageDelete")
    public String marriageDeletePage(@RequestParam(name = "id", required = true) Integer id, Model model){
        marrige m = mService.findById(id);
        mService.deletePeople(m);
        return "redirect:/marriages";
    }

    @PostMapping("/marriageAdd")
    public String marriageAddPage(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id == null) {
            model.addAttribute("marriage", new marrige());
            return "marriageAdd";
        }

        marrige marriage = mService.findById(id);
        if (marriage == null) {
            model.addAttribute("error_msg", "No marriage with id " + id);
            return "error";
        }

        model.addAttribute("marriage", marriage);
        return "marriageAdd";
    }

    @PostMapping("/marriageSave")
    public String humanSavePage(@RequestParam(name = "id", required = false) Integer id,
                                @RequestParam(name = "wife_id") int wife_id,
                                @RequestParam(name = "husband_id") int husband_id,
                                @RequestParam(name = "marriage_date") Date marriage_date,
                                @RequestParam(name = "divorce_date") Date divorce_date,
                                Model model) {
        marrige marriage = null;

        if (id != null) {
            marriage = mService.findById(id);
            if (marriage != null) {
                marriage.setWife_id(wife_id);
                marriage.setHusband_id(husband_id);
                marriage.setMarriage_date(marriage_date);
                marriage.setDivorce_date(divorce_date);
                mService.updatePeople(marriage);
            }
        }
        if (marriage == null) {
            //human = new people(address, name, null);
            mService.savePeople(marriage);
        }

        return String.format("redirect:/marriage?id=%d", marriage.getId());
    }


}
