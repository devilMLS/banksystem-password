/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pures6322
 */
public class BankSystem {

    // creates an arraylist of accounts and a file info instance
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static FileInfo file;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //create file settings class
        file = new FileInfo();
        //get the nuumber of account in the text file (datbase)
        int numberOfAccounts = file.amountOfAccounts();
        //load in all of the files from the text file (database)
        for (int i = 0; i < numberOfAccounts; i++) {
            accounts.add(file.loadAccounts());
        }
        
        addAcc("Kelly Johnson", "Saphire City", 1067.82, "Drummer123");
        
        //save the accounts (and their info) to the text file (database)
        file.save(accounts);
    }
    
    /**
     * Creates an account and adds it to the account list
     * @param name the name of the account holder
     * @param address the address of the account holder
     * @param balance the balance deposited by the account holder
     * @param pass the password set by the account holder
     */
    public static void addAcc(String name, String address, double balance, String pass){
        
        int bronze = 3;
        int silver = 2;
        int gold = 1;
        
        int status;
        
        if (balance > 0 && balance < 1000) {
            status = bronze;
        } else if (balance > 1000 && balance < 10000) {
            status = silver;
        } else if (balance > 10000) {
            status = gold;
        } else {
            status = bronze;
        }
        
        accounts.add(new Account(name, address, balance, pass, accounts.size() + 1, status));
        System.out.println("Account successfully added!");
    }
    
    /**
     * Retrieves the account from the accounts list
     * @param pass the suggested password of the account
     * @param accNum the suggested account number of the account
     * @return the account with the specified info
     */
    public Account getAcc(String pass, int accNum){
        System.out.println("Account added!");
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).checkPass(pass)){
                if(accounts.get(i).accNum() == accNum){
                    return accounts.get(i);
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * Removes the account with the corresponding info
     * @param pass the suggested password of the account
     * @param accNum the suggested account number for the account
     */
    public static void removeAcc(String pass, int accNum){
        int prevSize = accounts.size();
        
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).checkPass(pass)){
                if(accounts.get(i).accNum() == accNum){
                    accounts.remove(i);
                    System.out.println("removed");
                }
            }
            if(i == accounts.size() - 1 && accounts.size() == prevSize){
                throw new IndexOutOfBoundsException();
            }
        }
    }
    
}
