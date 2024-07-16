package org.Mess.Client;

import java.util.*;

import org.Mess.Model.menuModel;
import org.Mess.Repository.admisionRepository;
import org.Mess.Repository.billingRepository;
import org.Mess.Model.AllmessCustomerModel;
import org.Mess.Model.admisionModel;
import org.Mess.Model.attendanceModel;
import org.Mess.Model.billingModel;
import org.Mess.Model.breakfastModel;
import org.Mess.Model.dinnerModel;
import org.Mess.Service.AllmessCustomerService;
import org.Mess.Service.admisionService;
import org.Mess.Service.attendanceService;
import org.Mess.Service.breakfastService;
import org.Mess.Service.dinnerService;
import org.Mess.Service.menuItemService;

public class Client_Application {

	public static void main(String[] args) {

		List<menuModel> list;
		List<AllmessCustomerModel> list1;
		List<breakfastModel> list2;
		List<dinnerModel> list3;
		List<AllmessCustomerModel> listbill;
		attendanceModel attendmodel;
		billingModel bmodel;
		menuItemService menuitemservice = new menuItemService();
		breakfastService bfs = new breakfastService();
		dinnerService ds = new dinnerService();
		admisionService admisionser=new admisionService();
		admisionModel admisionmodel;
		billingRepository billingRepo=new billingRepository();
		AllmessCustomerService allmesscust = new AllmessCustomerService();
		AllmessCustomerModel allcust;
		attendanceService attendservice=new attendanceService();
		boolean b;
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("        Welcome TO Mess Management System    ");
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		boolean exit = false;

		do {
			System.out.println("Enter 1 for Admin Login");
			System.out.println("Enter 2 for Customer Registration");
			System.out.println("Enter 3 to View Items");
			System.out.println("Enter 4 to join mess:");
			System.out.println("Enter 0 to Exit");
//			System.out.print("Enter your choice: ");
//			choice = sc.nextInt();
//			sc.nextLine(); // Consume newline
			boolean validInput = false;

	        while (!validInput) {
	            try {
	                System.out.print("Enter your choice: ");
	                choice = sc.nextInt();
	                sc.nextLine();  
	                validInput = true;  
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	                sc.nextLine();  
	            }
	        }

			
	
			switch (choice) {
			case 1:
				String aname = "admin";
				String apass = "admin";
				System.out.println("Enter username and password:");
				String name = sc.nextLine();
				String pass = sc.nextLine();

				if (name.equals(aname) && pass.equals(apass)) {
					int adminChoice = 0;
					do {
						System.out.println("Enter 1 for Add menu");
						System.out.println("Enter 2 for View menu");
						System.out.println("Enter 3 for Calculate bill for walking customer");
						System.out.println("Enter 4 to Update menu");
						System.out.println("Enter 5 to See all customers");
						System.out.println("Enter 6 to Delete Menu");
						System.out.println("Enter 7 to mark attendance:");
						System.out.println("Enter 8 to View income of mess and walking customer");
						System.out.println("Enter 0 to Logout");
//						System.out.print("Enter your choice: ");
//						adminChoice = sc.nextInt();
						 validInput = false;

				        while (!validInput) {
				            try {
				                System.out.print("Enter your choice: ");
				                adminChoice = sc.nextInt();
				                sc.nextLine();  
				                validInput = true;  
				            } catch (InputMismatchException e) {
				                System.out.println("Invalid input. Please enter an integer.");
				                sc.nextLine();  
				            }
				        }

						

						switch (adminChoice) {
						case 1:
							int addChoice = 0;
							do {
								System.out.println("Enter 1 for Add Breakfast");
								System.out.println("Enter 2 for Add Lunch");
								System.out.println("Enter 3 for Add Dinner");
								System.out.println("Enter 0 to Go Back");
								validInput = false;

						        while (!validInput) {
						            try {
						                System.out.print("Enter your choice: ");
						                adminChoice = sc.nextInt();
						                sc.nextLine();  
						                validInput = true;  
						            } catch (InputMismatchException e) {
						                System.out.println("Invalid input. Please enter an integer.");
						                sc.nextLine();  
						            }
						        }
								switch (addChoice) {
								case 1:
									 System.out.println("Enter 0 to go back to the main menu.");

					                    try {
					                        int innerChoice = sc.nextInt(); 
					                        if (innerChoice == 0) {
					                            break; 
					                        } else {
					                            System.out.println("Invalid choice. Exiting from Add Menu.");
					                            sc.nextLine();
					                        }
					                    } catch (Exception e) {
					                        System.out.println("Invalid input. Please enter a valid integer.");
					                        sc.nextLine(); 
					                    }
									System.out.print("Enter item name: ");
									String iname = sc.nextLine();
									System.out.print("Enter item price: ");
									int iprice = sc.nextInt();
									breakfastModel breakmodel = new breakfastModel();
									breakmodel.setName(iname);
									breakmodel.setPrice(iprice);
									b = bfs.isAddBreakfast(breakmodel);
									if (b) {
										System.out.println("Item Added Successfully...");
									} else {
										System.out.println("Item Not Added...");
									}
									break;
								case 2:
									System.out.println("Enter 0 to go back to the main menu.");

				                    try {
				                        int innerChoice = sc.nextInt(); 
				                        if (innerChoice == 0) {
				                            break; 
				                        } else {
				                            System.out.println("Invalid choice. Exiting from Add Menu.");
				                            sc.nextLine();
				                        }
				                    } catch (Exception e) {
				                        System.out.println("Invalid input. Please enter a valid integer.");
				                        sc.nextLine(); 
				                    }
							
									System.out.print("Enter item name: ");
									String itname = sc.nextLine();
									System.out.print("Enter item price: ");
									int itprice = sc.nextInt();
									menuModel menu = new menuModel();
									menu.setName(itname);
									menu.setPrice(itprice);

									b = menuitemservice.isAddItem(menu);
									if (b) {
										System.out.println("Item added Successfully...");
									} else {
										System.out.println("Item not Added Successfully...");
									}
									break;
								case 3:
									System.out.println("Enter 0 to go back to the main menu.");

				                    try {
				                        int innerChoice = sc.nextInt(); 
				                        if (innerChoice == 0) {
				                            break; 
				                        } else {
				                            System.out.println("Invalid choice. Exiting from Add Menu.");
				                            sc.nextLine();
				                        }
				                    } catch (Exception e) {
				                        System.out.println("Invalid input. Please enter a valid integer.");
				                        sc.nextLine(); 
				                    }
							
									System.out.print("Enter Dinner item: ");
									String dname = sc.nextLine();
									System.out.print("Enter price of item: ");
									int dprice = sc.nextInt();
									dinnerModel dm = new dinnerModel();
									dm.setName(dname);
									dm.setPrice(dprice);
									b = ds.isAddDinner(dm);
									if (b) {
										System.out.println("Item Added Successfully...");
									} else {
										System.out.println("Item Not Added...");
									}
									break;
								}
							} while (addChoice != 0);

							break;

						case 2:
							int viewChoice = 0;
							do {
								System.out.println("Enter 1 to View Breakfast menu");
								System.out.println("Enter 2 to View Lunch Menu");
								System.out.println("Enter 3 to View Dinner Menu");
								System.out.println("Enter 0 to Go Back");
//								System.out.print("Enter your choice: ");
//								viewChoice = sc.nextInt();
//								sc.nextLine(); // Consume newline
								validInput = false;

						        while (!validInput) {
						            try {
						                System.out.print("Enter your choice: ");
						                viewChoice = sc.nextInt();
						                sc.nextLine();  
						                validInput = true;  
						            } catch (InputMismatchException e) {
						                System.out.println("Invalid input. Please enter an integer.");
						                sc.nextLine();  
						            }
						        }

								switch (viewChoice) {
								case 1:
									System.out.println("Menu Available for Breakfast:");
									list2 = bfs.isgetBreakfast();
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									System.out.printf("%-10s %-20s %-10s%n", "Sr.No", "Name", "Price");
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									for (breakfastModel ms : list2) {
										System.out.printf("%-10d %-20s %-10d%n", ms.getBid(), ms.getName(), ms.getPrice());
									}
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									break;

								case 2:
									System.out.println("Menu Available for Lunch:");
									list = menuitemservice.isgetMenu();
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									System.out.printf("%-10s %-20s %-10s%n", "Sr.No", "Name", "Price");
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									for (menuModel ms : list) {
										System.out.printf("%-10d %-20s %-10d%n", ms.getId(), ms.getName(), ms.getPrice());
									}
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									break;

								case 3:
									System.out.println("Menu Available for Dinner:");
									list3 = ds.isgetDinner();
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									System.out.printf("%-10s %-20s %-10s%n", "Sr.No", "Name", "Price");
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									for (dinnerModel ms : list3) {
										System.out.printf("%-10d %-20s %-10d%n", ms.getDid(), ms.getName(), ms.getPrice());
									}
									System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
									break;
								}
							} while (viewChoice != 0);

							break;

						case 3:
							System.out.println("Enter 0 to go back to the main menu.");

		                    try {
		                        int innerChoice = sc.nextInt(); 
		                        if (innerChoice == 0) {
		                            break; 
		                        } else {
		                            System.out.println("Invalid choice. Exiting from Add Menu.");
		                            sc.nextLine();
		                        }
		                    } catch (Exception e) {
		                        System.out.println("Invalid input. Please enter a valid integer.");
		                        sc.nextLine(); 
		                    }
					
							System.out.println("Enter user mail id:");
							String uemail=sc.nextLine();
							int cid=allmesscust.ischeckcutomerpresent(uemail);
							if(cid!=0)
							{
								System.out.println("Enter date: YYYY/MM//DD");
								String bdate=sc.nextLine();
								System.out.println("Enter Item name:");
								String iname=sc.nextLine();
								System.out.println("ENter Quntity of items");
								int qty=sc.nextInt();
								System.out.println("Enter price:");
								int itemprice=sc.nextInt();
								int totalamount=qty*itemprice;
								bmodel=new billingModel();
								bmodel.setBdate(bdate);
								bmodel.setCid(cid);
								bmodel.setItemName(name);
								bmodel.setQty(qty);
								bmodel.setAmount(totalamount);
								
								listbill=allmesscust.isgetbillcustomer(uemail);
//								AllmessCustomerModel allmess = (AllmessCustomerModel)listbill;
								for(AllmessCustomerModel allmess:listbill)
								{
								 System.out.printf(
							                "----------------------------------------\n" +
							                "                  BILL                  \n" +
							                "----------------------------------------\n" +
							                "Customer Name       : %s\n" +
							                "Customer Email ID   : %s\n" +
							                "Customer Contact No : %s\n" +
							                "----------------------------------------\n" +
							                "Items Name          : %s\n" +
							                "Quantity of Items   : %d\n" +
							                "----------------------------------------\n" +
							                "Total Amount Due    : $%d\n" +
							                "----------------------------------------",
							                allmess.getName(),
							                allmess.getEmail(),
							                allmess.getContact(),
							                iname,
							                qty,
							                totalamount
							       ) ;
								}
								   
//							 System.out.println(bill);
								b=billingRepo.iscalculatebill(bmodel);
								if(b)
								{
									System.out.println("Data Saved...");
								}
								else
								{
									System.out.println("Data Not Saved...");
								}
							}
						else
							{
								System.out.println("Check mail id or Do registration:");
							}
							break;

						case 4:
							int updateChoice = 0;
							do {
								System.out.println("Enter 1 to Update Breakfast menu");
								System.out.println("Enter 2 to Update Lunch Menu");
								System.out.println("Enter 3 to Update Dinner Menu");
								System.out.println("Enter 0 to Go Back");
//								System.out.print("Enter your choice: ");
//								updateChoice = sc.nextInt();
//								sc.nextLine(); // Consume newline
								validInput = false;

						        while (!validInput) {
						            try {
						                System.out.print("Enter your choice: ");
						                updateChoice = sc.nextInt();
						                sc.nextLine();  
						                validInput = true;  
						            } catch (InputMismatchException e) {
						                System.out.println("Invalid input. Please enter an integer.");
						                sc.nextLine();  
						            }
						        }

								switch (updateChoice) {
								case 1:
									int updateBreakfastChoice = 0;
									do {
//										System.out.println("Enter 1 to Update Breakfast name");
										System.out.println("Enter 2 to Update Breakfast price");
										System.out.println("Enter 0 to Go Back");
										System.out.print("Enter your choice: ");
										updateBreakfastChoice = sc.nextInt();
										sc.nextLine(); // Consume newline

										switch (updateBreakfastChoice) {
										case 1:
											System.out.println("Enter 0 to go back to the main menu.");

						                    try {
						                        int innerChoice = sc.nextInt(); 
						                        if (innerChoice == 0) {
						                            break; 
						                        } else {
						                            System.out.println("Invalid choice. Exiting from Add Menu.");
						                            sc.nextLine();
						                        }
						                    } catch (Exception e) {
						                        System.out.println("Invalid input. Please enter a valid integer.");
						                        sc.nextLine(); 
						                    }
									
											System.out.print("Enter Breakfast name: ");
											String bname = sc.nextLine();

											b = bfs.ischeckName(bname);
											if (b) {
												System.out.print("Enter new name to update: ");
												String nname = sc.nextLine();
												b = bfs.isupdateName(bname, nname);
												if (b) {
													System.out.println("Breakfast item updated successfully.");
												} else {
													System.out.println("Breakfast item not updated.");
												}
											} else {
												System.out.println("Breakfast item not present.");
											}
											break;

										case 2:
											System.out.println("Enter 0 to go back to the main menu.");

						                    try {
						                        int innerChoice = sc.nextInt(); 
						                        if (innerChoice == 0) {
						                            break; 
						                        } else {
						                            System.out.println("Invalid choice. Exiting from Add Menu.");
						                            sc.nextLine();
						                        }
						                    } catch (Exception e) {
						                        System.out.println("Invalid input. Please enter a valid integer.");
						                        sc.nextLine(); 
						                    }
									
											System.out.print("Enter Breakfast name to update price: ");
											String pname = sc.nextLine();
											b = bfs.ischeckPrice(pname);
											if (b) {
												System.out.print("Enter new price to update: ");
												int nprice = sc.nextInt();
												b = bfs.isupdatePrice(pname, nprice);
												if (b) {
													System.out.println("Price updated successfully.");
												} else {
													System.out.println("Price not updated.");
												}
											} else {
												System.out.println("Breakfast item not present.");
											}
											break;
										}
									} while (updateBreakfastChoice != 0);
									break;

								case 2:
									System.out.println("Enter 0 to go back to the main menu.");

				                    try {
				                        int innerChoice = sc.nextInt(); 
				                        if (innerChoice == 0) {
				                            break; 
				                        } else {
				                            System.out.println("Invalid choice. Exiting from Add Menu.");
				                            sc.nextLine();
				                        }
				                    } catch (Exception e) {
				                        System.out.println("Invalid input. Please enter a valid integer.");
				                        sc.nextLine(); 
				                    }
							
									System.out.println("Enter lunch name for update lunch price");
									String lunchName=sc.nextLine();
									b=menuitemservice.ischecklunchname(lunchName);
									if(b)
									{
									System.out.println("Enter new lunch price:");
									int nlunchprice=sc.nextInt();
									b=menuitemservice.isupdatelunchPrice(nlunchprice,lunchName);
									if(b)
									{
										System.out.println("Price updated...");
									}
									else
									{
										System.out.println("Price not updated");
									}
									}
									else
									{
										System.out.println("Item not present add to menu card");
									}
									break;

								case 3:
									System.out.println("Enter 0 to go back to the main menu.");

				                    try {
				                        int innerChoice = sc.nextInt(); 
				                        if (innerChoice == 0) {
				                            break; 
				                        } else {
				                            System.out.println("Invalid choice. Exiting from Add Menu.");
				                            sc.nextLine();
				                        }
				                    } catch (Exception e) {
				                        System.out.println("Invalid input. Please enter a valid integer.");
				                        sc.nextLine(); 
				                    }
							
									System.out.println("Enter Dinner menu name to update price:");
									String dinnerName=sc.nextLine();
									b=ds.ischeckDinnerName(dinnerName);
									if(b)
									{
										System.out.println("Enter new price ");
										int dinnerPrice=sc.nextInt();
										b=ds.isupdatedinnerPrice(dinnerPrice,dinnerName);
									}
									else
									{
										System.out.println("Item not present add to menu card");
									}
									break;
								}
							} while (updateChoice != 0);

							break;

						case 5:
							System.out.println("All Customer List:");
							System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
							list1 = allmesscust.isgetcustomer();
							System.out.printf("%-10s %-20s %-30s %-15s%n", "Sr.No", "Name", "Email", "Contact");
							for (AllmessCustomerModel a : list1) {
								System.out.printf("%-10d %-20s %-30s %-15s%n", a.getId(), a.getName(), a.getEmail(), a.getContact());
							}
							System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
							break;

						case 6:
							int deleteChoice = 0;
							do {
								System.out.println("Enter 1 to Delete Breakfast menu");
								System.out.println("Enter 2 to Delete Lunch menu");
								System.out.println("Enter 3 to Delete Dinner menu");
								System.out.println("Enter 0 to Go Back");
//								System.out.print("Enter your choice: ");
//								deleteChoice = sc.nextInt();
//								sc.nextLine(); // Consume newline
								validInput = false;

						        while (!validInput) {
						            try {
						                System.out.print("Enter your choice: ");
						                deleteChoice = sc.nextInt();
						                sc.nextLine();  // consume the newline character
						                validInput = true;  // input is valid, exit the loop
						            } catch (InputMismatchException e) {
						                System.out.println("Invalid input. Please enter an integer.");
						                sc.nextLine();  // consume the invalid input
						            }
						        }

								switch (deleteChoice) {
								case 1:
									System.out.println("Enter 0 to go back to the main menu.");

				                    try {
				                        int innerChoice = sc.nextInt(); 
				                        if (innerChoice == 0) {
				                            break; 
				                        } else {
				                            System.out.println("Invalid choice. Exiting from Add Menu.");
				                            sc.nextLine();
				                        }
				                    } catch (Exception e) {
				                        System.out.println("Invalid input. Please enter a valid integer.");
				                        sc.nextLine(); 
				                    }
							
									System.out.print("Enter Breakfast menu name to delete: ");
									String did = sc.nextLine();
									b = bfs.isdelete(did);
									if (b) {
										System.out.println("Item deleted successfully.");
									} else {
										System.out.println("Item not deleted.");
									}
									break;

								case 2:
									System.out.println("Enter 0 to go back to the main menu.");

				                    try {
				                        int innerChoice = sc.nextInt(); 
				                        if (innerChoice == 0) {
				                            break; 
				                        } else {
				                            System.out.println("Invalid choice. Exiting from Add Menu.");
				                            sc.nextLine();
				                        }
				                    } catch (Exception e) {
				                        System.out.println("Invalid input. Please enter a valid integer.");
				                        sc.nextLine(); 
				                    }
							
									System.out.print("Enter Lunch menu name to delete: ");
									String lid = sc.nextLine();
									b = bfs.isdelete(lid);
									if (b) {
										System.out.println("Item deleted successfully.");
									} else {
										System.out.println("Item not deleted.");
									}
									break;

								case 3:
									System.out.println("Enter 0 to go back to the main menu.");

				                    try {
				                        int innerChoice = sc.nextInt(); 
				                        if (innerChoice == 0) {
				                            break; 
				                        } else {
				                            System.out.println("Invalid choice. Exiting from Add Menu.");
				                            sc.nextLine();
				                        }
				                    } catch (Exception e) {
				                        System.out.println("Invalid input. Please enter a valid integer.");
				                        sc.nextLine(); 
				                    }
							
									System.out.print("Enter Dinner menu name to delete: ");
									String dinnerid = sc.nextLine();
									b = ds.isdelete(dinnerid);
									if (b) {
										System.out.println("Item deleted successfully.");
									} else {
										System.out.println("Item not deleted.");
									}
									break;
								}
							} while (deleteChoice != 0);
							break;
						case 7:
							System.out.println("Enter 0 to go back to the main menu.");

		                    try {
		                        int innerChoice = sc.nextInt(); 
		                        if (innerChoice == 0) {
		                            break; 
		                        } else {
		                            System.out.println("Invalid choice. Exiting from Add Menu.");
		                            sc.nextLine();
		                        }
		                    } catch (Exception e) {
		                        System.out.println("Invalid input. Please enter a valid integer.");
		                        sc.nextLine(); 
		                    }
					
							System.out.println("Enter your email id:");
							String cemail=sc.nextLine();
							int aid=allmesscust.ischeckcutomerpresentattendance(cemail);
							
							if(aid!=0)
							{
								System.out.println("Enter Date:YYYY//MM/DD");
								String adate=sc.nextLine();
								System.out.println("Enter 1 for present and 0 for Absent");
								int p=sc.nextInt();
								attendmodel =new attendanceModel();
								attendmodel.setAdate(adate);
								attendmodel.setPresent(p);
								attendmodel.setAid(aid);
								
								b=attendservice.isaddPresent(attendmodel);
								if(b)
								{
									System.out.println("Attendance Marked..");
								}
								else
								{
									System.out.println("Attendance not marked...");
								}
							}
							else
							{
								System.out.println("Enter correct mail id:");
							}
							break;
						case 8:
							int walkingamount=billingRepo.isgettotalwalkin();
							int admisioncount=admisionser.isgettotal();
							int admisionamount=admisioncount*1500;
							
							System.out.println("Income From walking Customer is:"+walkingamount);
							System.out.println("Income From Mess Customer is :"+admisionamount);
							break;
						case 0:
							// Exit admin loop
							break;

						default:
							System.out.println("Invalid choice. Please try again.");
						}
					} while (adminChoice != 0);

				} else {
					System.out.println("Invalid username or password. Please try again.");
				}
				break;

			case 2:
				System.out.println("Enter 0 to go back to the main menu.");

                try {
                    int innerChoice = sc.nextInt(); 
                    if (innerChoice == 0) {
                        break; 
                    } else {
                        System.out.println("Invalid choice. Exiting from Add Menu.");
                        sc.nextLine();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    sc.nextLine(); 
                }
		
				System.out.print("Enter Customer Name: ");
				String name1 = sc.nextLine();
				System.out.print("Enter Customer Email: ");
				String email = sc.nextLine();
				System.out.print("Enter Contact Number: ");
				String contact = sc.nextLine();

				allcust = new AllmessCustomerModel();
				allcust.setName(name1);
				allcust.setEmail(email);
				allcust.setContact(contact);

				b = allmesscust.isAddCustomer(allcust);
				if (b) {
					System.out.println("Your record has been saved successfully.");
				} else {
					System.out.println("Failed to save your record.");
				}
				break;

			case 3:
				int custchoice=0;
				do
				{
					System.out.println("ENter 1 for view break fast menu:");
					System.out.println("Enter 2 for view Lunch menu:");
					System.out.println("Enter 3 for view Dinner menu:");
					System.out.println("Enter 0 for exist:");
					System.out.println("Enter your choice:");
					custchoice=sc.nextInt();
					switch(custchoice)
					{
					case 1:
						System.out.println("Menu Available for Breakfast:");
						list2 = bfs.isgetBreakfast();
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						System.out.printf("%-10s %-20s %-10s%n", "Sr.No", "Name", "Price");
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						for (breakfastModel ms : list2) {
							System.out.printf("%-10d %-20s %-10d%n", ms.getBid(), ms.getName(), ms.getPrice());
						}
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						break;

					case 2:
						System.out.println("Menu Available for Lunch:");
						list = menuitemservice.isgetMenu();
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						System.out.printf("%-10s %-20s %-10s%n", "Sr.No", "Name", "Price");
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						for (menuModel ms : list) {
							System.out.printf("%-10d %-20s %-10d%n", ms.getId(), ms.getName(), ms.getPrice());
						}
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						break;

					case 3:
						System.out.println("Menu Available for Dinner:");
						list3 = ds.isgetDinner();
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						System.out.printf("%-10s %-20s %-10s%n", "Sr.No", "Name", "Price");
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						for (dinnerModel ms : list3) {
							System.out.printf("%-10d %-20s %-10d%n", ms.getDid(), ms.getName(), ms.getPrice());
						}
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						break;
					}
				}while(custchoice!=0);
				
				break;
			case 4:
				System.out.println("Enter 0 to go back to the main menu.");

                try {
                    int innerChoice = sc.nextInt(); 
                    if (innerChoice == 0) {
                        break; 
                    } else {
                        System.out.println("Invalid choice. Exiting from Add Menu.");
                        sc.nextLine();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    sc.nextLine(); 
                }
		
				System.out.println("Enter your mail id:");
				String custmail=sc.nextLine();
				int num=allmesscust.ischeckcutomerpresent(custmail);
				if(num!=0)
				{
					System.out.println("One time mess amount=1500");
					System.out.println("Two time mess amount=3000");
					System.out.println("Enter how many time you want to join mess");
					int htime=sc.nextInt();
					int pay=htime*1500;
					System.out.println("You how to pay amount"+htime*1500);
					System.out.println("Enter your amount:");
					int amount=sc.nextInt();
					sc.nextLine();
					if(amount==pay)
					{
						
						System.out.println("Enter Date in YYYY/MM/DD");
						String adate=sc.nextLine();
						admisionmodel=new admisionModel();
						
						admisionmodel.setAdate(adate);
						admisionmodel.setCid(num);
						admisionmodel.setDeposite(pay);
						admisionmodel.setHtimes(htime);
						
						
						b=admisionser.isaddadmision(admisionmodel);
						if(b)
						{
							System.out.println("Your Admision sucessfully done..");
						}
						else
						{
							System.out.println("Your admision is not done..");
						}
					}
					else
					{
						System.out.println("Please enter specified amount:");
					}
					
				}
				else
				{
					System.out.println("Please Registration first...");
				}
				break;
			case 0:
				exit = true;
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
			
			
		} while (!exit);

		System.out.println("Thank you for using the Mess Management System. Goodbye!");
		sc.close();
	}
}
