import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserInput extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInput frame = new UserInput();
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
	public UserInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblInserisci = new JLabel("Inserisci:");
		contentPane.add(lblInserisci, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		
		JButton btnInvia = new JButton("Invia");
		btnInvia.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				((JButton)e.getSource()).setBackground(Color.white);
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				((JButton)e.getSource()).setBackground(Color.orange);
			}
		});
		btnInvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				GraphicOutput g = new GraphicOutput();
				g.setVisible(true);
				g.setValore(textArea.getText());
//				String i;
//				
//				System.out.println("Inviato con successo.");
//				
//				i = textArea.getText();
//				System.out.println(i);
			}
		});
		contentPane.add(btnInvia, BorderLayout.SOUTH);
	}
	
	

}
