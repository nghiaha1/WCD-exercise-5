package com.wcd.excercise5.controller;

import com.wcd.excercise5.entity.Phone;
import com.wcd.excercise5.entity.myenum.PhoneStatus;
import com.wcd.excercise5.model.MySqlPhoneModel;
import com.wcd.excercise5.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreatePhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;

    public CreatePhoneServlet() {
        this.phoneModel = new MySqlPhoneModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        Phone phone = new Phone();
        phone.setName(name);
        phone.setBrand(brand);
        phone.setDescription(description);
        phone.setPrice(price);
        phone.setCreatedAt(LocalDateTime.now());
        phone.setUpdatedAt(LocalDateTime.now());

        if (!phone.isValid()) {
            req.setAttribute("phone", phone);
            req.setAttribute("errors",phone.getErrors());
            req.getRequestDispatcher("/addphone.jsp").forward(req,resp);
        }

        if (phoneModel.add(phone) != null) {
            resp.sendRedirect("/listphone");
        } else {
            req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
        }
    }
}
