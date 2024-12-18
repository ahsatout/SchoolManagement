package com.hyh.schoolmanagement.dao.impl;

import com.hyh.schoolmanagement.dao.ElementDao;
import com.hyh.schoolmanagement.dao.ModuleDao;
import com.hyh.schoolmanagement.dao.ProfessorDao;
import com.hyh.schoolmanagement.model.Element;
import com.hyh.schoolmanagement.model.Module;
import com.hyh.schoolmanagement.model.Professor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ElementDaoImpl extends DefaultDao<Element> implements ElementDao {

	private final ModuleDao moduleDao;
	private final ProfessorDao professorDao;

	public ElementDaoImpl(ModuleDao moduleDao, ProfessorDao professorDao) {
		this.moduleDao = moduleDao;
		this.professorDao = professorDao;
	}

	@Override
	public String getTableName() {
		return "element";
	}

	@Override
	public String getPrimaryKeyLabel() {
		return "id";
	}

	@Override
	public String[] getColumnLabels() {
		return new String[] { getPrimaryKeyLabel(), "name", "coefficient", "module",
				"professor" };
	}

	@Override
	public Element map(Map<String, String> tMap) {
		Module module = null;
		Professor professor = null;

		Optional<Module> moduleOptional = moduleDao
				.findById(Long.parseLong(tMap.get("module")));
		if (moduleOptional.isPresent())
			module = moduleOptional.get();

		Optional<Professor> professorOptional = professorDao
				.findById(Long.parseLong(tMap.get("professor")));
		if (professorOptional.isPresent())
			professor = professorOptional.get();

		Element element = new Element(tMap.get("name"),
				Double.parseDouble(tMap.get("coefficient")), module,
				professor);

		return element;
	}

	@Override
	public Map<String, String> getColumns(Element element) {
		Map<String, String> map = new HashMap<>();
		map.put("name", element.getName());
		map.put("coefficient", String.valueOf(element.getCoefficient()));
		map.put("module", String
				.valueOf(element.getModule() != null ? element.getModule() : ""));
		map.put("professor", String.valueOf(
				element.getProfessor() != null ? element.getProfessor().getId() : ""));
		return map;
	}

	@Override
	public List<Element> findElementsByProfessorId(Long professorId) {
		return findBy("professor", professorId.toString());
	}

/*
	public static void main(String[] args) throws Exception {

		ElementDao elementDao = new ElementDaoImpl();


		Element newElement = new Element("Génie Mecanique", 11,"","","");
		elementDao.save(newElement);


	}
	*/

}
