package com.nhnacademy.board.command;

import com.nhnacademy.board.userdomain.User;
import com.nhnacademy.board.userdomain.UserRepository;
import com.nhnacademy.board.userdomain.UserRepositoryImpl;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ServletContext servletContext = request.getServletContext();

        UserRepository userRepository = (UserRepositoryImpl) servletContext.getAttribute("userRepository");

        List<User> users = userRepository.getUsers();
//
        servletContext.setAttribute("userList",users);

        return "/users.jsp";
    }
}
