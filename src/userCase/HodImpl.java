package userCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import beenClasses.EngineersBeen;
import beenClasses.ProblemsBeen;
import dao.HodInterface;
import exception.classNotFoundException;
import utility.DBUtil;

public class HodImpl implements HodInterface {

	@Override
	public String hodlogin(String username, String password) throws classNotFoundException {
		String res=null;
		Connection connection=DBUtil.provideConnection();
		try {
			PreparedStatement pr=connection.prepareStatement("select * from hod where username=? and password=?");
			pr.setString(1, username);
			pr.setString(2, password);
			ResultSet resultSet= pr.executeQuery();
			if(resultSet.next()) {
				res=resultSet.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
//			res=e.getMessage();
			throw new classNotFoundException("some technicla issue");
		}
		
		
		return res;
	}

	@Override
	public String hodRagisterEng() {
		
		String res=null;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter The Name Of Enginer");
		String nameString=scanner.next();
		
		System.out.println("Enter The UserName");
		String usernameString=scanner.next();
		
		System.out.println("Enter The Password ");
		String passowrdString=scanner.next();
		
		System.out.println("Enter The enginer role with choice");
		
		System.out.println("Enter 1 for Hardware");
		System.out.println("Enter 2 for Software");
		
		int x=scanner.nextInt();
		
		String roleString=(x==1)?"Hardware":"software";
		
		
		Connection conn=DBUtil.provideConnection();
		try {
			PreparedStatement pr=conn.prepareStatement("insert into enginer (name,username,password,en_role) values(?,?,?,?)");
			pr.setString(1, nameString);
			pr.setString(2, usernameString);
			pr.setString(3, passowrdString);
			pr.setString(4, roleString);
			
			
			int da=pr.executeUpdate();
			
			if(da>0) {
				res="Data Inserted";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=e.getMessage();
		}
		
		return res;
	}

	@Override
	public List<EngineersBeen> getDetailsengs() {
		List<EngineersBeen> list=new ArrayList<>();
		
		
		Connection connection=DBUtil.provideConnection();
		
		try {
			PreparedStatement pr=connection.prepareStatement("select * from enginer");
			ResultSet resultSet= pr.executeQuery();
			
			while(resultSet.next()) {
				
				int enId=resultSet.getInt("enId");
				String name=resultSet.getString("name");
				String username=resultSet.getString("username");
				String password=resultSet.getString("password");
				String en_role=resultSet.getString("en_role");
				
				list.add(new EngineersBeen(enId,name,username,password,en_role));
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	
	@Override
	public String deleteEng() {
		
		String res=null;
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter The userName of the Engienr");
		String usernameString=scanner.next();
		System.out.println("Enter The password of the Enginer");
		String PasswordString=scanner.next();
		
		Connection conn=DBUtil.provideConnection();
		
		try {
			
			PreparedStatement pr= conn.prepareStatement("delete from enginer where username=? and password=?;");
			pr.setString(1, usernameString);
			pr.setString(2, PasswordString);
			
			int x=pr.executeUpdate();
			
			if(x>0) {
				res="Enginer Deleted";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=e.getMessage();
		}
		
		return res;
	}

	@Override
	public List<ProblemsBeen> allProblems() {
		
		// TODO Auto-generated method stub
		List<ProblemsBeen> list=new ArrayList<>();
		Connection connection=DBUtil.provideConnection();
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("select * from complain");
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				int cid=resultSet.getInt("cid");
				String cname=resultSet.getString("cname");
				String c_status=resultSet.getString("c_status");
				String c_role=resultSet.getString("c_role");
				list.add(new ProblemsBeen(cid,cname,c_status,c_role));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String assigncomplainToEng() {
		
		String res=null;
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter The Enginer Id");
		int enId=scanner.nextInt();
		
		System.out.println("Enter The complain Id");
		int cid=scanner.nextInt();
		 
		Connection connection=DBUtil.provideConnection();
		try {
			
			PreparedStatement idPreparedStatement=connection.prepareStatement("select * from enginer where enId=?");
			idPreparedStatement.setInt(1, enId);
			
			ResultSet resultSet=idPreparedStatement.executeQuery();
			if(resultSet.next()) {
				
			}
			else {
				res="Please enter valid Enginer id";
				return res;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			PreparedStatement idPreparedStatement=connection.prepareStatement("select * from complain where cid=?");
			idPreparedStatement.setInt(1, cid);
			ResultSet resultSet=idPreparedStatement.executeQuery();
			if(resultSet.next()) {
				
			}
			else {
				res="Please enter valid complain id";
				return res;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			PreparedStatement pr=connection.prepareStatement("insert into eng_complain values(?,?)");
			pr.setInt(1, enId);
			pr.setInt(2, cid);
			int value=pr.executeUpdate();
			if(value>0) {
				res="data inserted";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			res=e.getMessage();
			
		}
		
		
		return res;
	}


	

}
