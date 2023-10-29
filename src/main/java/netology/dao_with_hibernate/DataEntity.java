package netology.dao_with_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataEntity implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Person anar = Person.builder().contact(Contact.builder()
                        .name("Oleg")
                        .surname("Ivanov")
                        .age(28)
                        .build())
                .phoneNumber("+7 (222) 133-43-46")
                .cityOfLiving("Rostov")
                .build();

        Person dmitriy = Person.builder().contact(Contact.builder()
                        .name("Dmitriy")
                        .surname("Petrov")
                        .age(30)
                        .build())
                .phoneNumber("+7 (555) 666-99-99")
                .cityOfLiving("Moscow")
                .build();

        Person vlad = Person.builder().contact(Contact.builder()
                        .name("Vladimir")
                        .surname("Reshetnikov")
                        .age(42)
                        .build())
                .phoneNumber("+7 (666) 666-66-66")
                .cityOfLiving("Krasnodar")
                .build();
       entityManager.persist(anar);
       entityManager.persist(dmitriy);
       entityManager.persist(vlad);
    }
}
