/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class Account extends DBContext {
    String IdAcc;
    String Account;
    String Pass;
    String Role;

    public String getAccount() {
        return Account;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getIdAcc() {
        return IdAcc;
    }

    public void setIdAcc(String IdAcc) {
        this.IdAcc = IdAcc;
    }
    
    public Account() {
        connectDB();
    }

    public Account(String Account, String Pass, String Role) {
        this.Account = Account;
        this.Pass = Pass;
        this.Role = Role;
        connectDB();
    }

    public Account(String IdAcc, String Account, String Pass, String Role) {
        this.IdAcc = IdAcc;
        this.Account = Account;
        this.Pass = Pass;
        this.Role = Role;
        connectDB();
    }
    

    Connection cnn;//ket noi db
    Statement stm;//thuc hien yeu cau lenh db
    ResultSet rs;// luu tru va su li du lieu
    PreparedStatement pstm;

    private void connectDB() {
        try {
            cnn = super.connection;
            System.out.println("connect success");
        } catch (Exception e) {
            System.out.println("Connext error " + e.getMessage());
        }
    }
     public boolean checklogin() {
        try {
            String strSelect = "select * from [login] "
                    + "where Acc= ? and "
                    + "Pass=? and "
                    + "[Role]=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, Account);
            pstm.setString(2, Pass);
            pstm.setString(3, Role);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login error : " + e.getMessage());
        }
        return false;
    }
}
