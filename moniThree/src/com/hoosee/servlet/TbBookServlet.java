package com.hoosee.servlet;

import com.hoosee.model.TbBook;
import com.hoosee.service.TbBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/tbBookServlet")
public class TbBookServlet extends HttpServlet {
   TbBookService tbBookService= new TbBookService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //定义编码方式为utf-8
        request.setCharacterEncoding("utf-8");
        //定义日期格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String type=request.getParameter("type");
        if("update".equals(type)){
            String id=request.getParameter("id");
            tbBookService.update("1",Integer.parseInt(id));

            //查询全部
            List<TbBook> list = tbBookService.selectAll();
            //请求转发到request作用域中
            request.setAttribute("list",list);
            //跳转页面
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }else if("add".equals(type)){
            String name=request.getParameter("name");
            String zz=request.getParameter("zz");
            String price=request.getParameter("price");
            String cbs=request.getParameter("cbs");
            Date date=new Date();
            String d=sdf.format(date)+"";
            tbBookService.insert(name,zz,Float.parseFloat(price),cbs,0,d);

            //查询全部
            List<TbBook> list = tbBookService.selectAll();
            //请求转发到request作用域中
            request.setAttribute("list",list);
            //跳转页面
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } else {
            //查询全部
            List<TbBook> list = tbBookService.selectAll();
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
