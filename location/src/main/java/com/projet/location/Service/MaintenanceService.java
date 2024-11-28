package com.projet.location.Service;

import com.projet.location.Repository.MaintenanceRepository;
import com.projet.location.Repository.EquipmentRepository;
import com.projet.location.model.Maintenance;
import com.projet.location.model.StatusMaintenance;
import com.projet.location.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public MaintenanceService(MaintenanceRepository maintenanceRepository, EquipmentRepository equipmentRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.equipmentRepository = equipmentRepository;
    }

    // Method to request maintenance with equipment
    public Maintenance demanderMaintenance(Maintenance maintenance) {
        // Optional: Set equipment if needed
        if (maintenance.getEquipment() != null) {
            Optional<Equipment> equipmentOptional = equipmentRepository.findById(maintenance.getEquipment().getId());
            if (equipmentOptional.isEmpty()) {
                throw new RuntimeException("Equipment with ID " + maintenance.getEquipment().getId() + " not found.");
            }
            maintenance.setEquipment(equipmentOptional.get());
        }

        maintenance.setDateDemande(LocalDate.now());
        maintenance.setStatus(StatusMaintenance.PENDING);
        return maintenanceRepository.save(maintenance);
    }

    // List all maintenance requests
    public List<Maintenance> listerMaintenances() {
        return maintenanceRepository.findAll();
    }
}
