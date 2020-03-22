package VRPTW;

import static java.lang.Math.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadIn {
	public int customerNr; // 客户数量
	public int capacity; // 车辆容量
	public double[][] Graph; // 记录图
	public Customer[] customers; // 存储客户数据
	
	//计算图上各节点间的距离
	private double Distance ( Customer C1, Customer C2 ) {
	    return sqrt ( ( C1.X - C2.X ) * ( C1.X - C2.X ) + ( C1.Y - C2.Y ) * ( C1.Y - C2.Y ) );
	}
	
	//读取数据
	public void Read(String fileName){
		try {	
			Scanner in = new Scanner(new FileReader(fileName));
			
			in.next();
			customerNr = in.nextInt();
			capacity = in.nextInt();
			
			customers = new Customer[customerNr + 10];
			Graph = new double[customerNr + 10][customerNr + 10];
			for(int i = 0; i < customerNr + 10; i++) {
				customers[i] = new Customer();
			}
			
			for ( int i = 0; i <= customerNr; ++i ) {
				 customers[i].Number=in.nextInt();
				 customers[i].X=in.nextInt();
				 customers[i].Y=in.nextInt();
				 customers[i].Demand=in.nextInt();
				 customers[i].Begin=in.nextInt();
				 customers[i].End=in.nextInt();
				 customers[i].Service=in.nextInt();
				 //System.out.println("customerNr X,Y = " + customers[i].X + "\t" + customers[i].Y);
			}
			
			in.close();
		}catch (FileNotFoundException e) {
			// 未找到文件
			System.out.println("File not found!");
			System.exit(-1);
		}

	    for ( int i = 0; i <= customerNr; ++i )
	        for ( int j = 0; j <= customerNr; ++j )
	            Graph[i][j] = Distance ( customers[i], customers[j] );
	}
}
