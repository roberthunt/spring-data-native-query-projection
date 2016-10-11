package uk.co.rbrt;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author <a href="mailto:roberthunt87@gmail.com">Robert Hunt</a>
 */
public interface PersonRepository extends CrudRepository<Person, Long>
{
    // list

    List<PersonSummary> findAllProjectedBy();

    @Query(value = "SELECT name AS name, age AS age FROM Person")
    List<PersonSummary> findAllProjectedJpaQuery();

    @Query(value = "SELECT name AS name, age AS age FROM Person", nativeQuery = true)
    List<PersonSummary> findAllProjectedNativeQuery();

    // one

    PersonSummary findProjectedById(long id);

    @Query(value = "SELECT name AS name, age AS age FROM Person WHERE id = ?1")
    PersonSummary findProjectedByIdJpaQuery(long id);

    @Query(value = "SELECT name AS name, age AS age FROM Person WHERE id = ?1", nativeQuery = true)
    PersonSummary findProjectedByIdNativeQuery(long id);
}
