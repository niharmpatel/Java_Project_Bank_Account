/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_200396470;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 *
 * @author nihar
 */
public class Account {
    private String   accountNumber;
    private double accountBalance;
    private String accountName;
  //  public static DecimalFormat d = new DecimalFormat("#.##");
   
	public Account() {}
	public Account(String accountName, String accountNumber,double accountBalance) {
            if(accountName.matches("(^[a-z-A-Z]*$){2,}") && accountName != null){
                this.accountName = accountName;
            }
            else
                this.accountName = null;
            if(accountNumber.matches("([0-9]){7,}" )){
                this.accountNumber = accountNumber;
            }
            else{
                this.accountNumber = null;
            }
//            Double newValue = Double.parseDouble(d.format(accountBalance));
//            if(newValue == accountBalance){            
            String abToString = Double.toString(accountBalance);
            if (abToString.matches("-?[0-9]+(.[0-9]{0,2})")){
                 this.accountBalance = accountBalance;
            }
      	}     
//             for (Account account:Acco
	public String getAccountName() {
            if(accountName != null){
            return accountName;
            }
            else{
                return"";
            }
	}
	public boolean setAccountName(String accountName) {            
            if (accountName.matches("([a-z-A-Z]){2,}") && !accountName.contains(" ")){
                this.accountName = accountName;
                return true;
            }
            else{
                this.accountName ="";
		return false;
            }
	}
	public String  getAccountNumber() {
		return accountNumber;
	}
	public boolean setAccountNumber(String  accountNumber) {
             if(accountNumber.matches("([0-9]){7,}" ))
        {
        this.accountNumber= accountNumber;
        return true;
        }
        else{
		return false;
             }
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public boolean setAccountBalance(double value) {
            //Double newValue = Double.parseDouble(d.format(value));
            //if(newValue == accountBalance){
            String bToString = Double.toString(value);
            if(bToString.matches("-?[0-9]+(.[0-9]{0,2})")){
            this.accountBalance = value;
                return true;
            }
            else{
                
                return false;
            }
        }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
            return false;
        }
        if (Double.doubleToLongBits(this.accountBalance) != Double.doubleToLongBits(other.accountBalance)) {
            return false;
        }
        if (!Objects.equals(this.accountName, other.accountName)) {
            return false;
        }
        return true;
    }
/*	@Override
	public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            else{
		return false;
            }
	}        
    
	@Override
	public String toString() {
		return "";
    
	}  
*/
    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", accountName=" + accountName + "}" ;
    }
    
}
