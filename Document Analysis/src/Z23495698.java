
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Z23495698<X extends Comparable<X>, Y> implements Counter<X, Y> {

	public static void main(String args[]) throws FileNotFoundException {
		Counter<String, String> x = new Z23495698<String, String>();
		Utility.run(x);
	}

	public String get(X word) {

		Entry<TreeSet<Y>, Integer> value = map.get(word);
		if (value == null) 
			return null; 
		else {

			StringBuilder output = new StringBuilder();
			output.append("total count " + value.getValue());

			for (Y w : value.getKey()) {
				output.append(", ").append(w.toString());
			}

			return output.toString();
		}
	}


	public int getCount(X word) {
		Entry<TreeSet<Y>, Integer> value = map.get(word);
		if (value == null) 
			return 0;
		else 
			return value.getValue();
	}

	public Set<X> keySet() {
		return map.keySet();
	}


	public void put(X keyWord, Y word) {
		if (!map.containsKey(keyWord)) 
			map.put(keyWord, new Entry<TreeSet<Y>, Integer>(new TreeSet<>(), 0));
		Entry<TreeSet<Y>, Integer> values = map.get(keyWord);

		values.getKey().add(word);

		values.setValue(values.getValue() + 1);

	}

	private HashMap<X, Entry<TreeSet<Y>, Integer>> map = new HashMap<>();


	private class Entry<Key, Value> {
		protected Key k;
		protected Value v;

		public Key getKey() {
			return k;
		}

		public void setKey(Key k) {
			this.k = k;
		}

		public Value getValue() {
			return v;
		}

		public void setValue(Value v) {
			this.v = v;
		}

		public Entry(Key k, Value v) {
			this.k = k;
			this.v = v;
		}

		public String toString() {
			return k + "->" + v;
		}
	}

}
