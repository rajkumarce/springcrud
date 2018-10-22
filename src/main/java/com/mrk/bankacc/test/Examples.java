package com.mrk.bankacc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Examples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMap();

		List<String> names1 = new ArrayList<String>();
	      names1.add("Mahesh ");
	      names1.add("Suresh ");
	      names1.add("Ramesh ");
			
	      List<String> names2 = new ArrayList<String>();
	      names2.add("Mahesh ");
	      names2.add("Suresh ");
	      names2.add("Ramesh ");
	      for(String ss:names1){
	    	 System.out.println(ss);
	      }

		
	}
	
	public static void testMap(){
		
		HashMap<Integer, String> hashMap = new HashMap();
		hashMap.put(1, "Test1");
		hashMap.put(2, "Test2");
		hashMap.put(3, "Test3");
		
		Set set = hashMap.entrySet();
		Iterator<Entry> itr = set.iterator();
		while(itr.hasNext()){
			Entry entry = itr.next();
			entry.getKey();
			entry.getValue();
			//hashMap.remove(entry.getKey());
			if(entry.getKey().equals(2))
			 itr.remove();
		}

        List<Integer> list = new ArrayList();
        try{
		for(Map.Entry m: hashMap.entrySet()){
			
			m.getKey();
			m.getValue();
			if(m.getKey().equals(2))
				hashMap.remove(m.getKey());
/*			if(m.getKey().equals(2) || m.getKey().equals(3))
				list.add((Integer) m.getKey());*/
		}
		
/*         for(Integer elm : list){		
		  hashMap.remove(elm);
         }*/
		System.out.println(hashMap);
        }catch(Exception e){
        	
        	System.out.println(e.getMessage());
        }
		
		
		
		
		
		
	}
	

}
