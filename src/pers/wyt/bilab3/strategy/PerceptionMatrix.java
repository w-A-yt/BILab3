package pers.wyt.bilab3.strategy;

public class PerceptionMatrix {

	public static int Score(String S) {
		int score = 0;
		int S_length = S.length();
		int[][] perceptionmatrix = new int[21][S_length + 1];
		perceptionmatrix = PerceptionMatrix.EstablishedScoreMatrix(S_length);
		return score;
	}

	private static int[][] EstablishedScoreMatrix(int S_length) {
		int[][] perceptionmatrix = new int[21][S_length + 1];
		// ¼òµ¥³õÊ¼»¯¸ĞÖª¾ØÕó
		/**
		 * °±»ùËáÄ¬ÈÏÅÅĞò 
		 * ±û°±Ëá Ala A 1 
		 * ¾«°±Ëá Arg R 2 
		 * Ìì¶¬°±Ëá Asp D 3... 
		 * °ëë×°±Ëá Cys C 
		 * ¹È°±õ£°· Gln Q 
		 * ¹È°±ËáGlu/Gln E 
		 * ×é°±Ëá His H 
		 * ÒìÁÁ°±Ëá Ile I 
		 * ¸Ê°±Ëá Gly G 
		 * Ìì¶¬õ£°· Asn N 
		 * ÁÁ°±Ëá Leu L 
		 * Àµ°±Ëá Lys K 
		 * ¼×Áò°±ËáMet M 
		 * ±½±û°±ËáPhe F 
		 * ¸¬°±Ëá Pro P 
		 * Ë¿°±Ëá Ser S 
		 * ËÕ°±Ëá Thr T 
		 * É«°±Ëá Trp W 
		 * ÀÒ°±Ëá Tyr Y 
		 * çÓ°±Ëá Val V
		 */
		int i, j;
		for (i = 1; i < 21; i++) {
			perceptionmatrix[i][0] = i;
		}
		for (j = 1; j < S_length + 1; j++) {
			perceptionmatrix[0][j] = j;
		}
		/**
		 * ÊäÈëÕı·´Àı¸÷50¹¹Ôì¸ĞÖª¾ØÕó
		 */
		int Tcount = 0;
		int N_Tcount = 0;
		//pathÒ»¶ÑÎÄ¼şÂ·¾¶
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
		return perceptionmatrix;
	}
}
