package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAtleta;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforoGun = new Semaphore(5);
		Semaphore mutexPlacement = new Semaphore(1);
		Semaphore mutexConsole = new Semaphore(1);

		for (int i = 0; i < 25; i++) {
			ThreadAtleta t = new ThreadAtleta(i + 1, randNome(), semaforoGun, mutexPlacement, mutexConsole);
			t.start();
		}
	}

	private static String randNome() {
		return "Nome";
	}
}
