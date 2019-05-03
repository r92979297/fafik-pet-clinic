package com.fafik.fafikpetclinic.repositories;

import com.fafik.fafikpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository  extends CrudRepository<PetType,Long> {
}
