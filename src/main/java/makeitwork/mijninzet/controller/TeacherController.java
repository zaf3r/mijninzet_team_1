package makeitwork.mijninzet.controller;

import makeitwork.mijninzet.model.*;
import makeitwork.mijninzet.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("preference")
    public String addPreferences(Model model, Principal principal) {

        User user = usersRepository.findByUsername(principal.getName());

        System.out.println(user.getUsername());

        VoorkeurSchaal voorkeurSchaal1 = new VoorkeurSchaal(1);
        VoorkeurSchaal voorkeurSchaal2 = new VoorkeurSchaal(2);
        VoorkeurSchaal voorkeurSchaal3 = new VoorkeurSchaal(3);

        ArrayList<VoorkeurSchaal> voorkeurSchaal = new ArrayList<>();
        voorkeurSchaal.add(voorkeurSchaal1);
        voorkeurSchaal.add(voorkeurSchaal2);
        voorkeurSchaal.add(voorkeurSchaal3);

        Voorkeur voorkeur1 = new Voorkeur("Programming",1, voorkeurSchaal);
        Voorkeur voorkeur2 = new Voorkeur("OOP",1,voorkeurSchaal);
        Voorkeur voorkeur3 = new Voorkeur("Advanced programming",3,voorkeurSchaal);
        Voorkeur voorkeur4 = new Voorkeur("Complex programmeren",2,voorkeurSchaal);

        List<Voorkeur> voorkeurTestsList = new ArrayList<Voorkeur>();
        voorkeurTestsList.add(voorkeur1);
        voorkeurTestsList.add(voorkeur2);
        voorkeurTestsList.add(voorkeur3);
        voorkeurTestsList.add(voorkeur4);

        PreferenceForm preferenceForm = new PreferenceForm();
        preferenceForm.setVoorkeur(voorkeurTestsList);


        model.addAttribute("preferenceForm",preferenceForm);
        model.addAttribute("voorkeurTestsList",voorkeurTestsList);
        model.addAttribute("voorkeurSchaal",voorkeurSchaal);

        return "voorkeur-vakken";
    }

    @PostMapping("postPreferences")
    public String postPreferences(@ModelAttribute("preferenceForm") PreferenceForm preferenceForm) {
        System.out.println(preferenceForm);

        return "redirect:/teacher/preference";
    }

}
