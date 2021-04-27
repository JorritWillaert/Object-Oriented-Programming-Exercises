package iterators;

public class ArrayListIterator implements Iterator {
	
	public ArrayList arrayList;
	public int index;
	
	public ArrayListIterator(ArrayList arrayList) {
		this.arrayList = arrayList;
	}
	
	@Override
	public boolean hasNext() {
		return index < arrayList.elements.length;
	}
	
	@Override
	public Object next() {
		return arrayList.elements[index++];
	}
}
