public class Daying
{
	public static void main(String[] args)
	{
		for(int i=1;i<7;i++)			
		{	
		    for(int j=1;j<7-i;j++)
			{
				System.out.print("");
			}
			
			for(int k=i;k>=1;--k)
			{
				System.out.print(k+" ");
			}
			System.out.print();
		}
	}
}
            