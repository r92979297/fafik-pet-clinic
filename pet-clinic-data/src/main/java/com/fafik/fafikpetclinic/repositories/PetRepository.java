package com.fafik.fafikpetclinic.repositories;

import com.fafik.fafikpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
