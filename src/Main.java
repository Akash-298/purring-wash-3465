import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import UserExectiion.classNotFound;
import allbeenclasses.EmpProblemClassbeen;
import allbeenclasses.EmployeeBeen;
import allbeenclasses.EngenersBeen;
import allbeenclasses.ProblemsBeen;
import useCaseClasses.Employeelmpl;
import useCaseClasses.Engenerlmpl;
import useCaseClasses.HodImpl;

public class Main {
	static HodImpl hodobjHodImpl=new HodImpl();
	static EngenersBeen engobj=null;
	 static Engenerlmpl engerlmplobj=new Engenerlmpl();
	static List<ProblemsBeen> list=null;
	static EmployeeBeen employeeBeen=null;
	static Employeelmpl employeelmpl=new Employeelmpl();
	public static void loding() {
    	System.out.println();
    	System.out.print("Loading"+"\u001B[32m");
        for(int i=0; i<10; i++) {
        	System.out.print(".");
        	try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        System.out.print("!"+"\u001B[0m");
       
    }
		public static void employeMethod() {
			while(true) {
				System.out.println("\r\n"
						+ "▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀   █░█░█ █▀▀ █░░ █▀█ █▀▀ █▀▄▀█ █▀▀\r\n"
						+ "▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀   ▀▄▀▄▀ ██▄ █▄▄ █▄█ █▄▄ █░▀░█ ██▄ "+employeeBeen.getEmpName()+"\r\n"
								+ "▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀\r\n"
								+ "▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀ ▀▀");
				System.out.println("\u001B[32m"+"Enter Your Choice"+"\u001B[0m");
				System.out.println("\u001B[32m"+"1 Ragister New Complain");
				System.out.println("2 chek Your complaing Status");
				System.out.println("3 check  past All compalins");
				System.out.println("4 change Your Password ");
				System.out.println("5 Exit"+"\u001B[0m");
				Scanner scanner=new Scanner(System.in);
				int empchoice=scanner.nextInt();
				if(empchoice==1) {
					String res= employeelmpl.registerComplain(employeeBeen);
					if(res!=null) {
						System.out.println(res);
					}
					else {
						System.out.println("\033[0;31m"+"Data Not inserted"+"\033[0m");
					}
				}
				else if(empchoice==2) {
					List<EmpProblemClassbeen> list=employeelmpl.getComplain();
					if(list.size()!=0) {
						list.forEach(s->System.out.println(s));
						
					}
					else {
						System.out.println("\033[0;31m"+"Nothing found"+"\033[0m");
					}
				}
				else if(empchoice==3) {
					List<ProblemsBeen> list= employeelmpl.allPstComplainsBeens(employeeBeen);
					if(list.size()!=0) {
						list.forEach(s-> System.out.println(s));
						
					}
					else {
						System.out.println("\033[0;31m"+"Data Not found"+"\033[0m");
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
		System.out.println("\t\t\t ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░░▒▒▒▒░░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒░▒▒▒▒▒▒░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒░░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒░░░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒░░░░░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░▒░░░░░░░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒░▒▒▒░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒░░░░░░▓▓\r\n"
					+ "\t\t\t ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n"
					+ "\t\t\t _______▒__________▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
					+ "\t\t\t ______▒_______________▒▒▒▒▒▒▒▒\r\n"
					+ "\t\t\t _____▒________________▒▒▒▒▒▒▒▒\r\n"
					+ "\t\t\t ____▒___________▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
					+ "\t\t\t ___▒\r\n"
					+ "\t\t\t __▒______▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n"
					+ "\t\t\t _▒______▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓\r\n"
					+ "\t\t\t ▒▒▒▒___▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓\r\n"
					+ "\t\t\t ▒▒▒▒__▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓▒▓\r\n"
					+ "\t\t\t ▒▒▒__▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n"
					+ "\t\t\t ▒▒\r\n"
					+ "");
		Thread.sleep(800);
		System.out.println("==============\r\n"
				+ "█▀▀█ █▀▀▄ █░░ ░▀░ █▀▀▄ █▀▀ 　 █░░█ █▀▀█ █▀▀█ █▀▀▄ █░░░█ █▀▀█ █▀▀█ █▀▀ 　 █▀▀█ █▀▀▄ █▀▀▄ \r\n"
				+ "█░░█ █░░█ █░░ ▀█▀ █░░█ █▀▀ 　 █▀▀█ █▄▄█ █▄▄▀ █░░█ █▄█▄█ █▄▄█ █▄▄▀ █▀▀ 　 █▄▄█ █░░█ █░░█ \r\n"
				+ "▀▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░░▀ ▀▀▀ 　 ▀░░▀ ▀░░▀ ▀░▀▀ ▀▀▀░ ░▀░▀░ ▀░░▀ ▀░▀▀ ▀▀▀ 　 ▀░░▀ ▀░░▀ ▀▀▀░ \r\n"
				+ "\r\n"
				+ "█▀▀ █▀▀█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █▀▀ 　 █▀▀ █░░█ █▀▀█ █▀▀█ █▀▀█ █▀▀█ ▀▀█▀▀ 　 █▀▀ █░░█ █▀▀ ▀▀█▀▀ █▀▀ █▀▄▀█ \r\n"
				+ "▀▀█ █░░█ █▀▀ ░░█░░ █▄█▄█ █▄▄█ █▄▄▀ █▀▀ 　 ▀▀█ █░░█ █░░█ █░░█ █░░█ █▄▄▀ ░░█░░ 　 ▀▀█ █▄▄█ ▀▀█ ░░█░░ █▀▀ █░▀░█ \r\n"
				+ "▀▀▀ ▀▀▀▀ ▀░░ ░░▀░░ ░▀░▀░ ▀░░▀ ▀░▀▀ ▀▀▀ 　 ▀▀▀ ░▀▀▀ █▀▀▀ █▀▀▀ ▀▀▀▀ ▀░▀▀ ░░▀░░ 　 ▀▀▀ ▄▄▄█ ▀▀▀ ░░▀░░ ▀▀▀ ▀░░░▀======================");
		while(true) {
			Scanner sc=new Scanner(System.in);
			Thread.sleep(600);
			System.out.println("\u001B[32m"+"\b Enter Your Choice"+"\u001B[0m");
			Thread.sleep(600);
			System.out.println("\u001B[34m"+"1.\b HOD");
			Thread.sleep(600);
			System.out.println("2 \b Enginer");
			Thread.sleep(600);
			System.out.println("3 \b Employee"+"\u001B[0m");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
//				Thread.sleep(600);
				loding();
					System.out.println("==================\r\n"
							+ "▒█░░▒█ █▀▀ █░░ █▀▀█ █▀▀ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █▀▀█ 　 ▒█░▒█ ▒█▀▀▀█ ▒█▀▀▄ 　 ▒█▀▀█ █▀▀█ █▀▀▀ █▀▀ \r\n"
							+ "▒█▒█▒█ █▀▀ █░░ █░░█ █░░ █░▀░█ █▀▀ 　 ░▒█░░ █░░█ 　 ▒█▀▀█ ▒█░░▒█ ▒█░▒█ 　 ▒█▄▄█ █▄▄█ █░▀█ █▀▀ \r\n"
							+ "▒█▄▀▄█ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀▀▀ ▀░░░▀ ▀▀▀ 　 ░▒█░░ ▀▀▀▀ 　 ▒█░▒█ ▒█▄▄▄█ ▒█▄▄▀ 　 ▒█░░░ ▀░░▀ ▀▀▀▀ ▀▀▀ ===========================");
					System.out.println("\u001B[32m"+"Enter Your Choice"+"\u001B[0m");
					Thread.sleep(600);
					System.out.println("\u001B[34m"+"1 Login");
					Thread.sleep(600);
					System.out.println("2 Back"+"\u001B[0m");
					Thread.sleep(600);
					int hodChoice=sc.nextInt();
					if(hodChoice==1) {
						Thread.sleep(600);
						System.out.println("Enter Your Username:) ");
						
						String usernameString=sc.next();
						System.out.println("Enter Your Password:) ");
						String passwordString=sc.next();
						try {
							String res =hodobjHodImpl.hodlogin(usernameString, passwordString);
							if(res!=null) {
								System.out.println("Login sucessfully");
								while(true) {
									Thread.sleep(600);
									System.out.println("========= welcome "+res.toUpperCase()+" ===============");
									Thread.sleep(600);
									System.out.println("\u001B[32m"+"Enter Your Choice"+"\u001B[0m");
									Thread.sleep(600);
									System.out.println("\u001B[34m"+"1 Register a new Enginer");
									Thread.sleep(600);
									System.out.println("2 see all the Enginer List");
									Thread.sleep(600);
									System.out.println("3 Delete Enginer");
									Thread.sleep(600);
									System.out.println("4 See all The Problems");
									Thread.sleep(600);
									System.out.println("5 Assign Problem  to the Enginer");
									Thread.sleep(600);
									System.out.println("6 Enter for Exit"+"\u001B[0m");
									Thread.sleep(600);
									int hodChoic=sc.nextInt();
									if(hodChoic==1) {
									String s=hodobjHodImpl.hodRagisterEng();
										if(s!=null) {
											System.out.println(s);
										}
										else {
											System.out.println("\033[0;31m"+"something wrong "+"\033[0m");
										}
									}
									else if(hodChoic==2) {
										List<EngenersBeen> list=hodobjHodImpl.getDetailsengs();
										if(list.size()!=0) {
											list.forEach(s-> System.out.println(s));
										}
										else {
											System.out.println("\033[0;31m"+"NO Data Found"+"\033[0m");
										}
										
									}
									else if(hodChoic==3) {
										String xString=hodobjHodImpl.deleteEng();
										if(xString!=null) {
											System.out.println(xString);
										}
										else {
											System.out.println("\033[0;31m"+"Data Not Deleted"+"\033[0m");
										}
										
										
									}
									else if(hodChoic==4) {
										List<ProblemsBeen> list=hodobjHodImpl.allProblems();
										if(list.size()!=0) {
											list.forEach(s-> System.out.println(s));
										}
										else {
											System.out.println("\033[0;31m"+"NO Data Found"+"\033[0m");
										}
										
									}
									else if(hodChoic==5){
										String valueString=hodobjHodImpl.assigncomplainToEng();
										if(valueString!=null) {
											System.out.println(valueString);
										}
										else {
											System.out.println("\033[0;31m"+"data insertion not completed"+"\033[0m");
										}
									}
									else {
										break;
									}
								}
								
							}
							else {
								System.out.println("\033[0;31m"+"Wrong username and passwords"+"\033[0m");
							}
						} catch (classNotFound e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else if(hodChoice==2) {
						continue;
					}
					else {
						throw new IllegalArgumentException("\033[0;31m"+"Unexpected value: "+"\033[0m" + hodChoice);
					}
					
				break;
			case 2:
//				Thread.sleep(600);
				loding();
				System.out.println("\r\n"
						+ "▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \r\n"
						+ "▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \r\n"
						+ "░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \r\n"
						+ "\r\n"
						+ "▒█░░▒█ █▀▀ █░░ █▀▀ █▀▀█ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █░░█ █▀▀ 　 ▒█▀▀▀ █▀▀▄ █▀▀▀ ░▀░ █▀▀▄ █▀▀ █▀▀ █▀▀█ 　 ▒█▀▀█ █▀▀█ █▀▀▀ █▀▀ \r\n"
						+ "▒█▒█▒█ █▀▀ █░░ █░░ █░░█ █░▀░█ █▀▀ 　 ░▒█░░ █▀▀█ █▀▀ 　 ▒█▀▀▀ █░░█ █░▀█ ▀█▀ █░░█ █▀▀ █▀▀ █▄▄▀ 　 ▒█▄▄█ █▄▄█ █░▀█ █▀▀ \r\n"
						+ "▒█▄▀▄█ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░░▀ ▀▀▀ 　 ░▒█░░ ▀░░▀ ▀▀▀ 　 ▒█▄▄▄ ▀░░▀ ▀▀▀▀ ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀▀ 　 ▒█░░░ ▀░░▀ ▀▀▀▀ ▀▀▀ \r\n"
						+ "\r\n"
						+ "▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \r\n"
						+ "▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \r\n"
						+ "░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░");
				Thread.sleep(600);
				System.out.println("\u001B[32m"+"Enter Your Choice"+"\u001B[0m");
				Thread.sleep(600);
				System.out.println("\u001B[34m"+"1 Login");
				Thread.sleep(600);
				System.out.println("2 Back"+"\u001B[0m");
				Thread.sleep(600);
				int engchoice=sc.nextInt();
				if(engchoice==1) {
					engobj= engerlmplobj.engLogin();
					if(engobj!=null) {
						Thread.sleep(600);
						while(true) {
							System.out.println("================== Welcome "+ engobj.getEngNaame() +"=====================");
							System.out.println("\u001B[32m"+"Enter Your Choice"+"\u001B[0m");
							Thread.sleep(600);
							System.out.println("\u001B[34m"+"1 check Your all complains");
							System.out.println("2 update Your work ");
							System.out.println("3 see pase complains");
							Thread.sleep(600);
							System.out.println("4 update Your password");
							System.out.println("5 Exit"+"\u001B[0m");
							int engoptionChoice=sc.nextInt();
							
							if(engoptionChoice==1) {
							 list=engerlmplobj.getProblemAssignmed(engobj);
							
//							System.out.println(engobj.getEid());
								if(list!=null) {
									list.forEach(s->System.out.println(s));
								}
								else {
									System.out.println("\033[0;31m"+"Nothing found"+"\033[0m");
								}
							}
							else if(engoptionChoice==2) {
								list=engerlmplobj.getProblemAssignmed(engobj);
								System.out.println("\u001B[33m"+"Eneter Your Compalin id: "+"\u001B[0m");
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
										System.out.println("\033[0;31m"+"something wrong"+"\033[0m");
									}
								}
								else {
									System.out.println("\033[0;31m"+"Sorry you are not authorized for this complain or may be this might be compited");
								}
								
							}
							else if(engoptionChoice==3) {
								List<ProblemsBeen> list1= engerlmplobj.getAllPassProblems(engobj);
								if(list1!=null) {
									list1.forEach(s->System.out.println(s));
								}
								else {
									System.out.println("\033[0;31m"+"Nothing found"+"\033[0m");
								}
								
								
							}
							else if(engoptionChoice==4) {
								String reString= engerlmplobj.engChangPassword(engobj);
								if(reString!=null) {
									System.out.println(reString);
								}
								else {
									System.out.println("\033[0;31m"+"Password did not changed "+"\033[0m");
									
								}
								
							}
							else {
								break;
							}
								
						}
						
					}
					else {
						System.out.println("\033[0;31m"+"Something went worong"+"\033[0m");
					}
				
				}
				else if(engchoice==2) {
					continue;
				}
				else {
					throw new IllegalArgumentException("\033[0;31m"+"Unexpected value: " +"\033[0m"+ engchoice);
				}
				
				
				break;
			case 3:
//				Thread.sleep(600);
				loding();
				System.out.println("\r\n"
						+ "▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \r\n"
						+ "▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \r\n"
						+ "░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \r\n"
						+ "\r\n"
						+ "▒█░░▒█ █▀▀ █░░ █▀▀ █▀▀█ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █░░█ █▀▀ 　 ▒█▀▀▀ █▀▄▀█ █▀▀█ █░░ █▀▀█ █░░█ █▀▀ █▀▀ \r\n"
						+ "▒█▒█▒█ █▀▀ █░░ █░░ █░░█ █░▀░█ █▀▀ 　 ░▒█░░ █▀▀█ █▀▀ 　 ▒█▀▀▀ █░▀░█ █░░█ █░░ █░░█ █▄▄█ █▀▀ █▀▀ \r\n"
						+ "▒█▄▀▄█ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░░▀ ▀▀▀ 　 ░▒█░░ ▀░░▀ ▀▀▀ 　 ▒█▄▄▄ ▀░░░▀ █▀▀▀ ▀▀▀ ▀▀▀▀ ▄▄▄█ ▀▀▀ ▀▀▀ \r\n"
						+ "\r\n"
						+ "▒█▀▀█ █▀▀█ █▀▀▀ █▀▀ █▀▀█ 　 ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \r\n"
						+ "▒█▄▄█ █▄▄█ █░▀█ █▀▀ █▄▄▀ 　 ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \r\n"
						+ "▒█░░░ ▀░░▀ ▀▀▀▀ ▀▀▀ ▀░▀▀ 　 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░");
				Thread.sleep(600);
				System.out.println("\u001B[32m"+"Enter Your Choice"+"\u001B[0m");
				Thread.sleep(600);
				System.out.println("\u001B[34m"+"1 Register");
				Thread.sleep(600);
				System.out.println("2 Login");
				Thread.sleep(600);
				System.out.println("3 Back"+"\u001B[0m");
				int empchoice=sc.nextInt();
				if(empchoice==1) {
					employeeBeen=employeelmpl.empRagister();
					if(employeeBeen!=null) {
//						employeMethod();
						Thread.sleep(600);
						while(true) {
							System.out.println("Now You Have to login");
							System.out.println("\u001B[34m"+"1 Login");
							System.out.println("2 exit"+"\u001B[0m");
							int hi=sc.nextInt();
							if(hi==1) {
								employeeBeen=employeelmpl.empLogin();
								if(employeeBeen!=null) {
									employeMethod();
//									continue;
								}
								else {
									System.out.println("\033[0;31m"+"Wrong passowrds"+"\033[0m");
								}

							}
							else {
								break;
							}
							
						}
						
					}
					else {
						System.out.println("\033[0;31m"+"Some Tehchnicla issue"+"\033[0m");
					}
				}
				else if(empchoice==2) {
					
					employeeBeen=employeelmpl.empLogin();
					if(employeeBeen!=null) {
						employeMethod();
//						continue;
					}
					else {
						System.out.println("\033[0;31m"+"Wrong passowrds"+"\033[0m");
					}
					
				}
				else if(empchoice==3) {
					continue;
				}
				else {
					throw new IllegalArgumentException("\033[0;31m"+"Unexpected value: "+"\033[0m" + empchoice);
				}
				break;
				
			default:
				loding();
				throw new IllegalArgumentException("\033[0;31m"+"Unexpected value: "+"\033[0m"+ + choice);
			}
			
			
			
		}
		

	}

}
