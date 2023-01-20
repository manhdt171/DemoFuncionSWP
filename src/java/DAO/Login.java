/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class Login extends DBContext {

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
    public boolean checklogin(Account acc) {
        connectDB();
        try {
            String strSelect = "select * from [login] "
                    + "where Acc= ? and "
                    + "Pass=? and "
                    + "[Role]=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc.getAccount());
            pstm.setString(2, acc.getPass());
            pstm.setString(3, acc.getRole());
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login error : " + e.getMessage());
            System.out.println(acc.getAccount());
            System.out.println("day la pass: " + acc.getPass());
            System.out.println("day la role: " + acc.getRole());
        }
        return false;
    }
}
