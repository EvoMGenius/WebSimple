package com.apatrios;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
собирать в maven. war файл.
clean install - соберет файл который надо запустить на серве.
clean install tomcat7:redeploy - соберет файл и запустит на серве.
сервлет создается всегда в одном единственном экземпляре. service может дергаться из разных потоков.
 */
@WebServlet(urlPatterns = "/")//ссылка на котором весит сервлет
public class FirstServlet implements Servlet {

    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException { //вызывется при создании сервлета
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException { //каждый раз когда на него будет приходить запрос, будет вызывваться этот метот
        servletResponse.getWriter().println("<h1>Hello World</h1>");
    }

    @Override
    public String getServletInfo() {
        return "first test servlet";
    }

    @Override
    public void destroy() { // в конце работы вызывается

    }
}
