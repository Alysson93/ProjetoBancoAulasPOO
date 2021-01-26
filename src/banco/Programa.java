package banco;

public class Programa {

	public static void main(String[] args) {
		Conta c1 = new Conta("123","1","Alysson","103",'I',"26/01/2021");
		Conta c2 = new Conta("234","2","Pereira","858",'P',"26/01/2021");
		c1.depositar(100f);
		c1.transferir(c2, 25f);
		System.out.println(c1);
		System.out.println(c2);
	}

}
