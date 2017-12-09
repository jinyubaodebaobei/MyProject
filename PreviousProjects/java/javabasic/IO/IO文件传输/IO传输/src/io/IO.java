package io;

public class IO {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="金玉宝AB";//一个中文汉字两个字节
		//将String基本数据类型转化为字节型
		byte []b=a.getBytes();
		//将字节型转化为16进制int的基本数据类型
		for(byte c:b)
		{
			System.out.println(Integer.toHexString(c)+" ");
		}
		/**
		 * 如果（c×0ff）就是去掉前面的o,默认为GBK编码，中文占用两个字节，英文占用一个字节
		 */
		//指定编码格式gbk编码：中文占用两个字节，英文占用一个字节
		/**
		 * byte a=b.getBytes("gbk");
		 * for(byte c:b)
		{
			System.out.println(Integer.toHexString(c)+" ");
		}
		 */
	     
		//2.
		/**指定编码格式utf-8编码：中文占用三个字节，英文占用一个字节
		  byte a=b.getBytes("utf-8");
		 * for(byte c:b)
		{
			System.out.println(Integer.toHexString(c)+" ");
		}
		 */
		
		/**指定编码格式utf-16be编码：中文占用两个字节，英文占用两个字节
		 * byte a=b.getBytes("utf-16be");
		 * for(byte c:b)
		{
			System.out.println(Integer.toHexString(c)+" ");
		}
		 */
		//当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要这种编码方式，否则会出现乱码
		/**
		 * String [] t=new String(a) ;   因为a采用的字节编码是utf-16，而系统默认的是gbk
		 * 应该为：String [] t=new String(a，"utf-16") ;
		 * 
		 */	
	}
}
