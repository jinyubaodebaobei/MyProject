package Accessible_IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
public class jin {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
   		File f1=new File("demo");
   	    if(!f1.exists())
   	    	System.out.println("不存在"+f1+"目录");
   	    	f1.mkdir();
   	    	File f2=new File("demo","jin.txt");
   	    if(!f2.exists())
   	    {
   	    	System.out.println(f1+"不是目录");
   	    	f2.createNewFile();
   	    }
   	    RandomAccessFile raf=new RandomAccessFile(f2, "rw");
   	    System.out.println(raf.getFilePointer());
   	    raf.write('A');
        System.out.println(raf.getFilePointer());
        raf.write('B');
        //直接写一个int
        int i=0x7fffffff;
        raf.writeInt(i);//已经转化为byte型
        String s="中国";
        byte [] b=s.getBytes("gbk");
        raf.write(b);
        System.out.println(raf.length());
        //读文件必须把指针移到一定的位置
        raf.seek(0);
        byte [] c=new byte[(int)raf.length()];
        raf.read(c);
        System.out.println(Arrays.toString(c));  
        raf.seek(10); 
        String  s1="强国梦";
        byte [] b1=s1.getBytes("gbk");
        raf.write(b1);
        raf.seek(16);
        raf.write('5');
        raf.seek(0);
        byte[] c3=new byte[(int)raf.length()];
        raf.read(c3);//读了之后才能将它以数组的形式输出
        System.out.println(Arrays.toString(c3));
       raf.close();   
	}
}


