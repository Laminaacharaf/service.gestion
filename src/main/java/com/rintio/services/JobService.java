/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rintio.services;

//import static Entities.Candidat_.niveau;
import Entities.Cv;
import Entities.Demande;
import Entities.Offre;
import Entities.Postuler;
import Entities.Users;
import Repositories.BaseRepository;
import Repositories.CvRepository;
import Repositories.DemandeRepository;
import Repositories.OffreRepository;
import Repositories.PostulerRepository;
import Repositories.UsersRepository;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ATANDA
 */
@Component
public class JobService {

    //GESTION DES DEMANDES
    public Boolean enregistrerDemande(Demande demande) throws SQLException {
        DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");
        return demandeRepository.create(demande);
    }

    public boolean deleteDemandeById(int id) throws SQLException {
        BaseRepository baseRepository = new DemandeRepository("GesJob_Pu");
        baseRepository.deleteById(id);
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

    public Demande getDemandeById(int id) throws SQLException {
        DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");

        return demandeRepository.getDemandeById(id);
    }

    public List<Demande> listeDemande() throws SQLException {
        DemandeRepository demandeRepository = new DemandeRepository("GesJob_Pu");
        return demandeRepository.findAll();
    }

    //GESTION D'OFFRES
    public Boolean enregistrerOffres(Offre offre) throws SQLException {
        OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
        return offreRepository.create(offre);
    }

    public boolean deleteOffreById(int id) throws SQLException {
        BaseRepository baseRepository = new OffreRepository("GesJob_Pu");
        baseRepository.deleteById(id);
        return true;
    }

    public Offre modifierOffre(Offre offre) throws SQLException {
        OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
        offreRepository.update(offre);
        return offre;
    }

    public Offre getOffreById(int id) throws SQLException {
        OffreRepository offreRepository = new OffreRepository("GesJob_Pu");
        return offreRepository.getOffreById(id);
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
    public Boolean enregistrerUsers(Users users) throws SQLException {
        UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
        return usersRepository.create(users);
    }

    public boolean deleteUsersById(int id) throws SQLException {
        BaseRepository baseRepository = new UsersRepository("GesJob_Pu");
        baseRepository.deleteById(id);
        return true;
    }

    public Users modifierUsers(Users users) throws SQLException {
        UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
        usersRepository.update(users);
        return users;
    }

    public Users getUsersById(int id) throws SQLException {
        UsersRepository usersRepository = new UsersRepository("GesJob_Pu");
        return usersRepository.getUsersById(id);
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
    public Boolean enregistrerPostulers(Postuler postuler) throws SQLException {
        PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
        return postulerRepository.create(postuler);
    }

    public boolean deletePostulerById(int id) throws SQLException {
        BaseRepository baseRepository = new PostulerRepository("GesJob_Pu");
        baseRepository.deleteById(id);
        return true;
    }

    public Postuler modifierPostuler(Postuler postuler) throws SQLException {
        PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
        postulerRepository.update(postuler);
        return postuler;
    }

    public Postuler getPostulerById(int id) throws SQLException {
        PostulerRepository postulerRepository = new PostulerRepository("GesJob_Pu");
        return postulerRepository.getPostulerById(id);
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

    public boolean deleteCvById(int id) throws SQLException {
        BaseRepository baseRepository = new UsersRepository("GesJob_Pu");
        baseRepository.deleteById(id);
        return true;
    }

    public Cv modifierCv(Cv cv) throws SQLException {
        CvRepository cvRepository = new CvRepository("GesJob_Pu");
        cvRepository.update(cv);
        return cv;
    }

    public Cv getCvById(int id) throws SQLException {
        CvRepository cvRepository = new CvRepository("GesJob_Pu");
        return cvRepository.getCvById(id);
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
