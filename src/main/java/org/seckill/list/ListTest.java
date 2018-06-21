package org.seckill.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 12084
 * @create 2018-06-21 15:13
 */

public class ListTest {

    public static void main(String[] args) {
        List<Map<Integer, Integer>> list = new ArrayList<Map<Integer, Integer>>();

        for (int i = 0; i < 10; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(i, i);
            list.add(map);
        }

        Object[] objects = list.toArray();


        for (Object object : objects) {
            System.out.println(object);
        }

    }
}
