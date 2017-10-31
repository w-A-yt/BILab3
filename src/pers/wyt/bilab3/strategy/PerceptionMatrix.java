package pers.wyt.bilab3.strategy;

import java.util.Scanner;

public class PerceptionMatrix {

	/**
	 * S序列与感知矩阵比对获取得分
	 * @param S
	 * @return
	 */
	public static int Score(String S) {
		//有点小问题
		int M_length = 0;
		int U_length = 0;
		String unit = null;
		int score = 0;
		int S_length = S.length();
		int[][] perceptionmatrix = new int[U_length][M_length];
		perceptionmatrix = PerceptionMatrix.EstablishedScoreMatrix(S_length);
		int i=0;
		for(i=0;i<S_length;i++) {
			int line;
			int column;
			line = unit.indexOf(S.charAt(i));
			column = i;
			score+=perceptionmatrix[line][column];
		}
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
		 * 输入正反例各50构造感知矩阵
		 */
		perceptionmatrix = PerceptionMatrix.EstablishedTrainingMatrix(perceptionmatrix);
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
		//做参数传入
		String unit = "";
		int M_length = 0;
		//或是正例次数和反例次数
		System.out.println("输入正反例次数");
		Scanner sc = new Scanner(System.in); 
		int times = sc.nextInt();
		int i,j;
		for (i = 0;i < times;i++) {
			//正例从文件读入,正例长度为M_length
			String PositiveCase = "";
			int position;
			for(j = 0;j<M_length;j++) {					
				position = unit.indexOf(PositiveCase.charAt(j));
				basicmatrix[position+1][j]++;
			}
		}
		//反例
		for (i = 0;i < times;i++) {
			//反例从文件读入,反例长度为M_length
			String NegativeCase = "";
			int position;
			for(j = 0;j<M_length;j++) {					
				position = unit.indexOf(NegativeCase.charAt(j));
				basicmatrix[position+1][j]--;
			}
		}
		sc.close();
		return basicmatrix;
	}
}
