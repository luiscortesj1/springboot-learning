package com.curso.springboothorario.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

@Component("horario")
public class HorarioInterceptor  implements HandlerInterceptor {
    @Value("${config.horario.apertura}")
    private Integer apertura;

    @Value("${config.horario.cierre}")
    private Integer cierre;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        if(hora >= apertura && hora < cierre){
            StringBuilder mensaje = new StringBuilder("Horario de atención abierto");
            mensaje.append(", atendemos desde las ");
            mensaje.append(apertura);
            request.setAttribute("mensaje", mensaje.toString());
            return true;
        }
        response.sendRedirect(request.getContextPath().concat("/cerrado"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String mensaje = (String) request.getAttribute("mensaje");
        modelAndView.addObject("mensaje",mensaje);
        if(modelAndView != null){
            modelAndView.addObject("mensaje",mensaje);
        }
    }
}
