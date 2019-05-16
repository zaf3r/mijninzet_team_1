package makeitwork.mijninzet.controller;


import makeitwork.mijninzet.model.DayPart;
import makeitwork.mijninzet.model.GlobalAvalability;
import makeitwork.mijninzet.model.Voorkeur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/globalAvalability")
public class GlobalAvalabilityController {

//    @GetMapping("dayParts")
//    public String addDayParts(Model model) {

//        GlobalAvalability monday1 = new GlobalAvalability (user.id, 1, 1, true);
//        GlobalAvalability monday2 = new GlobalAvalability(1, 2);
//        GlobalAvalability monday3 = new GlobalAvalability(1, 3);
//        GlobalAvalability tuesday1 = new GlobalAvalability(2, 1);
//        GlobalAvalability tuesday2 = new GlobalAvalability(2, 2);
//        GlobalAvalability tuesday3 = new GlobalAvalability(2, 3);
//        GlobalAvalability wednesday1 = new GlobalAvalability(3, 1);
//        GlobalAvalability wednesday2 = new GlobalAvalability(3, 2);
//        GlobalAvalability wednesday3 = new GlobalAvalability( 3, 3);
//        GlobalAvalability thursday1 = new GlobalAvalability( 4, 1);
//        GlobalAvalability thursday2 = new GlobalAvalability(4, 2);
//        GlobalAvalability thursday3 = new GlobalAvalability(4, 3);
//        GlobalAvalability friday1 = new GlobalAvalability( 5, 1);
//        GlobalAvalability friday2 = new GlobalAvalability( 5, 2);
//        GlobalAvalability friday3 = new GlobalAvalability( 5, 3);

//        List<GlobalAvalability> globalAvalabilityList = new ArrayList<GlobalAvalability>();
//        globalAvalabilityList.add(monday1);
//        globalAvalabilityList.add(monday2);
//        globalAvalabilityList.add(monday3);
//        globalAvalabilityList.add(tuesday1);
//        globalAvalabilityList.add(tuesday2);
//        globalAvalabilityList.add(tuesday3);
//        globalAvalabilityList.add(wednesday1);
//        globalAvalabilityList.add(wednesday2);
//        globalAvalabilityList.add(wednesday3);
//        globalAvalabilityList.add(thursday1);
//        globalAvalabilityList.add(thursday2);
//        globalAvalabilityList.add(thursday3);
//        globalAvalabilityList.add(friday1);
//        globalAvalabilityList.add(friday2);
//        globalAvalabilityList.add(friday3);


//
//        GlobalAvalability globalAvalabilityForm = new GlobalAvalability();
//        GlobalAvalability.setGlobalAvalability(globalAvalabilityList);
//
//        model.addAttribute("globalAvalabilityForm", globalAvalabilityForm);
//
//        return ""
//    }



//        @PostMapping("postGlobalAvalability")
//    public GlobalAvalability postGlobalPreferances(@ModelAttribute GlobalAvalability globalAvalabilityForm, Model model) {
//        System.out.println(globalAvalabilityForm);
//        model.addAttribute("monday1", 1, 1, GlobalAvalability.isAvalable());
//        repo.save(globalAvalabilityForm);
//        return  "redirect:/globalAvalability";
//    }

//    @PostMapping("postGlobalAvalability")
//    public String postGlobalPreferances(@ModelAttribute("globalAvalabilityForm") GlobalAvalability globalAvalabilityForm) {
//        System.out.println(globalAvalabilityForm);
//
//        return  "redirect:/globalAvalability";

    //@PostMapping("postIncidentalAvalability")
}
