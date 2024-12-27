package com.hyh.schoolmanagement.dao.impl;

import com.hyh.schoolmanagement.dao.FiliereDao;
import com.hyh.schoolmanagement.model.Filiere;
import com.hyh.schoolmanagement.model.Module;
import com.hyh.schoolmanagement.dao.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FiliereDaoImpl extends DefaultDao<Filiere> implements FiliereDao {

	private final Database database = Database.getInstance();

	@Override
	public String getTableName() {
		return "filiere";
	}

	@Override
	public String getPrimaryKeyLabel() {
		return "id";
	}

	@Override
	public String[] getColumnLabels() {
		return new String[]{getPrimaryKeyLabel(), "name", "acronym"};
	}

	@Override
	public Filiere map(Map<String, String> filiereMap) {
		Filiere filiere = new Filiere(
				Long.parseLong(filiereMap.get("id")),
				filiereMap.get("name"),
				filiereMap.get("acronym")
		);
		// Convertir le Set en List avant de définir les modules
		Set<Module> moduleSet = getModules(filiere);
		List<Module> moduleList = new ArrayList<>(moduleSet); // Conversion du Set en List
		filiere.setModules(moduleList); // Définir les modules
		return filiere;
	}

	@Override
	public Map<String, String> getColumns(Filiere filiere) {
		HashMap<String, String> map = new HashMap<>();
		map.put("name", filiere.getName());
		map.put("acronym", filiere.getAcronym());
		return map;
	}

	private Set<Module> getModules(Filiere filiere) {
		Set<Module> modules = new HashSet<>();
		String query = "SELECT m.* FROM module m " +
				"JOIN filiere_module fm ON m.id = fm.module_id " +
				"WHERE fm.filiere_id = " + filiere.getId();
		ResultSet rs = null;

		try {
			rs = database.executeQuery(query);
			while (rs.next()) {
				Module module = new Module(
						rs.getLong("id"),
						rs.getString("name")
				);
				modules.add(module);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error fetching modules for filiere", e);
		} finally {
			closeResultSet(rs);
		}
		return modules;
	}

	private void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error closing ResultSet", e);
		}
	}
}
