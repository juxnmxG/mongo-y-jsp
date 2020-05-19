package Controlador;

import Estudiante.Estudiante;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    Estudiante e = new Estudiante();
    PersonaDAO dao = new PersonaDAO();
    String id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
   
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso = add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            
            id = request.getParameter("txtId");
            String nom =request.getParameter("txtNom");
            String fec =request.getParameter("txtFec");
            
            e.setId(id);
            e.setNombre(nom);
            e.setFecha(fec);
            dao.add(e);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String id_2 = request.getParameter("txtId");
            String nom = request.getParameter("txtNom");
            String fec = request.getParameter("txtFec");
            e.setId(id_2);
            e.setNombre(nom);
            e.setFecha(fec);
            dao.edit(e);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            String id_1 = request.getParameter("txtId");
            e.setId(id_1);
            dao.eliminar(id_1);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
