package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
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
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSave(){
        Address address = new Address(22, "Fake St", "FakeTown", "NN", 22334);
        assertNull(address.getId());
        addressRepository.save(address);
        assertNotNull(address.getId());

        Address fetchedAddress = addressRepository.findOne(address.getId());
        assertNotNull(fetchedAddress);

        assertEquals(fetchedAddress.getId(), address.getId());

        fetchedAddress.setHouseNumber(42);
        addressRepository.save(fetchedAddress);

        Address updatedFetchedAddress = addressRepository.findOne(fetchedAddress.getId());
        assertEquals(updatedFetchedAddress.getHouseNumber(), fetchedAddress.getHouseNumber());
    }
}
