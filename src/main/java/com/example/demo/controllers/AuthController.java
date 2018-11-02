package com.example.demo.controllers;


import com.example.demo.pojos.Auth;
import com.example.demo.pojos.NewTokenResponse;
import com.example.demo.services.AuthService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(path = "/authenticateUser" , method = RequestMethod.POST)
    public boolean authenticateUser(@RequestBody Auth user){
        return authService.authenticateUser(user);
    }

    @RequestMapping(path = "/generateTokenForUser/{username}" , method = RequestMethod.GET)
    public NewTokenResponse generateTokenForUser(@PathVariable("username") String username){
        return authService.generateNewTokenForUser(username);
    }

    @RequestMapping(path = "/validateTokenForUser" , method = RequestMethod.POST)
    public Boolean validateToken(@RequestBody Auth userToken){
        return authService.validateToken(userToken);
    }

    @RequestMapping(path = "/ecryptPass" , method = RequestMethod.GET)
    public String ecryptPass(){
        try{
            String seed = "9;fPG6%V:HtX/(-";
            String passwordToencrypt = "password";
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword(seed);
            String encrypted= encryptor.encrypt(passwordToencrypt);
            //Decryt
            String decrypted = encryptor.decrypt(encrypted);
            return "Encrypted: " + encrypted + " Decryted: " +decrypted;
        }catch(Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    public static String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    //Add salt
    public static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }

}

