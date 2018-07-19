/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rintio.services;

import com.rintio.services.*;
import Entities.Candidat;
//import static Entities.Candidat_.niveau;
import Entities.Cv;
import Entities.Demande;
import Entities.Metier;
import Entities.Offre;
import Entities.Postuler;
import Entities.Recruteur;
import Entities.Users;
import Enums.Formation;
import Repositories.BaseRepository;
import Repositories.CandidatRepository;
import Repositories.CvRepository;
import Repositories.DemandeRepository;
import Repositories.MetierRepository;
import Repositories.OffreRepository;
import Repositories.PostulerRepository;
import Repositories.RecruteurRepository;
import Repositories.UsersRepository;
import com.Entities.Candidats;
import com.infos.InfosCandidat;
import com.infos.InfosDemande;
import com.infos.InfosMetier;
import com.infos.InfosOffre;
import com.infos.InfosPostuler;
import com.infos.InfosRecruteur;
import com.infos.InfosUsers;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ATANDA
 */
@Component
public class JobService {

    //GESTION DE CANDIDAT
//      public Boolean  enregistrerCandidat( InfosCandidat infosCandidat ) throws SQLException{
//      CandidatRepository candidatRepository = new CandidatRepository("GesJob_Pu");
//       Candidat candidat = infosCandidat.getCandidat();
//        return candidatRepository.create(candidat);
//    } 
    public Boolean enregistrerCandidats(Candidat candidat) throws SQLException {
        CandidatRepository candidatRepository = new CandidatRepository("GesJob_Pu");
        return candidatRepository.create(candidat);
    }

//     public Boolean  suprimerCandidat( String idCandidat ) throws SQLException{
//      CandidatRepository candidatRepository = new CandidatRepository("GesJob_Pu");
//        return candidatRepository.delete(idCandidat);
//    } 
    public boolean deleteCandidatById(String idCandidat) throws SQLException {
        BaseRepository baseRepository = new CandidatRepository("GesJob_Pu");
        baseRepository.deleteById(idCandidat);
        return true;
    }

    public Candidat modifierCandidat(Candidat candidat) throws SQLException {
        CandidatRepository candidatRepository = new CandidatRepository("GesJob_Pu");
        candidatRepository.update(candidat);
        return candidat;
    }

    public Candidat getCandidatById(String idCandidat) throws SQLException {
        CandidatRepository candidatRepository = new CandidatRepository("GesJob_Pu");
        return candidatRepository.getCandidatById(idCandidat);
    }

    public List<Candidat> getCandidat(String idMetier, Formation niveau) throws SQLException {
        CandidatRepository candidatRepository = new CandidatRepository("GesJob_Pu");
        return candidatRepository.getCandidat(idMetier, niveau);
    }

    public List<Candidat> lireCandidat(Candidat candidat) throws SQLException {
        CandidatRepository candidatRepository = new CandidatRepository("GesJob_Pu");
        return candidatRepository.listCandidat();
    }

    public List<Candidat> listeCandidat() throws SQLException {
        CandidatRepository candidatRepository = new CandidatRepository("GesJob_Pu");
        return candidatRepository.findAll();
    }
    //GESTION DES RECRUTEURS

    public Boolean enregistrerRecruteur(InfosRecruteur infosrecruteur) throws SQLException {
        RecruteurRepository recruteurRepository = new RecruteurRepository("GesJob_Pu");
        Recruteur recruteur = infosrecruteur.getRecruteur();
        return recruteurRepository.create(recruteur);
    }

//     public Recruteur  suprimerRecruteur( String idRecruteur ) throws SQLException{
//      RecruteurRepository recruteurRepository = new RecruteurRepository("GesJob_Pu");
//        return recruteurRepository.delete(idRecruteur);
//    } 
    public boolean deleteRecruteurById(String idRecruteur) throws SQLException {
        BaseRepository baseRepository = new RecruteurRepository("GesJob_Pu");
        baseRepository.deleteById(idRecruteur);
        return true;
    }

