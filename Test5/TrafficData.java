import javax.swing.JOptionPane;

class TrafficData
{
	public static int[] trafficdata ()
	{
		int intArray[] = new int[7];
		
		String firstNumber;

		firstNumber = JOptionPane.showInputDialog("please enter monday trafficload");
		intArray[0] = Integer.parseInt(firstNumber);
		firstNumber = JOptionPane.showInputDialog("please enter Tuesday trafficload");
		intArray[1] = Integer.parseInt(firstNumber);
 		firstNumber = JOptionPane.showInputDialog("please enter Wednesday trafficload");
		intArray[2] = Integer.parseInt(firstNumber);
		firstNumber = JOptionPane.showInputDialog("please enter Thursday trafficload");
		intArray[3] = Integer.parseInt(firstNumber);
		firstNumber = JOptionPane.showInputDialog("please enter Friday trafficload");
		intArray[4] = Integer.parseInt(firstNumber);
		firstNumber = JOptionPane.showInputDialog("please enter Saturday trafficload");
		intArray[5] = Integer.parseInt(firstNumber);
		firstNumber = JOptionPane.showInputDialog("please enter Sunday trafficload");
		intArray[6] = Integer.parseInt(firstNumber);
		
		return intArray;
  	}

	public static int getMax (int[] arr)
	{
		int max = arr[0];
		int num ;
		int x;
		for(x =1;x<arr.length;x++){
			if(arr[x]>max){

				max = arr[x];
			}
		}
		int res [] = {max};
		
		return max;		
  	}

   
   public static void main(String[] args)
   {
		String day = " ";

		int arr[] = trafficdata();
		
		int res  = getMax(arr);

		if( res == arr[0]){
			day = "Monday";
		}else if(res == arr[1]){
			day = "Tuesday";
		}else if(res == arr[2]){
			day = "Wednesday";
		}else if(res == arr[3]){
			day = "Thursday";
		}else if(res == arr[4]){
			day = "Friday";
		}else if(res == arr[5]){
			day = "Saturday";
		}else if(res == arr[6]){
			day = "Sunday";
		}
		
		JOptionPane.showMessageDialog(null,
											"Monday trafficload is "+arr[0]+"\n"+
											"Tuesday trafficload is "+arr[1]+"\n"+
											"Wednesday trafficload is "+arr[2]+"\n"+
											"Thursday trafficload is "+arr[3]+"\n"+
											"Friday trafficload is "+arr[4]+"\n"+
											"Saturday trafficload is "+arr[5]+"\n"+
											"Sunday trafficload is "+arr[6]+"\n"+
											day+"'s trafficload is biggest ,the number is "+res,"biggest trafficloads", JOptionPane.PLAIN_MESSAGE);
	  	//day+"'s trafficload is biggest ,the number is "+max
   
  	    System.exit(0);

  } 
} 

