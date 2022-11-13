package comutility;

import java.util.List;

import UserExectiion.classNotFound;
import allbeenclasses.EngenersBeen;
import allbeenclasses.ProblemsBeen;

public interface HodInter {
	public String hodlogin(String username,String password) throws classNotFound;
	public String hodRagisterEng();
	public List<EngenersBeen> getDetailsengs();
	public String deleteEng();
	public List<ProblemsBeen> allProblems();
	public String assigncomplainToEng();
	

}
