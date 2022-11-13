package useCaseClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import allbeenclasses.EmpProblemClassbeen;
import allbeenclasses.EmployeeBeen;
import allbeenclasses.ProblemsBeen;
import comdatabases.ConnectToConnection;
import comutility.EmpInter;

public class Employeelmpl implements EmpInter {

	@Override
	public EmployeeBeen empLogin() {
		EmployeeBeen objBeen=null;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("\033[0;33m"+"Enter Your username");
		String usernameString=scanner.next();
		System.out.println("Enter Your Password");
		String passString=scanner.next();
		Connection connection=ConnectToConnection.provideConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where username=? and password=?");
			preparedStatement.setString(1,usernameString);
			preparedStatement.setString(2, passString);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				int value=resultSet.getInt("emId");
				String nameString=resultSet.getString("ename");
				String usernameString2=resultSet.getString("username");
				String passwordString=resultSet.getString("password");
				objBeen=new EmployeeBeen(value,nameString,usernameString2,passwordString);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return objBeen;
	}

	@Override
	public EmployeeBeen empRagister() {
		EmployeeBeen objBeen=null;
		
	Scanner scanner=new Scanner(System.in);
	System.out.println("\033[0;33m"+"Enter Your Name");
	String nameString=scanner.next();
	System.out.println("Enter Your username");
	String usernameString=scanner.next();
	System.out.println("Enter Your Password");
	String passString=scanner.next();
	Connection connection=ConnectToConnection.provideConnection();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement("insert into employee(ename,username,password)values(?,?,?)");
		preparedStatement.setString(1, nameString);
		preparedStatement.setString(2,usernameString);
		preparedStatement.setString(3, passString);
		int x = preparedStatement.executeUpdate();
		if(x>0) {
			objBeen=new EmployeeBeen(nameString,usernameString,passString);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return objBeen;
	}

	@Override
	public String registerComplain(EmployeeBeen obj) {
		String reString=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("\033[0;33m"+"Enter Your Complaing details");
		String cnameString=scanner.nextLine();
		System.out.println("Enter The complain chocie");
		System.out.println("Enter 1 for Hardware");
		System.out.println("Enter 2 for Software");
		int x=scanner.nextInt();
		String roleString=(x==1)?"Hardware":"software";
		
		Connection connection=ConnectToConnection.provideConnection();
		 try {
			PreparedStatement preaPreparedStatement= connection.prepareStatement("insert into complain(cname,c_role) values(?,?)");
			preaPreparedStatement.setString(1, cnameString);
			preaPreparedStatement.setString(2, roleString);
			int data=preaPreparedStatement.executeUpdate();
			if(data>0) {
				reString="data Insterted";
			}
			
			PreparedStatement preparedStatement1= connection.prepareStatement("select cid from complain where cname=? and c_role=?");
			preparedStatement1.setString(1, cnameString);
			preparedStatement1.setString(2,roleString);
			ResultSet resultSet1= preparedStatement1.executeQuery();
			int cid=0;
			
			if(resultSet1.next()) {
				 cid=resultSet1.getInt("cid");
				
//				
				System.out.println(obj.getEmpId());
				
			}
			else {
				
			}
			PreparedStatement preparedStatement2= connection.prepareStatement("insert into emp_complain values(?,?)");
			preparedStatement2.setInt(1, obj.getEmpId());
			preparedStatement2.setInt(2, cid);
			int value=preparedStatement2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reString;
	}

	@Override
	public List<EmpProblemClassbeen> getComplain() {
		// TODO Auto-generated method stub
		List<EmpProblemClassbeen> list=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Any Complain Id");
		int choice=sc.nextInt();
		Connection connection=ConnectToConnection.provideConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("select * from enginer INNER JOIN complain INNER JOIN eng_complain ON enginer.enId=eng_complain.enId and complain.cid=eng_complain.cid where complain.cid=? group by enginer.name");
			preparedStatement.setInt(1, choice);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String nameString=resultSet.getString("name");
				String en_role =resultSet.getString("en_role");
				int cid=resultSet.getInt("cid");
				String cnameString=resultSet.getString("cname");
				String c_status=resultSet.getString("c_status");
				String c_role=resultSet.getString("c_role");
				list.add(new EmpProblemClassbeen(nameString, en_role, cid, cnameString, c_status, c_role));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<ProblemsBeen> allPstComplainsBeens(EmployeeBeen obj) {
		List<ProblemsBeen> list=new ArrayList<>();
		Connection connection=ConnectToConnection.provideConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("select complain.cid,complain.cname,complain.c_status,complain.c_role from employee INNER JOIN complain INNER JOIN emp_complain ON employee.emId=emp_complain.em_emId and complain.cid=emp_complain.c_cid where employee.emId=?;");
			preparedStatement.setInt(1, obj.getEmpId());
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int cid=resultSet.getInt("cid");
				String cname=resultSet.getString("cname");
				String c_statu=resultSet.getString("c_status");
				String c_roleString=resultSet.getString("c_role");
				list.add(new ProblemsBeen(cid,cname,c_statu,c_roleString));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String changePassword(EmployeeBeen obj) {
		String resString=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your new Password");
		String newPassword=scanner.next();
		Connection connection=ConnectToConnection.provideConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("update employee set password=? where emId=?");
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, obj.getEmpId());
			int x=preparedStatement.executeUpdate();
			if(x>0) {
				resString="Password chagned";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			resString=e.getMessage();
		}
		
		return resString;
	}

}
