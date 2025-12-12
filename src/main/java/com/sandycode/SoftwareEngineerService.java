package com.sandycode;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository)
    {
        this.softwareEngineerRepository =softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineer()
    {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer)
    {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id)
    {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new SoftwareEngineerNotFoundException(id));
    }
    public void updateSoftwareEngineer(Integer id, SoftwareEngineer updatedData)
    {
        SoftwareEngineer existing = getSoftwareEngineerById(id);
        existing.setName(updatedData.getName());
        existing.setTechStack(updatedData.getTechStack());
        softwareEngineerRepository.save(existing);
    }
    public void deleteSoftwareEngineer(Integer id)
    {
        softwareEngineerRepository.deleteById(id);
    }


}



