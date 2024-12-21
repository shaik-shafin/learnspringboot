package com.shaik.acknowledge.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

        System.out.println("Filter2 initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("*************** Pre Filter2 invoked ***************");
        chain.doFilter(request, response);
        System.out.println("*************** Post Filter2 invoked ***************");
    }

    @Override
    public void destroy() {
        System.out.println("Filter2 destroyed");
    }

}
