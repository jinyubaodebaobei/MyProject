package outstrame;

import java.io.FileInputStream;
import java.io.IOException;

public class lianxi {
	public static void print (String filename) throws IOException
	{
		FileInputStream f1=new FileInputStream(filename);
		int b;
		int i=1;
		while((b=f1.read())!=-1)
		{
			if(b<=0xf)
			{
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+"  ");
			if((i++)%10==0)
				//i++是在本次循环中仍然是原来的数字，一到下次循环就加1
			{
				System.out.println();
			}
		}
		f1.close();
	}
}

