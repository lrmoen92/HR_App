package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

import java.util.List;

/**
 * Created by Logan.Moen on 7/12/2017.
 */
public interface ElementTypeService {

    ElementType getElementTypeById(Integer id);

    Iterable<ElementType> listAllElementTypes();

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType(Integer id);

    //custom repository queries

    List<ElementType> findTop3ByOrderByElementTypeNameDesc();

    int countByElementTypeName(String elementTypeName);

    ElementType findTopByOrderByIdDesc();

    List<ElementType> findAll();
}
