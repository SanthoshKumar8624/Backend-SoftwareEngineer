package com.sandycode;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController
{
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }
    @GetMapping //Get All rows of Engineer
    public List<SoftwareEngineer> getEngineers()
    {
        return softwareEngineerService.getAllSoftwareEngineer();
    }
    @GetMapping("{id}")// Get by ID
    public SoftwareEngineer getEngineerById(@PathVariable Integer id)
    {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }
    @PostMapping// Post or insert a row
    public void addnewSoftwareEngineer( @RequestBody SoftwareEngineer softwareEngineer)
    {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }
    @PutMapping("{id}")// Put or Update a row by ID
    public void updateEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer updatedEngineer)
    {
        softwareEngineerService.updateSoftwareEngineer(id, updatedEngineer);
    }
    @DeleteMapping("{id}")// Delete a row by ID
    public void deleteEngineer(@PathVariable Integer id)
    {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }
}
