package service;

import java.util.ArrayList;
import java.util.List;

import model.material.AuxiliaryMaterial;

public class AuMaterialService {
	
	private List<AuxiliaryMaterial> list;
	
	public AuMaterialService(){
		list = new ArrayList<AuxiliaryMaterial>();
	}
	
	public void add(AuxiliaryMaterial item){
		if(!list.contains(item)){
			list.add(item);
		}
	}
	
	public void remove(AuxiliaryMaterial item){
		if(list.contains(item)){
			list.remove(item);
		}
	}
	
	public List<AuxiliaryMaterial> getAllRecords(){
		return list;
	}

}
