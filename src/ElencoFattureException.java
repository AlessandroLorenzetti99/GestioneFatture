

public class ElencoFattureException extends Exception 
{
	private String messaggio;
	public ElencoFattureException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	public String toString()
	{
		return messaggio;
	}
}
