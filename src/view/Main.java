package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAtleta;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforoGun = new Semaphore(5);
		Semaphore mutexPlacement = new Semaphore(1);
		Semaphore mutexConsole = new Semaphore(1);

		for (int i = 0; i < 25; i++) {
			ThreadAtleta t = new ThreadAtleta(i + 1, getNomeAtletaPorRank(i + 1), semaforoGun, mutexPlacement,
					mutexConsole);
			t.start();
		}
	}

	public static String getNomeAtletaPorRank(int rank) {
		switch (rank) {
		case 1:
			return "Jan Frodeno";
		case 2:
			return "Kristian Blummenfelt";
		case 3:
			return "Daniela Ryf";
		case 4:
			return "Gustav Iden";
		case 5:
			return "Flora Duffy";
		case 6:
			return "Lionel Sanders";
		case 7:
			return "Patrick Lange";
		case 8:
			return "Lucy Charles-Barclay";
		case 9:
			return "Alistair Brownlee";
		case 10:
			return "Anne Haug";
		case 11:
			return "Vincent Luis";
		case 12:
			return "Taylor Knibb";
		case 13:
			return "Sebastian Kienle";
		case 14:
			return "Laura Philipp";
		case 15:
			return "Sam Long";
		case 16:
			return "Javier Gomez Noya";
		case 17:
			return "Katie Zaferes";
		case 18:
			return "Frederik Van Lierde";
		case 19:
			return "Chelsea Sodaro";
		case 20:
			return "Mario Mola";
		case 21:
			return "Heather Jackson";
		case 22:
			return "Joe Skipper";
		case 23:
			return "Sarah Crowley";
		case 24:
			return "Jodie Stimpson";
		case 25:
			return "Ben Kanute";
		default:
			return "Rank nao encontrado";
		}
	}
}
