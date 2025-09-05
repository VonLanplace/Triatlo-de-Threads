package controller;

import java.util.concurrent.Semaphore;

import model.Atleta;
import model.listaSimples.ListaSimples;

public class ThreadAtleta extends Thread {
	static int corredores = 0;
	Atleta atleta;
	Semaphore semaforoGun;
	Semaphore mutexPlacement;
	Semaphore mutexConsole;
	ListaSimples<Atleta> scoreboard;

	public ThreadAtleta(int ID, Semaphore semaforoGun, Semaphore mutexPlacement, Semaphore mutexConsole,
			ListaSimples<Atleta> scoreboard) {
		this.atleta = new Atleta(ID, 0, "Paulo");
		this.semaforoGun = semaforoGun;
		this.mutexPlacement = mutexPlacement;
		this.scoreboard = scoreboard;

	}

	@Override
	public void run() {
		try {
			running();
			semaforoGun.acquire();
			shooting();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			semaforoGun.release();
		}
		try {
			biking();
			mutexPlacement.acquire();
			markScore();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			mutexPlacement.release();
		}
		corredores++;
		System.out.println(corredores);
		if (corredores >= 25) {
			sortScore();
			System.out.println(scoreboard.toString());
		}
	}

	private void running() throws InterruptedException {
		int distancia = 3000, velocidade = (int) ((Math.random() * 6) + 20);
		while (distancia > 0) {
			sleep(30);
			distancia -= velocidade;
		}
	}

	private void shooting() throws InterruptedException {
		int aux = 0;
		for (int i = 0; i < 3; i++) {
			aux += (int) ((Math.random() * 11) + 0);
			this.atleta.setPontuacao(i);
			sleep((int) ((Math.random() * 2501) + 500));
		}
		this.atleta.setPontuacao(aux);
	}

	private void biking() throws InterruptedException {
		int distancia = 5000, velocidade = (int) ((Math.random() * 11) + 30);
		while (distancia > 0) {
			sleep(40);
			distancia -= velocidade;
		}
	}

	private void markScore() throws InterruptedException {
		int aux = atleta.getPontuacao();
		aux += 250 - (scoreboard.total() * 10);
		atleta.setPontuacao(aux);
		scoreboard.append(atleta);
	}

	private void sortScore() {
		sortScore(this.scoreboard, 0, this.scoreboard.total() - 1);
	}

	private void sortScore(ListaSimples<Atleta> scoreboard, int min, int max) {
		int i = min, j = max;
		Atleta pivo = scoreboard.get((max - min) / 2 + min).getConteudo();
		while (i <= j) {
			while (scoreboard.get(i).getConteudo().getPontuacao() > pivo.getPontuacao()) {
				i++;
			}
			while (scoreboard.get(j).getConteudo().getPontuacao() < pivo.getPontuacao()) {
				j--;
			}
			if (i <= j) {
				Atleta aux = scoreboard.get(i).getConteudo();
				scoreboard.get(i).setConteudo(scoreboard.get(j).getConteudo());
				scoreboard.get(j).setConteudo(aux);

				i++;
				j--;
			}
		}

		if (i < max) {
			sortScore(scoreboard, i, max);
		}
		if (j > min) {
			sortScore(scoreboard, min, j);
		}
	}
}
