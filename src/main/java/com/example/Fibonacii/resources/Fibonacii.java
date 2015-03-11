package com.example.Fibonacii.resources;

import com.example.Fibonacii.core.CalculateFibIterative;
import com.example.Fibonacii.core.FibonaciiResultSet;
import com.yammer.dropwizard.auth.Auth;
import com.example.Fibonacii.core.CalculateFib;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/kuldeep")
public class Fibonacii {
    @GET
    @Path("{fib}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getFibNumber(@PathParam("fib") Integer n) throws Exception {
    	//System.out.println(CalculateFib.Fib(n));
        //FibonaciiResultSet set ;
        if(n<0 || n>92)
            return Long.valueOf(-1);
        return CalculateFibIterative.Fib(n);
    }
}
