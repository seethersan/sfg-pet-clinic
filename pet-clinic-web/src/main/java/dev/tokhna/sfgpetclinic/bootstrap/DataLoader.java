package dev.tokhna.sfgpetclinic.bootstrap;

import dev.tokhna.sfgpetclinic.model.*;
import dev.tokhna.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final AddressService addressService;
    private final SpecialtyService specialtyService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      AddressService addressService, SpecialtyService specialtyService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.addressService = addressService;
        this.specialtyService = specialtyService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Address address1 = new Address();
        address1.setName("Primary Address");
        address1.setAddress("123 Brickerel");
        address1.setCity("Miami");
        address1.setTelephone("1231231234");
        Set<Address> addresses1 = new HashSet<>();
        Address saveAddress1Address = addressService.save(address1);
        addresses1.add(saveAddress1Address);

        Address address2 = new Address();
        address2.setName("Primary Address");
        address2.setAddress("456 Brickerel");
        address2.setCity("Miami");
        address2.setTelephone("2232232234");
        Set<Address> addresses2 = new HashSet<>();
        Address saveAddress2Address = addressService.save(address2);
        addresses2.add(saveAddress2Address);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Watson");
        owner1.setAddresses(addresses1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddresses(addresses2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setName("Fido");
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);
        petService.save(mikesPet);

        Pet fionaPet = new Pet();
        fionaPet.setPetType(saveCatPetType);
        fionaPet.setName("Rose");
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setOwner(owner2);
        petService.save(fionaPet);

        System.out.println("Loaded Pets");

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialties");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);
        vet1.getSpecialties().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tammy");
        vet2.setLastName("South");
        vet2.getSpecialties().add(savedDentistry);
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
