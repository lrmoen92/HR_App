package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
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
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement() {

        //setup element
        Element element = new Element();
        element.setElementName("Phone");

        //save element, verify it has ID after save
        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        //fetch
        Element fetchedElement = elementRepository.findOne(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        //update
        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findOne(fetchedElement.getId());

        assertEquals("Email", updatedElement.getElementName());
        elementRepository.deleteAll();

    }

    @Test
    public void testSaveElementList() {
        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.save(elementList);

        Iterable<Element> fetchedElementList = elementRepository.findAll();

        int count = 0;
        for(Element element : fetchedElementList){
            count++;
        }

        assertEquals(4, count);
        elementRepository.deleteAll();


    }

    @Test
    public void testFindByName(){
        Element element = new Element("FindTest");
        elementRepository.save(element);

        Element foundByNameElement = elementRepository.findByElementName("FindTest");

        assertEquals(element.getId(), foundByNameElement.getId());
        elementRepository.deleteAll();
    }

    @Test
    public void testFindAllByName(){
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);

        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("FindTest");

        assertEquals(3, foundAllByNameElement.size());
        elementRepository.deleteAll();
    }

    @Test
    public void testFindTop3Desc(){
        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.save(elementList);
        assertEquals("Phone", elementRepository.findTop3ByOrderByElementNameDesc().get(0).getElementName());
        elementRepository.deleteAll();
    }

    @Test
    public void countByElementName(){
        elementRepository.save(new Element("PayRate"));
        elementRepository.save(new Element("PayRate"));
        elementRepository.save(new Element("Phone"));
        elementRepository.save(new Element("Email"));
        assertEquals(2, elementRepository.countByElementName("PayRate"));
        elementRepository.deleteAll();
        assert(true);
    }
}
