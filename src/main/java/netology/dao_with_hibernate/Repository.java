package netology.dao_with_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;


    protected List<Person> getPersonsByCity(String city) {
        var query = entityManager.createNamedQuery("findPersonByCity");
        query.setParameter("city", city);
        List<Person> personList = query.getResultList();

        return personList;
    }


}
