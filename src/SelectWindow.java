import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectWindow implements ActionListener
{
	Container contenitore =  new Container();
	public SelectWindow()
	{
		JFrame window = new JFrame("GestioneFatture2018 Vx.x");
		
		window.setBounds(500, 500, 600, 300);
		
		window.getContentPane();
		
		contenitore.setLayout(new BoxLayout(contenitore, BoxLayout.X_AXIS));
		
		JPanel sx = new JPanel();
		JPanel sep = new JPanel();
		JPanel dx = new JPanel();
		
		sx.setLayout(new BoxLayout(sx, BoxLayout.Y_AXIS));
		sep.setLayout(new BoxLayout(sep, BoxLayout.Y_AXIS));
		dx.setLayout(new BoxLayout(dx, BoxLayout.Y_AXIS));
		
		contenitore.add(sx);
		contenitore.add(sep);
		contenitore.add(dx);
		
		contenitore.setBackground(Color.GREEN);
		
		sep.add(new JButton("1"));
		sep.add(new JButton("2"));
		sep.add(new JButton("3"));
		sep.add(new JButton("4"));
		sep.add(new JButton("5"));
		sep.add(new JButton("6"));
		sep.add(new JButton("7"));
		sep.add(new JButton("8"));
		sep.add(new JButton("9"));
		
		//window.setLayout(manager);
		
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class clicBottone implements ActionListener
	{
	   public void actionPerformed(ActionEvent evento)
	   {  contenitore.setBackground(Color.cyan);}

	}
	
	

	
	public void view()
	{
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
