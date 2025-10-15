import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int L; // bucket size
		int r; // flow rate
		int ta = 0, lct = 0; // time of arrival, last packet arrival time
		int I; // size of incoming packet
		int x = 0, x1 = 0; // current level of bucket, bucket level after leaking

		System.out.println("Input bucket size");
		L = scanner.nextInt();

		System.out.println("Enter Output rate");
		r = scanner.nextInt();

		while (true) {
			System.out.println("\nEnter time of arrival");
			ta = scanner.nextInt();
			if (ta == -1){
				System.out.println("exit...");
				scanner.close();
				System.exit(0);
			}
			
			System.out.println("Enter packet size");
			I = scanner.nextInt();
			if (I > L){
				System.out.println("Non conformal packet");
				continue;
			}
			else{
				x1 = x - (ta - lct)* r;
				if (x1 < 0){
					x1 = 0;
					x = x1 + I;
					lct = ta;
					System.out.println("Conformal Packet");
				}
				else {
					if (x1 + I <= L){
						x = x1 + I;
						lct = ta;
						System.out.println("Conformal Packet");
					}
					else{
						System.out.println("Non Conformal Packet");
					}
				}
			}
		}
	}
}
