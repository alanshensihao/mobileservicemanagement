package client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.io.*;
public class MDMClient {

    private static int port = 1234;

    public static void main(String[] args) 
	{
		String message;
		
		try
		{
			while (true){
			int menu_option;
			printMenu();
            menu_option = Integer.parseInt(System.console().readLine());
			InetAddress host = InetAddress.getLocalHost();
			Socket socket = new Socket(host.getHostName(), port);
			switch (menu_option) {
				case 1:
				case 3:
				case 4:
					String s =String.valueOf(menu_option);
					System.out.println("please type the values");
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					BufferedReader userPrompt = new BufferedReader(new InputStreamReader(System.in));
					String userMessage;
		    		userMessage = userPrompt.readLine();
					oos.writeObject(s+','+userMessage);
					System.out.println("Sent Message: " + userMessage);
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					message = (String) ois.readObject();
					System.out.println("Retrieved acknowledgement: " + message);
					ois.close();
					oos.close();
					break;
				case 2:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
					System.out.println("Our team is still working on these options!!! Please try again later :)");
					break;

			}
	
		}
		}
		catch (Exception e)
		{
			System.out.println("Error");
		}
    }
    
	public static void printMenu(){
		System.out.println("\nMenu:");
        System.out.println("1. Add User <user details in comma-separated list>");
        System.out.println("2. Add Users <users' details in comma-separated list>");
        System.out.println("3. Update User <user>");
		System.out.println("4. Delete User <username>");
		System.out.println("5. Delete Users< users names list>");
		System.out.println("6. Add Account <phone, user, bundle>");
		System.out.println("7. Add Account <account>");
		System.out.println("8. Delete Account <phone>");
		System.out.println("9. Update Account <phone, bundle>");
		System.out.println("10. Add Preconfigured Bundle <bundle name> ");
		System.out.println("11. Add PaC Bundle <bundle name> ");
		// other options need to be added
		
	}
}