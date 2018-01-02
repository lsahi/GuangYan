package com.servlet;
import java.net.*;
import java.util.ArrayList;
import java.io.*;
/**
 * ������
 * ArrayListȷ����ͬʱ���ж���ͻ��˵�����
 * **����ʱ�����IP������̨
 * **�˿��ݶ�Ϊ30000
 * 
*/
public class ServerConn
{
    public ArrayList<ClientServer> clientServer;  
    public ServerConn() {  
        // TODO Auto-generated constructor stub  
        // ��ʼ������  
        clientServer = new ArrayList<ClientServer>();  
    }  
    public void initServerConn()throws IOException
    {
        //��ӡ������IP��ַ
        InetAddress address=InetAddress.getLocalHost();
        System.out.println("������IP��ַ��"+address.getHostAddress());
        //
        // ����һ��ServerSocket�����ڼ����ͻ���Socket����������
        ServerSocket ss = new ServerSocket(30000);
        // ����ѭ�����Ͻ������Կͻ��˵�����
        while (true)
        {
            // ÿ�����ܵ��ͻ���Socket�����󣬷�������Ҳ��Ӧ����һ��Socket
            Socket s = ss.accept();
            // ��Socket��Ӧ���������װ��PrintStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            // ������ͨIO����
            ps.println("���ã����������ӳɹ�");
            
            clientServer.add(new ClientServer(s));
        }
    }
    
    class ClientServer {  
        Socket ss;  
   
        public ClientServer(Socket ss) {  
            // TODO Auto-generated constructor stub  
            this.ss = ss;  
            // socket�������������Ϊ�ֽ�����  
            try {  
            	BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
                String line = br.readLine();
                System.out.println("���Կͻ��˵����ݣ�" + line);
                
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