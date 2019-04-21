package com.domain;

import com.form.UserForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UtilsTests {

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
        assertEquals(actual, 300);
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
        assertEquals(actual, 200);
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
        assertEquals(actual, 200);
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
        tmpForm.setSex(0);
        tmpForm.setVersion(1);
        a.add(tmpForm);

        tmpForm = new UserForm();
        tmpForm.setUserId(200);
        tmpForm.setSex(0);
        tmpForm.setVersion(1);
        a.add(tmpForm);

        tmpForm = new UserForm();
        tmpForm.setUserId(300);
        tmpForm.setSex(0);
        tmpForm.setVersion(1);
        a.add(tmpForm);

        tmpForm = new UserForm();
        tmpForm.setUserId(100);
        tmpForm.setSex(1);
        tmpForm.setVersion(1);
        b.add(tmpForm);

        tmpForm = new UserForm();
        tmpForm.setUserId(400);
        tmpForm.setSex(1);
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
    }

    @Test
    public void tekitou2() {
        List<UserForm> a = new ArrayList<>();
        UserForm tmpForm;

        tmpForm = new UserForm();
        tmpForm.setUserId(100);
//		tmpForm.setSex(0);
        tmpForm.setVersion(1);
        a.add(tmpForm);

        tmpForm = new UserForm();
        tmpForm.setUserId(200);
//		tmpForm.setSex(0);
        tmpForm.setVersion(1);
        a.add(tmpForm);

        tmpForm = new UserForm();
        tmpForm.setUserId(300);
//		tmpForm.setSex(0);
        tmpForm.setVersion(1);
        a.add(tmpForm);

        tmpForm = new UserForm();
        tmpForm.setUserId(100);
//		tmpForm.setSex(1);
        tmpForm.setVersion(1);
        a.add(tmpForm);

        tmpForm = new UserForm();
        tmpForm.setUserId(400);
//		tmpForm.setSex(1);
        tmpForm.setVersion(1);
        a.add(tmpForm);


        // すべて一致するのであれば、こちらでいいかも。
        Set<UserForm> unique = Collections.newSetFromMap(new ConcurrentHashMap<>());
//	　　　終端処理しないと動かない？
//	〇	a.stream().parallel().filter(form -> unique.add(form)).collect(Collectors.toList());
//	×	a.stream().parallel().filter(form -> unique.add(form));
        a = a.stream().parallel().filter(form -> unique.add(form)).collect(Collectors.toList());


        System.out.println("てきとう2_1");
        unique.forEach(ax -> {
            System.out.println(ax.getUserId());
            System.out.println(ax.getVersion());
        });
        System.out.println("てきとう2_2");
        a.forEach(ax -> {
            System.out.println(ax.getUserId());
            System.out.println(ax.getVersion());
        });
    }

    /**
     * こんなやり方でしか、javaで集約できない？
     */
    @Test
    public void test_集約() {
        List<UserForm> ufList =
                Arrays.asList(
                        new UserForm(1, 1, 2, 3),
                        new UserForm(1, 1, 2, 3),
                        new UserForm(1, 1, 2, 3),
                        new UserForm(1, 1, 2, 3),
                        new UserForm(1, 1, 2, 3)
                );

        List<UserForm> actual = new ArrayList<>();
        Map<Integer, List<UserForm>> listMap = ufList.stream().collect(Collectors.groupingBy(UserForm::getUserId));

        for (Integer key : listMap.keySet()) {
            List<UserForm> tmp = listMap.get(key);

            int a = 0;
            int b = 0;
            int c = 0;
            for (UserForm uf : tmp) {
                a += uf.getName();
                b += uf.getSex();
                c += uf.getVersion();
            }
            UserForm tmpuf = new UserForm(key, a, b, c);
            actual.add(tmpuf);
        }
        List<UserForm> expect =
                Arrays.asList(
                        new UserForm(1, 5, 10, 15)
                );

        assertEquals(actual, expect);


    }
}
