package com.hoosee.servlet;

import com.hoosee.dao.TbCourseDao;
import com.hoosee.model.TbCourse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletSelect")
public class ServletSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        TbCourseDao tbCourseDao=new TbCourseDao();
        String var=request.getParameter("var");
        List<TbCourse> list;
        if(var==null){
            list=tbCourseDao.selectTbCourse("");
        }else {
            list=tbCourseDao.selectTbCourse(request.getParameter("inpu"));
        }
        request.setAttribute("list",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
