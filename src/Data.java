
public class Data
{
	private int giorno;
	private int mese;
	private int anno;
	
	public Data()
	{
		setGiorno(giorno);
		setMese(mese);
		setAnno(anno);
	}

	public int getGiorno()
	{
		return giorno;
	}

	public void setGiorno(int giorno) 
	{
		this.giorno = giorno;
	}

	public int getMese()
	{
		return mese;
	}

	public void setMese(int mese)
	{
		this.mese = mese;
	}

	public int getAnno()
	{
		return anno;
	}

	public void setAnno(int anno) 
	{
		this.anno = anno;
	}
	
	public String toString()
	{
		return " " + getGiorno() + " " + getMese() + " " + getAnno();
		
	}
	
	
	


}
