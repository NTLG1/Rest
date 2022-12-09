package com.longnt.demorest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


import java.sql.*;

public class EmployeeRepository {
	
	Connection con = null;
	
	public EmployeeRepository()
	{
		try {
			File f = new File("/Users/admin/Documents/cs/in.txt");
	        FileReader fr = new FileReader(f);
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        line = br.readLine();
	        
		String url = "jdbc:mysql://localhost:3306/demorest";
		String username = line;
		line = br.readLine();
		String password = line;
		fr.close();
        br.close();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}catch (Exception e) {
			System.out.println(e);
	        }
	}
		public List<Employee> getEmployees(){
			List<Employee> employees = new ArrayList<>();
			String sql = "select*from Employee";
			try
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next())
				{
					Employee emp = new  Employee();
					emp.setID(rs.getString(1));
					emp.setName(rs.getString(2));
					emp.setAge(rs.getInt(3));
					employees.add(emp);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return employees;
		}
		public Employee getEmployee(String id)
		{
			Employee emp = new  Employee();
			String sql = "select*from Employee where id="+id;
			try
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next())
				{
					emp.setID(rs.getString(1));
					emp.setName(rs.getString(2));
					emp.setAge(rs.getInt(3));
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			return emp;
		}
		public void create(Employee emp) {
			String sql = "insert into Employee values (?,?,?)";
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, emp.getID());
				st.setString(2, emp.getName());
				st.setInt(3, emp.getAge());
				st.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}		
			}
		public void update(Employee emp) {
			String sql = "update Employee set name=?, age=? where id=?";
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(3, emp.getID());
				st.setString(1, emp.getName());
				st.setInt(2, emp.getAge());
				st.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}		
			}
		public void delete(String id) {
			// TODO Auto-generated method stub
			String sql = "delete from Employee where id=?";
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, id);
				st.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}		
		}
		
}
