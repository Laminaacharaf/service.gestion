/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infos;

import Entities.Postuler;
import java.io.Serializable;

/**
 *
 * @author ATANDA
 */
public class InfosPostuler implements Serializable   {
    
    private Postuler postuler;

    public Postuler getPostuler() {
        return postuler;
    }

    public void setCandidat(Postuler postuler) {
        this.postuler = postuler;
    }
  
    
}
