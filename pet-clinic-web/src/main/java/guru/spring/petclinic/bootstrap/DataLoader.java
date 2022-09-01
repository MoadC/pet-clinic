package guru.spring.petclinic.bootstrap;

import guru.spring.petclinic.model.*;
import guru.spring.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Jake");
        owner1.setLastName("Jackson");
        owner1.setAddress("123 Street");
        owner1.setCity("Miami");
        owner1.setTelephone("111111111");

        Pet jakepet = new Pet();
        jakepet.setPetType(savedDogPetType);
        jakepet.setOwner(owner1);
        jakepet.setBirthDate(LocalDate.now());
        jakepet.setName("Rosco");
        owner1.getPets().add(jakepet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Maria");
        owner2.setLastName("Barbara");
        owner2.setAddress("123 Street");
        owner2.setCity("Miami");
        owner2.setTelephone("222222222");

        Pet mariasCat = new Pet();
        mariasCat.setPetType(savedCatPetType);
        mariasCat.setName("Kitty");
        mariasCat.setOwner(owner2);
        mariasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(mariasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(mariasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("active kitty !");

        visitService.save(catVisit);

        System.out.println("Loaded Owners..");

        Vet vet1 = new Vet();
        vet1.setFirstName("ProVet");
        vet1.setLastName("Ares");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Doc");
        vet2.setLastName("Toboggan");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets..");
    }
}
