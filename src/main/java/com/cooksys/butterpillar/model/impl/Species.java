package com.cooksys.butterpillar.model.impl;

import com.cooksys.butterpillar.model.IButterpillar;
import com.cooksys.butterpillar.model.ICatterfly;
import com.cooksys.butterpillar.model.IGrowthModel;
import com.cooksys.butterpillar.model.ISpecies;

public class Species implements ISpecies {

	private String name;
	private IGrowthModel growthModel;
	
	public Species() {
		super();
	}
	
	public Species(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public IGrowthModel getGrowthModel() {
		return growthModel;
	}
	
	public void setGrowthModel(IGrowthModel growthModel) {
		this.growthModel = growthModel;
	}
	
	public ICatterfly createCatterfly(double wingspan, double weight) {
		return new Catterfly(wingspan, weight);
	}
	
	public IButterpillar createButterpillar(double length, double leavesEaten) {
		return new Butterpillar(length, leavesEaten);
	}
	
	public ICatterfly[] convert(IButterpillar[] butterpillars) {
		ICatterfly[] catterflies = new Catterfly[butterpillars.length];
		for(int i = 0; i < butterpillars.length; i++) {
			catterflies[i] = growthModel.butterpillarToCatterfly(butterpillars[i]);
		}
		return catterflies;
	}
	
	public IButterpillar[] convert(ICatterfly[] catterflies) {
		IButterpillar[] butterpillars = new Butterpillar[catterflies.length];
		for(int i = 0; i < catterflies.length; i++) {
			butterpillars[i] = growthModel.catterflyToButterpillar(catterflies[i]);
		}
		return butterpillars;
	}
	
}
