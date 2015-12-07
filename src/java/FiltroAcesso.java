/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lhries
 */
@WebFilter(filterName = "FiltroAcesso", urlPatterns = {"/faces/gradeCurricular.xhtml", "/faces/cadastroCurso.xhtml", "/faces/cadastroDisciplina.xhtml", "/faces/cadastroTurma.xhtml"})
public class FiltroAcesso implements Filter {
    
    public FiltroAcesso() {
    }    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        HttpSession sessao = req.getSession();
        UserLoginMB userLoginMB = (UserLoginMB) sessao.getAttribute("userLoginMB");
        if(userLoginMB!= null && userLoginMB.getLogado()){
            chain.doFilter(request, response);
        }
        else{
            resp.sendRedirect(req.getContextPath()+"/faces/index.xhtml");
        }
        
    }

    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        
    }

    
}
