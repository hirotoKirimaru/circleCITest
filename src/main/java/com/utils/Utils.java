package com.utils;

import java.util.Comparator;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
public class Utils {

	public int maxInt(List<Integer> a) {		
		return a.stream().max(Comparator.naturalOrder()).get();
	}
	
	/**
	  * ���X�g�̒�����p�����[�^b�ɍł��߂��A���傫���l���擾����B
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int nearIntToMax(List<Integer> a, int b) {		
		int rtn = 0;
		rtn = a.stream().filter(x -> x >= b).min(Comparator.naturalOrder()).get();
		
		return rtn;
	}
}
