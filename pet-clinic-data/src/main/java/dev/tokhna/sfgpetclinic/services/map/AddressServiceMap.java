package dev.tokhna.sfgpetclinic.services.map;

import dev.tokhna.sfgpetclinic.model.Address;
import dev.tokhna.sfgpetclinic.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddressServiceMap extends AbstractMapService<Address, Long> implements AddressService {
    @Override
    public Set<Address> findAll() {
        return null;
    }

    @Override
    public Address findById(Long id) {
        return null;
    }

    @Override
    public Address save(Address object) {
        return null;
    }

    @Override
    public void delete(Address object) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
