/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pures6322
 */ 
public class FileInfo{
    //instance variables
    private File bankFile;
    private FileWriter write;
    private BufferedWriter bfW;
    private BufferedReader bfR;
    private FileReader read;
    
    //constructor
    public FileInfo() throws IOException {
        //initialize variables
        this.bankFile = new File("BankAccountInfo.txt");
        this.write = new FileWriter(this.bankFile, true);
        this.bfW = new BufferedWriter(this.write);
        this.read = new FileReader(this.bankFile);
        this.bfR = new BufferedReader(this.read);
    }
    
    /**
     * Creates an account loaded in with information from the bank account info text file
     * @return the next account with the loaded in information
     * @throws IOException if the file doesn't exist/the buffered reader has read a line with nothing contained in it
     */
    public Account loadAccounts() throws IOException{
        //variables for account info
        String accNumber;
        String name;
        String pass;
        String balance;
        String address;
        String status;
        
        //intialize variables
        accNumber = bfR.readLine();
        name = bfR.readLine();
        pass = bfR.readLine();
        balance = bfR.readLine();
        address = bfR.readLine();
        status = bfR.readLine();
        //remove zeros
        accNumber = accNumber.replaceAll("0", "");
        
        
        //create account and return it
        Account acc = new Account(name, address, Double.parseDouble(balance), pass, Integer.parseInt(accNumber), Integer.parseInt(status));
        return acc;
    }
    
    /**
     * Gets the amount of accounts in the database (text file)
     * @return The number of accounts
     * @throws IOException when the buffered reader has read a line with nothing contained in it
     */
    public int amountOfAccounts() throws IOException{
        //The first line in the text file contains this information
        return Integer.parseInt(bfR.readLine());
    }
    
    /**
     * saves all account data to the text file
     * @param accounts
     * @throws IOException 
     */
    public void save(ArrayList<Account> accounts) throws IOException{
        int numOfAcc = accounts.size();
        
        String txt = numOfAcc + "\n";
        
        for (int i = 0; i < numOfAcc; i++) {
            
            if(accounts.get(i).accNum() < 10){
                txt += "000" + accounts.get(i).accNum() + "\n";
            } else if(accounts.get(i).accNum() < 100){
                txt += "00" + accounts.get(i).accNum() + "\n";
            } else if(accounts.get(i).accNum() < 1000){
                txt += "0" + accounts.get(i).accNum() + "\n";
            }else{
                txt += accounts.get(i).accNum() + "\n";
            }
                
            
            txt += accounts.get(i).getName() + "\n";
            txt += accounts.get(i).pass() + "\n";
            txt += accounts.get(i).getBalance() + "\n";
            txt += accounts.get(i).getAddress() + "\n";
            txt += accounts.get(i).getStatus() + "\n";
        }
        
        this.write = new FileWriter(this.bankFile, false);
        this.bfW.write(txt);
        this.bfW.flush();
        
    }
}
