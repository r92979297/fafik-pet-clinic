package com.fafik.fafikpetclinic.services;

import com.fafik.fafikpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
