package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import webservices.ComprasService_Service;

/**
 *
 * @author angel
 */
@WebServlet(name = "ComprasServlet", urlPatterns = {"/ComprasServlet"})
public class ComprasServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WSCompras/ComprasService.wsdl")
    private ComprasService_Service service;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los parámetros de la solicitud y convertirlos a enteros
        int cantidadPan = Integer.parseInt(request.getParameter("cantidadPan"));
        int cantidadQueso = Integer.parseInt(request.getParameter("cantidadQueso"));
        int cantidadPlatano = Integer.parseInt(request.getParameter("cantidadPlatano"));
        int cantidadNaranja = Integer.parseInt(request.getParameter("cantidadNaranja"));

        // Invocar el método del servicio web
        String message = "";
        
        try{
            message = comprar(cantidadPan, cantidadQueso, cantidadPlatano, cantidadNaranja);
        }catch(Exception a){
            System.out.print(a);
        }
        

        // Configurar la respuesta
        response.setContentType("text/html;charset=UTF-8");

        //response.sendRedirect("result.jsp");
        
        if(message.equals("Las cantidades son incorrectas")){
            
            response.sendRedirect("result.jsp?isErrorPage=true");
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ComprasController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComprasController at " + request.getContextPath() + "</h1>");
            out.println("<p>Mensaje del servicio: " + message + "</p>");
            out.println("<p>Cantidad de Pan: " + cantidadPan + "</p>");
            out.println("<p>Cantidad de Queso: " + cantidadQueso + "</p>");
            out.println("<p>Cantidad de Plátano: " + cantidadPlatano + "</p>");
            out.println("<p>Cantidad de Naranja: " + cantidadNaranja + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String comprar(int cantidadPan, int cantidadQueso, int cantidadPlatanos, int cantidadNaranjas) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservices.ComprasService port = service.getComprasServicePort();
        return port.comprar(cantidadPan, cantidadQueso, cantidadPlatanos, cantidadNaranjas);
    }

}
