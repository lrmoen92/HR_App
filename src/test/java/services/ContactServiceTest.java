package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Logan.Moen on 7/7/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void testSave(){
        Contact contact = new Contact("889-234-2341", "this@that.com", new Address(22, "Fake St", "FakeTown", "NN", 22334));
        assertNull(contact.getId());
        contactService.save(contact);
        assertNotNull(contact.getId());

        Contact fetchedContact = contactService.findOne(contact.getId());
        assertNotNull(fetchedContact);

        assertEquals(fetchedContact.getId(), contact.getId());

        fetchedContact.setEmail("These@Those.com");
        contactService.save(fetchedContact);

        Contact updatedFetchedContact = contactService.findOne(fetchedContact.getId());
        assertEquals(updatedFetchedContact.getEmail(), fetchedContact.getEmail());
    }
}
