package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Logan.Moen on 7/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementTypeRepositoryTest {

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Test
    public void saveElementTypeTest(){
        ElementType elementType = new ElementType();
        assertNull(elementType.getId());
        elementTypeRepository.save(elementType);
        assertNotNull(elementType.getId());

        ElementType fetchedElementType = elementTypeRepository.findOne(elementType.getId());
        assertNotNull(fetchedElementType);
        assertEquals(elementType.getId(), fetchedElementType.getId());

        fetchedElementType.setElementTypeName("Cell");
        elementTypeRepository.save(fetchedElementType);

        ElementType updatedElementType = elementTypeRepository.findOne(fetchedElementType.getId());
        assertEquals("Cell", updatedElementType.getElementTypeName());

        List<ElementType> elementTypeList = new ArrayList<>();

        elementTypeList.add(new ElementType("Work"));
        elementTypeList.add(new ElementType("Home"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Private"));

        elementTypeRepository.save(elementTypeList);

        assertEquals(8, elementTypeRepository.count());
        elementTypeRepository.deleteAll();
    }

    @Test
    public void countByElementTypeNameTest(){
        List<ElementType> elementTypeList = new ArrayList<>();

        elementTypeList.add(new ElementType("Work"));
        elementTypeList.add(new ElementType("Home"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Private"));

        elementTypeRepository.save(elementTypeList);

        assertEquals(4, elementTypeRepository.countByElementTypeName("Cell"));

        elementTypeRepository.deleteAll();
    }

    @Test
    public void findAllOrderByDesc(){
        List<ElementType> elementTypeList = new ArrayList<>();

        elementTypeList.add(new ElementType("Work"));
        elementTypeList.add(new ElementType("Home"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Private"));

        elementTypeRepository.save(elementTypeList);

        assertEquals("Work", elementTypeRepository.findTop3ByOrderByElementTypeNameDesc().get(0).getElementTypeName());

        elementTypeRepository.deleteAll();
    }

    @Test
    public void findMostRecent(){
        List<ElementType> elementTypeList = new ArrayList<>();

        elementTypeList.add(new ElementType("Work"));
        elementTypeList.add(new ElementType("Home"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Private"));

        elementTypeRepository.save(elementTypeList);

        assertEquals("Private", elementTypeRepository.findTopByOrderByIdDesc().getElementTypeName());

        elementTypeRepository.deleteAll();
    }

    @Test
    public void findAll(){
        List<ElementType> elementTypeList = new ArrayList<>();

        elementTypeList.add(new ElementType("Work"));
        elementTypeList.add(new ElementType("Home"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Cell"));
        elementTypeList.add(new ElementType("Private"));

        elementTypeRepository.save(elementTypeList);

        assertEquals(7, elementTypeRepository.findAll().size());

        elementTypeRepository.deleteAll();

    }
}
