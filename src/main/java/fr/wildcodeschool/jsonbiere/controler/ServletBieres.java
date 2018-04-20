package fr.wildcodeschool.jsonbiere.controler;

import fr.wildcodeschool.jsonbiere.model.DAOJsonRecherche;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletBieres", urlPatterns = {"/beers"})
public class ServletBieres extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");


        if (name != null || name != ""){
            request.setAttribute("name", name);

            request.setAttribute("bieres", DAOJsonRecherche.rechercheBiere(name));

        } else if (type != null || type != "") {
            String ingredient = request.getParameter("ingredient");
            double quantite = Double.parseDouble(request.getParameter("quantite"));

            request.setAttribute("type", type);
            request.setAttribute("ingredient", ingredient);
            request.setAttribute("quantite", quantite);

            request.setAttribute("bieres", DAOJsonRecherche.rechercheBiere(type, ingredient, quantite));
        }
        else {
            request.setAttribute("bieres", DAOJsonRecherche.rechercheTouteBieres());
        }
        getServletContext().getRequestDispatcher("/beers.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("bieres", DAOJsonRecherche.rechercheTouteBieres());


        getServletContext().getRequestDispatcher("/beers.jsp").forward(request, response);
    }
}
