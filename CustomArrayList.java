
public class CustomArrayList<T> {
   Object [] arr = new Object[100];
   int currentIndex = 0;
   
   public static void main(String [] args){
	   CustomArrayList list = new CustomArrayList<Integer>();
	   list.add(5);
	   list.add(10);
	   list.add(15);
	   list.add(20);
	   list.add(25);
	   list.add(30);
	   System.out.println(list);
	   list.remove(4);
	   System.out.println(list);
	   list.add(35);
	   System.out.println(list);
   } 

  public void add(T item) {
	  int len = arr.length;
	  if (currentIndex == len) {
		  //Array is full. Now resize the array
		  Object[] newArr = new Object[len*2];
		  for (int i=0; i<len; i++) {
			  newArr[i] = arr[i];
		  }
		  this.arr = newArr;
	  }	  
      arr[currentIndex] = item;
      currentIndex++;	  
  }

  public int size() {
	  return currentIndex;
  }
  
  public T get(int index){
	  return (T)arr[index];
  }
  
  public void remove(int index) {
	  if (index > currentIndex) {
		  return;
	  }
      else {
		 for (int i=index;i<currentIndex; i++) {
			 //Shift all elements left
			 arr[i] = arr[i+1];
         }
          currentIndex--;		 
	  }	   
		  
  }

  @Override
  public String toString(){
	  StringBuilder builder = new StringBuilder();
	  for (int i=0; i<currentIndex; i++) {
		  builder.append(arr[i]).append(",");
	  }
      return builder.toString();	  
  }	  
    
  
}