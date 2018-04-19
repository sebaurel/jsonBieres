package fr.wildcodeschool.jsonbiere;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet( name="ServletIndex", urlPatterns = {"/index.html"} )

public class ServletIndex extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       

        request.setAttribute("biere", DAOJsonRecherche.rechercheBiere(1));

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
