package com.lp.liuan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelExample {
    public static void main(String args[]){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:/ѧϰ�ܽ�/java���뱾��.txt");
            FileChannel fileChannel = fis.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int bytes = fileChannel.read(byteBuffer);
            while(bytes!=-1){
                byteBuffer.flip();
                byte[] buffer = new byte[bytes];//����ȡ���ֽڷŵ��ֽ������У����ں�������������
                int i=0;
                while (byteBuffer.hasRemaining()){
                	buffer[i++]=byteBuffer.get();
                }
                String str = new String(buffer,"GBK");//�������
                System.out.println(str);
                byteBuffer.clear();
                bytes = fileChannel.read(byteBuffer);
            }
            if(fis!=null){
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}