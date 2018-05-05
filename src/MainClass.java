import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class MainClass {

	public static void main(String[] args) 
	{
		String[] elenco = {"Aggiungi fattura","Segnaa Fattura come errata","Registra pag. nuova fattura","Visualizza fatture in ordine di data di emissione","visualizza faytture non pagate "};
		Menu m1 = new Menu(elenco);
		
		m1.visualizza();
		m1.scelta();
		
		

	}

}
