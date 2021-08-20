package com.barbershop.core;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Hello world!
 *
 */
public class BarberShop {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Customer> chairs;
		boolean isOpen = true;
		Map<Integer, Service> serviceMap = Map.of(1, Service.HAIR_STYLE, 2, Service.SHAVING, 3, Service.FACE_MASSAGE);

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Please enter number of chairs in shop:");
			chairs = new LinkedBlockingQueue<Customer>(sc.nextInt());
			sc.nextLine();
			ExecutorService executor = Executors.newSingleThreadExecutor();

			BarberTask barberTask = new BarberTask(chairs);
			executor.execute(barberTask);

			while (isOpen) {
				System.out.println("\nEnter \n1: for customer details\n0: for closing shop");
				switch (sc.nextLine()) {
				case "1": {
					System.out.println("Name:");
					String name = sc.nextLine();
					System.out.println("Enter service number\n1:Hair Style\n2:Shaving\n3:Face Masage");
					int service = sc.nextInt();
					sc.nextLine();
					if (chairs.remainingCapacity() > 1 || barberTask.isSleeping()) {
						chairs.put(new Customer(name, serviceMap.get(service)));
						System.out.println(String.format("Hi %s, please be seated", name));
					} else {
						System.out.println("Sorry, We are full!");
					}
					break;
				}
				case "0": {
					chairs.clear();
					isOpen = false;
					barberTask.setShopOpen(false);
					if (barberTask.isSleeping()) {
						executor.shutdownNow();
					} else {
						executor.shutdown();
					}
					System.out.println("Closing the shop bye!");
					break;
				}
				default:
					System.out.println("Wrong option. Please try again!!");
					break;
				}
			}
		}

	}
}
