package bank_management_system;

import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    
    private String firstName;
    // First name of the user.
    
    private String lastName;
    // Last name of the user.
    
    private String uuid;
    // Unique ID Number.
    
    private byte pinHash[];
    
    // the md5 hash of the user's pin number.
    
    private ArrayList<Account> accounts;
    // list of accounts of this user.
    
    /**
     * Create a new user
     * @param fName user's first name
     * @param lName user's last name
     * @param pin user's pin number
     * @param theBank the Bank object 
     */
    public User (String fName, String lName, String pin, Bank theBank) {
        
        // set user's name
        this.firstName = fName;
        this.lastName = lName;
        
        // store the pin's MD5 hash
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        }
        catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        
        // get a new unique universal id for the user
        this.uuid = theBank.getNewUserUUID();
        
        // create empty list of account
        this.accounts = new ArrayList<Account>();
        
        // print log message
        System.out.printf("New user %s, %s, with ID %s created.\n", lastName, firstName, this.uuid);
        
    }

    /**
     * Add an account for the user
     * @param anAcct the account to add
     */
    
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);  
    }

}
