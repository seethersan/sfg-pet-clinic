package dev.tokhna.sfgpetclinic.repositories;

import dev.tokhna.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
