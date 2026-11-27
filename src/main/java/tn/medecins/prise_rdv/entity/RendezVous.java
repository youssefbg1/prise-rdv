package tn.medecins.prise_rdv.entity;

import java.time.LocalDateTime;

public class RendezVous {
    private Long id;
    private LocalDateTime dateCreation;
    private StatutRendezVous statut;
    private Creneau creneau;

    public RendezVous() {
    }

    public RendezVous(Long id, LocalDateTime dateCreation, StatutRendezVous statut, Creneau creneau) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.statut = statut;
        this.creneau = creneau;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public StatutRendezVous getStatut() {
        return statut;
    }

    public void setStatut(StatutRendezVous statut) {
        this.statut = statut;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", status=" + statut +
                ", creneau=" + creneau +
                '}';
    }
}
