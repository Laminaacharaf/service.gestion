/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rintio.controllers;

import Entities.Candidat;
import Entities.Cv;
import Entities.Demande;
import Entities.Metier;
import Entities.Offre;
import Entities.Postuler;
import Entities.Recruteur;
import Entities.Users;
import Enums.Formation;
import Repositories.CvRepository;
import com.infos.InfosCandidat;
import com.infos.InfosDemande;
import com.infos.InfosMetier;
import com.infos.InfosOffre;
import com.infos.InfosPostuler;
import com.infos.InfosRecruteur;
import com.infos.InfosUsers;
import com.rintio.commons.exceptions.DatabaseException;
import com.rintio.commons.models.Criterias;
import com.rintio.commons.models.RechercheClass;
import com.rintio.services.JobService;
import com.rintio.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ATANDA
 */
@RestController("JobControlleur")
@RequestMapping("/jobs/")
@Api(value = "Job API", description = "Job API")
@CrossOrigin(origins = "*")
public class JobControlleur {

    @Autowired
    JobService jobService;
    @Autowired
    HttpServletRequest request;
    
    // GESTION DES CANDIDATS
//    //CREATION
//    @RequestMapping(method = RequestMethod.POST,value = "/createCandidat")
//    @ApiVersions({"1.0"})
//    @ApiOperation(value = "Create a new candidat", notes = "Create a new candidat")
//    public ResponseEntity<Boolean> create(@RequestBody @Valid InfosCandidat infoscandidat) throws Exception {
//        Boolean result = jobService.enregistrerCandidat(infoscandidat);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
    //CREATION
    @RequestMapping(method = RequestMethod.POST,value = "/createCandidats")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new candidat", notes = "Create a new candidat")
    public ResponseEntity<Boolean> createC(@RequestBody @Valid Candidat candidat) throws Exception {
        Boolean result = jobService.enregistrerCandidats(candidat);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //MODIFICATION DE CANDIDAT
    @RequestMapping(method = RequestMethod.PUT , value = "modifierCandidat")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a candidat", notes = "Update a candidat")
    public ResponseEntity<Candidat> update(@RequestBody @Valid Candidat candidat) throws Exception {
        Candidat result = jobService.modifierCandidat( candidat);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //SUPPRIMER CANDIDAT
    @RequestMapping(method = RequestMethod.DELETE , value = "SupprimerCandidat/{idCandidat}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete candidat", notes = "Delete a candidat")
    public ResponseEntity<Boolean> deleteC(@PathVariable(name = "idCandidat")  String idCandidat) throws Exception {
    System.out.println("*****Affichage du candidat******"+idCandidat);
        Boolean result = jobService.deleteCandidatById(idCandidat);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER  CANDIDATS
    @RequestMapping(method = RequestMethod.GET,value = "LireCandidat/{idCandidat}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Lire candidat", notes = "Lire Candidat")
    public ResponseEntity<Candidat> lire(@PathVariable(name = "idCandidat")  String idCandidat) throws Exception {
        Candidat result = jobService.getCandidatById(idCandidat);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER  LISTE DES CANDIDATS
    @RequestMapping(method = RequestMethod.GET,value = "/ListeCandidat")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des candidat", notes = "Liste Candidats")
    public ResponseEntity<List<Candidat>> ListeC() throws Exception {
        List<Candidat> result = jobService.listeCandidat();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER  CANDIDATS
    @RequestMapping(method = RequestMethod.GET,value = "SearchCandidat/{idMetier}/{Niveau}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Search candidat", notes = "Search Candidat")
    public ResponseEntity<List<Candidat>> RechercherC(@PathVariable(name = "idMetier")  String idMetier, @PathVariable(name = "Niveau") Formation niveau) throws Exception {
        List<Candidat> result = jobService.getCandidat(idMetier,niveau);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    //GESTION DES DEMANDES
    //CREER DEMANDE
    @RequestMapping(method = RequestMethod.POST,value = "/createDemande")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new demande", notes = "Create a new demande")
    public ResponseEntity<Boolean> createD(@RequestBody @Valid InfosDemande infosdemande) throws Exception {
        Boolean result = jobService.enregistrerDemande(infosdemande);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //MODIFIER DEMANDE
    @RequestMapping(method = RequestMethod.PUT , value = "modifierDemande")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a demande", notes = "Update a demande")
    public ResponseEntity<Demande> updateD(@RequestBody @Valid Demande demande) throws Exception {
        Demande result = jobService.modifierDemande( demande);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //SUPPRIMER DEMANDE
    @RequestMapping(method = RequestMethod.DELETE , value = "SupprimerDemande/{idDemande}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Demande", notes = "Delete a Demande")
    public ResponseEntity<Boolean> deleteD(@PathVariable(name = "idDemande")  String idDemande) throws Exception {
        Boolean result = jobService.deleteDemandeById( idDemande);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER DEMANDE
    @RequestMapping(method = RequestMethod.GET,value = "LireDemande/{idDemande}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Demande", notes = " Lire Demande")
    public ResponseEntity<Demande> lireD(@PathVariable(name = "idDemande")  String idDemande) throws Exception {
        Demande result = jobService.getDemandeById(idDemande);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
     //AFFICHER  LISTE DES DEMANDE
    @RequestMapping(method = RequestMethod.GET,value = "/ListeDemande")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des demandes", notes = "Liste Demandes")
    public ResponseEntity<List<Demande>> ListeD() throws Exception {
        List<Demande> result = jobService.listeDemande();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    //GESTION DES METIERS
    @RequestMapping(method = RequestMethod.POST,value = "/createMetier")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new metier", notes = "Create a new metier")
    public ResponseEntity<Boolean> createM(@RequestBody @Valid InfosMetier infosmetier) throws Exception {
        Boolean result = jobService.enregistrerMetier(infosmetier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT , value = "modifierMetier/{idMetier}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a metier", notes = "Update a metier")
    public ResponseEntity<Metier> updateM(@RequestBody @Valid Metier metier) throws Exception {
        Metier result = jobService.modifierMetier( metier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
     //SUPPRIMER METIERS
    @RequestMapping(method = RequestMethod.DELETE , value = "SupprimerMetier/{idMetier}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Metier", notes = "Delete a Metier")
    public ResponseEntity<Boolean> deleteM(@PathVariable(name = "idMetier")  String idMetier) throws Exception {
        Boolean result = jobService.deleteMetierById( idMetier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER METIERS
    @RequestMapping(method = RequestMethod.GET,value = "LireMetier/{idMetier}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Metier", notes = " Lire Metier")
    public ResponseEntity<Metier> lireM(@PathVariable(name = "idMetier")  String idMetier) throws Exception {
        Metier result = jobService.getMetierById(idMetier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
     //AFFICHER  LISTE DES METIERS
    @RequestMapping(method = RequestMethod.GET,value = "/ListeMetier")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Metier", notes = "Liste Metier")
    public ResponseEntity<List<Metier>> ListeM() throws Exception {
        List<Metier> result = jobService.listeMetier();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
     //GESTION DES OFFRES
//    @RequestMapping(method = RequestMethod.POST,value = "/createOffre")
//    @ApiVersions({"1.0"})
//    @ApiOperation(value = "Create a new offre", notes = "Create a new offre")
//    public ResponseEntity<Boolean> createO(@RequestBody @Valid InfosOffre infosoffre) throws Exception {
//        Boolean result = jobService.enregistrerOffre(infosoffre);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
     //CREATION
    @RequestMapping(method = RequestMethod.POST,value = "/createOffres")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new Offre", notes = "Create a new Offre")
    public ResponseEntity<Boolean> createOf(@RequestBody @Valid Offre offre) throws Exception {
        Boolean result = jobService.enregistrerOffres(offre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT , value = "modifierOffre/{idOffre}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a offre", notes = "Update a offre")
    public ResponseEntity<Offre> updateO(@RequestBody @Valid Offre offre) throws Exception {
        Offre result = jobService.modifierOffre( offre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
      //SUPPRIMER OFFRES
    @RequestMapping(method = RequestMethod.DELETE , value = "SupprimerOffre/{idOffre}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Offre", notes = "Delete a Offre")
    public ResponseEntity<Boolean> deleteO(@PathVariable(name = "idOffre")  String idOffre) throws Exception {
        Boolean result = jobService.deleteOffreById( idOffre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER OFFRES
    @RequestMapping(method = RequestMethod.GET,value = "LireOffre/{idOffre}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Offre", notes = " Lire Offre")
    public ResponseEntity<Offre> lireO(@PathVariable(name = "idOffre")  String idOffre) throws Exception {
        Offre result = jobService.getOffreById(idOffre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
     //AFFICHER  LISTE DES OFFRES
    @RequestMapping(method = RequestMethod.GET,value = "/ListeOffre")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Metier", notes = "Liste Offre")
    public ResponseEntity<List<Offre>> ListeO() throws Exception {
        List<Offre> result = jobService.listeOffre();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
     //GESTION DES POSTULES
//    @RequestMapping(method = RequestMethod.POST,value = "/createPost")
//    @ApiVersions({"1.0"})
//    @ApiOperation(value = "Create a new postule", notes = "Create a new postule")
//    public ResponseEntity<Boolean> createP(@RequestBody @Valid InfosPostuler infospostuler) throws Exception {
//        Boolean result = jobService.enregistrerPostuler(infospostuler);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
    //CREATION
    @RequestMapping(method = RequestMethod.POST,value = "/createPostule")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new Postule", notes = "Create a new Postule")
    public ResponseEntity<Boolean> createPo(@RequestBody @Valid Postuler postuler) throws Exception {
        Boolean result = jobService.enregistrerPostulers(postuler);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT , value = "modifierPostuler/{idPost}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a postule", notes = "Update a postule")
    public ResponseEntity<Postuler> updateP(@RequestBody @Valid Postuler postuler) throws Exception {
        Postuler result = jobService.modifierPostuler( postuler);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
       //SUPPRIMER POSTULER
    @RequestMapping(method = RequestMethod.DELETE , value = "SupprimerPostuler/{idPost}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Postuler", notes = "Delete a Postuler")
    public ResponseEntity<Boolean> deleteP(@PathVariable(name = "idPost")  String idPost) throws Exception {
        Boolean result = jobService.deletePostulerById( idPost);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER POSTULER
    @RequestMapping(method = RequestMethod.GET,value = "LirePost/{idPost}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Postuler", notes = " Lire Postuler")
    public ResponseEntity<Postuler> lireP(@PathVariable(name = "idPost")  String idPost) throws Exception {
        Postuler result = jobService.getPostulerById(idPost);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
     //AFFICHER  LISTE DES POSTULER
    @RequestMapping(method = RequestMethod.GET,value = "/ListePostuler")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Postuler", notes = "Liste Postuler")
    public ResponseEntity<List<Postuler>> ListeP() throws Exception {
        List<Postuler> result = jobService.listePostuler();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
     //GESTION DES RECRUTEURS
    @RequestMapping(method = RequestMethod.POST,value = "/createRecruteur")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new recruteur", notes = "Create a new recruteur")
    public ResponseEntity<Boolean> createR(@RequestBody @Valid InfosRecruteur infosrecruteur) throws Exception {
        Boolean result = jobService.enregistrerRecruteur(infosrecruteur);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT , value = "modifierJob/{idRecruteur}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a recruteur", notes = "Update a recruteur")
    public ResponseEntity<Recruteur> updateR(@RequestBody @Valid Recruteur recruteur) throws Exception {
        Recruteur result = jobService.modifierRecruteur( recruteur);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
       //SUPPRIMER RECRUTEUR
    @RequestMapping(method = RequestMethod.DELETE , value = "SupprimerRecruteur/{idRecruteur}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Recruteur", notes = "Delete a Recruteur")
    public ResponseEntity<Boolean> deleteR( @PathVariable(name = "idRecruteur")  String idRecruteur) throws Exception {
        Boolean result = jobService.deleteRecruteurById(idRecruteur);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER RECRUTEUR
    @RequestMapping(method = RequestMethod.GET,value = "LireRecruteur/{idRecruteur}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Recruteur", notes = " Lire Recruteur")
    public ResponseEntity<Recruteur> lireR(@PathVariable(name = "idRecruteur")  String idRecruteur) throws Exception {
        Recruteur result = jobService.getRecruteurById(idRecruteur);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
      //AFFICHER  LISTE DES RECRUTEUR
    @RequestMapping(method = RequestMethod.GET,value = "/ListeRecruteur")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Recruteurs", notes = "Liste Recruteur")
    public ResponseEntity<List<Recruteur>> ListeR() throws Exception {
        List<Recruteur> result = jobService.listeRecruteur();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
     //GESTION DES USERS
    @RequestMapping(method = RequestMethod.POST,value = "/createUser")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new users", notes = "Create a new users")
    public ResponseEntity<Boolean> createU(@RequestBody @Valid InfosUsers infosusers) throws Exception {
        Boolean result = jobService.enregistrerUsers(infosusers);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT , value = "modifierJob/{idUser}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a users", notes = "Update a users")
    public ResponseEntity<Users> updateU(@RequestBody @Valid Users users) throws Exception {
        Users result = jobService.modifierUsers( users);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
      //SUPPRIMER USERS
    @RequestMapping(method = RequestMethod.DELETE , value = "SupprimerUsers/{idUser}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Users", notes = "Delete a Users")
    public ResponseEntity<Boolean> deleteU( @PathVariable(name = "idUser")  String idUser) throws Exception {
        Boolean result = jobService.deleteUsersById( idUser);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER USERS
    @RequestMapping(method = RequestMethod.GET,value = "LireUser/{idUser}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Users", notes = " Lire Users")
    public ResponseEntity<Users> lireU(@PathVariable(name = "idUser")  String idUser) throws Exception {
        Users result = jobService.getUsersById(idUser);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
      //AFFICHER  LISTE DES USERS
    @RequestMapping(method = RequestMethod.GET,value = "/ListeUsers")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Users", notes = "Liste Users")
    public ResponseEntity<List<Users>> ListeU() throws Exception {
        List<Users> result = jobService.listeUsers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //GESTION DES CV
    @RequestMapping(method = RequestMethod.POST,value = "/createCV")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Add a new CV", notes = "Add a new CV")
    public ResponseEntity<Boolean> createV(@RequestBody @Valid Cv cv) throws Exception {
        Boolean result = jobService.enregistrerCv(cv);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT , value = "modifierCv/{idCv}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a Cv", notes = "Update a Cv")
    public ResponseEntity<Cv> updateV(@RequestBody @Valid Cv cv) throws Exception {
        Cv result = jobService.modifierCv( cv);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
      //SUPPRIMER CV
    @RequestMapping(method = RequestMethod.DELETE , value = "SupprimerCv/{idCv}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Cv", notes = "Delete a Cv")
    public ResponseEntity<Boolean> deleteV( @PathVariable(name = "idCv")  String idCv) throws Exception {
        Boolean result = jobService.deleteCvById(idCv);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER CV
    @RequestMapping(method = RequestMethod.GET,value = "LireCv/{idCv}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Cv", notes = " Lire Cv")
    public ResponseEntity<Cv> lireV(@PathVariable(name = "idCv")  String idCv) throws Exception {
        Cv result = jobService.getCvById(idCv);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
      //AFFICHER  LISTE DES CV
    @RequestMapping(method = RequestMethod.GET,value = "/ListeCv")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Cv", notes = "Liste Cv")
    public ResponseEntity<List<Cv>> ListeV() throws Exception {
        List<Cv> result = jobService.listeCv();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
 //RECHERCHE GLOBALE
    /**
     * Get all the stations following the given fields and criterias
     *
     * @param recherche
     * @return stations
     */
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Read a or all users by cretera", notes = "Read a or all users by cretera")
    public ResponseEntity<List<Cv>> search(@RequestBody @Valid RechercheClass recherche) {
        Criterias criteres = recherche.getCriterias();
        CvRepository cvrepository = new CvRepository("GesJob_Pu");
        List<String> champs = recherche.getFields();
        List<Cv> retour;
        try {
            if (criteres == null && champs == null) {
                retour = cvrepository.findAll();
            } else if (criteres != null && champs == null) {
                retour = cvrepository.getDataByCriteria(criteres);
            } else if (criteres == null && champs != null) {
                retour = cvrepository.getDataByCriteria(champs);
            } else if (criteres != null && champs != null) {
                retour = cvrepository.getDataByCriteria(criteres, champs);
            } else {
                retour = cvrepository.findAll();
            }
            return new ResponseEntity<>(retour, HttpStatus.OK);
        } catch (IllegalAccessException | DatabaseException | InvocationTargetException ex) {
  
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
