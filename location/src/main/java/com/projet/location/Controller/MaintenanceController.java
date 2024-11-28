package com.projet.location.Controller;

import com.projet.location.Service.MaintenanceService;
import com.projet.location.model.Maintenance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/maintenances")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    public Maintenance demanderMaintenance(@RequestBody Maintenance maintenance) {
        if (maintenance.getDescription() == null || maintenance.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("La description ne peut pas être vide !");
        }

        // You can now pass the entire Maintenance object which may include equipment
        return maintenanceService.demanderMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> listerMaintenances() {
        return maintenanceService.listerMaintenances();
    }
}
