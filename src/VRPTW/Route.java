package VRPTW;

import java.util.ArrayList;

public class Route {
	public double load;//单条路径承载量
    public double distance;//单条路径总长度
    public double time;
    public ArrayList <Integer> customers = new ArrayList<>();
}