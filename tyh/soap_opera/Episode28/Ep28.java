import java.util.*;
class Ep28 {
	public static List<String> f(int n) {
		List<String> res = new ArrayList<>();
		if(n==0) {
			res.add("");
		} else if(n==1) {
			res.add("A");
			res.add("X");
		} else {
			List<String> t = f(n-1);
			for(String s: t) {
				if(s.charAt(s.length()-1)=='A') {
					res.add(s+"A");
					res.add(s+"X");
				} else {
					res.add(s+"A");
				}
			}
		}
		return res;
	}
	public static Pair<Integer, Integer> g(int n) {
		if(n==0) return new Pair(0,0);
		else if(n==1) return new Pair(1,1);
		else {
			Pair<Integer, Integer> p = g(n-1);
			return new Pair(p.getKey()+p.getValue(), p.getKey());
		}
	}
	public static int h(int n) {
		Pair<Integer, Integer> p = g(n);
		return p.getKey() + p.getValue();
	}
	private static class Pair<K,V> {
		K key;
		V value;
		public Pair(K k, V v) {
			key=k; value=v;
		}
		public K getKey() { return key; }
		public V getValue() { return value; }
	}
}
