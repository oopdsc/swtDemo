package service;

import java.util.ArrayList;
import java.util.List;

import model.material.MaterialItem;

public class MaterialService {
	
	private List<MaterialItem> list;
	
	public MaterialService(){
		list = new ArrayList<MaterialItem>();
	}
	
	public void add(MaterialItem item){
		if(!list.contains(item)){
			list.add(item);
		}
	}
	
	public void remove(MaterialItem item){
		if(list.contains(item)){
			list.remove(item);
		}
	}
	
	public List<MaterialItem> getAllRecords(){
		return list;
	}

}
