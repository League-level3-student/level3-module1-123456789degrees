package _00_Intro_To_ArrayLists;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	ArrayList<String> names = new ArrayList<String>();
	public void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setSize(400,200);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		button1.addActionListener(this);
		button1.setText("Add Name");
		button2.setText("View Names");
		button2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == button1) {
			String x = JOptionPane.showInputDialog("Enter a name: ");
			names.add(x);
		}
		else {
			String ans = "";
			for (int i = 0; i < names.size(); i++) {
				int a = i+1;
				ans += "Guest #" + a + ": " + names.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, ans);
		}
	}
}
