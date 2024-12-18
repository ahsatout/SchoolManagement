package com.hyh.schoolmanagement.dao;


import com.hyh.schoolmanagement.model.Element;

import java.util.List;

public interface ElementDao extends Dao<Element> {

	List<Element> findElementsByProfessorId(Long professorId);

}
