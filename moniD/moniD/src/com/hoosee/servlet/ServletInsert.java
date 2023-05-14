package com.hoosee.servlet;

import com.hoosee.dao.TbCourseDao;
import com.hoosee.model.TbCourse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ServletInsert")
public class ServletInsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              request.setCharacterEncoding("utf-8");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        TbCourseDao  tbCourseDao=new TbCourseDao();
        TbCourse tbCourse=new TbCourse();
        tbCourse.setName(request.getParameter("name"));
        tbCourse.setCount(Integer.getInteger(request.getParameter("type")));
        try {
            tbCourse.setStartDate(sdf.parse(request.getParameter("date")));
            tbCourse.setEndDate(sdf.parse(request.getParameter("end")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tbCourse.setTeacher(request.getParameter("js"));
        tbCourseDao.insertTbCourse(tbCourse);
        request.getRequestDispatcher("ServletSelect").forward(request,response);

    }
}
