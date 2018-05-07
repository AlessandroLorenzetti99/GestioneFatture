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
		ConsoleInput tastiera = new ConsoleInput();
		Scanner onlyString = new Scanner(System.in);
		ElencoFatture lista = new ElencoFatture();
		LocalDate data1= LocalDate.of(2018, 1, 1);
		Fattura f = new Fattura();
		String[] elenco = {"Gestione Fatture 2018","1.   --->   Aggiungi fattura","2.   --->   Segnaa Fattura come errata","3.   --->   Registra pag. nuova fattura","4.   --->   Visualizza fatture in ordine di data di emissione","5.   --->   visualizza faytture non pagate "};
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
			int posizione = 0;
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
			lista.segnalaFatturaErrata(posizione);
			System.out.println(lista.toString());
			
			
			break;
			
		case 3:
			
			break;
			
		case 4:
			break;
			
		case 5:
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
