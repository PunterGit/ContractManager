package com.kamil.servlet;

import com.kamil.service.ClientService;
import com.kamil.service.ClientServiceImpl;
import com.kamil.service.ContractService;
import com.kamil.service.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list")
public class ContractListServlet extends HttpServlet {

    private ContractService contractService = new ContractServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contracts", contractService.getContracts());
        request.getRequestDispatcher("/WEB-INF/view/ContractList.jsp").forward(request,response);
    }
}
