package VRPTW;

public class Customer {
	int Number;//节点自身编号
    int R;//节点所属车辆路径编号
    int X, Y;//节点横纵坐标
    int Begin, End, Service;//节点被访问的最早时间，最晚时间以及服务时长
    int Demand;//节点的需求容量
    
    public Customer() {
    	this.Number=0;
    	this.R=0;
    	this.Begin =0;
    	this.End=0;
    	this.Service=0;
    	this.X=0;
    	this.Y=0;
    	this.Demand=0;
    }
    
    public Customer copy() {
    	Customer newCustomer = new Customer(); 
    	newCustomer.Number=this.Number;
    	newCustomer.R=this.R;
    	newCustomer.Begin =this.Begin;
    	newCustomer.End=this.End;
    	newCustomer.Service=this.Service;
    	newCustomer.X=this.X;
    	newCustomer.Y=this.Y;
    	newCustomer.Demand=this.Demand;
    	return newCustomer;
    }
}
