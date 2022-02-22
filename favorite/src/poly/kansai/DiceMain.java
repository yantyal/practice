package poly.kansai;

public class DiceMain {
	
	public static void main (String[] args) {
	//サイコロ二つのインスタンス生成
//	Dice dice1 = new Dice();
//	Dice dice2 = new Dice();
//	
//	//サイコロの目の数を指定してそれぞれのサイコロを振る
//	dice1.makeRandom(100000000);
//	dice2.makeRandom(100000000);
//	
//	//サイコロのフィールドのdiceの値を出力
//	//それぞれのサイコロの目をコンソールに出力
//	System.out.println(dice1.dice + ":" + dice2.dice );
	
	// 変数と配列を準備
	int[] numbers = { 100, 200 };
	Dice[] dices = new Dice[numbers.length];
	// 配列の要素それぞれにインスタンスを生成
	for (int i = 0; i < numbers.length; i++) {
		dices[i] = new Dice();
		dices[i].makeRandom(numbers[i]);
		System.out.println(dices[i].dice);
	}
	//それぞれのサイコロを振るメソッド
	//サイコロのフィールドのdiceの値を出力
//	for (int i = 0; i < numbers.length; i++) {
//		dices[i].makeRandom(numbers[i]);
//		System.out.println(dices[i].dice);
//	}
	}

}
