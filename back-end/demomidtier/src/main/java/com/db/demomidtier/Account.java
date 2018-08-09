package com.db.demomidtier;
 
/**
 *
 * @author Selvyn
 */
public class Account
{
    private double  itsBalance = 0;
     
    public  Account()
    {
    }
     
    public  Account( double amt )
    {
        itsBalance = amt;
    }
     
    public  double  getBalance()
    {
        return itsBalance;
    }
     
    public  double  credit( double amt )
    {
        itsBalance += amt;
         
        return itsBalance;
    }
     
    public  double  dedit( double amt )
    {
        if( (itsBalance - amt) >= 0 )
            itsBalance += amt;
         
        return itsBalance;
    }
}