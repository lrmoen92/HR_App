package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.services.AddressService;
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
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void testSave(){
        Address address = new Address(22, "Fake St", "FakeTown", "NN", 22334);
        assertNull(address.getId());
        addressService.save(address);
        assertNotNull(address.getId());

        Address fetchedAddress = addressService.findOne(address.getId());
        assertNotNull(fetchedAddress);

        assertEquals(fetchedAddress.getId(), address.getId());

        fetchedAddress.setHouseNumber(42);
        addressService.save(fetchedAddress);

        Address updatedFetchedAddress = addressService.findOne(fetchedAddress.getId());
        assertEquals(updatedFetchedAddress.getHouseNumber(), fetchedAddress.getHouseNumber());
    }

}
