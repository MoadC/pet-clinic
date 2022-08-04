package guru.spring.petclinic.services;

import guru.spring.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

 }
