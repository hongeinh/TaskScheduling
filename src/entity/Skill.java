package entity;

import common.Common;
import entity.pool.ResourcePool;

import java.util.HashMap;
import java.util.Map;

public class Skill {

	private int id;

	private Map<Resource, Double> lexp;

	private double maxSkill;

	public Skill(int id) {
		this.id = id;
		this.lexp = new HashMap<>();
		setLexp();
		setMaxSkill();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Resource, Double> getLexp() {
		return lexp;
	}

	public void setLexp() {
		for (int i = 0; i < Common.numOfResources; i++) {
			if(Common.lexp[i][this.id] > 0) {
				this.lexp.put(ResourcePool.getResourcePool().getResource(i), Common.lexp[i][this.id]);
			}
		}
	}

	public double getMaxSkill() {
		return maxSkill;
	}

	public void setMaxSkill() {
		double maxSkill = 0;
		for (Map.Entry<Resource, Double> entry: this.lexp.entrySet()) {
			maxSkill = maxSkill > entry.getValue() ? maxSkill : entry.getValue();
		}
		this.maxSkill = maxSkill;
	}
}
