package fr.wildcodeschool.jsonbiere.controler;

import fr.wildcodeschool.jsonbiere.model.DAOJsonRecherche;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletBiere", urlPatterns = {"/beer"})
public class ServletBiere extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("biere", DAOJsonRecherche.rechercheBiere(id));

        getServletContext().getRequestDispatcher("/beer.jsp").forward(request, response);
    }
}
