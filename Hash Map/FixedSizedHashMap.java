
public class FixedSizedHashMap<ValueObject> {

	public static final Object DEFAULT_NOT_FOUND = null;
	public static final double DEFAULT_FILL_FRACTION = 0.4; //Default fill fraction for sizing of table
	protected final int arraySize;
	protected final String[] keyArray;
	protected final ValueObject[] valueArray;
	protected Object notFoundValue = null;
	protected final int hitOffset;
	
	//Constructors
	
	public FixedSizedHashMap(int count, double fill, Object defaultNotFound){
		
		if(fill <= 0.0 || fill > 0.8){
			throw new IllegalArgumentException("Fill fraction is out of allowed range");
			
		}
		
		int size = Math.max((int) (count/fill), 11);
		size = size + (size + 1) % 2;
		arraySize = size;
		
		keyArray = new String[size];
		valueArray = (ValueObject[]) new Object[size];
		
		for(int i =0; i<size; i++){
			valueArray[i] = null;
		}
		hitOffset = arraySize / 2;
		notFoundValue = defaultNotFound;
	}
	
	public FixedSizedHashMap(int count, ValueObject miss){
		this(count, DEFAULT_FILL_FRACTION, miss);
		
	}
	
	public FixedSizedHashMap(int count){
		this(count,DEFAULT_FILL_FRACTION, DEFAULT_NOT_FOUND);
		
	}
	
	private final int slotStep(int slot){
		return (slot + hitOffset) % arraySize;
	}
	
	/*Find free slot number for entry. Starts at slot based on hashed 
	key value, if occupied, it adds collision offset and checks next slot
	untill unused slot is found. */
	private final int findFreeSlot(int slot){
		while(keyArray[slot] != null)
		{
			slot = slotStep(slot);
		}
		return slot;
	}
	
	private int regularFind(String key){
		int slot = regularSlot(key);
		
		while(keyArray[slot]!=null)
		{
			if(keyArray[slot].equals(key)){
				return slot;
			}
			else{
				slot = slotStep(slot);
			}
		}
		return -slot-1;
	}
	
	private final int regularSlot(String key){
		return (key.hashCode() & Integer.MAX_VALUE) % arraySize;
	}
	
	public boolean set(String key, ValueObject value)
	{
		//Validating Parameters 
		if(key == null || value == null){
			return false;
		}
		else{
			
			int offset  = regularFind(key);
			if (offset >- 0){
				
				valueArray[offset] = value;
				return true;
			}
			else{ //add new pair to hashmap
				offset = -offset - 1;
				keyArray[offset] = key;
				valueArray[offset] = value;
				return true;
			}
		}
	}
	
	public final boolean containsKey(String key){
		return regularFind(key) >= 0;
	}
	
	public final ValueObject get(String key){
		int slot = regularFind(key);
		if(slot>=0){
			return valueArray[slot];
		}
		else{
			return (ValueObject) notFoundValue;
		}
	}
	
	public boolean delete(String key){
		int slot = regularFind(key);
		if(slot >= 0){
			valueArray[slot] = (ValueObject) notFoundValue;
			keyArray[slot] = null;
			return true;
		}
		else{
			return false;
		}
	}
	public float load(){
		return keyArray.length / arraySize;
	} 
	
	public static void main(String args[]){ // main to Test this hashmap implentation 
		
		FixedSizedHashMap<String> hm = new FixedSizedHashMap<>(5);
		hm.set("a", "Armageddon");
		hm.set("b", "bail");
		hm.set("c", "Class");
		hm.set("d", "Github");
		hm.set("l", "Rules.");
		System.out.println(hm.get("d") + hm.get("l"));
		hm.delete("b");
		System.out.println(hm.get("b"));
	}
	
}

