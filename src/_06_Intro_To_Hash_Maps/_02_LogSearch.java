package _06_Intro_To_Hash_Maps;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
   	*/
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton add = new JButton();
	static JButton search = new JButton();
	static JButton view = new JButton();
	static JButton remove = new JButton();
	public static void main (String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.run();
	}
	public void run() {
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(600, 400));
		frame.add(panel);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		add.setText("Add Entry");
		search.setText("Search by ID");
		view.setText("View List");
		remove.setText("Remove Entry");
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		frame.pack();
	}
    /*
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button == add) {
			String x = JOptionPane.showInputDialog("Enter an ID#");
			int id = Integer.parseInt(x);
			String name = JOptionPane.showInputDialog("Enter a name");
			map.put(id, name);
		}
		else if (button == search) {
			String x = JOptionPane.showInputDialog("Enter an ID#");
			int id = Integer.parseInt(x);
			if (map.get(id) != null) {
				JOptionPane.showMessageDialog(null, map.get(id));
			}
			else {
				JOptionPane.showMessageDialog(null, "That entry does not exist.");

			}
		}
		else if (button == view) {
			String list = "";
			for (Integer i : map.keySet()) {
				list += "ID: " +  i + " Name: " + map.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		else {
			String x = JOptionPane.showInputDialog("Enter an ID#");
			int id = Integer.parseInt(x);
			if (map.remove(id) != null) {
				map.remove(id);
			}
			else {
				JOptionPane.showMessageDialog(null, "ID# is not in list.");
			}
		}
	}

}
