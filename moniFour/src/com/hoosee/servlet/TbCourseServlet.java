package com.hoosee.servlet;

import com.hoosee.model.TbCourse;
import com.hoosee.service.TbCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@WebServlet( "/tbCourseServlet")
public class TbCourseServlet extends HttpServlet {
    TbCourseService tbCourseService=new TbCourseService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义编码方式
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        if("likk".equals(type)){
            String i=request.getParameter("inpu");
            //模糊查询s
            List<TbCourse> list = tbCourseService.selectLike(i);
            //请求转发到request作用域中
            request.setAttribute("list",list);
            request.setAttribute("inpu",i);
            //跳转页面
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if("del".equals(type)){
            String id=request.getParameter("id");
            tbCourseService.delete(Integer.parseInt(id));
            //查询全部
            List<TbCourse> list = tbCourseService.selectAll();
            //请求转发到request作用域中
            request.setAttribute("list",list);
            //跳转页面
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if("add".equals(type)){
            String name=request.getParameter("name");
            String typ=request.getParameter("typ");
            String date=request.getParameter("date");
            String end=request.getParameter("end");
            String js=request.getParameter("js");
            System.out.println(name);
            System.out.println(typ);
            System.out.println(date);
            System.out.println(end);
            System.out.println(js);

            tbCourseService.insert(name,Integer.parseInt(typ),date,end,js);
            //查询全部
            List<TbCourse> list = tbCourseService.selectAll();
            //请求转发到request作用域中
            request.setAttribute("list",list);
            //跳转页面
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            //查询全部
            List<TbCourse> list = tbCourseService.selectAll();
            //请求转发到request作用域中
            request.setAttribute("list",list);
            //跳转页面
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }



    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
