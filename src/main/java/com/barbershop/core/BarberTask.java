package com.barbershop.core;

import java.util.concurrent.BlockingQueue;

public class BarberTask implements Runnable {

	private BlockingQueue<Customer> chairs;

	private boolean isShopOpen;
	
	private boolean isSleeping;

	public BarberTask(BlockingQueue<Customer> chairs) {
		this.chairs = chairs;
		this.isShopOpen = true;
		isSleeping=false;
	}

	public void run() {
		while (isShopOpen) {
			try {
				if(chairs.isEmpty()) {
					isSleeping=true;
				}
				Customer customer = chairs.take();
				isSleeping=false;
				Thread.sleep(customer.getService().getTimeInSec());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public void setShopOpen(boolean isShopOpen) {
		this.isShopOpen = isShopOpen;
	}

	public boolean isSleeping() {
		return isSleeping;
	}

	
}
