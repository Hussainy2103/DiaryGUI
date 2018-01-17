

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class MainWindow extends JFrame {

	JTextArea textArea;
	JButton button1, button2;

	JPanel mainPanel, panel1, panel2;

	Time time = new Time();
	SaveToFile save = new SaveToFile();

	//the idea here is to put textArea inside panel1 and buttons inside panel2
	//put everything inside mainPanel

	public MainWindow() {
		super("App");
		this.setSize(500,270);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		mainPanel = new JPanel(new BorderLayout());
		panel1= new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));

		textArea = new JTextArea(10,40);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		JScrollPane pane = new JScrollPane(textArea);

		button1 = new JButton("Save");
		button2 = new JButton("Open with notepad");

		DealWithButtons db = new DealWithButtons();
		button1.addActionListener(db);
		button2.addActionListener(db);

		panel1.add(pane);

		panel2.add(button1);
		panel2.add(button2);


		mainPanel.add(panel1, BorderLayout.CENTER);

		mainPanel.add(panel2, BorderLayout.SOUTH);

		this.add(mainPanel);

		this.setVisible(true);
		textArea.requestFocus();
	}

	private class DealWithButtons implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String path = "C:\\Users\\Mustafa\\Desktop\\test\\diary.txt";

			if(e.getSource() == button1) {
				PrintWriter pr = save.createFile(path);

				int option = JOptionPane.showConfirmDialog(null, "Do you want to save");
				if(option == 0) {

				save.printToFile(textArea.getText().trim(), pr);
				save.printToFile(time.getDate(), pr);
				save.printToFile(time.getTime(), pr);
				save.addSpace();
				pr.close();

				textArea.setText("");
			}

		}

			if(e.getSource() == button2) {
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				if(file.exists() && file.length()>0) {
						try {
							desktop.edit(file);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}

	}

}
