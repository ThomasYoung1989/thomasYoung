package com.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListTest {

	public static void main(String[] args) {
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		Map<String, String> hahaMap=new HashMap<String, String>();
		
		for(int i=0;i<20;i++){
			hahaMap.put("key"+i, "value"+i);
			list.add(hahaMap);
		}
		
		System.out.println(list.size());
	}
}
