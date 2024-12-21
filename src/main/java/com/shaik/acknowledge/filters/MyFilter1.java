package com.shaik.acknowledge.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Filter1 initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("**************** Pre Filter1 invoked ****************");
        chain.doFilter(request, response);
        System.out.println("**************** Post Filter1 invoked ****************");
    }

    @Override
    public void destroy() {
        System.out.println("Filter1 destroyed");
    }
}
