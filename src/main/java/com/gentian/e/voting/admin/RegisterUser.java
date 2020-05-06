package com.gentian.e.voting.admin;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Gentian
 */
@Named(value = "registerUser")
@SessionScoped
public class RegisterUser implements Serializable {

    /**
     * Creates a new instance of RegisterUser
     */
    public RegisterUser() {
    }
    
}
