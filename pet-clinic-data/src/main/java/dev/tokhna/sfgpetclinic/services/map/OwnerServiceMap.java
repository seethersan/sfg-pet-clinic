package dev.tokhna.sfgpetclinic.services.map;

import dev.tokhna.sfgpetclinic.model.Address;
import dev.tokhna.sfgpetclinic.model.Owner;
import dev.tokhna.sfgpetclinic.model.Pet;
import dev.tokhna.sfgpetclinic.services.AddressService;
import dev.tokhna.sfgpetclinic.services.OwnerService;
import dev.tokhna.sfgpetclinic.services.PetService;
import dev.tokhna.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("map")
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final AddressService addressService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService, AddressService addressService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.addressService = addressService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null){
            if (object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if (pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("PetType is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            if (object.getAddresses() != null){
                object.getAddresses().forEach(address -> {
                    if (address.getId() == null){
                        Address savedAddress = addressService.save(address);
                        address.setId(savedAddress.getId());
                    }
                });
            } else {
                throw new RuntimeException("Address is required");
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
