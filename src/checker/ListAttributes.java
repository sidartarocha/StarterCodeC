package checker;

import java.util.List;

public class ListAttributes {
	
	private final List<Type> listType;
	private final int size;
	
	public ListAttributes(int size, List<Type> listType){
		this.size = size;
		this.listType = listType;
	}

	public int getSize() {
		return size;
	}

	public List<Type> getListType() {
		return listType;
	}
	
	@Override
	public boolean equals(Object attrib){
		ListAttributes listAtt = (ListAttributes) attrib;
		List<Type> listType = listAtt.getListType();
		
		if(this.getSize() != listAtt.getSize()){
			return false;
		}else{
			for (int i = 0; i< this.getSize(); i++) {
				if(listType.get(i).equals(listType.get(i))){
					return false;
				}
			}
		}
		
		return true;
		
	}
	
		
}
