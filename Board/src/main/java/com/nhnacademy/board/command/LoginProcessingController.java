package com.nhnacademy.board.command;

import com.nhnacademy.board.userdomain.User;
import com.nhnacademy.board.userdomain.UserRepository;
import com.nhnacademy.board.userdomain.UserRepositoryImpl;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginProcessingController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        ServletContext servletContext = request.getServletContext();

        UserRepository userRepository = (UserRepositoryImpl) servletContext.getAttribute("userRepository");

        User user = userRepository.getUser(id);

        if (user != null && user.getPassword().equals(pwd)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);

            return "redirect:/login.do";
        } else {
            return "/loginForm.jsp";
        }
    }

}
