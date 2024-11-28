package com.projet.location.Service;


import com.projet.location.Repository.EquipmentRepository;
import com.projet.location.model.Equipment;
import com.projet.location.model.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService {
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipementService(EquipmentRepository equipementRepository){
        this.equipmentRepository = equipementRepository;
    }

    public Equipment updateEquipementState(Long equipementId, String newState){
        Equipment equipment = equipmentRepository.findById(equipementId)
                .orElseThrow(() -> new RuntimeException("Equipement non trouvé"));
        equipment.setState(newState);
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> listerEquipements(){
        return equipmentRepository.findAll();
    }
}
