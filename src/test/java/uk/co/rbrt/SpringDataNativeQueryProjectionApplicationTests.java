package uk.co.rbrt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataNativeQueryProjectionApplicationTests {

	@Autowired
	PersonRepository personRepository;

    // list

	@Test
    public void testFindAllProjectedBy()
    {
        List<PersonSummary> personSummaries = personRepository.findAllProjectedBy();
        PersonSummary personSummary = personSummaries.get(0);
        Assert.assertEquals("Bob", personSummary.getName());
        Assert.assertEquals(33, personSummary.getAge());
    }

    @Test
    public void testFindAllProjectedJpaQuery()
    {
        List<PersonSummary> personSummaries = personRepository.findAllProjectedJpaQuery();
        PersonSummary personSummary = personSummaries.get(0);
        Assert.assertEquals("Bob", personSummary.getName());
        Assert.assertEquals(33, personSummary.getAge());
    }

    @Test
    public void testFindAllProjectedNativeQuery()
    {
        List<PersonSummary> personSummaries = personRepository.findAllProjectedNativeQuery();
        PersonSummary personSummary = personSummaries.get(0);
        Assert.assertEquals("Bob", personSummary.getName());
        Assert.assertEquals(33, personSummary.getAge());
    }

    // one

    @Test
    public void testFindProjectedById()
    {
        PersonSummary personSummary = personRepository.findProjectedById(1);
        Assert.assertEquals("Bob", personSummary.getName());
        Assert.assertEquals(33, personSummary.getAge());
    }

    @Test
    public void testFindProjectedByIdJpaQuery()
    {
        PersonSummary personSummary = personRepository.findProjectedByIdJpaQuery(1);
        Assert.assertEquals("Bob", personSummary.getName());
        Assert.assertEquals(33, personSummary.getAge());
    }

    @Test
    public void testFindProjectedByIdNativeQuery()
    {
        PersonSummary personSummary = personRepository.findProjectedByIdNativeQuery(1);
        Assert.assertEquals("Bob", personSummary.getName());
        Assert.assertEquals(33, personSummary.getAge());
    }

}
