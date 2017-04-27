import java.io.IOException;
import java.util.Scanner;搜索
public class T {
public static void main(String[] args) throws Exception {
Scanner s = new Scanner(System.in);
String str1 = s.nextLine();
System.out.println("你输入的是："+str1+",请输入'E'确认");
String str2 = s.next();
if("E".equals(str2))
System.out.println("确认成功！");
else System.out.println("确认失败！");
}
}