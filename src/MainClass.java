import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;




public class MainClass implements Serializable 
{
	
	public static void main(String[] args)
	{
		Start st1 = new Start('*', 50, "GESTIONE FATTURE 2018.");
		boolean errore = false; // segnalatore di errore
		int posizione = 0;
		ConsoleInput tastiera = new ConsoleInput();
		
		//InputStreamReader input = new InputStreamReader(System.in);
		//BufferedReader tastiera = BufferedReader(input);
		
		Scanner onlyString = new Scanner(System.in);
		ElencoFatture lista = new ElencoFatture();
		
		
		
		String[] elenco = {"1.   --->   Aggiungi fattura","2.   --->   Segnala Fattura Pagata","3.   --->  Registra fattura Sbagliata","4.   --->   Visualizza fatture in ordine di data di emissione","5.   --->   visualizza totale fatture non pagate ","6   --->   visualizza importo fatture non pagate dal cliente","7   --->   visualizzare dati di una fattura tramite ID","8   --->   Visualizza"};
		Menu m1 = new Menu(elenco);
		char continua = 'S'; // Se = 1 stop
		
		//***********************CARICAMENTO DATI DA STORAGE.BIN*************************
		try 
		{
			
			lista.caricaElencoFatture("storage.bin");
			System.out.println("Fatture caricate: " + lista.getElementi());
		} 
		catch (ClassNotFoundException e4)
		{
			System.out.println("!");
		}
		catch (IOException e4)
		{
			System.out.println("Il File storage.bin è danneggiato o inesistente");
		}
		//*********************************************************************************************
		
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
			
			} while (errore != false);
			
			
			try
			{
				lista.inserisciInCoda(f);
			}
			catch (ElencoFattureException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Errore Nel salvataggio dell'elmento nella lista!");
			}
			
			//*******************AVVIO FILE DI STOCCAGGIO DATI*****************************
				
			try
			{
				lista.salvaElencoFatture("storage.bin");
				
			} 
			catch (IOException e3)
			{
				// TODO Auto-generated catch block
				System.out.println("Errore");
			}
			
			
			//***********************************************************************************
		
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
			
			try 
			{
				
				f5 = lista.getFattura(posizione);
				
			
			}
			catch (ElencoFattureException e1) 
			{
				
				// TODO Auto-generated catch block
				System.out.println("Eccexione");
				
			}
			
			
			
			if(f5.getStatoFattura() == false)
			{
				f5.setStatoFattura(true);
			}
			else
			{
				System.out.println("Fattura già pagata");
			}
			
			
			System.out.println(lista.toString());
			
			
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
			
			
			
			try 
			{
				
				f6 = lista.getFattura(posizione);
				
			} 
			catch (ElencoFattureException e1)
			{
				
				System.out.println("Errore");
			}
			
			f6.setFatturaErrata(true);
			try {
				System.out.println(lista.visualizza(posizione));
			} catch (ElencoFattureException e1) {
				// TODO Auto-generated catch block
				System.out.println("errore");
			}
			
			break;
			
		case 4:
			//Visualizza tutte fatture in ordine di data di emissione
			
			//trasferimento dati lista ---> Array
			Fattura[] ArrayFatture;
			
			ArrayFatture = new Fattura[lista.getElementi()];
			
			for (int i = 1; i < lista.getElementi(); i++)
			{
				try {
					ArrayFatture[i] = lista.getFattura(i);
				} catch (ElencoFattureException e) {
					// TODO Auto-generated catch block
					System.out.println("Errore");
				}
			}
			
			//***************ORDINA DATI******************
			
			
			
			
			
			
			//***********************************************
			
			
			//*************VISUALIZZA DATI*****************
			
			
			
			
			
			//************************************************
			
			break;
			
		case 5:
			//visualizza importo fatture non pagate dal cliente
			Fattura f7 = new Fattura();
			String nomeCliente = null;
			
			
			int totaleFattureNonPagate  = 0;
			System.out.println("Inserisci il nome del cliente:");
			nomeCliente = onlyString.nextLine();
			
			for (int i = 1; i < lista.getElementi(); i++)
			{
				try 
				{
					f7 = lista.getFattura(i);
				} 
				catch (ElencoFattureException e1)
				{
					// TODO Auto-generated catch block
					System.out.println("Errore generico");
				}
				if (f7.getStatoFattura() != true &&  f7.getNomeEnte().compareToIgnoreCase(nomeCliente)==0)
				{
					totaleFattureNonPagate +=  f7.getImporto();
				}
				else
				{
					System.out.println("Non funge");
				}
			}
			
			System.out.println("It totale della fatture non pagate è:" + totaleFattureNonPagate);
				
			break;
			
		case 6:
			//visualizza importo fatture non pagate dal cliente
			Fattura f8 = new Fattura();
			String nomeCliente1 = null;
			
			
			int totaleFatturePagate  = 0;
			System.out.println("Inserisci il nome del cliente:");
			nomeCliente = onlyString.nextLine();
			
			for (int i = 1; i < lista.getElementi(); i++)
			{
				try 
				{
					f7 = lista.getFattura(i);
				} 
				catch (ElencoFattureException e1)
				{
					// TODO Auto-generated catch block
					System.out.println("Errore generico");
				}
				if (f8.getStatoFattura() == true &&  f8.getNomeEnte().compareToIgnoreCase(nomeCliente)==0)
				{
					totaleFatturePagate +=  f8.getImporto();
				}
				else
				{
					System.out.println("Non funge");
				}
			}
			
			System.out.println("It totale della fatture  pagate è:" + totaleFatturePagate);
				
			
			
			break;
			
		case 7:
			
			//visualizzare dati di una fattura tramite ID
			int anno = 0;
			int numeroIdentificativo = 0;  //i = numero progressivo fattura
			Fattura f10 = new Fattura();
			
			System.out.println("Inserisci anno del ID dell'utente:");
			try
			{
				anno = tastiera.readInt();
			}
			catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				System.out.println("Il numer inserito non è valido");
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				System.out.println("il valore inserito non è un numero");
			}
			
			System.out.println("Inserisci numero progressivo fattura");
			try {
				numeroIdentificativo = tastiera.readInt();
			} catch (NumberFormatException e1) 
			{
				// TODO Auto-generated catch block
				System.out.println("Il numer inserito non è valido");
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				System.out.println("il valore inserito non è un numero");
			}
			
			for (int i = 0; i < lista.getElementi(); i++)
			{
				try {
					f10 = lista.getFattura(i);
				} catch (ElencoFattureException e) {
					// TODO Auto-generated catch block
					System.out.println("Errore generico");
				}
				
				if(f10.getAnno() == anno && f10.getI() == numeroIdentificativo)
				{
					f10.toString();
				}
				
			}
			
			
			
			break;
		case 8:
			for (int i = 1; i < lista.getElementi(); i++)
			{
				try 
				{
					
					System.out.println("Elemento" + lista.getFattura(i).toString());
					System.out.println("-------------------------------------------");
					
				} 
				
				catch (ElencoFattureException e)
				
				{
					// TODO Auto-generated catch block
					System.out.println("Fattura vuota.");
				}
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
	}

}
