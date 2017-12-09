package Accessible_IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Lianxi {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f1=new File("D:\\jinyubao\\bao","玉宝");
		/**
		 * 注意跨平台时（linux）就需要使用.Separator代替分隔符
		 */
		if(!f1.exists())
		{
			System.out.println("目录"+f1+"不存在");
			f1.mkdirs();
			System.out.println(f1.listFiles());
		}
//		File f2=new File("D:\\jinyubao\\bao","金");
//		f1.renameTo(f2);//如果盘符、目录不对就变成了剪切
		File f2=new File("D:\\jinyubao\\bao","金");
		f1.renameTo(new File("D:\\jinyubao\\bao","金"));
		//获取信息
		System.out.println(f2.getName());
		System.out.println(f2.getPath());
		System.out.println(f2.canExecute());
		System.out.println(f2.getAbsolutePath());
		System.out.println(f2.getParent());
		System.out.println(f2.length());
		System.out.println(f2+"是否为绝对路径："+" "+f2.isAbsolute());
		//获取盘符
		File[] f3=f2.listRoots();
		for(File f4:f3)
		{
			System.out.println(f4);
		}
		//获取File目录下所有文件
		File f5=new File("D:\\jinyubao");
		String [] s1=f5.list();
		for(String s2:s1)
		{
			System.out.println(s2);
		}
		//f2.delete()  程序正在运行或者打开文件的过程中任然不能关闭；程序在执行上面的语句出错时任然执行不了这句
		f2.deleteOnExit();//虚拟机停，终止时执行		
	}
}
