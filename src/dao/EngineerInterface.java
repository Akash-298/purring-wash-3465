package dao;

import java.util.List;

import beenClasses.EngineersBeen;
import beenClasses.ProblemsBeen;

public interface EngineerInterface {
	
	public EngineersBeen engLogin();
	public List<ProblemsBeen> getProblemAssignmed(EngineersBeen eng);
	public String updateComplainStatus(int cid);
	
	public List<ProblemsBeen> getAllPassProblems(EngineersBeen eng);
	
	
	public String engChangPassword(EngineersBeen eng);
	
}
