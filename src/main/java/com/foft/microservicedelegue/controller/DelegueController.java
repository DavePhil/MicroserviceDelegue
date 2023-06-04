package com.foft.microservicedelegue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foft.microservicedelegue.exception.DelegueNotFoundException;
import com.foft.microservicedelegue.modele.Delegue;
import com.foft.microservicedelegue.repository.DelegueRepository;
import java.util.Optional;
import com.foft.microservicedelegue.service.DelegueService;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;

@RestController
public class DelegueController {

    @Autowired
    private DelegueService delegueService;
    @Autowired
    private DelegueRepository delegueRepository;
    // @Autowired
    // private JavaMailSender javaMailSender;

        @PostMapping("/CreatDelegue")
        public String  CreatDelegue(@RequestParam("file") MultipartFile file,
                                    @RequestParam("nom") String nom,
                                    @RequestParam("mail") String mail,
                                    @RequestParam("matricule") String matricule,
                                    @RequestParam("id_classe") int id_classe,
                                    @RequestParam("password") String password) {
            delegueService.saveDelegueToDB(file, nom, mail, matricule, password,id_classe);
            // SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            // simpleMailMessage.setTo(mail);
            // simpleMailMessage.setSubject("Registration in Foft Application");
            // simpleMailMessage.setText("Ceci est un email envoyé par l'application Foft_Application. Veuillez trouver ci-dessous les informations de connexion pour votre compte :\n - Nom d'utilisateur :"+nom+ "\n - Mot de passe : " +password+" \n  N'hésitez pas à nous contacter si vous avez des questions ou des préoccupations. Nous sommes là pour vous aider. \n Cordialement, \n L'équipe Foft_Application");
            // javaMailSender.send(simpleMailMessage);
            return "redirect:/Delegue";
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
        return "redirect:/Delegue";
    }


    @GetMapping("/deleteDelegue/{id}")
    public String deleteDelegue(@PathVariable("id") int id)
    {

        delegueService.deleteDelegue(id);
        return "redirect:/Delegue";
    }


    @GetMapping("/Delegue")
    public Iterable<Delegue> getDelegues() {
        return delegueService.getdelegues();
    }


    @GetMapping("/Delegue/{id}")
    public Optional<Delegue> getDelegue(@PathVariable("id") final Integer id ){
        Optional<Delegue> delegue = delegueRepository.findById(id);
        if(!delegue.isPresent())  throw new DelegueNotFoundException("Le delegue correspondant à l'id " + id + " n'existe pas");
       return delegue;
        
    }
}
