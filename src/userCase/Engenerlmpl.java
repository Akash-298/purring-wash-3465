package userCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beenClasses.EngineersBeen;
import beenClasses.ProblemsBeen;
import dao.EngineerInterface;
import utility.DBUtil;

public class Engenerlmpl implements EngineerInterface {

	@Override
	public EngineersBeen engLogin() {
		EngineersBeen objBeen=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("\033[0;33m"+"Enter Your UserName");
		String engUsernameString=sc.next();
		System.out.println("Enter Your Passowrd");
		String engPasswordString=sc.next();
		
		Connection connection=DBUtil.provideConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("select * from enginer where username=? and password=?");
			preparedStatement.setString(1, engUsernameString);
			preparedStatement.setString(2, engPasswordString);
			ResultSet resultSet =preparedStatement.executeQuery();
			if(resultSet.next()) {
				int x=resultSet.getInt("enId");
				String nameString=resultSet.getString("name");
				String usernameString=resultSet.getString("username");
				String passwordString=resultSet.getString("password");
				String enRoleString=resultSet.getString("en_role");
				objBeen=new EngineersBeen(x,nameString,usernameString,passwordString,enRoleString);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return objBeen;
	}

	@Override
	public List<ProblemsBeen> getProblemAssignmed(EngineersBeen eng) {
	
		List<ProblemsBeen> list=new ArrayList<>();
		Connection connection=DBUtil.provideConnection();
	try {
		PreparedStatement preparedStatement=connection.prepareStatement("select * from enginer INNER JOIN complain INNER JOIN eng_complain ON enginer.enId=eng_complain.enId and complain.cid=eng_complain.cid where enginer.enId=? and complain.c_status='pending' group by complain.cid");
		preparedStatement.setInt(1, eng.getEid());
		
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			int cid=resultSet.getInt("cid");
			String cnameString=resultSet.getString("cname");
			String c_status=resultSet.getString("c_status");
			String c_role=resultSet.getString("c_role");
			list.add(new ProblemsBeen(cid,cnameString,c_status,c_role));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return list;
	}
	
	
	
	@Override
	public List<ProblemsBeen> getAllPassProblems(EngineersBeen eng) {
		List<ProblemsBeen> list=new ArrayList<>();
		Connection connection=DBUtil.provideConnection();
	try {
		PreparedStatement preparedStatement=connection.prepareStatement("select * from enginer INNER JOIN complain INNER JOIN eng_complain ON enginer.enId=eng_complain.enId and complain.cid=eng_complain.cid where enginer.enId=? and complain.c_status='complted' group by complain.cid");
		preparedStatement.setInt(1, eng.getEid());
		
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			int cid=resultSet.getInt("cid");
			String cnameString=resultSet.getString("cname");
			String c_status=resultSet.getString("c_status");
			String c_role=resultSet.getString("c_role");
			list.add(new ProblemsBeen(cid,cnameString,c_status,c_role));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return list;
	}
	
	@Override
	public String engChangPassword(EngineersBeen obj) {
		String reString=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your New Password");
		String newPassword=scanner.next();
		Connection connection=DBUtil.provideConnection();
		try {
			PreparedStatement objPreparedStatement= connection.prepareStatement("update enginer set password=? where username=?");
			objPreparedStatement.setString(1, newPassword);
			objPreparedStatement.setString(2, obj.getEngUsername());
			 int x=objPreparedStatement.executeUpdate();
			 if(x>0) {
				 reString="Password Changes";
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return reString;
	}

	@Override
	public String updateComplainStatus(int cid) {
		String reString=null;
		Connection connection=DBUtil.provideConnection();
	    try {
			PreparedStatement preparedStatement=connection.prepareStatement("update complain set c_status='complted' where cid=?");
			preparedStatement.setInt(1, cid);
			int x=preparedStatement.executeUpdate();
			if(x>0) {
				reString="complain updated";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return reString;
	}



}
