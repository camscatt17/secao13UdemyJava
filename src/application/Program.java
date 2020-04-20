package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date contractDate = sdf.parse(sc.next());
		
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Date x1 = new Date();
		
		Order order = new Order(x1, status, new Client(name, email,contractDate));
		
		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			System.out.println("Enter #"+ (i+1) + " item data:");
			System.out.print("Product name: ");
			String nameProd = sc.nextLine();
			System.out.print("Product price: ");
			double priceProd= sc.nextDouble();
			System.out.print("Quantity: ");
			int quant = sc.nextInt();
			sc.nextLine();
			
			OrderItem item = new OrderItem(quant, priceProd, new Product(nameProd, priceProd));
			order.addItem(item);
			
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);		
		
		sc.close();
	}

}