    public Recruteur modifierRecruteur(Recruteur recruteur) throws SQLException {
        RecruteurRepository recruteurRepository = new RecruteurRepository("GesJob_Pu");
        recruteurRepository.update(recruteur);
        return recruteur;
    }

    public Recruteur getRecruteurById(String idRecruteur) throws SQLException {
        RecruteurRepository recruteurRepository = new RecruteurRepository("GesJob_Pu");
        return recruteurRepository.getRecruteurById(idRecruteur);
    }

    public List<Recruteur> lireRecruteur(Recruteur recruteur) throws SQLException {
        RecruteurRepository recruteurRepository = new RecruteurRepository("GesJob_Pu");
        return recruteurRepository.listRecruteur();
    }

    public List<Recruteur> listeRecruteur() throws SQLException {
        RecruteurRepository recruteurRepository = new RecruteurRepository("GesJob_Pu");
        return recruteurRepository.findAll();
    }

    //GESTION DES DEMANDES
    public Boolean enregistrerDemande(InfosDemande infosdemande) throws SQLException {
        DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");
        Demande demande = infosdemande.getDemande();
        return demandeRepository.create(demande);
    }

//     public Demande suprimerDemande( String idDemande ) throws SQLException{
//      DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");
//        return demandeRepository.delete(idDemande);
//    } 
    public boolean deleteDemandeById(String idDemande) throws SQLException {
        BaseRepository baseRepository = new DemandeRepository("GesJob_Pu");
        baseRepository.deleteById(idDemande);
        return true;
    }

    public Demande modifierDemande(Demande demande) throws SQLException {
        DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");
        demandeRepository.update(demande);
        return demande;
    }

    public List<Demande> lireDemande(Demande demande) throws SQLException {
        DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");
        return demandeRepository.listDemande();
    }

    public Demande getDemandeById(String idDemande) throws SQLException {
        DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");

        return demandeRepository.getDemandeById(idDemande);
    }

    public List<Demande> listeDemande() throws SQLException {
        DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");
        return demandeRepository.findAll();
    }

    //GESTION DE METIERS
    public Boolean enregistrerMetier(InfosMetier infosmetier) throws SQLException {
        MetierRepository metierRepository = new MetierRepository("GesJob_Pu");
        Metier metier = infosmetier.getMetier();
        return metierRepository.create(metier);
    }

//     public Metier  suprimerMetier( String idMetier ) throws SQLException{
//      MetierRepository metierRepository = new MetierRepository("GesJob_Pu");
//        return metierRepository.delete(idMetier);
//    } 
    public boolean deleteMetierById(String idMetier) throws SQLException {
        BaseRepository baseRepository = new MetierRepository("GesJob_Pu");
        baseRepository.deleteById(idMetier);
        return true;
    }

    public Metier modifierMetier(Metier metier) throws SQLException {
        MetierRepository metierRepository = new MetierRepository("GesJob_Pu");
        metierRepository.update(metier);
        return metier;
    }

    public Metier getMetierById(String idMetier) throws SQLException {
        MetierRepository metierRepository = new MetierRepository("GesJob_Pu");
        return metierRepository.getMetierById(idMetier);
    }

    public List<Metier> lireMetier(Metier metier) throws SQLException {
        MetierRepository metierRepository = new MetierRepository("GesJob_Pu");
        return metierRepository.listMetier();
    }

    public List<Metier> listeMetier() throws SQLException {
        MetierRepository metierRepository = new MetierRepository("GesJob_Pu");
        return metierRepository.findAll();
    }

    //GESTION D'OFFRES
//      public Boolean  enregistrerOffre( InfosOffre infosoffre ) throws SQLException{
//      OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
//      Offre offre = infosoffre.getOffre();
//        return offreRepository.create(offre);
//    } 
    public Boolean enregistrerOffres(Offre offre) throws SQLException {
        OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
        return offreRepository.create(offre);
    }

//     public Offre  suprimerOffre( String idOffre ) throws SQLException{
//      OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
//        return offreRepository.delete(idOffre);
//    } 
    public boolean deleteOffreById(String idOffre) throws SQLException {
        BaseRepository baseRepository = new OffreRepository("GesJob_Pu");
        baseRepository.deleteById(idOffre);
        return true;
    }

