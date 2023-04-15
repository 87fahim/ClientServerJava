package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
	static Socket clientSocket;
	public static void main(String[] args) throws IOException {
		try (// Create server socket
			ServerSocket serverSocket = new ServerSocket(5000)) {
			clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		
			
			while (true) {			
				System.out.println("Client connected");

				// Create input and output streams
				
				System.out.print("Waiting for client to respond... ");
				// Read message from client
				String message = in.readLine();
				System.out.println("Received message: " + message);

				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter response: ");
				String response = scanner.nextLine();

				// Send response to client
				out.println(response);

				
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			// Close client socket
			clientSocket.close();
		}
	}
}
