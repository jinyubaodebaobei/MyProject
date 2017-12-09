#include <iostream>
#include <stdlib.h>
#include <string.h>
#include<typeinfo>
using namespace std;

/**
 * 定义移动类：Movable
 * 纯虚函数：move
 */
class Movable
{
public:
    virtual void move()=0;
};

/**
 * 定义公交车类：Bus
 * 公有继承移动类
 * 特有方法carry
 */
class Bus : public Movable
{
public:
    virtual void move()
    {
        cout << "Bus -- move" << endl;
    }
    
    void  carry()
    {
        cout << "Bus -- carry" << endl;
    }
};

/**
 * 定义坦克类：Tank
 * 公有继承移动类
 * 特有方法fire
 */
class Tank :public Movable
{
public:
    virtual  void move()
    {
        cout << "Tank -- move" << endl;
    }

    void  fire()
    {
        cout << "Tank -- fire" << endl;
    }
};

/**
 * 定义函数doSomething含参数
 * 使用dynamic_cast转换类型
 */
void doSomething(Movable *obj)
{
    obj->move();

    if(typeid(*obj)==typeid(Bus))
    {
        Bus *bus=dynamic_cast<Bus *>(obj);
        bus->carry();
    }

    if(typeid(*obj)==typeid(Tank))
    {
        Tank *tank=dynamic_cast<Tank *>(obj);
        tank->fire();
    }
}
int main(void)
{
    Bus b;
    Tank t;
    doSomething(&b);
    doSomething(&t);
    return 0;
}
