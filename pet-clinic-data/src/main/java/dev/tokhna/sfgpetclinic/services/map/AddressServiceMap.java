package dev.tokhna.sfgpetclinic.services.map;

import dev.tokhna.sfgpetclinic.model.Address;
import dev.tokhna.sfgpetclinic.services.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class AddressServiceMap extends AbstractMapService<Address, Long> implements AddressService {
    @Override
    public Set<Address> findAll() {
        return super.findAll();
    }

    @Override
    public Address findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Address save(Address object) {
        return super.save(object);
    }

    @Override
    public void delete(Address object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
