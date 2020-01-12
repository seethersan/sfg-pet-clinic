package dev.tokhna.sfgpetclinic.services;

import dev.tokhna.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
