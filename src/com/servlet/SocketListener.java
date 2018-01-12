package com.servlet;

import java.net.*;
import java.io.*;

import com.servlet.ServerConn;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SocketListener implements ServletContextListener {

     private MyThread myThread;
     @Override
     public void contextDestroyed(ServletContextEvent arg0) {
         if (myThread!=null&&myThread.isInterrupted()) {
             myThread.interrupt();
         }
 
     }
 
     @Override
     public void contextInitialized(ServletContextEvent arg0) {
         String str =null;
         if (str==null&&myThread==null) {
             myThread=new MyThread();
             myThread.start();//servlet�����ĳ�ʼ��ʱ����socket
         }
     }
     
     
     /*
      * �Զ���һ��Class�߳���̳����߳��࣬��дrun()���������ڴӺ�̨��ȡ��������
      * 
      */
     class MyThread extends Thread{
         public void run() {
        	InetAddress address = null;
			try {
				address = InetAddress.getLocalHost();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				//IP: 192.168.56.1
				e1.printStackTrace();
			}
             while (!this.isInterrupted()) {//�߳�δ�ж�ִ��ѭ��
                 try {
                     Thread.sleep(2000);//ÿ��2000msִ��һ��
                     
                     
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 
                 //----------------------��ʼִ��---------------------
                 try {
					ServerConn serverConnect=new ServerConn();
					serverConnect.initServerConn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
         }
     }
 
}