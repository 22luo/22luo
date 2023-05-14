package com.hoosee.servlet;

import com.hoosee.model.TbSource;
import com.hoosee.service.TbSourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet( "/tbSourceServlet")
public class TbSourceServlet extends HttpServlet {
    TbSourceService tbSourceService=new TbSourceService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //定义编码方式为utf-8
        request.setCharacterEncoding("utf-8");
        //初始化日期格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String type=request.getParameter("type");
        if("add".equals(type)){
//            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
            String name=request.getParameter("name");
            String sex=request.getParameter("sex");
            String birthday=request.getParameter("birthday");
            String cardno=request.getParameter("cardno");
            String address=request.getParameter("address");
            String isLocal=request.getParameter("isLocal");
            tbSourceService.insert(name,sex,birthday,cardno,address,Integer.parseInt(isLocal));

            //查询全部
            List<TbSource> list = tbSourceService.sellectAll();
            //转发到request作用域中
            request.setAttribute("list",list);
            //跳转页面
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }else if("del".equals(type)){
            //获取用户要删除的ID
            String id=request.getParameter("id");
            //根据ID删除信息
            tbSourceService.delete(Integer.parseInt(id));

            //查询全部
            List<TbSource> list = tbSourceService.sellectAll();
            //转发到request作用域中
            request.setAttribute("list",list);
            //跳转页面
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            //查询全部
            List<TbSource> list = tbSourceService.sellectAll();
            //转发到request作用域中
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
