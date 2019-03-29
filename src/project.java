import java.util.Scanner;

public class project {
	
	static double joint;
	static double H_income;
	static double W_income;
	
	public static double s_employer(int income) {
		int monincome = 0;
		double conper = 0;
		double con;
		
		monincome = income/12;
		if(monincome<=7100)
			con = 0;
		if (monincome>=7100 && monincome<=30000)
			conper = 0.05;
			con = income * conper;
		if (monincome>30000)
			con = 1500 * 12;
		return con;}
	
	public static double jointTax(int hincome,int wincome){
		
		double taxpayable = 0;
		double hnetincome = hincome - s_employer(hincome);
		double wnetincome = wincome - s_employer(wincome);
		double jointnetincome = hnetincome + wnetincome;
		double marriedallowance = 264000;
		double jointnetchar; 
		project p = new project();
		
		System.out.println("Joint Texation");
		System.out.println("---------------------------------------");
		System.out.println("Husband's Income: "+ hincome + "   " + "Wife's Income: "+ wincome );
		System.out.println("Husband's MPF contribution: "+s_employer(hincome)+"    "+ "Wife's MPF contribution: "+s_employer(wincome));
		System.out.println("Joint MPF contribution: "+ (int)(s_employer(hincome)+ s_employer(wincome)));
		System.out.println("Husband's Net Total income: "+(int)hnetincome +"    "+ "Wife's Net Total income: "+ (int)wnetincome);
		jointnetchar = jointnetincome - marriedallowance;
		System.out.println("Joint Net Chargeable income: " + jointnetchar);
		int n = (int) (jointnetchar / 50000);
		double tax = 0;
		double remainder = jointnetchar;
		double[] taxrate = {0.02,0.06,0.1,0.14,0.17};
		double taxth = 0;
		
		if(jointnetchar>=0){
		for(int i=0; i<=n+1;i++){
			if(remainder>=50000 && i<= 4){
				tax = 50000 * taxrate[i];
				System.out.println("Times:" + i + "    " + taxrate[i]+ "   " + (int)tax );
				remainder -= 50000;
				taxth+=tax;
			}
			else if(remainder >0 && remainder<=50000 && i<= 4){
				tax = remainder * taxrate[i];
				System.out.println("Times:" + i + "    " + taxrate[i]+ "   " + (int)tax );
				remainder -= 50000;
				taxth+=tax;
			}
			else if (remainder>=50000 && i>= 4){
				tax = 50000 * taxrate[4];
				System.out.println("Times" + i + "    " + taxrate[4]+ "  "+ (int)tax);
				remainder-= 50000;
				taxth+=tax;
			}
			else if (remainder >0 && remainder<=50000 && i>=4){
				tax = remainder* taxrate[4];
				System.out.println("Remainder:" + "    " + taxrate[4]+ "  "+ (int)tax);
				remainder -= 50000;
				taxth+=tax;
			
			}}}	else System.out.print("Amount is too less no need to pay tax for it in joint.");
		
		System.out.println("Tax thereon:       "+ taxth);
		
		int taxreduct = (int) ((int)taxth * 0.75);
		
		System.out.println("Less: 75% tax reduction:   "+ taxreduct);
		taxpayable = taxth - taxreduct;
		System.out.println("Tax payable:    " + taxpayable);
		
		project.joint = taxpayable;
		
		return taxpayable;
		
	}
	
	public static double H_SeperateTax(int income) {
		double taxpayable = 0;
		int singleallowance = 132000;
		double netincome = income - s_employer(income);
		double netcharincome = netincome - singleallowance;
		
		int n = (int) (netcharincome / 50000);
		double[] taxrate = {0.02,0.06,0.1,0.14,0.17};
		System.out.println("Separate Texation");
		System.out.println("---------------------------------------");
		System.out.println("Income: " + income);
		System.out.println("MPF contribution: " + s_employer(income));
		System.out.println("Net Total income: " + netincome);
		System.out.println("Net Chargeable income: " + netcharincome);
		double tax = 0;
		double remainder = netcharincome;
		double taxth = 0;
		if(netcharincome>=0){
		for(int i=0; i<=n+1;i++){
			if(remainder>=50000 && i<= 4){
				tax = 50000 * taxrate[i];
				System.out.println("Times:" + i + "    " + taxrate[i]+ "   " + (int)tax );
				remainder -= 50000;
				taxth+=tax;
			}
			else if(remainder >0 && remainder<=50000 && i<= 4){
				tax = remainder * taxrate[i];
				System.out.println("Times:" + i + "    " + taxrate[i]+ "   " + (int)tax );
				remainder -= 50000;
				taxth+=tax;
			}
			else if (remainder>=50000 && i>= 4){
				tax = 50000 * taxrate[4];
				System.out.println("Times" + i + "    " + taxrate[4]+ "  "+ (int)tax);
				remainder-= 50000;
				taxth+=tax;
			}
			else if (remainder >0 && remainder<=50000 && i>=4){
				tax = remainder* taxrate[4];
				System.out.println("Remainder:" + "    " + taxrate[4]+ "  "+ (int)tax);
				remainder -= 50000;
				taxth+=tax;
			} 
		}
		System.out.println("Tax thereon:       "+ taxth);
		
		int taxreduct = (int) ((int)taxth * 0.75);
		
		System.out.println("Less: 75% tax reduction:   "+ taxreduct);
		taxpayable = taxth - taxreduct;
		System.out.println("Tax payable:    " + taxpayable);
		}else System.out.print("Amount is too less no need to pay tax for it for person.");
		project.H_income = taxpayable;
		return taxpayable;
	}

