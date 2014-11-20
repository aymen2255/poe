package fr.treeptik.fichier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.channels.FileChannel;
import java.util.Properties;
import java.util.Scanner;

public class TestFichier {

	public static void main(String[] args) throws Exception {
		File file = new File("Fichier1.txt");
		File dest = new File("toFile.txt");
		File fileProperties = new File("conf.properties");
		TestFichier test = new TestFichier();
		/*
		 * System.out.println("************ write file *********");
		 * test.writeFile(file);
		 * System.out.println("************ read file *********");
		 * test.getFileContenu(file);
		 */
		// test.copyFile(file, dest);

		// test.readProperties(fileProperties);

	}

	public void writeFile(File file) throws Exception {
		String saisie = "";
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		Scanner sc = new Scanner(System.in);
		saisie = sc.next();
		bufferedWriter.write(saisie);
		bufferedWriter.newLine();
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	public void getFileContenu(File file) throws Exception {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			System.out.println(bufferedReader.readLine());
		}
	}

	public void copyFile(File file, File dest) throws Exception {
		/*
		 * 1ere facon File file1=new File("fichier1"); File filedest = new
		 * File("test/filedest.txt"); file1.renameTo(filedest);
		 */
		

		FileChannel in = null; // canal d'entrée
		FileChannel out = null; // canal de sortie
		in = new FileInputStream(file).getChannel();
		out = new FileOutputStream(dest).getChannel();

		in.transferTo(0, in.size(), out);
	}

	public void readProperties(File file) throws Exception {
		Properties properties = new Properties();
		FileReader fileReader = new FileReader(file);
		properties.load(fileReader);

		System.out.println(properties.getProperty("line2"));
	}

}
