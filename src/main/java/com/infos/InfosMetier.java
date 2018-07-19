/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infos;

import Entities.Metier;
import java.io.Serializable;

/**
 *
 * @author ATANDA
 */
public class InfosMetier implements Serializable  {
    
    private Metier metier;

    public Metier getMetier() {
        return metier;
    }

    public void setCandidat(Metier metier) {
        this.metier = metier;
    }
  
 
    
}
