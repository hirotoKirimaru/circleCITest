package com.domain;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {

    /**
     * FizzBuzz を実装するメソッド
     *
     * @param num 数値
     * @return FizzBuzz の結果
     */
    public String exec(int num) {
        StringBuilder sb = new StringBuilder();

        if (num % 3 == 0) {
            sb.append("Fizz");
        }

        if (num % 5 == 0) {
            sb.append("Buzz");
        }

        if (sb.length() == 0) {
            sb.append(num);
        }

        return sb.toString();
    }
}
