package com.kamil.servlet;

import com.kamil.model.Client;
import com.kamil.model.Contract;
import com.kamil.service.ContractService;
import com.kamil.service.ClientService;
import com.kamil.service.ContractServiceImpl;
import com.kamil.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateContractServlet extends HttpServlet {

    private ContractService contractService = new ContractServiceImpl();
    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("contractId");
        Contract contract = contractService.getContractById(Integer.parseInt(id));
        Client client = clientService.getClientById(contract.getClientId());
        request.setAttribute("contract", contract);
        request.setAttribute("client", client);
        request.getRequestDispatcher("/WEB-INF/view/CreateOrEdit.jsp").forward(request,response);
    }
}
