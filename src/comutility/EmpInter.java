package comutility;

import java.util.List;

import allbeenclasses.EmpProblemClassbeen;
import allbeenclasses.EmployeeBeen;
import allbeenclasses.ProblemsBeen;

public interface EmpInter {
	public EmployeeBeen empLogin();
	public EmployeeBeen empRagister();
	public String registerComplain(EmployeeBeen obj);
	public List<EmpProblemClassbeen> getComplain();
	public List<ProblemsBeen> allPstComplainsBeens(EmployeeBeen obj);
	
	public String changePassword(EmployeeBeen obj);
}
