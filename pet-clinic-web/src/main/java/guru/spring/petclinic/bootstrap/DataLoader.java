package guru.spring.petclinic.bootstrap;

import guru.spring.petclinic.model.Owner;
import guru.spring.petclinic.model.Vet;
import guru.spring.petclinic.services.OwnerService;
import guru.spring.petclinic.services.VetService;
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

        owner1.setFirstName("Jake");
        owner1.setLastName("Jackson");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Maria");
        owner2.setLastName("Barbara");

        ownerService.save(owner2);

        System.out.println("Loaded Owners..");

        Vet vet1 = new Vet();

        vet1.setFirstName("ProVet");
        vet1.setLastName("Ares");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Doc");
        vet2.setLastName("Toboggan");

        vetService.save(vet2);

        System.out.println("Loaded Vets..");



    }
}
