package tn.medecins.prise_rdv.service;

import org.springframework.stereotype.Service;
import tn.medecins.prise_rdv.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RendezVousService {
    private final MedecinService medecinService;
    private final List<RendezVous> rendezVous = new ArrayList<>();
    private Long prochainId = 1L;
    public RendezVousService(MedecinService medecinService) {
        this.medecinService = medecinService;
    }
    public synchronized RendezVous addRendezVous(
            Long medecinId, Creneau creneau) {
        Medecin medecin =
                medecinService.findMedecinById(medecinId);
        if (medecin == null) {
            throw new IllegalArgumentException(
                    "Aucun médecin trouvé avec cet identifiant."
            );
        }
        if (creneau.getStatut() != StatutCreneau.DISPONIBLE) {
            throw new IllegalStateException(

                    "Ce créneau n'est pas disponible."
            );
        }
// Réserver le créneau
        creneau.setStatut(StatutCreneau.RESERVE);
// Créer le rendez-vous
        RendezVous rdv = new RendezVous(
                prochainId++,
                LocalDateTime.now(),
                StatutRendezVous.PLANIFIE,
                creneau
        );
// Enregistrer le rendez-vous
        rendezVous.add(rdv);
        return rdv;
    }
}