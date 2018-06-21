package org.seckill.map;

import java.util.*;

/**
 * @author 12084
 * @create 2018-06-21 14:40
 */

public class MapTest {

    public static void main(String[] args) {

        List<Map<Integer, Long>> list = new ArrayList<Map<Integer, Long>>();

        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < 9999; i++) {
            map.put(i + "", "value" + i);
        }

        System.out.println("map长度：" + map.size());

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        long _1S = System.currentTimeMillis();
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }
        long _1E = System.currentTimeMillis();
        long l = _1E - _1S;
        Map map1 = new HashMap();
        map1.put(1, l);
        list.add(map1);
        System.err.println("_1 执行时间：" + l);
//
//
//        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        long _2S = System.currentTimeMillis();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        long _2E = System.currentTimeMillis();
        long l1 = _2E - _2S;
        Map map2 = new HashMap();
        map1.put(2, l1);
        list.add(map2);
        System.err.println("_2 执行时间：" + l1);
//
//
//        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        long _3S = System.currentTimeMillis();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        long _3E = System.currentTimeMillis();
        long l2 = _3E - _3S;
        Map map3 = new HashMap();
        map1.put(3, l2);
        list.add(map3);
        System.err.println("_3 执行时间：" + l2);
//
//
//        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        long _4S = System.currentTimeMillis();
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println("value = " + value);
        }
        long _4E = System.currentTimeMillis();
        long l3 = _4E - _4S;
        Map map4 = new HashMap();
        map1.put(4, l3);
        list.add(map4);
        System.err.println("_4 执行时间：" + l3);


        System.out.println(list.toString());
    }
}
