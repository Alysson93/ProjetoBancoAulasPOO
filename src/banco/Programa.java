package banco;

public class Programa {

	public static void main(String[] args) {
		Conta ci = new ContaCorrente("123","1","Alysson","103","26/01/2021");
		Conta cp = new ContaPoupanca("234","2","Pereira","858","26/01/2021");
		ci.depositar(100f);
		ci.transferir(cp, 25f);
		System.out.println(ci);
		System.out.println(cp);
	}

}
