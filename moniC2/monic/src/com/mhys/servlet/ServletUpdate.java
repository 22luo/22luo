package com.mhys.servlet;

import com.mhys.dao.TbBookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletUpdate")
public class ServletUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //
        TbBookDao tbBookDao=new TbBookDao();
        //
        tbBookDao.updateTbBook("1",request.getParameter("var"));
        //
        System.out.printf("修改成功");
        //
        request.getRequestDispatcher("ServletSelect").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
