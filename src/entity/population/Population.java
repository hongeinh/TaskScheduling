package entity.population;

import common.Common;
import entity.Vertice;

import java.util.ArrayList;
import java.util.List;

public class Population {
	protected List<Vertice> verticeList;

	public Population() {
		this.verticeList = new ArrayList<>();
//		produce();
	}
//	public void produce() {
//		for (int i = 0; i < Common.numOfPopulation; i++) {
//			this.verticeList.add(new Vertice());
//		}
//	}

	public List<Vertice> getVerticeList() {
		return verticeList;
	}

	public void setVerticeList(List<Vertice> verticeList) {
		this.verticeList = verticeList;
	}
}
