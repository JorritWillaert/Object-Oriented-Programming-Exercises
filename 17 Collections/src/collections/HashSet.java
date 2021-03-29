package collections;

import java.util.Arrays;

public class HashSet implements Set {
	
	//Note: normally increase number of buckets if number of elements increases. But: we skip this.
	
	private Set[] buckets;
	
	public HashSet(int capacity) {
		buckets = new Set[capacity];
		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new ArraySet();
	}
	
	private Set getBucket(Object object) {
		int hashcode = object.hashCode();
		return buckets[Math.floorMod(hashcode, buckets.length)];
	}
	
	public int size() {
		return Arrays.stream(buckets).mapToInt(bucket -> bucket.size()).sum();
	}
	
	public Object[] toArray() {
		//return Arrays.stream(buckets).flatMap(bucket -> Arrays.stream(toArray())).toArray();
		
		//Alternative implementation
		ArrayList result = new ArrayList();
		for (int i = 0; i < buckets.length; i++) {
			Object[] bucketContents = buckets[i].toArray();
			for (int j = 0; j < buckets[j].size(); j++) {
				result.add(bucketContents[j]);
			}
		}
		return result.toArray();
	}
	
	public boolean contains(Object object) {
		return getBucket(object).contains(object);
	}
	
	public void add(Object object) {
		getBucket(object).add(object);
	}
	
	public void remove(Object object) {
		getBucket(object).remove(object);
	}
	
}
