package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (// Connect to server
		Socket socket = new Socket("localhost", 5000)) {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            try (// Keep reading input from user and sending messages to server
			Scanner scanner = new Scanner(System.in)) {
				while (true) {
				    // Wait for user input via Scanner
				    System.out.print("Enter message: ");
				    String message = scanner.nextLine();

				    // Send message to server
				    out.println(message);
				    System.out.println("Sent message: " + message);

				    // Read response from server
				    String response = in.readLine();
				    System.out.println("Received response: " + response);
				}
			}

            // Close socket (this code is unreachable in this example)
            // socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

