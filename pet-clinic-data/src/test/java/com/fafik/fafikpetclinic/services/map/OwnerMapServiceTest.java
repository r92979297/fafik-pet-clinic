package com.fafik.fafikpetclinic.services.map;

import com.fafik.fafikpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerID=1L;
    final String lastName = "Kowalski";


    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerID).lastName(lastName).build());
    }

    @Test
    void findAll() {

        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1,owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerID);

        assertEquals(ownerID,owner.getId());
    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner2 = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }
    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerID));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerID);

        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {

        Owner kowalsky = ownerMapService.findByLastName(lastName);
        assertNotNull(kowalsky);
        assertEquals(ownerID,kowalsky.getId());
    }
    @Test
    void findByLastNameNotFound() {

        Owner kowalsky = ownerMapService.findByLastName("Any");
        assertNull(kowalsky);
    }

}