package dev.tokhna.sfgpetclinic.services.jpa;

import dev.tokhna.sfgpetclinic.model.Vet;
import dev.tokhna.sfgpetclinic.repositories.SpecialtyRepository;
import dev.tokhna.sfgpetclinic.repositories.VetRepository;
import dev.tokhna.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetsJpaService implements VetService {
    private final VetRepository vetRepository;
    private final SpecialtyRepository specialtyRepository;

    public VetsJpaService(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
        this.vetRepository = vetRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
