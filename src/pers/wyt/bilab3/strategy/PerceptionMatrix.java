package pers.wyt.bilab3.strategy;

import java.util.Scanner;

public class PerceptionMatrix {

	/**
	 * S�������֪����ȶԻ�ȡ�÷�
	 * @param S
	 * @return
	 */
	public static int Score(String S) {
		//�е�С����
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
	 * ������֪����
	 * @param S_length
	 * @return
	 */
	private static int[][] EstablishedScoreMatrix(int S_length) {
		/**
		 * ������λ
		 * �ɴ��ļ����룬ѡ��
		 * ����������ҲҪ��
		 */
		String unit = "";
	
		//���󳤶��û�����
		System.out.println("��������󳤶�");
		Scanner sc = new Scanner(System.in); 
		int M_length = sc.nextInt();
		int U_length = unit.length();
		M_length++;
		U_length++;
		int[][] perceptionmatrix = PerceptionMatrix.EstablishedBasicMatrix(U_length ,M_length);
		
		/**
		 * ������������50�����֪����
		 */
		perceptionmatrix = PerceptionMatrix.EstablishedTrainingMatrix(perceptionmatrix);
		return perceptionmatrix;
	}
	
	/**
	 * ��ʼ����֪����
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
	 * ������������50�����֪����
	 */
	private static int[][] EstablishedTrainingMatrix(int[][] basicmatrix) {	
		//����������
		String unit = "";
		int M_length = 0;
		//�������������ͷ�������
		System.out.println("��������������");
		Scanner sc = new Scanner(System.in); 
		int times = sc.nextInt();
		int i,j;
		for (i = 0;i < times;i++) {
			//�������ļ�����,��������ΪM_length
			String PositiveCase = "";
			int position;
			for(j = 0;j<M_length;j++) {					
				position = unit.indexOf(PositiveCase.charAt(j));
				basicmatrix[position+1][j]++;
			}
		}
		//����
		for (i = 0;i < times;i++) {
			//�������ļ�����,��������ΪM_length
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
