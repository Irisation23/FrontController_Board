package com.nhnacademy.filter;

import com.nhnacademy.board.util.WhiteListUtils;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "*.do", initParams = {
    @WebInitParam(name = "whitelist", value = "/boardForm.do\n/cart.do")
})
public class LoginCheckFilter implements Filter {
    private List<String> whitelists;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whitelists = WhiteListUtils.toList(filterConfig.getInitParameter("whitelist"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (whitelists.contains(req.getRequestURI())) {
            HttpSession session = req.getSession(false);
            if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
                RequestDispatcher rd = request.getRequestDispatcher("/loginForm.jsp");
                rd.forward(request, response);
            }
        }

        chain.doFilter(request, response);
    }
}
