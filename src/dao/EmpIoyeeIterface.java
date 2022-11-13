package dao;

import java.util.List;

import beenClasses.EmpProblemClassbeen;
import beenClasses.EmployeeBeen;
import beenClasses.ProblemsBeen;

public interface EmpIoyeeIterface {
	public EmployeeBeen empLogin();
	public EmployeeBeen empRagister();
	public String registerComplain(EmployeeBeen obj);
	public List<EmpProblemClassbeen> getComplain();
	public List<ProblemsBeen> allPstComplainsBeens(EmployeeBeen obj);
	
	public String changePassword(EmployeeBeen obj);
}
