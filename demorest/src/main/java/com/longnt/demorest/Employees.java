package com.longnt.demorest;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("Employees")
public class Employees {

	EmployeeRepository repo = new EmployeeRepository();
	
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Employee> getEmployees() {
    
    	return repo.getEmployees();
    	
   }
    @GET
    @Path("Employee/{id}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Employee getEmployee(@PathParam("id") String id) {
    	return repo.getEmployee(id);
   }
    @POST
    @Path("Employee")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Employee createEmployee(Employee emp)
    {
    	System.out.println(emp);
    	repo.create(emp);
    	return emp;
    }
    @PUT
    @Path("Employee")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Employee updateEmployee(Employee emp)
    {
    	System.out.println(emp);
    	if (repo.getEmployee(emp.getID()).getID()==null) repo.create(emp);
    	else repo.update(emp);
    	return emp;
    }
    @DELETE
    @Path("Employee/{id}")
	public Employee deleteEmployee(@PathParam("id") String id)
	{
		Employee emp = repo.getEmployee(id);
		
		if (emp.getID()!=null) repo.delete(id);
		return emp;
	}
}
    

