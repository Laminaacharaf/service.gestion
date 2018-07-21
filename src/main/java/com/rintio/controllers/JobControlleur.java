/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rintio.controllers;

import Entities.Offre;
import Entities.Postuler;
import com.rintio.services.JobService;
import com.rintio.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    //CREATION
    @RequestMapping(method = RequestMethod.POST, value = "/createOffres")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new Offre", notes = "Create a new Offre")
    public ResponseEntity<Boolean> createOf(@RequestBody @Valid Offre offre) throws Exception {
        Boolean result = jobService.enregistrerOffres(offre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "modifierOffre/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a offre", notes = "Update a offre")
    public ResponseEntity<Offre> updateO(@RequestBody @Valid Offre offre) throws Exception {
        Offre result = jobService.modifierOffre(offre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    //SUPPRIMER OFFRES
    @RequestMapping(method = RequestMethod.DELETE, value = "SupprimerOffre/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Offre", notes = "Delete a Offre")
    public ResponseEntity<Boolean> deleteO(@PathVariable(name = "id") int id) throws Exception {
        Boolean result = jobService.deleteOffreById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //AFFICHER OFFRES
    @RequestMapping(method = RequestMethod.GET, value = "LireOffre/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Offre", notes = " Lire Offre")
    public ResponseEntity<Offre> lireO(@PathVariable(name = "id") int id) throws Exception {
        Offre result = jobService.getOffreById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER  LISTE DES OFFRES

    @RequestMapping(method = RequestMethod.GET, value = "/ListeOffre")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Metier", notes = "Liste Offre")
    public ResponseEntity<List<Offre>> ListeO() throws Exception {
        List<Offre> result = jobService.listeOffre();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //GESTION DES POSTULES
    //CREATION
    @RequestMapping(method = RequestMethod.POST, value = "/createPostule")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new Postule", notes = "Create a new Postule")
    public ResponseEntity<Boolean> createPo(@RequestBody @Valid Postuler postuler) throws Exception {
        Boolean result = jobService.enregistrerPostulers(postuler);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "modifierPostuler/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a postule", notes = "Update a postule")
    public ResponseEntity<Postuler> updateP(@RequestBody @Valid Postuler postuler) throws Exception {
        Postuler result = jobService.modifierPostuler(postuler);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    //SUPPRIMER POSTULER
    @RequestMapping(method = RequestMethod.DELETE, value = "SupprimerPostuler/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Postuler", notes = "Delete a Postuler")
    public ResponseEntity<Boolean> deleteP(@PathVariable(name = "id") int id) throws Exception {
        Boolean result = jobService.deletePostulerById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //AFFICHER POSTULER
    @RequestMapping(method = RequestMethod.GET, value = "LirePostulation/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Postuler", notes = " Lire Postuler")
    public ResponseEntity<Postuler> lireP(@PathVariable(name = "id") int id) throws Exception {
        Postuler result = jobService.getPostulerById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    //AFFICHER  LISTE DES POSTULER
    @RequestMapping(method = RequestMethod.GET, value = "/ListePostuler")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Postuler", notes = "Liste Postuler")
    public ResponseEntity<List<Postuler>> ListeP() throws Exception {
        List<Postuler> result = jobService.listePostuler();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
