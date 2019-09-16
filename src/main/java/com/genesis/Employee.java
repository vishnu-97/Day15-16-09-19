package com.genesis;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	
	@Id
	private int eno;
	private String ename;
	private int esal;
	private Address add;
	@OneToOne(fetch = FetchType.LAZY)
	private Laptop lap;
	@OneToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;
		
	
	
	public Employee(int eno, String ename, int esal, Address add, Laptop lap, Vehicle vehicle) {
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.add = add;
		this.lap = lap;
		this.vehicle = vehicle;
	}
	public Employee(int eno, String ename, int esal, Address add, Laptop lap) {
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.add = add;
		this.lap = lap;
	}
	public Employee(int eno, String ename, int esal, Address add) {
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.add = add;
	}
	
	public Employee(int eno) {
		this.eno = eno;
	}
	public Employee() {
		super();
	}
	
	
	public Laptop getLap() {
		return lap;
	}
	public void setLap(Laptop lap) {
		this.lap = lap;
	}
	public Address getAdd() {
		return add;
	}
	
	public void setAdd(Address add) {
		this.add = add;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", esal=" + esal + ", add=" + add + ", lap=" + lap
				+ ", vehicle=" + vehicle + "]";
	}
	
	
}
