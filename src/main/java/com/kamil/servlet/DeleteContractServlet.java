package com.kamil.servlet;

import com.kamil.service.ContractService;
import com.kamil.service.ContractServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteContractServlet extends HttpServlet {

    private ContractService contractService = new ContractServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("contractId");
        contractService.deleteContract(Integer.parseInt(id));
        response.sendRedirect("/list");
    }
}
