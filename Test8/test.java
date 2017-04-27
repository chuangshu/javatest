import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestWindow extends JFrame{
	private JLabel aLabel;
	private JTextField aField,displayField;
	private JButton computeButton,exitButton;
	public TestWindow(){
		super("内部类的使用：计算一个数的平方");
		Container container = getContentPane();
		container.setLayout(new Flowlayout());
		aLabel = new JLabel("输入一个整数:");
		aField = new JTextField(10);
		container.add(aLabel);
		container.add(aField);
		displayField = new JTextField(30);
		displayField.setEditable(false);
		container.add(displayField);
		computeButton = new JButton("计算平方");
		container.add(computeButton);
		exitButton = new JButton("退出");
		container.add(exitButton);
		ActionEventHandler handler = new ActionEventHandler();
		computeButton.addActionListener(handler);
		exitButton.addActionListener(handler);
		setSize(400,140);
		setVisible(true);
	}
	public static void main(String args[]){
		TestWindow window = new TestWindow();
	}

	private class ActionEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == exitButton)
				System.exit(0);
			else if(event.getSource() == exitButton){
				Stringa = aField.getText();
				int ai = Integer.parseInt(a);
				ai = ai*ai;
				String b = String.valueOf(ai);
				displayField.setText(a+"的平方是："+b);
			}
		}
	}
}