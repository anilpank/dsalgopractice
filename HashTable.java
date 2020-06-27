
import java.util.List;
import java.util.ArrayList;

public class HashTable {
	
	private List<Pair>[] arr = new ArrayList[100];
	
	public static void main(String [] args) {
		System.out.println("implementing hashtable");
		HashTable table = new HashTable();
		table.put("ashi", "Ashi Verma");
		table.put("maahi", "Maahi Verma");
		table.put("anil",  "Anil Verma");
		table.put("anupam", "Anupam Kaushal");	
        System.out.println("ashi->" + table.get("ashi"));
        System.out.println("maahi->"+ table.get("maahi"));
        System.out.println("anil->" + table.get("anil"));
        System.out.println("anupam->" + table.get("anupam"));		
	}
	
	public String get(String key) {
		int hashCode = key.hashCode();
        int length = arr.length;
        int index = hashCode%length;
		index = Math.abs(index);
        List<Pair> itemList = arr[index];
        if (itemList == null) {
			return null;
        }
		
        for (Pair item : itemList) {			 
            if (key.equals(item.getKey())) {
				return item.getValue();
			}			
        }
        return null;		
	}
	
	public void put(String key, String value) {		
		int hashCode = key.hashCode();
        int length = arr.length;
        int index = hashCode%length;
		index = Math.abs(index);
		List<Pair> itemList = arr[index];
		if (itemList == null) {
			itemList = new ArrayList<>();
			arr[index] = itemList;
		}
		Pair pair = new Pair(key, value);
		itemList.add(pair);        		
	}
	
	
	
}