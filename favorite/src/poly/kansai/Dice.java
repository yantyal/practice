package poly.kansai;

import java.util.Random;

public class Dice {
	//サイコロの目の情報
	int dice;
	
	//サイコロを振るメソッド
	public void makeRandom(int number) {
		//1～6の乱数を作成する(入力部)
		Random rand = new Random();
		this.dice = rand.nextInt(number) + 1;//どういう意味ですか？
		// 結果を出力する(出力部)
		//System.out.println("サイコロの目は、" + dice);
	}

}
