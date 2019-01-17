package com.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public int maxInt(List<Integer> a) {
		Optional<Integer> b = a.stream().max(Comparator.naturalOrder());
		if (b.isPresent()) {
			return b.get();
		} else {
			return 0;
		}
	}
	
	/**
	  * リストの中からパラメータbに最も近く、かつ大きい値を取得する。
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
