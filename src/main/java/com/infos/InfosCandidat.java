/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infos;


import Entities.Candidat;
import java.io.Serializable;

/**
 *
 * @author ATANDA
 */
public class InfosCandidat implements Serializable {
    
    private Candidat candidat;

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
  
    
}
