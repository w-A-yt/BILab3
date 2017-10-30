package pers.wyt.bilab3.strategy;

import java.util.Scanner;

public class PerceptionMatrix {

	/**
	 * S序列与感知矩阵比对获取得分
	 * @param S
	 * @return
	 */
	public static int Score(String S) {
		int score = 0;
		int S_length = S.length();
		int[][] perceptionmatrix = new int[21][S_length + 1];
		perceptionmatrix = PerceptionMatrix.EstablishedScoreMatrix(S_length);
		return score;
	}

	/**
	 * 建立感知矩阵
	 * @param S_length
	 * @return
	 */
	private static int[][] EstablishedScoreMatrix(int S_length) {
		/**
		 * 基础单位
		 * 可从文件读入，选择
		 * 最后输出矩阵也要用
		 */
		String unit = "";
	
		//矩阵长度用户输入
		System.out.println("请输入矩阵长度");
		Scanner sc = new Scanner(System.in); 
		int M_length = sc.nextInt();
		int U_length = unit.length();
		M_length++;
		U_length++;
		int[][] perceptionmatrix = PerceptionMatrix.EstablishedBasicMatrix(U_length ,M_length);

		/**
		 * 氨基酸默认排序 
		 * 丙氨酸 Ala A 1 
		 * 精氨酸 Arg R 2 
		 * 天冬氨酸 Asp D 3... 
		 * 半胱氨酸 Cys C 
		 * 谷氨酰胺 Gln Q 
		 * 谷氨酸Glu/Gln E 
		 * 组氨酸 His H 
		 * 异亮氨酸 Ile I 
		 * 甘氨酸 Gly G 
		 * 天冬酰胺 Asn N 
		 * 亮氨酸 Leu L 
		 * 赖氨酸 Lys K 
		 * 甲硫氨酸Met M 
		 * 苯丙氨酸Phe F 
		 * 脯氨酸 Pro P 
		 * 丝氨酸 Ser S 
		 * 苏氨酸 Thr T 
		 * 色氨酸 Trp W 
		 * 酪氨酸 Tyr Y 
		 * 缬氨酸 Val V
		 */
		
		int i,j;
		/**
		 * 输入正反例各50构造感知矩阵
		 */
		int Tcount = 0;
		int N_Tcount = 0;
		//path一堆文件路径
		String path = null;
		for (Tcount = 0; Tcount < 50; Tcount++) {
			String tempT;
			tempT = ReadFromFile.ReadFasta(path);
			int tempT_length = tempT.length();
			for(i = 0; i < tempT_length; i++) {
				switch(tempT.charAt(i)) {
				case 'A':
					perceptionmatrix[1][i+1]++;
				case 'R':
					perceptionmatrix[2][i+1]++;
				case 'D':
					perceptionmatrix[3][i+1]++;
				case 'C':
					perceptionmatrix[4][i+1]++;
				case 'Q':
					perceptionmatrix[5][i+1]++;
				case 'E':
					perceptionmatrix[6][i+1]++;
				case 'H':
					perceptionmatrix[7][i+1]++;
				case 'I':
					perceptionmatrix[8][i+1]++;
				case 'G':
					perceptionmatrix[9][i+1]++;
				case 'N':
					perceptionmatrix[10][i+1]++;
				case 'L':
					perceptionmatrix[11][i+1]++;
				case 'K':
					perceptionmatrix[12][i+1]++;
				case 'M':
					perceptionmatrix[13][i+1]++;
				case 'F':
					perceptionmatrix[14][i+1]++;
				case 'P':
					perceptionmatrix[15][i+1]++;
				case 'S':
					perceptionmatrix[16][i+1]++;
				case 'T':
					perceptionmatrix[17][i+1]++;
				case 'W':
					perceptionmatrix[18][i+1]++;
				case 'Y':
					perceptionmatrix[19][i+1]++;					
				case 'V':
					perceptionmatrix[20][i+1]++;
				default:
					System.out.println("wrong");
				}
			}
		}
		for (N_Tcount = 0; N_Tcount < 50; N_Tcount++) {
			String tempN_T;
			tempN_T = ReadFromFile.ReadFasta(path);
			int tempN_T_length = tempN_T.length();
			for(i = 0; i < tempN_T_length; i++) {
				switch(tempN_T.charAt(i)) {
				case 'A':
					perceptionmatrix[1][i+1]--;
				case 'R':
					perceptionmatrix[2][i+1]--;
				case 'D':
					perceptionmatrix[3][i+1]--;
				case 'C':
					perceptionmatrix[4][i+1]--;
				case 'Q':
					perceptionmatrix[5][i+1]--;
				case 'E':
					perceptionmatrix[6][i+1]--;
				case 'H':
					perceptionmatrix[7][i+1]--;
				case 'I':
					perceptionmatrix[8][i+1]--;
				case 'G':
					perceptionmatrix[9][i+1]--;
				case 'N':
					perceptionmatrix[10][i+1]--;
				case 'L':
					perceptionmatrix[11][i+1]--;
				case 'K':
					perceptionmatrix[12][i+1]--;
				case 'M':
					perceptionmatrix[13][i+1]--;
				case 'F':
					perceptionmatrix[14][i+1]--;
				case 'P':
					perceptionmatrix[15][i+1]--;
				case 'S':
					perceptionmatrix[16][i+1]--;
				case 'T':
					perceptionmatrix[17][i+1]--;
				case 'W':
					perceptionmatrix[18][i+1]--;
				case 'Y':
					perceptionmatrix[19][i+1]--;					
				case 'V':
					perceptionmatrix[20][i+1]--;
				default:
					System.out.println("wrong");
				}
			}
		}
		sc.close();
		return perceptionmatrix;
	}
	
	/**
	 * 初始化感知矩阵
	 * @param U_length
	 * @param M_length
	 * @return
	 */
	private static int[][] EstablishedBasicMatrix(int U_length, int M_length) {	
		int[][] basicmatrix = new int[U_length][M_length];
		int i , j;
		for (i = 1; i < U_length; i++) {
			basicmatrix[i][0] = i;
		}
		for (j = 1; j < M_length + 1; j++) {
			basicmatrix[0][j] = j;
		}
		return basicmatrix;
	}
	
	/**
	 * 输入正反例各50构造感知矩阵
	 */
	private static int[][] EstablishedTrainingMatrix(int[][] basicmatrix) {	
		int[][] trainingmatrix = null;
		//或是正例次数和反例次数
		System.out.println("输入正反例次数");
		Scanner sc = new Scanner(System.in); 
		int times = sc.nextInt();
		int i;
		for (i = 0;i < times;i++) {
			//正例从文件读入
			String PositiveCases = "";
			
		}
		sc.close();
		return trainingmatrix;
	}
}
