package com.zs.iris.core;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class Driver {
  public static void main(String[] args) throws IOException {
    // 连接服务器
    Socket client1 = new Socket("localhost", 9999);
    Socket client2 = new Socket("localhost", 8888);

    Task task = new Task();

    OutputStream out1 = client1.getOutputStream();
    ObjectOutputStream objOut1 = new ObjectOutputStream(out1);

    SubTask subTask1 =
        new SubTask() {
          @Override
          public List<Integer> logic(List<Integer> datas) {
            datas.addAll(task.datas.subList(0, 2));
            return task.logic(datas);
          }
        };
    objOut1.writeObject(subTask1);

    objOut1.flush();
    objOut1.close();
    client1.close();

    OutputStream out2 = client2.getOutputStream();
    ObjectOutputStream objOut2 = new ObjectOutputStream(out2);

    SubTask subTask2 =
        new SubTask() {
          @Override
          public List<Integer> logic(List<Integer> datas) {
            datas.addAll(task.datas.subList(2, 4));
            return task.logic(datas);
          }
        };
    objOut2.writeObject(subTask2);

    objOut2.flush();
    objOut2.close();
    client2.close();

    System.out.println("客户端发送任务成功");
  }
}
