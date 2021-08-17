package com.example.springelasticsearch.api;


import com.example.springelasticsearch.entity.Kisi;
import com.example.springelasticsearch.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor //Hangi constructor gerekiyorsa onu argümanına eklesin
@RestController
@RequestMapping("/kisi") //kişi diye bir adreste yayınladık.
public class KisiController {
   private final KisiRepository kisiRepository; // bir tane kaydımızı yarattık

   @PostConstruct
   public void init(){
       Kisi kisi =new Kisi();
       kisi.setAd("Haydi");
       kisi.setSoyad("Kodlayalım");
       kisi.setAdres("test");                                    //bu adreste yayınladı.
       kisi.setDogumTarihi(Calendar.getInstance().getTime());
       kisi.setId("K0001");
       kisiRepository.save(kisi);
   }
@GetMapping("/{search}")
public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search){    //search girdiğimizde gidip adında arayıp getirecek
  List<Kisi>kisiler=  kisiRepository.getByCustomQuery(search);
return ResponseEntity.ok(kisiler);
}
}
