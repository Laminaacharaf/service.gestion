/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rintio.controllers;

import Entities.Users;
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
@RestController("UsersControlleur")
@RequestMapping("/users/")
@Api(value = "Job API", description = "Job API")
@CrossOrigin(origins = "*")
public class UsersControlleur {

    @Autowired
    JobService jobService;
    @Autowired
    HttpServletRequest request;

    //GESTION DES USERS
    @RequestMapping(method = RequestMethod.POST, value = "/createUser")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new users", notes = "Create a new users")
    public ResponseEntity<Boolean> createU(@RequestBody @Valid Users users) throws Exception {
        Boolean result = jobService.enregistrerUsers(users);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "modifierUsers/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Update a users", notes = "Update a users")
    public ResponseEntity<Users> updateU(@RequestBody @Valid Users users) throws Exception {
        Users result = jobService.modifierUsers(users);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //SUPPRIMER USERS
    @RequestMapping(method = RequestMethod.DELETE, value = "SupprimerUsers/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Delete Users", notes = "Delete a Users")
    public ResponseEntity<Boolean> deleteU(@PathVariable(name = "id") int id) throws Exception {
        Boolean result = jobService.deleteUsersById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //AFFICHER USERS
    @RequestMapping(method = RequestMethod.GET, value = "LireUser/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = " Lire Users", notes = " Lire Users")
    public ResponseEntity<Users> lireU(@PathVariable(name = "id") int id) throws Exception {
        Users result = jobService.getUsersById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //AFFICHER  LISTE DES USERS
    @RequestMapping(method = RequestMethod.GET, value = "/ListeUsers")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Liste des Users", notes = "Liste Users")
    public ResponseEntity<List<Users>> ListeU() throws Exception {
        List<Users> result = jobService.listeUsers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
