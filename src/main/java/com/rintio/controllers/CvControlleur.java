/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rintio.controllers;

import Entities.Cv;
import Repositories.CvRepository;
import com.rintio.commons.exceptions.DatabaseException;
import com.rintio.commons.models.Criterias;
import com.rintio.commons.models.RechercheClass;
import com.rintio.services.JobService;
import com.rintio.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.lang.reflect.InvocationTargetException;
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
@RestController("CvControlleur")
@RequestMapping("/cvCandidat/")
@Api(value = "Job API", description = "Job API")
@CrossOrigin(origins = "*")
public class CvControlleur {

    @Autowired
    JobService jobService;
    @Autowired
    HttpServletRequest request;

//GESTION DES CV
    @RequestMapping(method = RequestMethod.POST, value = "/createCV")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Add a new CV", notes = "Add a new CV")
    public ResponseEntity<Boolean> createV(@RequestBody @Valid Cv cv) throws Exception {
        Boolean result = jobService.enregistrerCv(cv);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "modifierCv/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a Cv", notes = "Update a Cv")
    public ResponseEntity<Cv> updateV(@RequestBody @Valid Cv cv) throws Exception {
        Cv result = jobService.modifierCv(cv);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //SUPPRIMER CV
    @RequestMapping(method = RequestMethod.DELETE, value = "SupprimerCv/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Cv", notes = "Delete a Cv")
    public ResponseEntity<Boolean> deleteV(@PathVariable(name = "id") int id) throws Exception {
        Boolean result = jobService.deleteCvById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //AFFICHER CV
    @RequestMapping(method = RequestMethod.GET, value = "LireCv/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Cv", notes = " Lire Cv")
    public ResponseEntity<Cv> lireV(@PathVariable(name = "id") int id) throws Exception {
        Cv result = jobService.getCvById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //AFFICHER  LISTE DES CV
    @RequestMapping(method = RequestMethod.GET, value = "/ListeCv")
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
