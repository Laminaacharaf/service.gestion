/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infos;

import Entities.Users;
import java.io.Serializable;

/**
 *
 * @author ATANDA
 */
public class InfosUsers implements Serializable {
    
    private Users users; 

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
}
