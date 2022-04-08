package com.zs.iris.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Executor2 {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // 启动服务器，接收数据
    ServerSocket server = new ServerSocket(8888);
    System.out.println("服务器启动成功，等待客户端连接...");

    Socket clinet = server.accept();
    InputStream in = clinet.getInputStream();
    ObjectInputStream objIn = new ObjectInputStream(in);
    SubTask task = (SubTask)objIn.readObject();

    List<Integer> compute = task.compute();

    System.out.println("计算节点[8888]结果：" + compute);

    in.close();
    objIn.close();
    clinet.close();
    server.close();
  }
}
