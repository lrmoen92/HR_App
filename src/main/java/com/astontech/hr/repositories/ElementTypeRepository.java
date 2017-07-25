package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Logan.Moen on 7/7/2017.
 */
public interface ElementTypeRepository extends CrudRepository<ElementType, Integer>{

    List<ElementType> findTop3ByOrderByElementTypeNameDesc();

    int countByElementTypeName(String elementTypeName);

    ElementType findTopByOrderByIdDesc();

    List<ElementType> findAll();

}
