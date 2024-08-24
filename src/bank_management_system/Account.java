package bank_management_system;

import java.util.ArrayList;

public class Account {
    
    private String name;
    // account name
    
    private String uuid;
    // account id num
    
    private User holder;
    // user who owns the account
    
    private ArrayList<Transaction> transactions;
    //list of transactions
    
    public Account (String nm, User holder, Bank theBank) {
        
        // set the account name and holder
        this.name = nm;
        this.holder = holder;
        
        // get new account UUID
        this.uuid = theBank.getNewAccountUUID();
        
        // initialize transactions
        this.transactions = new ArrayList<Transaction>();
        
        // add to holder and bank lists
        holder.addAccount(this);
        theBank.addAccount(this);
        
        
    }

}
