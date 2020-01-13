package dev.tokhna.sfgpetclinic.bootstrap;

import dev.tokhna.sfgpetclinic.model.Owner;
import dev.tokhna.sfgpetclinic.model.Vet;
import dev.tokhna.sfgpetclinic.services.OwnerService;
import dev.tokhna.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Watson");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tammy");
        vet2.setLastName("South");

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
