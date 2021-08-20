package com.barbershop.core;

public enum Service {
	HAIR_STYLE(30),SHAVING(15),FACE_MASSAGE(60);
	
	private long timeInSec;

	public long getTimeInSec() {
		return timeInSec;
	}

	public void setTimeInSec(long timeInSec) {
		this.timeInSec = timeInSec;
	}

	private Service(long timeInSec) {
		this.timeInSec = timeInSec*1000;
	}
	
	
}
