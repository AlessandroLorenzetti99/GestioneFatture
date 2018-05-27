import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class Testfattura {

	@Test
	public void testAnno()
	{
		LocalDate data= LocalDate.now();
		Fattura f1 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,'P');
		assertEquals("Anno = 2018",2018,f1.getAnno());
	}
	
	@Test
	public void TestNumeroProgressivoi()
	{
		LocalDate data= LocalDate.now();
		Fattura f1 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,'P');
		assertEquals("i = 1",0,f1.getI());
	}
	
	@Test
	public void TestNomeEnte()
	{
		LocalDate data= LocalDate.now();
		Fattura f1 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,'P');
		assertEquals("Nome Ente = Alessendro Lorenzetti","Alessandro Lorenzetti",f1.getNomeEnte());
	}
	
	@Test
	public void TestDescrizione()
	{
		LocalDate data= LocalDate.now();
		Fattura f1 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,'P');
		assertEquals("Descrizione1","Descrizione1",f1.getDescrizioneProdotto());
	}
	
	@Test
	public void TestImporto()
	{
		LocalDate data= LocalDate.now();
		Fattura f1 = new Fattura(data,2018,1,"Alessandro Lorenzetti","Descrizione1",1000,'P');
		assertEquals("importo = 1000",1000,f1.getImporto());
	}
	
	

}
