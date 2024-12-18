package com.hyh.schoolmanagement.dao.impl;


import com.hyh.schoolmanagement.dao.FiliereDao;
import com.hyh.schoolmanagement.dao.ModuleDao;
import com.hyh.schoolmanagement.model.Filiere;
import com.hyh.schoolmanagement.model.Module;
import com.hyh.schoolmanagement.model.Semester;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ModuleDaoImpl extends DefaultDao<Module> implements ModuleDao {

	private final FiliereDaoImpl filiereDao;

	public ModuleDaoImpl(FiliereDaoImpl filiereDao) {
		this.filiereDao = filiereDao;
	}

	@Override
	public String getTableName() {
		return "module";
	}

	@Override
	public String getPrimaryKeyLabel() {
		return "id";
	}

	@Override
	public String[] getColumnLabels() {
		return new String[] { getPrimaryKeyLabel(), "name", "filiere_id", "semester" };
	}

	@Override
	public Module map(Map<String, String> tMap) {
		Module module = new Module();
		module.setId(Long.parseLong(tMap.get("id")));
		module.setName(tMap.get("name"));
		Long filiereId = Long.parseLong(tMap.get("filiere_id"));
		String semester = tMap.get("semester");
		module.setSemester(Semester.valueOf(semester));

		Optional<Filiere> filiere = filiereDao.findById(filiereId);
		if (filiere.isPresent())
			module.setFiliere(filiere.get());

		return module;
	}

	@Override
	public Map<String, String> getColumns(Module module) {
		HashMap<String, String> map = new HashMap<>();
		map.put("name", module.getName());
		map.put("filiere_id", module.getFiliere().getId().toString());
		map.put("semester", module.getSemester().toString());
		return map;
	}

	public static void main(String[] args) throws Exception {
		ModuleDaoImpl moduleDao = new ModuleDaoImpl(new FiliereDaoImpl());
		// System.out.println(moduleDao.get(1L).get());
		FiliereDao filiereDao = new FiliereDaoImpl();

		Module module = moduleDao.findById(1L).get();
		Filiere filiere = filiereDao.findById(2L).get();

		module.setFiliere(filiere);

		moduleDao.update(module);
		filiereDao.update(filiere);
	}

}
