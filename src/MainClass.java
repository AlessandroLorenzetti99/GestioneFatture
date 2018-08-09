import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

/**
 * La classe MainClass e la classe principale del programma
 * 
 * @author Alessandro Lorenzetti
 * @version 1.0
 *
 */


public class MainClass implements Serializable 
{
	public static void LoadProgram()
	{
		
	}
	/**
	 * La Funzione main Permette l'esecuzione del programma,
	 * @param args
	 */
	
	public static void main(String[] args)
	{
	
		LoadProgram();
		
		
		int contatore_i = 0;
		
		/**
		 * La classe main è formata da un elemento LinkedList Database che rappresenta la lista 
		 * dove verranno salvate tutte le fatture create dal programma.
		 * 
		 */
		LinkedList Database = new LinkedList();
		Start st1 = new Start('*', 50, "GESTIONE FATTURE 2018."); /** Viene Invocata la clase Start che permette lA VISUALIZZAZIONE dell' titolo con interfaccia grafica prestabilita */
		boolean errore = false; // segnalatore di errore
		int posizione = 0;
		ConsoleInput tastiera = new ConsoleInput();
		
		
		
		Scanner onlyString = new Scanner(System.in);
		
		//inizializza
		FileInputStream contatore_R = null;
		try 
		{
			contatore_R = new FileInputStream("contatore.bin");
		} 
		catch (FileNotFoundException e5) 
		{
			System.err.println("FNF");
			FileOutputStream defau = null;
			try {
				defau = new FileOutputStream("contatore.bin");
			} catch (FileNotFoundException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			try {
				defau.write(0);
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			try {
				defau.close();
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			
		}
		try
		{
			contatore_i = contatore_R.read();
		} 
		catch (IOException e5) 
		{
			System.err.println("IOE");
		}
		try
		{
			contatore_R.close();
		}
		catch (IOException e5)
		{
			System.err.println("IOE");
		}
		
		System.out.println("Contatore Letto = " + contatore_i);
		
		
		if (contatore_i != 0)
		{
			// carica lista
			
			FileInputStream carica = null;
			try {
				carica = new FileInputStream("storage.bin");
			} 
			catch (FileNotFoundException e5) 
			{
				System.err.println("FNF");
			}
			ObjectInputStream load = null;
			try {
				load = new ObjectInputStream(carica);
			} catch (IOException e5) {
				System.err.println("Nessun file letto");
			}
			
			try {
				Database = (LinkedList) load.readObject();
			} catch (ClassNotFoundException e5) {
				System.err.println(errore);
			} catch (IOException e5) {
				System.err.println("Errore");
			}
			
			try {
				load.close();
			} catch (IOException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
			
			try {
				carica.close();
			} catch (IOException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
			
			System.out.println("Lista caricata");
		}
		
		
		
		
		String[] elenco = {"1.   --->   Aggiungi fattura","2.   --->   Segnala Fattura Pagata","3.   --->  Registra fattura Sbagliata","4.   --->   Visualizza fatture in ordine di data di emissione","5.   --->   visualizza totale fatture non pagate dal cliente ","6   --->   visualizza importo fatture pagate dal cliente","7   --->   visualizzare dati di una fattura tramite ID","8   --->   Visualizza tutte le fatture inserite."};
		Menu m1 = new Menu(elenco);
		char continua = 'S'; // Se = 1 stop
		
		
		st1.visualizza();
		
		while(continua == 's' || continua == 'S')
		{
			
		
		switch (m1.scelta())
		{
		case 1:
			Fattura f = new Fattura();
			LocalDate data1= LocalDate.now();
			//Aggiungi \ crea fattura
			
			do
			{
				System.out.println("Fattura numero:" + f.getI());
			System.out.println("inserisci anno della fattura:");
			try 
			{
				f.setAnno(tastiera.readInt());
				errore = false;
			} 
			catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Il valore inserito non è un numero:");
				errore = true;
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			}
			
			} while (errore != false);
			
			
			
			System.out.println("Inserisci il nome ente della fattura");
			f.setNomeEnte(onlyString.nextLine());
			
			
			System.out.println("inserisci la descrizione del prodotto:");
			f.setDescrizioneProdotto(onlyString.nextLine());
			
			do 
			{
				
			
			System.out.println("inserisci importo:");
			try 
			{
				f.setImporto(tastiera.readInt());
				errore = false;
			} 
			catch (NumberFormatException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
				errore = true;
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Il valore inserito non è un numero.");
				errore = true;
			}
			
			f.setData(data1);
			
			Database.add(contatore_i,f);
			
			contatore_i ++;
			
			System.out.println(Database);
			
			} while (errore != false);
		
			break;
			
			
		case 2:
			//Segnala Fattura come pagata
			Fattura f5 = new Fattura();
			
			System.out.println("Inserire il numero della fattura da segnalare come pagata:");
			try 
			{
				posizione = tastiera.readInt();
			} 
			catch (NumberFormatException e1) 
			{
				System.out.println("eccezione numerica...");
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				System.out.println("Input inserito non corretto");
			}
			
			f5 = (Fattura)Database.get(posizione);
			Database.remove(posizione);
			
			
			
			
			
			
			if(f5.getStatoFattura() == false)
			{
				f5.setStatoFattura(true);
			}
			else
			{
				System.out.println("Fattura già pagata");
			}
			
			
			//System.out.println(lista.toString());
			
			Database.add(f5);
			
			System.out.println(f5.toString());
			
			
			break;
			
		case 3:
			// segnala fattura errata
			posizione = 0;
			Fattura f6=new Fattura();
			System.out.println("Inserisci numero fattura da segnalare come errata");
			try 
			{
				
				posizione = tastiera.readInt();
				
			} 
			catch (NumberFormatException e2)
			{
				
				System.out.println("Numero non accettato");
			} 
			catch (IOException e2)
			{
				

				System.out.println("Numero non valido");
				
			}
			
			f6 = (Fattura)Database.get(posizione);
			Database.remove(posizione);
			
			f6.setFatturaErrata(true);
			
			Database.add(posizione,f6);
			
			break;
			
		case 4:
			//Visualizza tutte fatture in ordine di data di emissione
			
			Fattura arra [];
			
			arra = new Fattura[Database.size()];
			
			for (int i = 0; i < arra.length; i++)
			{
				arra[i] = (Fattura) Database.get(i);
				
			}
			
			for (int i = 0; i < arra.length-1; i++)
			{
				if (arra[i].getData().isAfter(arra[i+1].getData()) || arra[i].getData().equals(arra[i+1].getData()))
				{
					
					System.out.println(arra[i].toString() + "\n" + "---------" + "\n" + arra[i+1].toString());
					System.out.println("-------------------------------------------------------------------");
					
				}
				
			}
			
			
			break;
			
		case 5:
			//visualizza importo fatture non pagate dal cliente
			
			Fattura f7 = new Fattura();
			int totaleFattureNonPagate = 0;
			String nomeCliente = null;
			
			System.out.println("Inserisci il nome del cliente:");
			nomeCliente = onlyString.nextLine();
			
			for (int i = 0; i < Database.size(); i++)
			{
				f7 = (Fattura) Database.get(i);
				
				if (f7.getNomeEnte().equalsIgnoreCase(nomeCliente) == true && f7.getStatoFattura() == false)
				{
					totaleFattureNonPagate = totaleFattureNonPagate + f7.getImporto();
				}
				
			}
			
			System.out.println("Le fatture non pagate dal cliente " + nomeCliente + " ammontano ad " + totaleFattureNonPagate + "€");
			
			


				
			break;
			
		case 6:
			//visualizza importo fatture pagate dal cliente
			
			Fattura f8 = new Fattura();
			int totaleFatturePagate = 0;
			String nomeCliente1 = null;
			
			System.out.println("Inserisci il nome del cliente:");
			nomeCliente1 = onlyString.nextLine();
			
			for (int i = 0; i < Database.size(); i++)
			{
				f7 = (Fattura) Database.get(i);
				
				if (f8.getNomeEnte().equalsIgnoreCase(nomeCliente1) == true && f8.getStatoFattura() == true)
				{
					totaleFatturePagate = totaleFatturePagate + f8.getImporto();
				}
				
			}
			
			System.out.println("Le fatture pagate dal cliente " + nomeCliente1 + " ammontano ad " + totaleFatturePagate + "€");
			


			
			
			
			break;
			
		case 7:
			
			//visualizzare dati di una fattura tramite ID
			
			Fattura f10 = new Fattura();
			int ID = 0;
			
			System.out.println("Inserisci l'ID della Fattura da Mostrare:");
			try
			{
				ID = tastiera.readInt();
			} 
			catch (NumberFormatException e2)
			{
				System.err.println("NFE");
			} 
			catch (IOException e2)
			{
				System.err.println("IOE");
			}
			
			f10 = (Fattura) Database.get(ID);
			
			System.out.println("La fattura selezionata è:" + "\n" + f10.toString());
			

			
			break;
		case 8:
			
			//visualizza tutte le fatture
			
			//System.out.println("ok");
			
			Fattura f11 = new Fattura();
			
			for (int i = 0; i < Database.size(); i++)
			{
				f11 = (Fattura) Database.get(i);
				System.out.println(f11.toString());
				
			}
			


			
			break;

		default:
			System.out.println("opzione non disponibile!");
			break;
		}
		
		System.out.println("Continuare? S/N");
		try
		{
			continua = tastiera.readChar();
		} 
		
		catch (NumberFormatException e)
		
		{
			
			System.out.println("Errore generico");
		}
		
		catch (IOException e)
		
		{
			
			System.out.println("Errore generico");
		}
		
		

	}
		
		//chiusura ----------
		
		FileOutputStream contatore = null;
		try 
		{
			contatore = new FileOutputStream("contatore.bin");
		} 
		catch (FileNotFoundException e1)
		{
			
			System.err.println("fnf");
		}
		
		try 
		{
			contatore.write(contatore_i);
		} 
		catch (IOException e1)
		{
			System.err.println("ioe");
		}
		
		//System.out.println(contatore.toString());
		
		try
		{
			contatore.close();
		}
		catch (IOException e)
		{
			System.err.println("IOE");
		}
		
		//salvataggio file
		
		FileOutputStream salva = null;
		try {
			salva = new FileOutputStream("storage.bin");
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		ObjectOutputStream buff = null;
		try {
			buff = new ObjectOutputStream(salva);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		try {
			buff.writeObject(Database);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		try {
			buff.close();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		try {
			salva.close();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	
		
		
		
	}

}
