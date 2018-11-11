package impl.miw.presentation;

public class LoginCounter {

	private Integer logins;

	public Integer getLogins() {
		return logins;
	}
	
	public void inc()
	{
		logins ++;
	}
	
	public LoginCounter()
	{
		System.out.println("Inicializando el contador");
		logins=0;
	}
}
