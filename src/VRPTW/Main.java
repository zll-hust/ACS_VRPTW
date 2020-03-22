package VRPTW;

public class Main {
	public static void main (String arg[]) {
		long begintime = System.nanoTime();
		
		Parameter parameter = new Parameter();
		ReadIn readIn = new ReadIn();
		readIn.Read("c101.txt");
		
		System.out.println("waiting for a while ... ...");
		AntColonySystem ACS = new AntColonySystem(parameter, readIn); 
		Solution bestSolution = ACS.ACS_Strategy();
		
		Print print = new Print(bestSolution, readIn);
		print.Output();
		print.CheckAns();
		
	    long endtime = System.nanoTime();
		double usedTime= (endtime - begintime)/(1e9);
		System.out.println();
		System.out.println("Total run time £º"+usedTime+"s");
	}
}
