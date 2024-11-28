package com.projet.location.Controller;

import com.projet.location.Service.EquipementService;
import com.projet.location.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipements")
public class EquipementController {

    private final EquipementService equipementService;

    @Autowired
    public EquipementController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    // Endpoint to get all equipments
    @GetMapping
    public List<Equipment> listerEquipements() {
        return equipementService.listerEquipements();
    }

    // Endpoint to update the state of an equipment
    @PutMapping("/{id}/state")
    public Equipment updateEquipementState(@PathVariable Long id, @RequestParam String newState) {
        return equipementService.updateEquipementState(id, newState);
    }
}
