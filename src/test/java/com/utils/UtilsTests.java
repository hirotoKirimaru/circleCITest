package com.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Utils.class)
public class UtilsTests {

//	@Test
//	public void contextLoads() {
//	}

//	@Test
	@Autowired
	Utils testClass;
	
	@Test
	public void maxInt_1() {
		List<Integer> param1 = new ArrayList<Integer>();
		
		param1.add(100);
		param1.add(200);
		param1.add(300);
		
		
		
		int actual = 0;
		actual = testClass.maxInt(param1);
		assertEquals(actual , 300);
	}
	
	@Test
	public void nearIntToMax_1() {
		List<Integer> param1 = new ArrayList<Integer>();
		int param2 = 130;
		
		param1.add(100);
		param1.add(200);
		param1.add(300);
		
		
		
		int actual = 0;
		actual = testClass.nearIntToMax(param1, param2);
		assertEquals(actual , 200);
	}
	
	@Test
	public void nearIntToMax_2() {
		List<Integer> param1 = new ArrayList<Integer>();
		int param2 = 200;
		
		param1.add(100);
		param1.add(200);
		param1.add(300);
		
		
		int actual = 0;
		actual = testClass.nearIntToMax(param1, param2);
		assertEquals(actual , 200);
	}
	
}
