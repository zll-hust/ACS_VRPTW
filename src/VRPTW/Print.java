package VRPTW;
/**  
* <p>Title: Print</p>  
* <p>Description: </p>  
* @author zll_hust  
* @date 2020年2月2日  
*/

import java.util.ArrayList;

public class Print {
	
	private double bestCost;
	public int capacity; 
	private ArrayList <Route> bestRoutes=new ArrayList<>();
	private double[][] Graph;
	public Customer[] customers;
	
	Print(Solution bestSolution, ReadIn readIn){
		this.bestCost = bestSolution.totalCost;
		this.bestRoutes = bestSolution.routes;
		this.Graph = readIn.Graph;
		this.customers = readIn.customers;
		this.capacity = readIn.capacity;
	}
	
    //结果输出
	public void Output () {
	    System.out.println("************************************************************");
	    System.out.println("The Minimum Total Distance = "+ bestCost);
	    System.out.println("Concrete Schedule of Each Route as Following : ");

	    int id = 0;
	    for (int i = 1; i < bestRoutes.size(); i++)
	        if ( bestRoutes.get(i).customers.size() > 2 ) {
	            id++;
	            System.out.print("No." + id + " : ");
	            
	            for ( int j = 0; j < bestRoutes.get(i).customers.size() - 1; ++j )
	            	System.out.print( bestRoutes.get(i).customers.get(j) + " -> ");
	            System.out.println( bestRoutes.get(i).customers.get(bestRoutes.get(i).customers.size() - 1));
	        }
	    System.out.println("************************************************************");
	}
	
	public void CheckAns() {
		boolean checkTime = true;
		boolean checkCost = true;
		boolean checkCapacity = true;
		// 检验距离计算是否正确
	    double totalCost = 0;
	    for (int i = 0; i < bestRoutes.size(); i++)
	        for ( int j = 1; j < bestRoutes.get(i).customers.size(); ++j )
	            totalCost += Graph[bestRoutes.get(i).customers.get(j - 1)][bestRoutes.get(i).customers.get(j)];
	    // 防止精度损失
	    if (Math.abs(totalCost - bestCost) > 1) checkCost = false;
	    
	    for (int i = 0; i < bestRoutes.size(); i++) {
	    	int time = 0;
	    	for (int j = 1; j < bestRoutes.get(i).customers.size(); ++j) {
	    		time += Graph[bestRoutes.get(i).customers.get(j - 1)][bestRoutes.get(i).customers.get(j)];
	    		if (time > customers[bestRoutes.get(i).customers.get(j)].End) checkTime = false;
	    		time = Math.max(time, customers[bestRoutes.get(i).customers.get(j)].Begin)
	    				+ customers[bestRoutes.get(i).customers.get(j)].Service;
	    	}
	    }
	    
	    for (int i = 0; i < bestRoutes.size(); i++) {
	    	int load = 0;
	    	for (int j = 1; j < bestRoutes.get(i).customers.size() - 1; ++j) {
	    		load += customers[bestRoutes.get(i).customers.get(j)].Demand;
	    	}
	    	if (load > capacity) checkCapacity = false;
	    }
	    
	    System.out.println("Check total cost = " + totalCost + "\t" + checkCost);
	    System.out.println("Check time windows = " + checkTime);
	    System.out.println("Check time capacity = " + checkCapacity);
	}
}
