import java.util.*;

public class CRCProgram {
    // Arrays
    public static int datawordAndZeros[] = new int[100];  // dataword + appended zeros + later checksum
    public static int checksum[] = new int[100];         // checksum during division
    public static int generator[] = {1, 0, 1, 1};         // generator polynomial (x^3 + x + 1)

    // Useful lengths
    public static int datawordLength;
    public static int generatorLength = generator.length;

    // Function to perform XOR with generator polynomial
    public static void xorOperation() {
        for (int i = 1; i < generatorLength; i++) {
            checksum[i] = (checksum[i] == generator[i]) ? 0 : 1;
        }
    }

    // CRC division (both sender and receiver use this)
    public static void performCRC() {
        int pointer = 0;

        // Copy first part of dataword into checksum
        for (int i = 0; i < generatorLength; i++) {
            checksum[i] = datawordAndZeros[i];
        }

        // Simulate long division using XOR
        do {
            if (checksum[0] == 1) {
                xorOperation();
            }
            // Shift left
            for (int i = 0; i < generatorLength - 1; i++) {
                checksum[i] = checksum[i + 1];
            }
            checksum[generatorLength - 1] = datawordAndZeros[generatorLength + pointer++];
        } while (pointer <= datawordLength);
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        // Input dataword
        System.out.println("Enter the length of Data word:");
        datawordLength = scan.nextInt();

        System.out.println("Enter the Data word (bit by bit):");
        for (int i = 0; i < datawordLength; i++) {
            datawordAndZeros[i] = scan.nextInt();
        }

        // Show generator polynomial
        System.out.println("Generator polynomial is:");
        for (int i = 0; i < generatorLength; i++) {
            System.out.print(generator[i]);
        }
        System.out.println();

        // Append zeros to the dataword
        for (int i = datawordLength; i < datawordLength + generatorLength - 1; i++) {
            datawordAndZeros[i] = 0;
        }

        System.out.println("Extended Dataword (with zeros):");
        for (int i = 0; i < datawordLength + generatorLength - 1; i++) {
            System.out.print(datawordAndZeros[i]);
        }
        System.out.println();

        // Perform CRC (sender side)
        performCRC();

        // Print checksum
        System.out.println("Checksum is:");
        for (int i = 0; i < generatorLength - 1; i++) {
            System.out.print(checksum[i]);
        }
        System.out.println();

        // Form codeword = dataword + checksum
        for (int i = datawordLength; i < datawordLength + generatorLength - 1; i++) {
            datawordAndZeros[i] = checksum[i - datawordLength];
        }

        System.out.println("Codeword is:");
        for (int i = 0; i < datawordLength + generatorLength - 1; i++) {
            System.out.print(datawordAndZeros[i]);
        }
        System.out.println();

        // Receiver side
        System.out.println("Enter received Codeword (may contain error):");
        for (int i = 0; i < datawordLength + generatorLength - 1; i++) {
            datawordAndZeros[i] = scan.nextInt();
        }

        System.out.println("Received Dataword is:");
        for (int i = 0; i < datawordLength + generatorLength - 1; i++) {
            System.out.print(datawordAndZeros[i] + " ");
        }
        System.out.println();

        System.out.println("Performing CRC on receiver side...");
        performCRC();

        // Check if error detected
        boolean error = false;
        for (int i = 0; i < generatorLength - 1; i++) {
            if (checksum[i] != 0) {
                error = true;
                break;
            }
        }

        if (error) {
            System.out.println("Error detected in received codeword!");
        } else {
            System.out.println("No Error in received codeword.");
        }

        scan.close();
    }
}
