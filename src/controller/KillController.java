package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void listaProcessos() {
		try {
			if (os().contains("Linux")) {
				String process = "ps -ef";
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} else {
				String process = "TASKLIST /FO TABLE";
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void mataPID(int param) {
		try {
			if (os().contains("Linux")) {
				String cmdPID = "kill -9";
				StringBuffer buffer = new StringBuffer();
				buffer.append(cmdPID);
				buffer.append(" ");
				buffer.append(param);
				Runtime.getRuntime().exec(buffer.toString());
			} else {
				String cmdPID = "TASKKILL /PID";
				StringBuffer buffer = new StringBuffer();
				buffer.append(cmdPID);
				buffer.append(" ");
				buffer.append(param);
				Runtime.getRuntime().exec(buffer.toString());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void mataNome(String param) {
		try {
			if (os().contains("Linux")) {
				String cmdName = "pkill -f";
				StringBuffer buffer = new StringBuffer();
				buffer.append(cmdName);
				buffer.append(" ");
				buffer.append(param);
				Runtime.getRuntime().exec(buffer.toString());
			} else {
				String cmdName = "TASKKILL /IM";
				StringBuffer buffer = new StringBuffer();
				buffer.append(cmdName);
				buffer.append(" ");
				buffer.append(param);
				Runtime.getRuntime().exec(buffer.toString());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
