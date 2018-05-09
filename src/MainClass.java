import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) 
	{
		int posizione = 0;
		ConsoleInput tastiera = new ConsoleInput();
		Scanner onlyString = new Scanner(System.in);
		ElencoFatture lista = new ElencoFatture();
		LocalDate data1= LocalDate.of(2018, 1, 1);
		Fattura f = new Fattura();
		String[] elenco = {"Gestione Fatture 2018","1.   --->   Aggiungi fattura","2.   --->   Segnala Fattura Pagata","3.   --->  Registra fattura Sbagliata","4.   --->   Visualizza fatture in ordine di data di emissione","5.   --->   visualizza totale fatture non pagate "};
		Menu m1 = new Menu(elenco);
		int continua = 0; // Se = 1 stop
		
		while(continua == 0)
		{
			
		
		switch (m1.scelta())
		{
		case 1:
			System.out.println("inserisci anno della fattura:");
			try {
				f.setAnno(tastiera.readInt());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			}
			System.out.println("Inserisci il nome ente della fattura");
			f.setNomeEnte(onlyString.nextLine());
			System.out.println("inserisci la descrizione del prodotto:");
			f.setDescrizioneProdotto(onlyString.nextLine());
			System.out.println("inserisci importo:");
			try {
				f.setImporto(tastiera.readInt());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			}
			System.out.println("Inserisci metodo di pagamento:");
			try {
				f.setMetodoPagamento(tastiera.readChar());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			}
			System.out.println("Inserisci lo stato dela fattura");
			try {
				f.setStatoFattura(tastiera.readChar());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			}
			try {
				lista.inserisciInCoda(f);
			} catch (ElencoFattureException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			}
			try 
			{
				lista.inserisciInCoda(f);
			} 
			catch (ElencoFattureException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Errore generico.");
			}
			break;
		case 2:
			//Segnala Fattura come pagata
			Fattura f5 = new Fattura();
			
			System.out.println("Inserire l numero della fattura da segnalare come pagata:");
			try {
				posizione = tastiera.readInt();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				System.out.println("eccezione numerica...");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Input inserito non corretto");
			}
			
			try {
				f5 = lista.getFattura(posizione);
			} catch (ElencoFattureException e1) {
				// TODO Auto-generated catch block
				System.out.println("Eccexione");
			}
			
			f5.setStatoFattura('P');
			
			
			System.out.println(lista.toString());
			
			
			break;
			
		case 3:
			posizione = 0;
			Fattura f6=new Fattura();
			System.out.println("Inserisci numero fattura da segnalare come errata");
			try {
				posizione = tastiera.readInt();
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				System.out.println("Numero non accettato");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				System.out.println("Numero non valido");
			}
			try {
				f6 = lista.getFattura(posizione);
			} catch (ElencoFattureException e1) {
				// TODO Auto-generated catch block
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
			//Visualizza 
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
				if (f7.getStatoFattura() != 'P' &&  f7.getNomeEnte().compareToIgnoreCase(nomeCliente)==0)
				{
					totaleFattureNonPagate +=  f7.getImporto();
				}
				else
				{
					System.out.println("Non funge");
				}
			}
			
			System.out.println("It totale della fatture non pagate �:" + totaleFattureNonPagate);
				
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
				if (f8.getStatoFattura() == 'P' &&  f8.getNomeEnte().compareToIgnoreCase(nomeCliente)==0)
				{
					totaleFatturePagate +=  f8.getImporto();
				}
				else
				{
					System.out.println("Non funge");
				}
			}
			
			System.out.println("It totale della fatture  pagate �:" + totaleFatturePagate);
				
			
			
			break;
			
		case 7:
			
			//visualizzare dati di una fattura tramite ID
			int anno = 0;
			int numeroIdentificativo = 0;  //i = numero progressivo fattura
			Fattura f10 = new Fattura();
			
			System.out.println("Inserisci anno del ID dell'utente:");
			try {
				anno = tastiera.readInt();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				System.out.println("Il numer inserito non � valido");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("il valore inserito non � un numero");
			}
			
			System.out.println("Inserisci numero progressivo fattura");
			try {
				numeroIdentificativo = tastiera.readInt();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				System.out.println("Il numer inserito non � valido");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("il valore inserito non � un numero");
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

		default:
			System.out.println("opzione non disponibile!");
			break;
		}
		
		System.out.println("Continuare?");
		try
		{
			continua = tastiera.readInt();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore generico");
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Errore generico");
		}

	}
	}

}
