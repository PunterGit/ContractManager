package com.kamil.servlet;


import com.kamil.model.Contract;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/add")
public class AddContractServlet extends HttpServlet {


    private ContractService contractService = new ContractServiceImpl();
    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/view/CreateOrEdit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Contract contract = new Contract();

        if (request.getParameter("contractId") != null && !request.getParameter("contractId").isEmpty()) {
            contract.setId(Integer.parseInt(request.getParameter("contractId")));
        }
        contract.setPostcode(Integer.parseInt(request.getParameter("postcode")));
        contract.setConstructionYear(Integer.parseInt(request.getParameter("constructionYear")));
        contract.setInsuranceSum(Float.parseFloat(request.getParameter("insuranceSum")));
        contract.setInsurancePremium(Float.parseFloat(request.getParameter("insurancePremium")));
        contract.setArea(Float.parseFloat(request.getParameter("area")));
        try {
            contract.setInsuranceStartDate( new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("insuranceStartDate")));
            contract.setInsuranceEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("insuranceEndDate")));
            contract.setComputationDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("computationDate")));
            contract.setContractDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("contractDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        contract.setProperty(request.getParameter("property"));
        contract.setCountry(request.getParameter("country"));
        contract.setRepublic(request.getParameter("republic"));
        contract.setRegion(request.getParameter("region"));
        contract.setLocality(request.getParameter("locality"));
        contract.setStreet(request.getParameter("street"));
        contract.setHouse(request.getParameter("house"));
        contract.setHousing(request.getParameter("housing"));
        contract.setBuilding(request.getParameter("building"));
        contract.setApartment(request.getParameter("apartment"));
        contract.setComment(request.getParameter("comment"));
        contract.setClientId(clientService.getClientById(Integer.parseInt(request.getParameter("clientId"))));
        contractService.addContract(contract);
        response.sendRedirect("/list");
    }
}
