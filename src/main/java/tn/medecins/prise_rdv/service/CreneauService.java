package tn.medecins.prise_rdv.service;

import org.springframework.stereotype.Service;
import tn.medecins.prise_rdv.entity.Creneau;
import tn.medecins.prise_rdv.entity.Medecin;
import tn.medecins.prise_rdv.entity.StatutCreneau;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreneauService {
    private final List<Creneau> creneaux = new ArrayList<>();
    private Long prochainId = 1L;
    public Creneau addCreneauToMedecin(
            Medecin medecin,
            LocalDate date,
            LocalTime heureDebut,
            LocalTime heureFin) {

        // Vérifier les informations obligatoires
        if (medecin == null || date == null
                || heureDebut == null || heureFin == null) {
            throw new IllegalArgumentException(
                    "Le médecin, la date et les horaires sont obligatoires."
            );
        }
// Vérifier la cohérence des horaires
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "La date du créneau ne peut pas être passée."
            );
        }
// Vérifier la cohérence des horaires
        if (!heureFin.isAfter(heureDebut)) {
            throw new IllegalArgumentException(
                    "L'heure de fin doit être après l'heure de début."
            );
        }

// Créer le créneau
        Creneau creneau = new Creneau(
                prochainId++,
                date,
                heureDebut,
                heureFin,
                StatutCreneau.DISPONIBLE,
                medecin
        );
// Enregistrer le créneau
        creneaux.add(creneau);
        return creneau;
    }
}