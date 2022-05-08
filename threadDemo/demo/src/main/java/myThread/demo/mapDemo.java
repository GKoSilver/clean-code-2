package myThread.demo;

import java.util.HashMap;
import java.util.Map;

public class mapDemo {

	public static void main(String[] args) {
		Map<Key, Integer> myMap = new HashMap<>();
		Key myKey = new Key(0, 10);
		myMap.put(myKey, 10);
		System.out.println(myMap.get(myKey));
		myKey.setValue(20);
		System.out.println(myMap.get(myKey));
		myKey.setValue(10);
		System.out.println(myMap.get(myKey));
		Key myKey2 = new Key(0, 10);
		System.out.println(myMap.get(myKey2));
	}

}

class Key {
	private int id;
	private int value;

	public Key(int id, int value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (id != other.id)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

}