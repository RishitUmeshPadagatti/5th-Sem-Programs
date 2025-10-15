import java.util.Scanner;
import java.util.Random;

public class SlidingWindowProtocol {
	private final int windowSize;

	public SlidingWindowProtocol(int windowSize){
		this.windowSize = windowSize;
	}

	public void sendFrames(int totalFrames){
		int acknowledgedFrame = 0;
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		while (acknowledgedFrame < totalFrames){
			int currentWindowSize = Math.min(windowSize, totalFrames - acknowledgedFrame);

			System.out.println("\n===Window: [" + acknowledgedFrame + "..." + (acknowledgedFrame + currentWindowSize - 1) + "] ===");

			for (int i=0; i < currentWindowSize; i++){
				System.out.println("Sending frame " + (acknowledgedFrame + i));
			}

			int ackCount = random.nextInt(currentWindowSize + 1);

			if (ackCount == 0){
				System.out.println(">> All frames lost. Retransmitting the entire window");
			}
			else {
				acknowledgedFrame += ackCount;
				System.out.println(">> Acknowledged up to frame " + (acknowledgedFrame - 1)
				+ "(" + ackCount + " frame(s) acknowledged)");
			}
			System.out.println("Press Enter to continue");
			scanner.nextLine();
		}

		System.out.println("\nAll frames sent and acknowledged successfully");
		scanner.close();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter total number of frames to send: ");
		int totalFrames = scanner.nextInt();

		System.out.print("Enter window size: ");
		int windowSize = scanner.nextInt();

		scanner.nextLine();

		SlidingWindowProtocol swp = new SlidingWindowProtocol(windowSize);
		swp.sendFrames(totalFrames);

		scanner.close();
	}
}
