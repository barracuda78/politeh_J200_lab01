/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ENVY
 */
public class Lab1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //кодировку реквеста нужно установить:
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String info = request.getParameter("info");
        String send = request.getParameter("send");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lab1</title>");
            //ДОБАВКА:
            out.println("<style>");
                out.println("body{background-color: #AAAAFF;}");
                out.println("#box{");
                    out.println("position: absolute;");
                    out.println("top: 50%;");
                    out.println("left: 50%;");
                    out.println("margin: -75px 0px 0px -193px;");
                    out.println("padding: 10px;");

                    out.println("width: 360px;");
                    out.println("height: 150px;");

                    out.println("border: dotted blue 1px;");
                out.println("}");
                out.println("td{");
                    out.println("text-align:center;");
                out.println("}");
            out.println("</style>");   
            //КОНЕЦ ДОБАВКИ.
            out.println("</head>");
            out.println("<body>");
                out.println("<div id=\"box\">");  
                if(send != null){

                    if(info == null || "".equals(info)){
                        out.println("<h3>Повторите ввод</h3>");
                    }else{

                        try{
                            int i = Integer.valueOf(info);
                            i = i + 100;
                            out.println("<h3>Наше число больше на сотню: " + i + "</h3>");
                        }catch(NumberFormatException e){
                            if(send != null){
                            out.println("<h3>Число слов в веденной Вами строке = " + info + "</h3>");
                            //info = info.replaceAll("\\s+", " ");
                            String[] sArray = info.split(" +");
                            int countWords = sArray.length;
                            out.println("<h3>Составляет:" + countWords + "</h3>");
                            }
                        }
                    }
                }

                out.println("<form action=\"Lab1\" method=\"GET\" >");

                out.println("<p><b> Введите что-нибудь : </b>");
                //поле ввода:
                //"info" - передаем параметром в метод String info = request.getParameter("info"); выше
                out.println("<input type=\"text\" name=\"info\" size=20 />");
                //кнопочка:
                out.println("<input type=\"submit\" name=\"send\" value=\"Отправить\" />");

                out.println("</p></form>");
                out.println("<br></br><br></br>");

                //out.println("<h1>Servlet Lab1 at " + request.getContextPath() + "</h1>");
                //out.println("<h1>Русский текст</h1>");
                out.println("<div>");
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

}
