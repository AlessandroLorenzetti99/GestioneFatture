import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class GraphicMenu {
    
    Container contenuto = null;
    
	public GraphicMenu() 
	{
		JFrame finestra = new JFrame("GestioneFatture2018 Vx.x - Menu Principale.");
		finestra.getContentPane().setBackground(Color.DARK_GRAY);
		finestra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				//b1.setBackgroundColor(Color.ORANGE);
				
			}
		});
		finestra.setBounds(500, 500, 380, 227);
		contenuto = finestra.getContentPane();
		contenuto.setLayout(new BoxLayout(contenuto, BoxLayout.Y_AXIS));
	
		//bottone 
		JButton b1 = new JButton("Aggiungi fattura");
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				((JButton)e.getSource()).setBackground(Color.orange);
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				((JButton)e.getSource()).setBackground(Color.white);
			}
		});
        contenuto.add(b1);
        b1.addActionListener(new clicBottone() );
        
        JTextField cognome = new JTextField();
        //cognome.addKeyListener(new intercettaTasti());
        
        cognome.addKeyListener(new KeyAdapter() 
        {
           public void keyReleased(KeyEvent e) 
           {
             JTextField casellaTesto = (JTextField) e.getSource();
             String testo = casellaTesto.getText();
             casellaTesto.setText(testo.toUpperCase());
           }
        });        
        
        JButton btnSegnalaFatturaPagata = new JButton("Segnala Fattura Pagata");
        btnSegnalaFatturaPagata.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.orange);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) 
        	{
        		((JButton)e.getSource()).setBackground(Color.white);
        	}
        });
        finestra.getContentPane().add(btnSegnalaFatturaPagata);
        
        JButton btnNewButton = new JButton("Registra fattura Sbagliata");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) 
        	{
        		((JButton)e.getSource()).setBackground(Color.orange);
        	}
        	@Override
        	public void mouseExited(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.white);
        	}
        });
        finestra.getContentPane().add(btnNewButton);
        
        JButton btnVisualizzaFattureIn = new JButton("Visualizza fatture in ordine di data di emissione");
        btnVisualizzaFattureIn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.orange);
        	}
        	@Override
        	public void mouseExited(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.white);
        	}
        });
        finestra.getContentPane().add(btnVisualizzaFattureIn);
        
        JButton btnVisualizzaTotaleFatture = new JButton("visualizza totale fatture non pagate dal cliente");
        btnVisualizzaTotaleFatture.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.orange);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) 
        	{
        		((JButton)e.getSource()).setBackground(Color.white);
        	}
        });
        finestra.getContentPane().add(btnVisualizzaTotaleFatture);
        
        JButton btnVisualizzaImportoFatture = new JButton("visualizza importo fatture pagate dal cliente");
        btnVisualizzaImportoFatture.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.orange);
        	}
        	@Override
        	public void mouseExited(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.white);
        	}
        });
        finestra.getContentPane().add(btnVisualizzaImportoFatture);
        
        JButton btnNewButton_1 = new JButton(" visualizzare dati di una fattura tramite ID");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) 
        	{
        		((JButton)e.getSource()).setBackground(Color.orange);
        	}
        	@Override
        	public void mouseExited(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.white);
        	}
        });
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        finestra.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Visualizza tutte le fatture inserite.");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e)
        	{
        		((JButton)e.getSource()).setBackground(Color.orange);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) 
        	{
        		((JButton)e.getSource()).setBackground(Color.white);
        	}
        });
        finestra.getContentPane().add(btnNewButton_2);
        
        
        
        contenuto.add(cognome);
        
        
   
        finestra.setVisible(true);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	private class clicBottone implements ActionListener
	{
	   public void actionPerformed(ActionEvent evento)
	   {  contenuto.setBackground(Color.cyan);}

	}
	
	private class intercettaTasti implements KeyListener
	{



		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			JTextField casellaTesto = (JTextField) e.getSource();
		    String testo = casellaTesto.getText();
		    casellaTesto.setText(testo.toUpperCase());			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


			
		

	}
}


