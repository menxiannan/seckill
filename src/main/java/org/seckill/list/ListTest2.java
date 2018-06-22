package org.seckill.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 12084
 * @create 2018-06-21 15:23
 */

public class ListTest2 {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 3; i < 10; i++) {
            list2.add(i);
        }
        System.out.println("List1：" + list1);
        System.out.println("List2：" + list2);
        System.out.println("交集为" + getIntersection(list1, list2));


//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(1);
//        ids.add(2);
//        ids.add(3);
//        ids.add(4);
//
//
//        List<Integer> iiIds = new ArrayList<Integer>();
//        iiIds.add(1);
//        iiIds.add(2);
//        iiIds.add(3);
//        iiIds.add(4);
//
//
//        Collection exists=new ArrayList<Integer>(ids);
//        exists.removeAll(iiIds);
//        System.out.println(ids);
//        System.out.println(iiIds);
//        System.out.println(exists);
//        System.out.println(exists.size());


//        t7();
//        String text = "a r b k c d se f g a d f s s f d s ft gh f ws w f v x s g h d h j j k f sd j e wed a d f";
//        List<String> list = new ArrayList<String>();
//        list.addAll(Arrays.asList(text.split(" ")));
//        Set<String> uniqueWords = new HashSet<String>(list);
//        for (String word : uniqueWords) {
//            System.out.println(word + ": " + Collections.frequency(list, word));
//        }
    }

    public static List<Integer> getIntersection(List<Integer> list1,
                                                List<Integer> list2) {
        List<Integer> result = new ArrayList<Integer>();
        for (Integer integer : list2) {//遍历list1
            if (list1.contains(integer)) {//如果存在这个数
                result.add(integer);//放进一个list里面，这个list就是交集
            }
        }
        return result;
    }

    p

    /**
     * 去重复；
     */
    public static void t7() {
        List<String> lst1 = new ArrayList<String>();
        lst1.add("aa");
        lst1.add("dd");
        lst1.add("ss");
        lst1.add("aa");
        lst1.add("ss");

        //方法 1.
//        for (int i = 0; i < lst1.size() - 1; i++) {
//            for (int j = lst1.size() - 1; j > i; j--) {
//                if (lst1.get(j).equals(lst1.get(i))) {
//                    lst1.remove(j);
//                }
//            }
//        }
//        System.out.println(lst1);


        //方法 2.
        List<String> lst2 = new ArrayList<String>();
        for (String s : lst1) {
            System.out.println(s);
            int frequency = Collections.frequency(lst2, s);
            if (frequency < 1) {
                lst2.add(s);
            }
        }
        System.out.println(lst2);

    }

    /**
     * 其他
     */
    public static void t6() {
        List<String> person = new ArrayList<String>();
        person.add("马云");
        person.add("马化腾");
        //空则返回true，非空则返回false
        if (person.isEmpty()) {
            System.out.println("空的");
        } else {
            System.out.println("不是空的");
        }

        //返回Iterator集合对象；
        System.out.println("返回Iterator集合对象:" + person.iterator());


        //将集合转换为字符串；
        String liString = "";
        liString = person.toString();
        System.out.println("将集合转换为字符串:" + liString);

        //将集合转换为数组；
        System.out.println("将集合转换为数组:" + person.toArray());


    }


    /**
     * 对比两个list中的所有元素；
     * <p>
     * 两个相等对象的equals方法一定为true, 但两个hashcode相等的对象不一定是相等的对象
     */
    public static void t5() {

        List<String> person = new ArrayList<String>();
        person.add("马云");
        person.add("马化腾");


        List<String> fruits = new ArrayList<String>();
        fruits.add("马云");
        fruits.add("马化腾");

        if (person.equals(fruits)) {
            System.out.println("两个list中的所有元素相同");
        } else {
            System.out.println("两个list中的所有元素不一样");
        }

        if (person.hashCode() == fruits.hashCode()) {
            System.out.println("我们相同");
        } else {
            System.out.println("我们不一样");
        }
    }


    /**
     * 利用list中索引位置重新生成一个新的list（截取集合）；
     * <p>
     * 方法： .subList(fromIndex, toIndex)；　　.size() ； 该方法得到list中的元素数的和
     */
    public static void t4() {
        List<String> phone = new ArrayList<String>();
        phone.add("三星");    //索引为0
        phone.add("苹果");    //索引为1
        phone.add("锤子");    //索引为2
        phone.add("华为");    //索引为3
        phone.add("小米");    //索引为4
        //原list进行遍历
        for (String pho : phone) {
            System.out.println(pho);
        }
        //生成新list

        //.subList(fromIndex, toIndex)      //利用索引1-4的对象重新生成一个list，但是不包含索引为4的元素，4-1=3
        phone = phone.subList(1, 4);
        // phone.size() 该方法得到list中的元素数的和
        for (int i = 0; i < phone.size(); i++) {
            System.out.println("新的list包含的元素是" + phone.get(i));
        }
    }

    /**
     * list中查看（判断）元素的索引；
     * 　注意：.indexOf（）； 和  lastIndexOf（）的不同；
     */
    public static void t3() {
        List<String> names = new ArrayList<String>();
        names.add("刘备");    //索引为0
        names.add("关羽");    //索引为1
        names.add("张飞");    //索引为2
        names.add("刘备");    //索引为3
        names.add("张飞");    //索引为4

        System.out.println(names.indexOf("刘备"));
        System.out.println(names.lastIndexOf("刘备"));
        System.out.println(names.indexOf("张飞"));
        System.out.println(names.lastIndexOf("张飞"));


        //根据元素索引位置进行的判断;
        if (names.indexOf("刘备") == 0) {
            System.out.println("刘备在这里");
        } else if (names.lastIndexOf("刘备") == 3) {
            System.out.println("刘备在那里");
        } else {
            System.out.println("刘备到底在哪里？");
        }

    }


    /**
     * list中根据索引将元素数值改变(替换)；
     * 注意 .set(index, element); 和 .add(index, element); 的不同；
     */
    public static void t2() {

        String a = "白龙马", b = "沙和尚", c = "八戒", d = "唐僧", e = "悟空";
        List<String> people = new ArrayList<String>();
        people.add(a);
        people.add(b);
        people.add(c);
        System.out.println(people.toString());
        //.set(index, element);     //将d唐僧放到list中索引为0的位置，替换a白龙马
        people.set(0, d);
        System.out.println(people.toString());
        //.add(index, element);     //将e悟空放到list中索引为1的位置,原来位置的b沙和尚后移一位
        people.add(1, e);
        System.out.println(people.toString());
    }


    /**
     * 向list添加数据 add
     * 判断是否在list存在  contains("判断的东西");
     * list中删除 remove(下标)    remove("值")
     */
    public static void t1() {
        List<String> list = new ArrayList<String>();
        list.add("苹果");
        list.add("香蕉");
        list.add("榴莲");
        list.add("桃子");

        System.out.println(list.toString());

        String type = "苹果";
        System.out.println("是否包含" + type + "=" + list.contains(type));

        list.remove(1);
        System.out.println(list.toString());
        System.out.println("是否包含" + type + "=" + list.contains(type));
        list.remove("苹果");
        System.out.println(list.toString());
        System.out.println("是否包含" + type + "=" + list.contains(type));

    }
}
