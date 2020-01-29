package dev.tokhna.sfgpetclinic.services.jpa;

import dev.tokhna.sfgpetclinic.model.Address;
import dev.tokhna.sfgpetclinic.repositories.AddressRepository;
import dev.tokhna.sfgpetclinic.services.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class AddressJpaService implements AddressService {
    private final AddressRepository addressRepository;

    public AddressJpaService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Set<Address> findAll() {
        Set<Address> addresses = new HashSet<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address object) {
        return addressRepository.save(object);
    }

    @Override
    public void delete(Address object) {
        addressRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
