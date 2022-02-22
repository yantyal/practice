package poly.kansai;

public class SplitScoreCheck {
	public static void main(String[] args) {
		
		// テスト点数データCSV形式
		String data = "65,59,72,8あ,66";
		// ,ごとにデータを分割//Sting型配列
		String[] scores = data.split(",");
		//合計値を準備
		int sum = 0;
		//取得した配列内の要素をint型に変換し、合計値を計算
		for (String score : scores) {
			if (isCheckNumber(score)) {
				sum += Integer.parseInt(score);
			} else {
				//数字に変換できない場合の処理
				System.out.println(score + ":数値に変換できません");
			}
		}
		//結果を出力
//		System.out.println("点数一覧:" + data);
//		System.out.println("合計:" + sum);
		//printfバージョン
		System.out.printf("点数一覧：%s\n合計：%d",data,sum);
//		System.out.printf("合計： %d",sum);
	}
	//真偽判定メソッド
	public static boolean isCheckNumber(String number) {
		//文字列パターンが数字であるか正規表現を用いて確認
		return number.matches("\\d{1,2}|100");
	}

}
