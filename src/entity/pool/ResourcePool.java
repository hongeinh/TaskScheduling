package entity.pool;

import entity.Resource;

import java.util.HashMap;
import java.util.Map;

public class ResourcePool {
	private static final ResourcePool pool = null;
	private Map<Integer, Resource> resourceMap;

	private ResourcePool() {
		this.resourceMap = new HashMap<>();
		this.resourceMap.put(0, new Resource(0) );
		this.resourceMap.put(1, new Resource(1) );
		this.resourceMap.put(3, new Resource(3) );
		this.resourceMap.put(4, new Resource(4) );
		this.resourceMap.put(5, new Resource(5) );
		this.resourceMap.put(6, new Resource(6) );
		this.resourceMap.put(7, new Resource(7) );
		this.resourceMap.put(8, new Resource(8) );
		this.resourceMap.put(9, new Resource(9) );
		this.resourceMap.put(10,new Resource(10) );
	}

	public static ResourcePool getResourcePool() {
		if (pool == null) {
			return new ResourcePool();
		} else return pool;
	}

	public Resource getResource(int i) {
		return this.resourceMap.get(i);
	}
}
