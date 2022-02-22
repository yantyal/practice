package poly.kansai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Copy {
	public static void main(String[] args) {
		String originalFileName = "original";

		System.out.println("コピー先ファイル名を入力してください。");
		System.out.println("(書式：[コピー先ファイル名])");
		System.out.print("------->");

		String inputFileName = inputFilename();

		fileCopy(originalFileName,inputFileName);

		System.out.println(inputFileName + ".txtにコピーしました。");
		System.out.println("-------読み込んだファイル(" + originalFileName + ".txt)の内容-------");

		for (String line : read(originalFileName)) {
			System.out.println(line);
		}
	}

	public static List<String> read(String originalFilename) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("D://Java/" + originalFilename + ".txt"))) {
			String input = br.readLine();
			while (input != null) {
				lines.add(input);
				input = br.readLine();
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return lines;
	}

	public static void write(List<String> lines, String filename) {
		try (FileWriter fw = new FileWriter("D://Java/" + filename + ".txt")) {
			// バッファリングの機能をデコレートする
			BufferedWriter bw = new BufferedWriter(fw);
			// printの機能をデコレートする
			PrintWriter pw = new PrintWriter(bw);
			// ファイルの操作
			for (String e : lines) {
				pw.println(e);
			}
			pw.flush();// バッファの中身をフラッシュ
			// ファイルのクローズ
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String inputFilename() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public static void fileCopy(String originalFile, String inputFile) {
		List<String> lines = read(originalFile);
		write(lines, inputFile);
	}
}
