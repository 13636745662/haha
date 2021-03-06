package com.jarry.demo1.Java8tip;

import com.jarry.demo1.Entry.Result;
import com.jarry.demo1.Entry.UserBean;
import com.sun.org.apache.bcel.internal.classfile.Unknown;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @BelongsProject: demo1
 * @BelongsPackage: com.jarry.demo1.Java8tip
 * @Author: Jarry.Chang
 * @CreateTime: 2019-09-24 15:29
 */
public class Optional1 {

    UserBean userBean = new UserBean();
    Optional<UserBean> optionalBean = Optional.ofNullable(userBean);

    private String main() {

        optionalBean.ifPresent(System.out::println);
        if (optionalBean != null) {
            System.out.println(optionalBean);
        }

        /**
         * -----------------------------------------------------
         */
        // return optionalBean.orElse(null);
           /*
        if(optionalBean.isPresent()){
            return optionalBean.get();
        }
        else return null;*/
        return optionalBean.map(p -> p.getName()).map(name -> name.toUpperCase()).orElse(null);
    }

    /**
     * 空集合的流操作，------------如果集合为空，对空集合进行流操作
     */
    @Test
    public void Test1() {
        List list = new ArrayList();
        list.add(new Result<>());
        Stream eStream = Optional.ofNullable(list).map(List::stream).orElseGet(Stream::empty);
        Object collect = eStream.filter(u -> u != null).collect(Collectors.toList());
        System.out.println(collect.toString());

        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> collect1 = (List<Integer>) list.stream().filter(u -> u.equals(0) || u.equals(1)).collect(Collectors.toList());
        List<Integer> collect2 = collect1.stream().sorted().collect(Collectors.toList());
        System.out.println(collect2);


        Object o = Optional.ofNullable(null).orElse(0);
        boolean present = Optional.ofNullable(null).isPresent();
        Optional<Object> o1 = Optional.ofNullable(null);
        System.out.println(o1.toString());
        System.out.println(present);
    }
}