    public Offre modifierOffre(Offre offre) throws SQLException {
        OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
        offreRepository.update(offre);
        return offre;
    }

    public Offre getOffreById(String idOffre) throws SQLException {
        OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
        return offreRepository.getOffreById(idOffre);
    }

    public List<Offre> lireOffre(Offre offre) throws SQLException {
        OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
        return offreRepository.listOffre();
    }

    public List<Offre> listeOffre() throws SQLException {
        OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
        return offreRepository.findAll();
    }

    //GESTION DES USERS
    public Boolean enregistrerUsers(InfosUsers infosusers) throws SQLException {
        UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
        Users users = infosusers.getUsers();
        return usersRepository.create(users);
    }

//     public Users  suprimerUsers( String idUsers ) throws SQLException{
//      UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
//        return usersRepository.delete(idUsers);
//    } 
    public boolean deleteUsersById(String idUsers) throws SQLException {
        BaseRepository baseRepository = new UsersRepository("GesJob_Pu");
        baseRepository.deleteById(idUsers);
        return true;
    }

    public Users modifierUsers(Users users) throws SQLException {
        UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
        usersRepository.update(users);
        return users;
    }

    public Users getUsersById(String idUsers) throws SQLException {
        UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
        return usersRepository.getUsersById(idUsers);
    }

    public List<Users> lireCandidat(Users users) throws SQLException {
        UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
        return usersRepository.listUsers();
    }

    public List<Users> listeUsers() throws SQLException {
        UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
        return usersRepository.findAll();
    }

    //GESTION DES POSTULERS
//      public Boolean  enregistrerPostuler( InfosPostuler infospostuler ) throws SQLException{
//      PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
//       Postuler postuler = infospostuler.getPostuler();
//        return postulerRepository.create(postuler);
//    } 
    public Boolean enregistrerPostulers(Postuler postuler) throws SQLException {
        PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
        return postulerRepository.create(postuler);
    }

//     public Postuler  suprimerPostuler( String idPostuler ) throws SQLException{
//      PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
//        return postulerRepository.delete(idPostuler);
//    } 
    public boolean deletePostulerById(String idPostuler) throws SQLException {
        BaseRepository baseRepository = new PostulerRepository("GesJob_Pu");
        baseRepository.deleteById(idPostuler);
        return true;
    }

    public Postuler modifierPostuler(Postuler postuler) throws SQLException {
        PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
        postulerRepository.update(postuler);
        return postuler;
    }

    public Postuler getPostulerById(String idPostuler) throws SQLException {
        PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
        return postulerRepository.getPostulerById(idPostuler);
    }

    public List<Postuler> lirePostuler(Postuler postuler) throws SQLException {
        PostulerRepository PostulerRepository = new PostulerRepository("GesJob_Pu");
        return PostulerRepository.listPostuler();
    }

    public List<Postuler> listePostuler() throws SQLException {
        PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
        return postulerRepository.findAll();
    }
//GESTION DES CV
     public Boolean enregistrerCv(Cv cv) throws SQLException {
        CvRepository cvRepository = new CvRepository("GesJob_Pu");
        return cvRepository.create(cv);
    }

    public boolean deleteCvById(String idCv) throws SQLException {
        BaseRepository baseRepository = new UsersRepository("GesJob_Pu");
        baseRepository.deleteById(idCv);
        return true;
    }

    public Cv modifierCv(Cv cv) throws SQLException {
        CvRepository cvRepository = new CvRepository("GesJob_Pu");
        cvRepository.update(cv);
        return cv;
    }

    public Cv getCvById(String idCv) throws SQLException {
        CvRepository cvRepository = new CvRepository("GesJob_Pu");
        return cvRepository.getCvById(idCv);
    }

    public List<Cv> lireCv(Cv cv) throws SQLException {
        CvRepository cvRepository = new CvRepository("GesJob_Pu");
        return cvRepository.listCv();
    }

    public List<Cv> listeCv() throws SQLException {
        CvRepository cvRepository = new CvRepository("GesJob_Pu");
        return cvRepository.findAll();
    }

}
