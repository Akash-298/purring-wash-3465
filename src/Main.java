import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beenClasses.EmpProblemClassbeen;
import beenClasses.EmployeeBeen;
import beenClasses.EngineersBeen;
import beenClasses.ProblemsBeen;
import exception.classNotFoundException;
import userCase.Employeelmpl;
import userCase.Engenerlmpl;
import userCase.HodImpl;

public class Main {
	
	static HodImpl hodobjHodImpl=new HodImpl();
	static EngineersBeen engobj=null;
	 static Engenerlmpl engerlmplobj=new Engenerlmpl();
	static List<ProblemsBeen> list=null;
	static EmployeeBeen employeeBeen=null;
	static Employeelmpl employeelmpl=new Employeelmpl();
	public static void loding() {
    	System.out.println();
    	System.out.print("Loading");
     }
	
	
		public static void employeMethod() {
			while(true) {
				System.out.println("WELCOME"+employeeBeen.getEmpName());
				System.out.println("Choose");
				System.out.println("1 Ragister New Complain");
				System.out.println("2 chek complain Status");
				System.out.println("3 check All compalains");
				System.out.println("4 change Password ");
				System.out.println("5 Exit");
				Scanner scanner=new Scanner(System.in);
				int empchoice=scanner.nextInt();
				if(empchoice==1) {
					String res= employeelmpl.registerComplain(employeeBeen);
					if(res!=null) {
						System.out.println(res);
					}
					else {
						System.out.println("Data Not inserted");
					}
				}
				else if(empchoice==2) {
					List<EmpProblemClassbeen> list=employeelmpl.getComplain();
					if(list.size()!=0) {
						list.forEach(s->System.out.println(s));
						
					}
					else {
						System.out.println("Null");
					}
				}
				else if(empchoice==3) {
					List<ProblemsBeen> list= employeelmpl.allPstComplainsBeens(employeeBeen);
					if(list.size()!=0) {
						list.forEach(s-> System.out.println(s));
						
					}
					else {
						System.out.println("Data Not found");
					}
				}
				else if(empchoice==4) {
					String reString= employeelmpl.changePassword(employeeBeen);
					System.out.println(reString);
				}
				else {
					return;
				}
				

			}
			
			
		}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loding();
		System.out.println();

		
		System.out.println("ONLINE HARDWARE AND SOFTWARE SYSTEM SUPPORT");
		while(true) {
			Scanner sc=new Scanner(System.in);
			Thread.sleep(600);
			System.out.println(" Choose");
			Thread.sleep(600);
			System.out.println("1.\b HOD");
			Thread.sleep(600);
			System.out.println("2 \b Enginer");
			Thread.sleep(600);
			System.out.println("3 \b Employee");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
//				Thread.sleep(600);
				loding();
					System.out.println("WELCOME HOD");
					System.out.println("Choose");
					Thread.sleep(600);
					System.out.println("1 Login");
					Thread.sleep(600);
					System.out.println("2 Back");
					Thread.sleep(600);
					int hodChoice=sc.nextInt();
					if(hodChoice==1) {
						Thread.sleep(600);
						System.out.println("Enter Username:) ");
						
						String usernameString=sc.next();
						System.out.println("Enter Password:) ");
						String passwordString=sc.next();
						try {
							String res =hodobjHodImpl.hodlogin(usernameString, passwordString);
							if(res!=null) {
								System.out.println("Login sucessfully");
								while(true) {
									Thread.sleep(600);
									System.out.println("========= welcome "+res.toUpperCase()+" ===============");
									Thread.sleep(600);
									System.out.println("Choose");
									Thread.sleep(600);
									System.out.println("1 Register a new Enginer");
									Thread.sleep(600);
									System.out.println("2 Enginer List");
									Thread.sleep(600);
									System.out.println("3 Delete Enginer");
									Thread.sleep(600);
									System.out.println("4 See all The Problems");
									Thread.sleep(600);
									System.out.println("5 Assign Problem  to the Enginer");
									Thread.sleep(600);
									System.out.println("6 Enter for Exit");
									Thread.sleep(600);
									int hodChoic=sc.nextInt();
									if(hodChoic==1) {
									String s=hodobjHodImpl.hodRagisterEng();
										if(s!=null) {
											System.out.println(s);
										}
										else {
											System.out.println("something wrong ");
										}
									}
									else if(hodChoic==2) {
										List<EngineersBeen> list=hodobjHodImpl.getDetailsengs();
										if(list.size()!=0) {
											list.forEach(s-> System.out.println(s));
										}
										else {
											System.out.println("NO Data Found");
										}
										
									}
									else if(hodChoic==3) {
										String xString=hodobjHodImpl.deleteEng();
										if(xString!=null) {
											System.out.println(xString);
										}
										else {
											System.out.println("Data Not Deleted");
										}
										
										
									}
									else if(hodChoic==4) {
										List<ProblemsBeen> list=hodobjHodImpl.allProblems();
										if(list.size()!=0) {
											list.forEach(s-> System.out.println(s));
										}
										else {
											System.out.println("NO Data Found");
										}
										
									}
									else if(hodChoic==5){
										String valueString=hodobjHodImpl.assigncomplainToEng();
										if(valueString!=null) {
											System.out.println(valueString);
										}
										else {
											System.out.println("data insertion not completed");
										}
									}
									else {
										break;
									}
								}
								
							}
							else {
								System.out.println("Wrong username and passwords");
							}
						} catch (classNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else if(hodChoice==2) {
						continue;
					}
					else {
						throw new IllegalArgumentException("Unexpected value: " + hodChoice);
					}
					
				break;
			case 2:
//				Thread.sleep(600);
				loding();
				System.out.println("WELCOME TO ENGINEER PAGE");
				Thread.sleep(600);
				System.out.println("Choose");
				Thread.sleep(600);
				System.out.println("1 Login");
				Thread.sleep(600);
				System.out.println("2 Back");
				Thread.sleep(600);
				int engchoice=sc.nextInt();
				if(engchoice==1) {
					engobj= engerlmplobj.engLogin();
					if(engobj!=null) {
						Thread.sleep(600);
						while(true) {
							System.out.println("================== Welcome "+ engobj.getEngNaame() +"=====================");
							System.out.println("Choose");
							Thread.sleep(600);
							System.out.println("1 check Your all complains");
							System.out.println("2 update Your work ");
							System.out.println("3 see pase complains");
							Thread.sleep(600);
							System.out.println("4 update Your password");
							System.out.println("5 Exit");
							int engoptionChoice=sc.nextInt();
							
							if(engoptionChoice==1) {
							 list=engerlmplobj.getProblemAssignmed(engobj);
							
//							System.out.println(engobj.getEid());
								if(list!=null) {
									list.forEach(s->System.out.println(s));
								}
								else {
									System.out.println("Nothing found");
								}
							}
							else if(engoptionChoice==2) {
								list=engerlmplobj.getProblemAssignmed(engobj);
								System.out.println("Eneter Your Compalain id: ");
								int cid=sc.nextInt();
								boolean flag=false;
								for (ProblemsBeen problemsBeen : list) {
//									System.out.println(problemsBeen);
									if(problemsBeen.getCid()==cid) {
										flag=true;
										break;
									}
								}
								if(flag) {
									String string= engerlmplobj.updateComplainStatus(cid);
									if(string!=null) {
										System.out.println(string);
									}
									else {
										System.out.println("something wrong");
									}
								}
								else {
									System.out.println("not authorized for this complain or may be this might be completed");
								}
								
							}
							else if(engoptionChoice==3) {
								List<ProblemsBeen> list1= engerlmplobj.getAllPassProblems(engobj);
								if(list1!=null) {
									list1.forEach(s->System.out.println(s));
								}
								else {
									System.out.println("Nothing found");
								}
								
								
							}
							else if(engoptionChoice==4) {
								String reString= engerlmplobj.engChangPassword(engobj);
								if(reString!=null) {
									System.out.println(reString);
								}
								else {
									System.out.println("Password did not changed ");
									
								}
								
							}
							else {
								break;
							}
								
						}
						
					}
					else {
						System.out.println("Something went worong");
					}
				
				}
				else if(engchoice==2) {
					continue;
				}
				else {
					throw new IllegalArgumentException("Unexpected value: "+ engchoice);
				}
				
				
				break;
			case 3:
//				Thread.sleep(600);
				loding();
				System.out.println("WELCOME TO EMPLOYEE PAGE");
				Thread.sleep(600);
				System.out.println("Choose");
				Thread.sleep(600);
				System.out.println("1 Register");
				Thread.sleep(600);
				System.out.println("2 Login");
				Thread.sleep(600);
				System.out.println("3 Back");
				int empchoice=sc.nextInt();
				if(empchoice==1) {
					employeeBeen=employeelmpl.empRagister();
					if(employeeBeen!=null) {
//						employeMethod();
						Thread.sleep(600);
						while(true) {
							
							
							System.out.println("Now You Have to login");
							System.out.println("1 Login");
							System.out.println("2 exit");
							int hi=sc.nextInt();
							
							
							if(hi==1) {
								employeeBeen=employeelmpl.empLogin();
								if(employeeBeen!=null) {
									employeMethod();
//									continue;
								}
								
								else {
									System.out.println("Wrong passowrds");
								}

							}
							else {
								break;
							}
							
						}
						
					}
					
					
					else {
						System.out.println("Some Tehchnicla issue");
					}
					
					
				}
				else if(empchoice==2) {
					
					employeeBeen=employeelmpl.empLogin();
					if(employeeBeen!=null) {
						employeMethod();
//						continue;
					}
					else {
						System.out.println("Wrong passowrds");
					}
					
				}
				else if(empchoice==3) {
					continue;
				}
				else {
					throw new IllegalArgumentException("Unexpected value: " + empchoice);
				}
				break;
				
			default:
				loding();
				throw new IllegalArgumentException("Unexpected value:" + choice);
			}
			
			
			
		}
		

	}

}
