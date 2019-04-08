package com.fafik.fafikpetclinic.bootstrap;

import com.fafik.fafikpetclinic.model.Owner;
import com.fafik.fafikpetclinic.model.Vet;
import com.fafik.fafikpetclinic.services.OwnerService;
import com.fafik.fafikpetclinic.services.VetService;
import com.fafik.fafikpetclinic.services.map.OwnerServiceMap;
import com.fafik.fafikpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Scofield");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Shrek");

        ownerService.save(owner2);

        System.out.println("Loaded OWners........");

        Vet vet1= new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("POrter");

        vetService.save(vet2);

        System.out.println("Loaded Vets........");
    }
}
