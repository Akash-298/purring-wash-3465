package dao;

import java.util.List;

import beenClasses.EngineersBeen;
import beenClasses.ProblemsBeen;
import exception.classNotFoundException;

public interface HodInterface {
	public String hodlogin(String username,String password) throws classNotFoundException;
	public String hodRagisterEng();
	public List<EngineersBeen> getDetailsengs();
	public String deleteEng();
	public List<ProblemsBeen> allProblems();
	public String assigncomplainToEng();
	

}
