package com.nhnacademy.board.command;

import com.nhnacademy.board.userdomain.User;
import com.nhnacademy.board.userdomain.UserRepository;
import com.nhnacademy.board.userdomain.UserRepositoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserReadController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("id");

        ServletContext servletContext = request.getServletContext();
        UserRepository userRepository = (UserRepositoryImpl) servletContext.getAttribute("userRepository");

        User user = userRepository.getUser(userId);
        servletContext.setAttribute("userRead",user);
        return "/userRead.jsp";
    }
}
