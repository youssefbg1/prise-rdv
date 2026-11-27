package tn.medecins.prise_rdv.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Creneau {
    private Long id;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private StatutCreneau statut;
    private Medecin medecin;

    public Creneau() {
    }

    public Creneau(Long id, LocalDate date, LocalTime heureDebut, LocalTime heureFin,
                   StatutCreneau status, Medecin medecin) {
        this.id = id;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.statut = status;
        this.medecin = medecin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public StatutCreneau getStatut() {
        return statut;
    }

    public void setStatut(StatutCreneau status) {
        this.statut = status;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    @Override
    public String toString() {
        return "Creneau{" +
                "id=" + id +
                ", date=" + date +
                ", heureDebut=" + heureDebut +
                ", heureFin=" + heureFin +
                ", status=" + statut +
                ", medecin=" + medecin +
                '}';
    }
}
