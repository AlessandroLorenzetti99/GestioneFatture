import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class GraphicOutput extends JFrame {

	private JPanel contentPane;
	private String Testo = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicOutput frame = new GraphicOutput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraphicOutput() {
		setTitle("GestoneFatture2018 - Output");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTextArea txtrOutput = new JTextArea();
		//txtrOutput.setText("Output:");
		//Testo = txtrOutput.toString();
		txtrOutput.setText(Testo);
		contentPane.add(txtrOutput, "name_411199973800524");
	}
	
	public void setValore(String text)
	{
		//this.setText(text);
		this.Testo = text;
		
	}

}
