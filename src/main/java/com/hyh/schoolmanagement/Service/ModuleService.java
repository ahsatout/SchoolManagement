package com.hyh.schoolmanagement.Service;

import com.hyh.schoolmanagement.dao.ModuleDao;
import com.hyh.schoolmanagement.model.Module;

import java.util.List;
import java.util.Optional;

public class ModuleService {

    private final ModuleDao moduleDao;

    public ModuleService(ModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }

    public List<Module> getAllModules() {
        return moduleDao.findAll();
    }

    public Optional<Module> getModuleById(Long id) {
        return moduleDao.findById(id);
    }

    public void addModule(Module module) {
        moduleDao.save(module);
    }

    public void updateModule(Module module) {
        moduleDao.update(module);
    }

    public void deleteModule(Long id) {
        moduleDao.delete(id);
    }
}
