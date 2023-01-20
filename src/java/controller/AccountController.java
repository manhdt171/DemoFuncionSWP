package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DAO.Login;
import DAO.MD5;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       MD5 sec = new MD5();
       String mess="";
       String account=req.getParameter("acc");
       String pass=req.getParameter("pass");
       String role=req.getParameter("role");
       String SaltPass = pass + sec.saltMd5();
       String PassMD5 = sec.getMd5(SaltPass);
       //su li thong tin
       Account acc = new Account(account, PassMD5, role);
       Login checkLogin = new Login();
       boolean OK = checkLogin.checklogin(acc);
       // tra kq ve cho view
       if(OK){
           HttpSession session=req.getSession();
           session.setAttribute("account", account);
           req.setAttribute("account", account);
           req.getRequestDispatcher("main.jsp").forward(req, resp);
       }else{
           mess = "Sai tai khoan, mat khau";
           req.setAttribute("mess", mess);
           req.getRequestDispatcher("login.jsp").forward(req, resp);
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
