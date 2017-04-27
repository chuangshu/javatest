import javax.swing.JOptionPane;

class Artist
{
	public void aritst(String[] args)
	{
		//储存作者名的数组
		String aritst[] = new String[];
		//储存每一次输入的作者名
		String aritstInput;
		//用于判断是否继续输入的变量
		int count = JOptionPane.YES_OPTION;
		//输入的作者名是数组第几号元素
		int position = 0;

		//每输入一次作者名就存入数组，并询问是否再输入一次
		for(;count == JOptionPane.YES_OPTION;position++){
			aritstInput= JOptionPane.showInputDialog("please enter your favourit aritst");
			aritst[position] = aritstInput;
			int res=JOptionPane.showConfirmDialog(null, "continued to enter aritsts?", "continued", JOptionPane.YES_NO_OPTION);
		}
		
		//保存调用lineSearch的返回值
		int rest = lineSearch(aritst) + 1;

		//根据LineSearch返回值显示结果
		if(rest == -1){
			JOptionPane.showMessageDialog(null, "aritst not find", "404", JOptionPane.ERROR_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null,"your favourit aritst located in"+rest+"of the array","result", JOptionPane.PLAIN_MESSAGE);
		}
  	}

	public int lineSearch (String[] arr)
	{
		String aritst[] = arr;
		String find = JOptionPane.showInputDialog("please enter your favourit aritst to be fund");
		//调用外部函数，根据字符串查找数组，并且返回位置
		int rest = Arrays.binarySearch(aritst, find);
		return rest;		
  	}

   
   public static void main(String[] args)
   {
		aritst();
  	    System.exit(0);

  } 
} 

