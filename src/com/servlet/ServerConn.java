package com.servlet;
import java.net.*;
import java.util.ArrayList;
import java.io.*;
/**
 * 服务器
 * ArrayList确保能同时进行多个客户端的连接
 * **测试时先输出IP到控制台
 * **端口暂定为30000
 * 
*/
public class ServerConn
{
    public ArrayList<ClientServer> clientServer;  
    public ServerConn() {  
        // TODO Auto-generated constructor stub  
        // 初始化队列  
        clientServer = new ArrayList<ClientServer>();  
    }  
    public void initServerConn()throws IOException
    {
        //打印本机的IP地址
        InetAddress address=InetAddress.getLocalHost();
        System.out.println("本机的IP地址是"+address.getHostAddress());
        //
        // 创建一个ServerSocket，用于监听客户端Socket的连接请求
        ServerSocket ss = new ServerSocket(30000);
        // 采用循环不断接受来自客户端的请求
        while (true)
        {
            // 每当接受到客户端Socket的请求，服务器端也对应产生一个Socket
            Socket s = ss.accept();
            // 将Socket对应的输出流包装成PrintStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            // 进行普通IO操作
            ps.println("您好，服务器连接成功");
            
            clientServer.add(new ClientServer(s));
        }
    }
    
    class ClientServer {  
        Socket ss;  
   
        public ClientServer(Socket ss) {  
            // TODO Auto-generated constructor stub  
            this.ss = ss;  
            // socket的输出流（该流为字节流）  
            try {  
            	BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
                String line = br.readLine();
                System.out.println("来自客户端的数据：" + line);
                
                //String sepereating
                String [] arr = line.split("\\s+");
                for(String myarr : arr){
                    System.out.println(myarr);
                }
                //arr0 is ID, arr1 is pw;
                
                IdIsInDB certificantID=new IdIsInDB();
                try {
					certificantID.idInDB(arr[0],arr[1]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}