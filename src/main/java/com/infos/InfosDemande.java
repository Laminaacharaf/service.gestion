/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infos;

import Entities.Demande;
import java.io.Serializable;

/**
 *
 * @author ATANDA
 */
public class InfosDemande implements Serializable {
    
    private Demande demande;

    public Demande getDemande() {
        return demande;
    }

    public void setCandidat(Demande recruteur) {
        this.demande = demande;
    }
  
     
}
