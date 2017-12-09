package randomaccess;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * 
 * @author 锋客
 *  内容： 
 *  1.RandomAccessFile不会创建文件，需要和File配合使用 
 *  2.可以实现文件的复制
 *  3.乱码问题的解决：
 */
public class A {

 public static void main(String[] args) throws IOException {
  // TODO Auto-generated method stub
  File demo = new File("demo1");
  if (!demo.exists())
   demo.mkdir();
  File file1 = new File(demo, "raf.dat");
  if (!file1.exists())
   file1.createNewFile();

  // 打开文件，进行随机读写
  RandomAccessFile rf = new RandomAccessFile(file1, "rw");
  for (int i = 0; i < 10; i++) {
   // 写入基本类型double数据
   rf.writeDouble(i * 1.414);
  }
  rf.close();

  rf = new RandomAccessFile("rtest.dat", "rw");
  // 直接将文件指针移到第5个double数据后面
  rf.seek(5 * 8);
  // 覆盖第6个double数据 ======》i<6
  rf.writeDouble(47.0001);
  rf.close();

  rf = new RandomAccessFile("rtest.dat", "r");
  // 读取数据
  for (int i = 0; i < 6; i++) {
   System.out.println("Value " + i + ": " + rf.readDouble());
  }

  RandomAccessFile file = new RandomAccessFile("file", "rw");
  // 以下向file文件中写数据
  file.writeInt(20);// 占4个字节
  file.writeDouble(8.236598);// 占8个字节
  file.writeUTF("这是一个UTF字符串");// 这个长度写在当前文件指针的前两个字节处，可用readShort()读取
  file.writeBoolean(true);// 占1个字节
  file.writeShort(395);// 占2个字节
  file.writeLong(2325451l);// 占8个字节
  file.writeUTF("又是一个UTF字符串");
  file.writeFloat(35.5f);// 占4个字节
  file.writeChar('a');// 占2个字节

  file.seek(0);// 把文件指针位置设置到文件起始处

  // 以下从file文件中读数据，要注意文件指针的位置
  System.out.println("——————从file文件指定位置读数据——————");
  System.out.println(file.readInt());
  System.out.println(file.readDouble());
  System.out.println(file.readUTF());

  file.skipBytes(3);// 将文件指针跳过3个字节，本例中即跳过了一个boolean值和short值。
  System.out.println(file.readLong());

  file.skipBytes(file.readShort()); // 跳过文件中“又是一个UTF字符串”所占字节，注意readShort()方法会移动文件指针，所以不用加2。
  System.out.println(file.readFloat());

  // 以下演示文件复制操作
  System.out.println("——————文件复制（从file到fileCopy）——————");
  // 先得有接收文件，才能查看到实际结果
  File file_copy = new File("e:\\fileCopy.txt");
  file_copy.createNewFile();
  file.seek(0);
  RandomAccessFile fileCopy = new RandomAccessFile("e:\\fileCopy.txt", "rw");
  int len = (int) file.length();// 取得文件长度（字节数）
  byte[] b = new byte[len];
  file.readFully(b);
  fileCopy.write(b);
  System.out.println("文件路径:" + file_copy.getAbsolutePath());
  System.out.println("复制完成！");
  
  fileCopy.seek(0);// 这句话很重要，是查询的基础
  
  // 查看复制是否完成，必須有fileCopy.seek(0);
   System.out.println(fileCopy.readInt());
   System.out.println(fileCopy.readDouble());
   System.out.println(fileCopy.readUTF());
  fileCopy.close();
  file.close();

 }

}


