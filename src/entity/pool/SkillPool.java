package entity.pool;

import entity.Skill;

import java.util.HashMap;
import java.util.Map;

public class SkillPool {
	private static final SkillPool pool = null;
	private Map<Integer, Skill> skillMap ;

	private SkillPool() {
		this.skillMap = new HashMap<>();
		this.skillMap.put(0, new Skill(0) );
		this.skillMap.put(1, new Skill(1) );
		this.skillMap.put(3, new Skill(3) );
		this.skillMap.put(4, new Skill(4) );
		this.skillMap.put(5, new Skill(5) );
		this.skillMap.put(6, new Skill(6) );
		this.skillMap.put(7, new Skill(7) );
		this.skillMap.put(8, new Skill(8) );
		this.skillMap.put(9, new Skill(9) );
	}

	public static SkillPool getPool() {
		if (pool == null) {
			return new SkillPool();
		} else return pool;
	}

	public Skill getSkill(int i) {
		return this.skillMap.get(i);
	}
}
