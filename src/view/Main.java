package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAtleta;
import model.Atleta;
import model.listaSimples.ListaSimples;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforoGun = new Semaphore(5);
		Semaphore mutexPlacement = new Semaphore(1);
		Semaphore mutexConsole = new Semaphore(1);
		ListaSimples<Atleta> scoreboard = new ListaSimples<Atleta>();

		for (int i = 0; i < 25; i++) {
			ThreadAtleta t = new ThreadAtleta(i, semaforoGun, mutexPlacement, mutexConsole, scoreboard);
			t.start();
		}
	}
}
