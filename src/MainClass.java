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
		//--------------Test Classe Fattura------------------
		LocalDate data1= LocalDate.of(2018, 1, 1);
		System.out.println(data1.toString());
		
		Fattura f1 = new Fattura(data1, 0, 0, "Prova", "No descrizione", 100, 'P', 'P');
		
		System.out.println(f1.toString());

	}

}
