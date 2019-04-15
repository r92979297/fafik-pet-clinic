package com.fafik.fafikpetclinic.bootstrap;

import com.fafik.fafikpetclinic.model.Owner;
import com.fafik.fafikpetclinic.model.PetType;
import com.fafik.fafikpetclinic.model.Vet;
import com.fafik.fafikpetclinic.services.OwnerService;
import com.fafik.fafikpetclinic.services.PetTypeService;
import com.fafik.fafikpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService= petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Scofield");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Shrek");

        ownerService.save(owner2);

        System.out.println("Loaded OWners........");

        Vet vet1= new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("POrter");

        vetService.save(vet2);

        System.out.println("Loaded Vets........");
    }
}
