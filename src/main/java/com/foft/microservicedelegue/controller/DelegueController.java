package com.foft.microservicedelegue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foft.microservicedelegue.modele.Delegue;
import com.foft.microservicedelegue.repository.DelegueRepository;
import java.util.Optional;
import com.foft.microservicedelegue.service.DelegueService;

@RestController
public class DelegueController {

    @Autowired
    private DelegueService delegueService;
    @Autowired
    private DelegueRepository delegueRepository;
    

        @PostMapping("/CreatDelegue")
        public String  CreatDelegue(@RequestParam("file") MultipartFile file,
                                    @RequestParam("nom") String nom,
                                    @RequestParam("mail") String mail,
                                    @RequestParam("matricule") String matricule,
                                    @RequestParam("id_classe") int id_classe,
                                    @RequestParam("password") String password) {
            delegueService.saveDelegueToDB(file, nom, mail, matricule, password,id_classe);
            return "redirect:/ListDelegue";
        }



    @PostMapping("/ChangeDelegue/{id}")
    public String changeDelegueAll(@PathVariable("id") int id,
                            @RequestParam("file") MultipartFile file,
                            @RequestParam("nom") String nom,
                            @RequestParam("mail") String mail,
                            @RequestParam("matricule") String matricule,
                            @RequestParam("id_classe") int id_classe,
                            @RequestParam("password") String password) {
        delegueService.updateinformation(id,file, nom, mail, matricule, password,id_classe);
        // la page en question return "redirect:/listProducts.html";
        return "redirect:/ListDelegue";
    }



    @GetMapping("/ListDelegue")
    public String  allDelegue(Model model )
    {

        long delCount=delegueRepository.count();
        model.addAttribute("delCount", delCount);
        return "/delegue.html";
    }




    @GetMapping("/deleteDelegue/{id}")
    public String deleteDelegue(@PathVariable("id") int id)
    {

        delegueService.deleteDelegue(id);
        return "redirect:/ListDelegue";
    }




    @GetMapping("/Delegue")
    public Iterable<Delegue> getDelegues() {
        return delegueService.getdelegues();
    }
    @GetMapping("/Delegue/{id}")
    public Delegue getDelegue(@PathVariable("id") final Integer id ){
        Optional<Delegue> delegue = delegueService.getDelegue(id);
        if(delegue.isPresent()) {
            return delegue.get();
        } else {
            return null;
        }
    }
}




