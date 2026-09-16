package com.changwooheo;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/software-engineers")

public class SoftwareEngineerController {
    private final SoftwareEngineerRepository softwareEngineerRepository;
    private SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService, SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerService = softwareEngineerService;
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @PostMapping
    public void insertNewEngineers
            (@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineer(id);
    }


}
