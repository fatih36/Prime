package com.fatihaygun.prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Program {

	public Program() {
		int dosNo = 0;
		String bas = "";
		FileReader fr;
		BufferedReader br;
		try {
			for (int i = 0; i < 1000; i++) {
				fr = new FileReader("last.txt");
				br = new BufferedReader(fr);
				dosNo = Integer.parseInt(br.readLine());
				bas = br.readLine();
				br.close();
				prime(dosNo, bas);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void prime(int dosNo, String bas) {
		StringBuffer sb = new StringBuffer();
		BigInteger b = new BigInteger(bas), temp;
		int number = 100000;
		try {

			long time = -System.currentTimeMillis();

			sb.append(b.toString() + "\r\n");
			temp = b;
			b = b.nextProbablePrime();

			for (int j = 1; j < number; j++) {

				sb.append(b.toString() + "\r\n");
				// sb.append((b.subtract(temp)).toString()+"\r\n");
				// temp = b;
				b = b.nextProbablePrime();

				if (j % 10000 == 0) {
					System.out.println(b.toString());
				}
			}
			FileWriter fw = new FileWriter("p" + dosNo + ".txt");
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(sb.toString());

			bw.close();
			time += System.currentTimeMillis();
			System.out.println("\n" + b.toString() + "\t" + time);

			FileWriter fw2 = new FileWriter("last.txt");
			BufferedWriter bw2 = new BufferedWriter(fw2);
			PrintWriter pw2 = new PrintWriter(bw2);
			pw2.write("" + (dosNo + 1));
			bw2.newLine();
			pw2.write("" + b.toString());
			pw2.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		Program p = new Program();
	}

}
