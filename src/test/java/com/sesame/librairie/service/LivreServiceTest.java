package com.sesame.librairie.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.sesame.librairie.model.Livre;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
@Transactional
class LivreServiceTest {
    @Autowired
    private LivreService service;
    @Test
    void compterRenvoieCinqLivresAuDepart() {
        assertEquals(5, service.compter());
    }
    @Test
    void trouverRenvoieLeLivreExistant() {
        Livre livre = service.trouver(3L).get();
        assertEquals("L'Étranger", livre.getTitre());
    }
    @Test
    void trouverRenvoieVideSiIdInconnu() {
        assertTrue(service.trouver(99L).isEmpty());
    }
    @Test
    void listerFiltreParAuteur() {
        assertEquals(2, service.lister("camus").size());
    }
    @Test
    void ajouterAttribueUnIdentifiantEtAugmenteLeNombre() {
        Livre livre = service.ajouter("Candide", "Voltaire", 1759);
        assertNotNull(livre.getId());
        assertEquals(6, service.compter());
    }

    @Test
    void modifierChangeLesValeursDuLivre() {
        Livre donnees = new Livre(null, "Les Misérables", "V. Hugo", 1862);
        Livre modifie = service.modifier(1L, donnees).get();
        assertEquals("V. Hugo", modifie.getAuteur());
        assertEquals("V. Hugo", service.trouver(1L).get().getAuteur());
    }
    @Test
    void modifierRenvoieVideSiIdInconnu() {
        Livre donnees = new Livre(null, "Inconnu", "Inconnu", 2000);
        assertTrue(service.modifier(99L, donnees).isEmpty());
    }
    @Test
    void supprimerRetireLeLivre() {
        assertTrue(service.supprimer(1L));
        assertEquals(4, service.compter());
    }
    @Test
    void supprimerRenvoieFauxSiIdInconnu() {
        assertFalse(service.supprimer(99L));
    }

}