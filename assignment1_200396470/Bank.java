/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_200396470;

/**
 *
 * @author nihar
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Bank {    
public ArrayList<Account> Accounts = new ArrayList<>();    
private String bankName;
private String branchLocation;       
    public static enum BranchLocations {barrie,toronto,markham};	
    public static boolean check(String test){
        for (BranchLocations obj : BranchLocations.values()){
            if (obj.name().equals(test)) {
                return true;
            }
        }
        return false;
    }    
    public Bank() {}    
    public Bank(String bankName, String branchLocation){        
        this.bankName = (bankName.matches("([a-zA-Z]){5,}"))? bankName : null;
        this.branchLocation = (check(branchLocation))? branchLocation : null;
    }
    public Bank(String bankName, BranchLocations branchLocation){
       this.bankName = (bankName.matches("([a-zA-Z]){5,}"))? bankName : null;
       this.branchLocation = (branchLocation != null)? branchLocation.toString().toLowerCase() :null;
    }
    public String getBankName(){
        if (bankName != null)
            return bankName;
        else{
            return "";
        }
    }    
    public boolean setBankName(String bankName){
        if(bankName.matches("([a-zA-Z]){5,}") && bankName != null){
            this.bankName = bankName;
            return true;
        }
        else{
            return false;
        }            
    }
    
    public boolean setBranchLocation(String branchLocation){
        if(check(branchLocation)){
           this.branchLocation = branchLocation;
           return true;            
        }
        else{
            return false;
        }
            
    }
    public String getBranchLocation(){
        if(branchLocation != null)
            return branchLocation;
        else{
            return null;
        } 
    }
    public boolean setBranchLocation(BranchLocations branchLocation){
        if(branchLocation != null){
                this.branchLocation = branchLocation.toString();
                return true;
            }
            else{
                return false;
            }
    }
    public Account getAccountByNumber(String accountNumber){
        for(Account obj : Accounts){
            if(obj.getAccountNumber() == null ? accountNumber == null : obj.getAccountNumber().equals(accountNumber)){
                return obj;
            }
        }        
        return new Account(); 
    }
    public boolean addAccount(Account account){
        if(Accounts.contains(account)){
            return false;
        } 
        else{
            Accounts.add(account);
            return true;
        }
    }
    public boolean addAccount(String accountName, String accountNumber, double accountBalance){       
        Account Obj = new Account(accountName, accountNumber, accountBalance);
        if(Accounts.contains(Obj)==false){
            Accounts.add(Obj);
            return true;         
        }
        else{
        return false;
        }
    }     
    public Account viewAccount(String accountNumber){
       for(Account obj : Accounts){
        if(obj.getAccountNumber() == null ? accountNumber == null : obj.getAccountNumber().equals(accountNumber)){
            return obj;
        }
       }
       return new Account();        
    }
    public Account viewAccount(int index){
        if(index >= 0 && index <= Accounts.size()){
            Account obj = Accounts.get(index);
            return obj;            
        }
        else{            
            return new Account();
        }  
    }
    public boolean modifyAccount(String accountNumber, String accountName){
        for(Account obj : Accounts){
            if(obj.getAccountNumber() == null ? accountNumber == null : obj.getAccountNumber().equals(accountNumber) ){
                return obj.setAccountName(accountName);
            }
        }   
        return false;
    }
    public boolean modifyAccount(String accountNumber, double accountBalance){
        for(Account obj : Accounts){
         if(obj.getAccountNumber() == null ? accountNumber == null :
            obj.getAccountNumber().equals(accountNumber)){
            return obj.setAccountBalance(accountBalance);
         }   
        }   
        return false;   
    }  
    public boolean modifyAccount(String accountNumber, String accountName, double accountBalance){
        for(Account obj : Accounts){
            if(obj.getAccountNumber() == null ? accountNumber == null : obj.getAccountNumber().equals(accountNumber)){
                return obj.setAccountBalance(accountBalance) && obj.setAccountName(accountName);
            }
        }   
        return false;               
    }
    public boolean modifyAccount(int index, String accountName){
        if(index >= 0 && index <= Accounts.size()){
            Account obj = Accounts.get(index);            
            return obj.setAccountName(accountName);
        }
        return false;
    }
    public boolean modifyAccount(int index, double accountBalance){
        if(index >= 0 && index <= Accounts.size()){
            Account obj = Accounts.get(index);
            return  obj.setAccountBalance(accountBalance);
        }
        return false;                
    }
    
    public boolean modifyAccount(int index, String accountName, double accountBalance){
        if(index >= 0 && index <= Accounts.size()){
            Account obj = Accounts.get(index);
            return obj.setAccountName(accountName) && obj.setAccountBalance(accountBalance);            
        }    
        return false;
        
    }
    public boolean deleteAccount(String accountNumber){
        for(Account obj : Accounts){
         if(obj.getAccountNumber() == null ? accountNumber == null : obj.getAccountNumber().equals(accountNumber) ){
                return Accounts.remove(obj);
            }   
        }   
        return false; 
    }
    public boolean deleteAccount(int index){
        if(index >= 0 && index <= Accounts.size()){
           Accounts.remove(index);
           return true;
        }
        return false;     
    }        
}