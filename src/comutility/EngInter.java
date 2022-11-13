package comutility;

import java.util.List;

import allbeenclasses.EngenersBeen;
import allbeenclasses.ProblemsBeen;

public interface EngInter {
	
	public EngenersBeen engLogin();
	public List<ProblemsBeen> getProblemAssignmed(EngenersBeen eng);
	public String updateComplainStatus(int cid);
	
	public List<ProblemsBeen> getAllPassProblems(EngenersBeen eng);
	
	
	public String engChangPassword(EngenersBeen eng);
	
}
