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
import java.util.List;

@WebServlet("/client/list")
public class ClientListServlet extends HttpServlet {

    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String respData = "[";
        List<Client> clients = clientService.getClients();
        for (Client client:clients){
            respData += client+",";
        }
        respData += "]";
        response.getWriter().write(respData);
    }
}
