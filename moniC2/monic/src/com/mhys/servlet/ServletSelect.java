package com.mhys.servlet;

import com.mhys.dao.TbBookDao;
import com.mhys.model.TbBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletSelect")
public class ServletSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //查询
        TbBookDao tbBookDao= new TbBookDao();
        //
        List<TbBook>list=tbBookDao.selectTbBook();
        //
        request.setAttribute("list",list);
        //
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
