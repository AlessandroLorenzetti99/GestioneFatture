
public class Start
{
	private char logo;
	private int lunghezza;
	private String titolo;
	
	public Start(char logo,int lunghezza,String titolo)
	{
		setLogo(logo);
		setLunghezza(lunghezza);
		setTitolo(titolo);
	}

	public char getLogo()
	{
		return logo;
	}

	public void setLogo(char logo)
	{
		this.logo = logo;
	}

	public int getLunghezza()
	{
		return lunghezza;
	}

	public void setLunghezza(int lunghezza)
	{
		this.lunghezza = lunghezza;
	}
	
	
	public String getTitolo()
	{
		return titolo;
	}

	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}
	
	public void visualizza()
	{
		for (int i = 0; i < lunghezza; i++)
		{
			System.out.print(getLogo());;
		}
		
		System.out.println();
		
		System.out.println(getTitolo());
		
		for (int i = 0; i < lunghezza; i++)
		{
			System.out.print(getLogo());
		}
		
		// A capo
		for (int i = 0; i < 2; i++)
		{
			System.out.println();
		}
		
		
		
	}

	
	

}
