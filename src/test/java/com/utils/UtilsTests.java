package com.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.form.UserForm;

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
	
	
	
	/**
	  * 複数の特定のカラムが重複していた場合、重複を削除する処理をテストする。
	  * なお、今回はUserIdとVersionの重複しない場合として処理する。
	 */
	@Test
	public void tekitou() {
		List<UserForm> a = new ArrayList<>();
		List<UserForm> b = new ArrayList<>();
		UserForm tmpForm;
		
		tmpForm = new UserForm();
		tmpForm.setUserId(100);
		tmpForm.setVersion(1);
		a.add(tmpForm);
		
		tmpForm = new UserForm();
		tmpForm.setUserId(200);
		tmpForm.setVersion(1);
		a.add(tmpForm);
		
		tmpForm = new UserForm();
		tmpForm.setUserId(300);
		tmpForm.setVersion(1);
		a.add(tmpForm);
		
		tmpForm = new UserForm();
		tmpForm.setUserId(100);
		tmpForm.setVersion(1);
		b.add(tmpForm);
		
		tmpForm = new UserForm();
		tmpForm.setUserId(400);
		tmpForm.setVersion(1);
		b.add(tmpForm);
		
		b.forEach(bx -> {
			boolean flg = a.stream().filter(ax -> Objects.equals(bx.getUserId(), ax.getUserId())).anyMatch(a2 -> Objects.equals(a2.getVersion(), bx.getVersion()));
			if (!flg) a.add(bx);
		});
		
		a.forEach(ax -> {
			System.out.println(ax.getUserId());
			System.out.println(ax.getVersion());
		});
		
		
//		a.stream().filter(e -> Objects.equals(e.getUserId())
		
	}
}
