package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Logan.Moen on 7/7/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testSave(){
        Contact contact = new Contact("889-234-2341", "this@that.com", new Address(22, "Fake St", "FakeTown", "NN", 22334));
        assertNull(contact.getId());
        contactRepository.save(contact);
        assertNotNull(contact.getId());

        Contact fetchedContact = contactRepository.findOne(contact.getId());
        assertNotNull(fetchedContact);

        assertEquals(fetchedContact.getId(), contact.getId());

        fetchedContact.setEmail("These@Those.com");
        contactRepository.save(fetchedContact);

        Contact updatedFetchedContact = contactRepository.findOne(fetchedContact.getId());
        assertEquals(updatedFetchedContact.getEmail(), fetchedContact.getEmail());
    }

}
