package com.zs.iris.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 这个可以称之为数据结构
// 类似于 RDD
public class Task implements Serializable {
  List<Integer> datas = Arrays.asList(1, 2, 3, 4);

  List<Integer> logic(List<Integer> datas) {
    return datas.stream().map(i -> i * 2).collect(Collectors.toList());
  }
}
