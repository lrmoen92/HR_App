package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Logan.Moen on 7/7/2017.
 */
public interface ElementRepository extends CrudRepository<Element, Integer> {

    // will auto generate the required code from the structure of the method name
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findTop3ByOrderByElementNameDesc();

    int countByElementName(String elementName);

}
