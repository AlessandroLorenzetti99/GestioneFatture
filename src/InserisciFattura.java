import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InserisciFattura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciFattura frame = new InserisciFattura();
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
	public InserisciFattura() {
		Fattura f = new Fattura();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 32, 401, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		f.setNomeEnte(textField.toString());
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		lblNomeCliente.setBounds(23, 11, 91, 14);
		contentPane.add(lblNomeCliente);
		
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setBounds(23, 66, 74, 14);
		contentPane.add(lblDescrizione);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(23, 91, 401, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		f.setDescrizioneProdotto(textField_1.toString());
		
		JLabel lblSegnalaFatturaPagata = new JLabel("Segnala Fattura Pagata");
		lblSegnalaFatturaPagata.setBounds(23, 126, 165, 14);
		contentPane.add(lblSegnalaFatturaPagata);
		
		textField_2 = new JTextField();
		textField_2.setBounds(23, 151, 401, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		f.setDescrizioneProdotto(textField_2.toString());
		
		JLabel lblRegistraFatturaSbagliata = new JLabel("Registra fattura Sbagliata");
		lblRegistraFatturaSbagliata.setBounds(23, 177, 151, 14);
		contentPane.add(lblRegistraFatturaSbagliata);
		
		textField_3 = new JTextField();
		textField_3.setBounds(23, 202, 401, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblVisualizzaFattureIn = new JLabel("Visualizza fatture in ordine di data di emissione");
		lblVisualizzaFattureIn.setBounds(23, 233, 258, 14);
		contentPane.add(lblVisualizzaFattureIn);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(23, 255, 401, 20);
		contentPane.add(textField_4);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				((JButton)e.getSource()).setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				((JButton)e.getSource()).setBackground(Color.white);
			}
		});
		btnConferma.setBounds(234, 314, 91, 23);
		contentPane.add(btnConferma);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				((JButton)e.getSource()).setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				((JButton)e.getSource()).setBackground(Color.white);
			}
		});
		btnAnnulla.setBounds(335, 314, 89, 23);
		contentPane.add(btnAnnulla);
	}
}
