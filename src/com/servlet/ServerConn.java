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
            while(true) {
            	clientServer.add(new ClientServer(s));
                //δ����ȡ���֤��Ϣ
                //��ȡ������Ϣ���������֤ģ�鴦��
                /*
                 * in compose
                 * */
                //close the socket while get a certain token
            }

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
                // ������socket�ص������ص��ͻ�����δ���ܵ���Ϣ��ʱ���Ͽ�����  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}