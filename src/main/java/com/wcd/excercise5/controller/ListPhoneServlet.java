package com.wcd.excercise5.controller;

import com.wcd.excercise5.model.MySqlPhoneModel;
import com.wcd.excercise5.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListPhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;

    public ListPhoneServlet() {
        this.phoneModel = new MySqlPhoneModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("phone", phoneModel.findAll());
        req.getRequestDispatcher("/listphone.jsp").forward(req, resp);
    }
}
