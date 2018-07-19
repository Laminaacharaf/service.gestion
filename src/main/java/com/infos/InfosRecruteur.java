/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infos;

import Entities.Recruteur;
import java.io.Serializable;

/**
 *
 * @author ATANDA
 */
public class InfosRecruteur implements Serializable {
    
    private Recruteur recruteur;

    public Recruteur getRecruteur() {
        return recruteur;
    }

    public void setCandidat(Recruteur recruteur) {
        this.recruteur = recruteur;
    }
  
    
}
