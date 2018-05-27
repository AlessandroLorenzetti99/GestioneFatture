import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ElencoFatureTest {

	@Test
	public void TestGetElementi()
	{
		ElencoFatture listaTest = new ElencoFatture();
		LocalDate data= LocalDate.now();
		Fattura f1 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,true);
		Fattura f2 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,true);
		
		listaTest.inserisciInTesta(f1);
		listaTest.inserisciInTesta(f2);
		
		assertEquals("f1,f2 = 2",2,listaTest.getElementi());
	}
	

	@Test
	public void TestInserisciInCoda()
	{
		ElencoFatture listaTest = new ElencoFatture();
		LocalDate data= LocalDate.now();
		Fattura f1 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,true);
		Fattura f2 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,true);
		
		try {
			listaTest.inserisciInCoda(f1);
		} catch (ElencoFattureException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore");
		}
		try {
			listaTest.inserisciInCoda(f1);
		} catch (ElencoFattureException e) {
			// TODO Auto-generated catch block
			System.out.println("errore");
		}
		
		assertEquals("f1,f2 = 2",listaTest.toString());
	}
	

	@Test
	public void TestInserisciInTesta()
	{
		ElencoFatture listaTest = new ElencoFatture();
		LocalDate data= LocalDate.now();
		Fattura f1 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,true);
		Fattura f2 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,true);
		
		listaTest.inserisciInTesta(f1);
		listaTest.inserisciInTesta(f2);
		
		assertEquals("f1,f2 = 2",2,listaTest.getElementi());
	}
	
	

}
