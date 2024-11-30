package com.projet.location.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private LocalDate dateDemande;

    @Enumerated(EnumType.STRING)
    private StatusMaintenance status;

    // Ajout d'une relation ManyToOne avec Equipment
    @ManyToOne
    @JoinColumn(name = "c", nullable = false)  // clé étrangère dans la table Maintenance
    private Equipment equipment;

    public Maintenance(){}

    public Maintenance(String description, LocalDate dateDemande, StatusMaintenance status, Equipment equipment) {
        this.description = description;
        this.dateDemande = dateDemande;
        this.status = status;
        this.equipment = equipment;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public StatusMaintenance getStatus() {
        return status;
    }

    public void setStatus(StatusMaintenance status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
