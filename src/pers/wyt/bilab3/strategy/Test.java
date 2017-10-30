package pers.wyt.bilab3.strategy;

/**
 * 生物信息编程作业三，蛋白质特殊片段预测模型，建立感知矩阵和概率矩阵
 * @author asus
 *
 */
public class Test {

	public static void main(String[] args) {
		/**
		 * 第一部分：感知矩阵
		 * 给一个长约20bp的蛋白质序列
		 * 根据感知矩阵
		 * 获得序列得分Ws
		 */
		
		//将预测的蛋白质序列
		String S = "";
		//进入感知矩阵打分
		int Ws = PerceptionMatrix.Score(String S);
		//功能位点阈值
		int T;
		//非功能位点阈值
		int N_T;
		
		/**
		 * 第二部分：概率矩阵
		 * 给一个长约20bp的蛋白质序列
		 * 根据概率矩阵
		 * 获得似然比LR
		 */
		//进入概率矩阵
		double P ;
		double N_P;
		
	}

}
