package com.kamil.servlet;

import com.kamil.model.Client;
import com.kamil.service.ClientService;
import com.kamil.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client/update")
public class UpdateClientServlet extends HttpServlet {

    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset = UTF-8");
        int id = Integer.parseInt(request.getParameter("clientChangingId"));
        Client client = clientService.getClientById(id);
        request.setAttribute("client", client);
        request.getRequestDispatcher("/WEB-INF/view/CreateOrEdit.jsp").forward(request,response);
    }
}
