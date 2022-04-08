package com.zs.iris.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class SubTask implements Serializable {
    List<Integer> datas = new ArrayList<>();
    public abstract List<Integer> logic(List<Integer> datas);

    // 真正的计算
    List<Integer> compute() {
        return logic(datas);
    }
}
