package com.hoosee.servlet;

import com.hoosee.dao.TbCourseDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ServletDelect")
public class ServletDelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            TbCourseDao  tbCourseDao=new TbCourseDao();
            //获取id
            String id=request.getParameter("var");
            //调用方法删除id
            tbCourseDao.delTbCourse(id);
            //更新到查询全部
            request.getRequestDispatcher("ServletSelect").forward(request,response);
    }
}
