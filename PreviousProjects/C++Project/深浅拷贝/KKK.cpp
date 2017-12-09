#include <iostream>
using namespace std;
class Coordinate
{
    
public:
	Coordinate(int x, int y)
	{
		// 设置X,Y的坐标
		m_iX=x;
        m_iY=y;
         
	}
public:
	int m_iX;
	int m_iY;
};

int main(void)
{
    // 在堆上创建对象指针
	Coordinate *p=new Coordinate(3,3);//此为含参构造函数，必须赋值给参数 
    // 打印坐标
	cout <<(*p).m_iX<< (*p).m_iY<<endl;
	cout<<"________"<<endl;
    // 销毁对象指针
	delete p;
    p=NULL;
	return 0;
}
