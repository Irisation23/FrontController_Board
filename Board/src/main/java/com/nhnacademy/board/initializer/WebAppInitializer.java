package com.nhnacademy.board.initializer;

import com.nhnacademy.board.userdomain.UserImpl;
import com.nhnacademy.board.userdomain.UserRepository;
import com.nhnacademy.board.userdomain.UserRepositoryImpl;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.add(new UserImpl("admin","12345","관리자",null));
        userRepository.add(new UserImpl("kim","123","김훈민","아직음슴."));
        userRepository.add(new UserImpl("jo","123","조재철","아직음슴."));
        userRepository.add(new UserImpl("lee","123","이제훈","아직음슴."));
        userRepository.add(new UserImpl("choi","123","최정우","아직음슴."));

        servletContext.setAttribute("userRepository", userRepository);
    }
}
