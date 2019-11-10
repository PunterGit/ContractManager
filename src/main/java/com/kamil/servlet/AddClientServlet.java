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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/client/add")
public class AddClientServlet extends HttpServlet {


    private ClientService contractService = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/view/CreateOrEdit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Client client = new Client();

        if (request.getParameter("clientChangingId") != null && !request.getParameter("clientChangingId").isEmpty()) {
            client.setId(Integer.parseInt(request.getParameter("clientChangingId")));
        }
        try{
            client.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("clientBirthDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        client.setName(request.getParameter("clientName"));
        client.setMiddlename(request.getParameter("clientMiddlename"));
        client.setSurname(request.getParameter("clientSurname"));
        client.setPassportId(Float.parseFloat(request.getParameter("clientPassportId")+"."+request.getParameter("clientPassportId2")));
        String clientId = Integer.toString(contractService.addClient(client));
        response.getOutputStream().write(clientId.getBytes("UTF-8"));
    }
}
