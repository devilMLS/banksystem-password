/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

/**
 *
 * @author roopm8020
 */
public class Account {
    
    // instance variables
    private int accNum;
    private String name;
    private String pass;
    private double balance;
    private String address;
    private int status;
    
    // constructor for Account class that takes in name, address, initial deposit(balance), password, and the account number  
    public Account(String name, String address, double balance, String pass, int accNum, int status) {
        // set some of the instance variables
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.pass = pass;
        this.accNum = accNum;
        this.status = status;
    }
    
    /**
     * returns the name of the account holder
     * @return the name of the account holder
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * returns the address of the user
     * @return the address of the user 
     */
    public String getAddress() {
        return this.address;
    }
    
    /**
     * returns the account balance 
     * @return the account balance 
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * returns the account number 
     * @return the account number 
     */
    public int accNum() {
        return this.accNum;
    }
    
    /**
     * returns the password 
     * @return the password
     */
    public String pass() {
        return this.pass;
    }
    
    public boolean checkPass(String pass){
        return pass.equals(this.pass);
    }
    
    /**
     * returns the new balance (balance plus the deposit)
     * @param deposit  takes in the deposit 
     */
    public void setBalance(double deposit) {
        this.balance += deposit;
    }
    
    /**
     * return membership status of account 
     * @return status of account 
     */
    public int getStatus() {
        return this.status;
    }
    
}
