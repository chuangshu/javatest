//Welcome.java
import java.awt.*;
import java.awt.event.*;
class Welcome extends WindowAdapter implements ActionListener{
	Frame f;
	static Welcome.Thread3 wt1,wt2;
	public static void main(String arg[]){
		Welcome w=new Welcome();
		w.display();
		wt1=w.new Thread3("Welcome!");
		wt2=w.new Thread3("How are you?");
		wt2.start();
		wt2.setButton();	
	}


	public void display(){//用于设置可视化窗口的参数
		f=new Frame("Welcome");
		f.setSize(400,240);
		f.setLocation(200,140);
		f.setBackground(Color.lightGray);
		f.setLayout(new GridLayout(4,1));
		f.addWindowListener(this);
		f.setVisible(true);
	}
	class Thread3 extends Thread{
		Panel p1;//新建一个面板变量
		Label lb1;
		TextField tf1,tf2;//tf1是第一个滚动框字幕的框，tf2是用于设置秒速的文本框
		Button b1,b2;//start和pause按钮
		int sleeptime=(int)(Math.random()*100);//用于循环的时间
		public Thread3(String str){
			super(str);
			for(int i=0;i<100;i++)//加长字幕的长度
				str=str+" ";
			tf1=new TextField(str);//实例化滚动字幕框
			f.add(tf1);//添加到面板
			p1=new Panel();//添加面板
			p1.setLayout(new FlowLayout(FlowLayout.LEFT));//设置面板
			lb1=new Label("sleep");
			tf2=new TextField(""+sleeptime);//实例化循环时间的文本框
			p1.add(lb1);//添加提示语到面板
			p1.add(tf2);//添加循环时间文本框到面板
			b1=new Button("start");//实例化start按钮
			b2=new Button("pause");//实例化pause按钮
			p1.add(b1);//添加start按钮到面板
			p1.add(b2);//添加pause按钮到面板
			b1.addActionListener(new Welcome());//为start按钮添加监听事件
			b2.addActionListener(new Welcome());//为pause按钮添加监听事件
			f.add(p1);//添加面板到面板
			f.setVisible(true);//设置面板的可视性
		}
		public void run(){
			String str;//定义一个用于循环的字符串
			while(true)
			{	try{
					str=tf1.getText();//初始化字符串为滚动字幕文本框的内容
					str=str.substring(1)+str.substring(0,1);//每次都截取循环字符串的第一个字符并把它添加到字符串的最后，营造循环的错觉
					tf1.setText(str);//将截取完之后的字符串展示出来
					this.sleep(sleeptime);//循环时间
				}
				catch(InterruptedException e){	
					break;	
				}
			}
		}
		public void setButton(){	
			if(this.isAlive()) 
				b1.setEnabled(true);	//start按钮当在执行事件时不能设置		
			if(this.isInterrupted())
				b2.setEnabled(true);	//pause按钮在事件被停止时不能设置		
		}
	}
	public void windowClosing(WindowEvent e){
		System.exit(0);//定义窗口被关闭时退出程序
	}
	public void actionPerformed(ActionEvent e){	
		if((e.getSource()==wt1.b1)||(e.getSource()==wt1.b2))
			actionPerformed(e,wt1);//当面板1的start按钮被触发时启动下面的函数
		if((e.getSource()==wt2.b1)||(e.getSource()==wt2.b2))
			actionPerformed(e,wt2);//当面板2的start按钮被触发时启动下面的函数
	}
	public void actionPerformed(ActionEvent e,Thread3 wt){
		if(e.getSource()==wt.b1){	
			wt.sleeptime=Integer.parseInt(wt.tf2.getText());//初始化循环时间为整数
			wt.start();//执行run（）
			wt.b2.setEnabled(true);//pause按钮设置可以触发
		}
		if(e.getSource()==wt.b2)	
			wt.interrupt();//当pause按钮被触发停止时间
		wt.setButton();	//设置全部按钮的可操作性
	}
}

