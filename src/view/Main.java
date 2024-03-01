package view;

import java.util.Scanner;

import controller.KillController;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		KillController kCont = new KillController();

		kCont.listaProcessos();
		System.out.println();

		System.out.print("Informe o processo que deseja encerrar (PID): ");
		int processPID = sc.nextInt();
		kCont.mataPID(processPID);

		System.out.println("Informe o processo que deseja encerrar (Nome): ");
		String processName = sc.next();
		kCont.mataNome(processName);

		sc.close();
	}
}
