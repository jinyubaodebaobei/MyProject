package com.demo;
/*
 * ת��Dao��ӿ�(���ݷ��ʲ�ӿ�)
 * @autuor  jin
 * @data    2016-3-10
 */
public interface AccountDao {
	/*
	 * @param   out:ת���˺�
	 * @param   money:ת�����
	 */
	public   void    outMoney(String  out,double  money);
	
	/*
	 * @param   in:ת���˺�
	 * @param   money:ת�����
	 */
	public   void    inMoney(String  in,double  money);
}