public class oppgave2test {
	public static void main(String[] args) {
		int n = 20;
		for (int indeks = 0; indeks <= n - 2; indeks++) {
			for (int igjen = indeks + 1; igjen <= n - 1; igjen++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
