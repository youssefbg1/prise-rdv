package tn.medecins.prise_rdv.service;

import org.springframework.stereotype.Service;
import tn.medecins.prise_rdv.entity.Medecin;
import tn.medecins.prise_rdv.entity.Specialite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MedecinService {
    private final List<Medecin> medecins = new ArrayList<>();
    private Long prochainId = 1L;
    public Medecin addMedecin(
            String nom,
            String prenom,
            String matricule,
            List<Specialite> specialites) {

        if (specialites.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(
                    "La liste ne doit pas contenir de spécialité nulle."
            );
        }

        Medecin medecin = new Medecin(
                prochainId++,
                nom,
                prenom,
                matricule
        );

// Associer les spécialités
        for (Specialite specialite : specialites) {
            medecin.addSpecialite(specialite);
        }
// Enregistrer le médecin
        medecins.add(medecin);
        return medecin;
    }
    public Medecin findMedecinById(Long id) {
        for (Medecin medecin : medecins) {
            if (medecin.getId().equals(id)) {
                return medecin;
            }
        }
        return null;
    }
}