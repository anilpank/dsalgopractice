
import java.util.List;
import java.util.ArrayList;

public class HashTable<A, B> {
	
	private List<Pair<A,B>>[] arr = new ArrayList[100];
	
	public static void main(String [] args) {
		System.out.println("implementing hashtable");
		
		HashTable<String, String>table = new HashTable<>();
		table.put("ashi", "Ashi Verma");
		table.put("maahi", "Maahi Verma");
		table.put("anil",  "Anil Verma");
		table.put("anupam", "Anupam Kaushal");	
        System.out.println("ashi->" + table.get("ashi"));
        System.out.println("maahi->"+ table.get("maahi"));
        System.out.println("anil->" + table.get("anil"));
        System.out.println("anupam->" + table.get("anupam"));	
        System.out.println("raqndom->" + table.get("jhgeee")); 
		

        HashTable<Integer, String> table2 = new HashTable<>();
		table2.put(3, "Ashi Verma");
		table2.put(5, "Maahi Verma");
		table2.put(7,  "Anil Verma");
		table2.put(9, "Anupam Kaushal");	
        System.out.println(table2.get(7));		
	}
	
	public B get(A key) {
		int hashCode = key.hashCode();
        int length = arr.length;
        int index = hashCode%length;
		index = Math.abs(index);
        List<Pair<A, B>> itemList = arr[index];
        if (itemList == null) {
			return null;
        }
		
        for (Pair<A,B>item : itemList) {			 
            if (key.equals(item.getKey())) {
				return item.getValue();
			}			
        }
        return null;		
	}
	
	public void put(A key, B value) {		
		int hashCode = key.hashCode();
        int length = arr.length;
        int index = hashCode%length;
		index = Math.abs(index);
		List<Pair<A, B>> itemList = arr[index];
		if (itemList == null) {
			itemList = new ArrayList<>();
			arr[index] = itemList;
		}
		Pair<A, B> pair = new Pair(key, value);
		itemList.add(pair);        		
	}
	
}