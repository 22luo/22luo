package com.mhys.servlet;

import com.mhys.dao.TbBookDao;
import com.mhys.model.TbBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ServletInsert")
public class ServletInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //
        request.setCharacterEncoding("utf-8");
        //
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //
        TbBookDao tbBookDao= new TbBookDao();
        TbBook tbBook=new TbBook();
        //
        tbBook.setBook_name(request.getParameter("name"));
        tbBook.setBook_author(request.getParameter("zz"));
        tbBook.setBook_price(Float.parseFloat(request.getParameter("price")));
        tbBook.setBook_publisher(request.getParameter("sd"));
        tbBook.setBook_state(0);

            tbBook.setAdd_time(sdf.format(date));

        //
        tbBookDao.insertTbBook(tbBook);
        //
        request.getRequestDispatcher("ServletSelect").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
