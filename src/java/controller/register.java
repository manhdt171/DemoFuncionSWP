package controller;


import DAO.GetSetAccount;
import DAO.MD5;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Account;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       MD5 sec = new MD5();
       String mess="";
       String account=req.getParameter("acc");
       String pass=req.getParameter("pass");
       String role=req.getParameter("role");
       String SaltPass = pass + sec.saltMd5();
       String PassMD5 = sec.getMd5(SaltPass);
       Account acc= new Account(account, PassMD5, role);
       GetSetAccount getset = new GetSetAccount();
       ArrayList<Account> getAllacc = getset.getAllAccount();
       getset.insert(account, PassMD5, role, getAllacc);
       req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    
}
