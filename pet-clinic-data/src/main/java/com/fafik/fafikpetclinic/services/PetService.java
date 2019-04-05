package com.fafik.fafikpetclinic.services;

import com.fafik.fafikpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
