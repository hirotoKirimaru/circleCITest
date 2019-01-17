package com.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.model.GitHubUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiUtilsTests {

	@Autowired
	RestApiUtils testClass;
	
	@Test
	public void maxInt_1() {
		String param1 = "hirotoKirimaru";
		GitHubUser actual = new GitHubUser();
		actual = testClass.getGitHubUser(param1);
		assertEquals(actual.getId() ,  30658134);
		assertEquals(actual.getLogin() , "hirotoKirimaru");
	}

}
