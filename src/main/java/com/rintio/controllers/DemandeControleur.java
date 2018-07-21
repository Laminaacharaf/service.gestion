/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rintio.controllers;

import Entities.Demande;
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
@RestController("DemandeControlleur")
@RequestMapping("/demande/")
@Api(value = "Job API", description = "Job API")
@CrossOrigin(origins = "*")
public class DemandeControleur {

    @Autowired
    JobService jobService;
    
    @Autowired
    HttpServletRequest request;

    //CREATION
    @RequestMapping(method = RequestMethod.POST, value = "/createDemandes")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new Demande", notes = "Create a new Demande")
    public ResponseEntity<Boolean> createOf(@RequestBody @Valid Demande demande) throws Exception {
        Boolean result = jobService.enregistrerDemande(demande);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "modifierDemande/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a demande", notes = "Update a demande")
    public ResponseEntity<Demande> updateO(@RequestBody @Valid Demande demande) throws Exception {
        Demande result = jobService.modifierDemande(demande);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    //SUPPRIMER DEMANDE
    @RequestMapping(method = RequestMethod.DELETE, value = "SupprimerDemande/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Demande", notes = "Delete a Demande")
    public ResponseEntity<Boolean> deleteO(@PathVariable(name = "id") int id) throws Exception {
        Boolean result = jobService.deleteDemandeById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //AFFICHER DEMANDE
    @RequestMapping(method = RequestMethod.GET, value = "LireDemande/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Demande", notes = " Lire Demande")
    public ResponseEntity<Demande> lireO(@PathVariable(name = "id") int id) throws Exception {
        Demande result = jobService.getDemandeById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //AFFICHER  LISTE DES DEMANDES

    @RequestMapping(method = RequestMethod.GET, value = "/ListeDemande")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Demandes", notes = "Liste Demande")
    public ResponseEntity<List<Demande>> ListeO() throws Exception {
        List<Demande> result = jobService.listeDemande();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
}