	public static double W_SeperateTax(int income) {
		double taxpayable = 0;
		int singleallowance = 132000;
		double netincome = income - s_employer(income);
		double netcharincome = netincome - singleallowance;
		
		int n = (int) (netcharincome / 50000);
		double[] taxrate = {0.02,0.06,0.1,0.14,0.17};
		System.out.println("Separate Texation");
		System.out.println("---------------------------------------");
		System.out.println("Income: " + income);
		System.out.println("MPF contribution: " + s_employer(income));
		System.out.println("Net Total income: " + netincome);
		System.out.println("Net Chargeable income: " + netcharincome);
		double tax = 0;
		double remainder = netcharincome;
		double[] taxarray = new double [n];
		double taxth = 0;
		if(netcharincome>=0){
		for(int i=0; i<=n+1;i++){
			if(remainder>=50000 && i<= 4){
				tax = 50000 * taxrate[i];
				System.out.println("Times:" + i + "    " + taxrate[i]+ "   " + (int)tax );
				remainder -= 50000;
				taxth+=tax;
			}
			else if(remainder >0 && remainder<=50000 && i<= 4){
				tax = remainder * taxrate[i];
				System.out.println("Times:" + i + "    " + taxrate[i]+ "   " + (int)tax );
				remainder -= 50000;
				taxth+=tax;
			}
			else if (remainder>=50000 && i>= 4){
				tax = 50000 * taxrate[4];
				System.out.println("Times" + i + "    " + taxrate[4]+ "  "+ (int)tax);
				remainder-= 50000;
				taxth+=tax;
			}
			else if (remainder >0 && remainder<=50000 && i>=4){
				tax = remainder* taxrate[4];
				System.out.println("Remainder:" + "    " + taxrate[4]+ "  "+ (int)tax);
				remainder -= 50000;
				taxth+=tax;
			} 
		}
		System.out.println("Tax thereon:       "+ taxth);
		
		int taxreduct = (int) ((int)taxth * 0.75);
		
		System.out.println("Less: 75% tax reduction:   "+ taxreduct);
		taxpayable = taxth - taxreduct;
		System.out.println("Tax payable:    " + taxpayable);
		}else System.out.println("Amount is too less no need to pay tax for it for person.");
		project.W_income = taxpayable;
		return taxpayable;
		
	}
	
	public static void main(String[] args){
		int h;
		int w; 
		int hincome;
		int wincome;
		int[] taxarray = new int[10];
		int s = 0;
		project p = new project();

		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input husband's income.");
		hincome = input.nextInt();
		
		System.out.println("Please input wife's income");
		wincome = input.nextInt();
		
		H_SeperateTax(hincome);
		System.out.println("");
		W_SeperateTax(wincome);
		System.out.println("");
		System.out.println("=============================================");
		jointTax(hincome,wincome);
		System.out.println("=============================================");
		System.out.println("Recommendation: ");
		
		if(project.joint>0 && project.H_income>0 && project.W_income >0) {
		System.out.println("The joint taxpayable amount is:" + project.joint);
		System.out.println("The husband taxpayable amount is: " + project.H_income);
		System.out.println("The wife taxpayable amount is: " + project.W_income);
		double combine = project.H_income + project.W_income;
		
		if(project.joint > combine)
			System.out.println("Recommendation: separate taxpay is better than joint taxpay");
		else if (combine > project.joint)
			System.out.println("Recommendation: Joint taxpay is better than separate taxpay");
		}else System.out.print("Because both parties no need to pay tax, no recommendation!");
	
	}
}