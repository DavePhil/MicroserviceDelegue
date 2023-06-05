package com.foft.microservicedelegue.service;

import com.foft.microservicedelegue.modele.Delegue;
import com.foft.microservicedelegue.repository.DelegueRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Data
@Service
public class DelegueService {

    @Autowired
    private DelegueRepository delegueRepository;
    public Optional<Delegue> getDelegue(Integer id){

        Optional<Delegue> delegue = delegueRepository.findById(id);
        if(delegue.isPresent()){
            return delegue;
        }
        else return null;
    }
    public Iterable<Delegue> getdelegues(){
        return delegueRepository.findAll();
    }


    public Delegue saveDelegueToDB(MultipartFile photo, String name, String email, String matricule, String password, int id_classe)
    {
        Delegue delegue = new Delegue();
        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            delegue.setPhoto(Base64.getEncoder().encodeToString(photo.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        delegue.setEmail(email);
        delegue.setPassword(password);

        delegue.setNom(name);
        delegue.setIdClasse(id_classe);
        delegue.setMatricule(matricule);

        delegueRepository.save(delegue);
        return delegue;
    }


//    public void deleteDelegue (Integer id){
//        delegueRepository.deleteById(id);
//    }



    public void deleteDelegue (Integer id){
        try {
            delegueRepository.deleteById(id);
        } catch (Exception e){

        }
    }



    public Delegue saveDelegue (Delegue delegue){
        Delegue saved = delegueRepository.save(delegue);
        return saved;
    }




    public void updateinformation(int id,MultipartFile photo, String name, String email, String matricule,String password,int id_classe)
    {
        Delegue del=new Delegue();
        del=delegueRepository.findById(id).get();
        del.setPhoto(String.valueOf(photo));
        del.setNom(name);
        del.setEmail(email);
        del.setMatricule(matricule);
        del.setPassword(password);
        del.setIdClasse(id_classe);

        delegueRepository.save(del);
    }

}
