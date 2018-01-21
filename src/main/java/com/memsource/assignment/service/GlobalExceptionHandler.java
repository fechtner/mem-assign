package com.memsource.assignment.service;

import com.memsource.assignment.model.memsource.AuthenticationException;
import com.memsource.assignment.model.memsource.MemsourceApiException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = AuthenticationException.class)
    public ModelAndView authenticationErrorHandler() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", "Memsource authentication error.");
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = MemsourceApiException.class)
    public ModelAndView apiErrorHandler(MemsourceApiException e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", "Memsource API error - " + e.getMessage() + ".");
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", e.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
