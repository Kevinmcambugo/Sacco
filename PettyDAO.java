package Sacco.view.pettycashDAO;

import Sacco.connection.DBConnector;


import Sacco.view.financeManip.PettyReturns;
import Sacco.view.pettycashManip.ApprovePettyCash;
import Sacco.view.pettycashManip.GLaccounts;
import Sacco.view.pettycashManip.PayeeManip;
import Sacco.view.pettycashManip.PettyApprove;
import Sacco.view.pettycashManip.PettyAuthorize;
import Sacco.view.pettycashManip.PettyCashCapture;
import Sacco.view.pettycashManip.PettyPayee;
import Sacco.view.pettycashManip.PettyRefund;
import Sacco.view.pettycashManip.PettySettings;

import Sacco.view.pettycashManip.ReverseIssuance;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class PettyDAO {
    DBConnector db=new DBConnector();
    public PettyDAO() {
        super();
    }
    
    public List<PettySettings> findAccountGroup() 
        {
       
           Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            
            List<PettySettings>data=new ArrayList<PettySettings>();
             String query = "{call getPettySettings()}";
                try
                   {
                    conn= db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PettySettings la=new PettySettings();
                           la.setId(rs.getString(1));
                              la.setAccountName(rs.getString(2));
                           la.setGlAccount(rs.getString(3));
                           la.setCurrency(rs.getString(4));
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    public List<GLaccounts> findAccounts( ) 
        {
       
         
                         
                                          PreparedStatement pstmt = null;
                             Connection conn=null;
                             ResultSet rs=null;
                          
                             List<GLaccounts>data=new ArrayList<GLaccounts>();
                                          String query ="{CALL getAccounts()}";
                                        
                                          
                                         
                         

                             
                                 try
                                    {
                                     conn=db.getDataSourceConnection();
                                        pstmt = conn.prepareStatement(query);
                                      
                                       
                                        rs = pstmt.executeQuery();
                                        while(rs.next())
                                        {
                                                GLaccounts mem=new GLaccounts();
                                                   mem.setCode(rs.getString(1));
                                                mem.setName(rs.getString(2));
                                                
                                                   
                                                data.add(mem);
                                            
                                            }
                                    }
                                    catch(Exception e)
                                    {
                                       e.printStackTrace(); 
                                        }
                                          finally
                                          {
                                       
                                        try{
                                            if(rs!=null){
                                            rs.close();
                                            }
                                            
                                            db.closeConnection(conn,pstmt);
                                           
                                           
                                        }
                                    catch(Exception e)
                                    {
                                      e.printStackTrace();     
                                      }
                                          }
                                      
                     return data;
                     }
    
    public List<PayeeManip> findPetyPayee() 
        {
       
           Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            List<PayeeManip>data=new ArrayList<PayeeManip>();
             String query = "{call getPettyPayee()}";
                try
                   {
                    conn= db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PayeeManip la=new PayeeManip();
                           la.setIdNo(rs.getString(1));
                              la.setFName(rs.getString(2));
                           la.setLName(rs.getString(3));
                          
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    
    
    public List<PettyCashCapture> findPettyCash() 
        {
       
            Connection conn=null;
            Statement state=null;
            ResultSet rs=null;
            List<PettyCashCapture>data=new ArrayList<PettyCashCapture>();
             String query = "{call getPettyCash()}";
                try
                   {
                    conn=db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PettyCashCapture la=new PettyCashCapture();
                           la.setId(rs.getString(1));
                              la.setAmount(rs.getBigDecimal(2));
                           la.setDescription(rs.getString(3));
                           la.setDate(rs.getString(4));
                           la.setStatus(rs.getString(5));
                           la.setPayee(rs.getString(6));
                          
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    
    
    public List<PettyPayee> findPettyPayees() 
        {
       
           Connection conn=null;
           Statement state=null;
            ResultSet rs=null;
            List<PettyPayee>data=new ArrayList<PettyPayee>();
             String query = "{call getPettyPayees()}";
                try
                   {
                    conn= db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PettyPayee la=new PettyPayee();
                           la.setId(rs.getString(1));
                              la.setName(rs.getString(2));
                           
                          
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    public List<PettyAuthorize> findPettyCashAuth() 
        {
       
            Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            List<PettyAuthorize>data=new ArrayList<PettyAuthorize>();
             String query = "{call getPettyCash()}";
                try
                   {
                    conn=db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PettyAuthorize la=new PettyAuthorize();
                           la.setId(rs.getString(1));
                              la.setAmount(rs.getBigDecimal(2));
                           la.setDescription(rs.getString(3));
                           la.setDate(rs.getString(4));
                           la.setStatus(rs.getString(5));
                           la.setPayee(rs.getString(6));
                          la.setSelected(false);
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    public List<PettyApprove> findPettyCashApprove() 
        {
       
          Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            List<PettyApprove>data=new ArrayList<PettyApprove>();
             String query = "{call getPettyApproval()}";
                try
                   {
                    conn=  db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PettyApprove la=new PettyApprove();
                           la.setId(rs.getString(1));
                              la.setAmount(rs.getBigDecimal(2));
                           la.setDescription(rs.getString(3));
                           la.setDate(rs.getString(4));
                           la.setStatus(rs.getString(5));
                           la.setPayee(rs.getString(6));
                          la.setSelected(false);
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    
    public List<ApprovePettyCash> findPettyCashIssue() 
        {
       
          Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            List<ApprovePettyCash>data=new ArrayList<ApprovePettyCash>();
             String query = "{call get_petty_issue()}";
                try
                   {
                    conn=  db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           ApprovePettyCash la=new ApprovePettyCash();
                           la.setId(rs.getString(1));
                              la.setAmount(rs.getBigDecimal(2));
                           la.setDescription(rs.getString(3));
                           la.setDate(rs.getString(4));
                           la.setStatus(rs.getString(5));
                           la.setPayee(rs.getString(6));
                          la.setSelected(false);
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    public List<ReverseIssuance> findPettyCashReverseIssuance() 
        {
       
          Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            List<ReverseIssuance>data=new ArrayList<ReverseIssuance>();
             String query = "{call reverse_issuance_petty()}";
                try
                   {
                    conn=  db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           ReverseIssuance la=new ReverseIssuance();
                           la.setId(rs.getString(1));
                              la.setAmount(rs.getBigDecimal(2));
                           la.setDescription(rs.getString(3));
                           la.setDate(rs.getString(4));
                           la.setStatus(rs.getString(5));
                           la.setPayee(rs.getString(6));
                          la.setSelected(false);
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    public List<PettyReturns> findPettyCashReturns() 
        {
       
          Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            List<PettyReturns>data=new ArrayList<PettyReturns>();
             String query = "{call capture_return()}";
                try
                   {
                    conn=  db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PettyReturns la=new PettyReturns();
                           la.setId(rs.getString(1));
                              la.setAmount(rs.getBigDecimal(2));
                           la.setDescription(rs.getString(3));
                           la.setDate(rs.getString(4));
                           la.setStatus(rs.getString(5));
                           la.setPayee(rs.getString(6));
                          la.setSelected(false);
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    
    
    public List<PettyRefund> findPettyCashReturnsAuth() 
        {
       
          Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            List<PettyRefund>data=new ArrayList<PettyRefund>();
             String query = "{call get_authorize_returns()}";
                try
                   {
                    conn=  db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PettyRefund la=new PettyRefund();
                           la.setId(rs.getString(1));
                              la.setAmount(rs.getBigDecimal(2));
                               la.setOrigAmount(rs.getBigDecimal(3));
                           la.setDescription(rs.getString(4));
                           la.setDate(rs.getString(5));
                           la.setStatus(rs.getString(6));
                           la.setPayee(rs.getString(7));
                          la.setSelected(false);
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
    
    public List<PettyRefund> findPettyCashReverseReturns() 
        {
       
          Connection conn=null;
            ResultSet rs=null;
            Statement state=null;
            List<PettyRefund>data=new ArrayList<PettyRefund>();
             String query = "{call get_reverse_returns()}";
                try
                   {
                    conn=  db.getDataSourceConnection();
                    state=conn.createStatement();

                       rs=state.executeQuery(query);
                       while(rs.next())
                       {
                           PettyRefund la=new PettyRefund();
                           la.setId(rs.getString(1));
                              la.setAmount(rs.getBigDecimal(2));
                               la.setOrigAmount(rs.getBigDecimal(3));
                           la.setDescription(rs.getString(4));
                           la.setDate(rs.getString(5));
                           la.setStatus(rs.getString(6));
                           la.setPayee(rs.getString(7));
                          la.setSelected(false);
                          
                          
                           data.add(la);
                           
                           }
                   }
                   catch(Exception e)
                   {
                      e.printStackTrace(); 
                       }
                         finally
                         {
                      
                       try{
                           if(rs!=null){
                           rs.close();
                           }
                           db.closeConnection(conn,state);
                       }
                   catch(Exception e)
                   {
                     e.printStackTrace();     
                     }
                         }
                     return data;
                     }
}
