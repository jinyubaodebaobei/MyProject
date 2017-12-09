package Accessible_IO;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class lianxi2 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f1=new File("D:\\金玉波\\jin\\yu\\bao");
		if(!f1.exists())
		{
			f1.mkdirs();
		}
		File f2=new File("D:\\金玉波\\jin\\yu\\bao","beibei.txt");
		if(!f2.exists())
		{
			f2.createNewFile();
		}
		//注意文件类型的格式不能进行读写，必须是txt或者dat格式的
		/**
		 * 通过RandomAccessFile获取读写的权限
		 */
		RandomAccessFile raf=new RandomAccessFile(f2,"rw");
		/**
		 * 写
		 */
		raf.seek(0);
		raf.write('A');
		raf.write('B');//写入文件中的都是字节的形式
		String s="中国";
	    //将基本类型转化为字节型,并且需要一个对应的编码格式（防止乱码）
		byte [] b=s.getBytes("gbk");
		System.out.println("指针位置在:"+raf.getFilePointer());
		raf.write(b);
		raf.write('3');
		System.out.println("文本大小："+raf.length()+"字节");
		/**
		 * 读
		 */
		raf.seek(0);//必须先说明指针位置
		byte [] b1=new byte[(int)raf.length()];
		raf.read(b1);
		//以数组（字节）的形式打印输出
		System.out.println(Arrays.toString(b1));
		f1.deleteOnExit();
	}
}
