package pack02_array;

import java.util.Random;
import java.util.Scanner;

public class Ex04_text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����, ��ĳ��
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		// ������ ������ �ʵ��� ���ѹݺ�
		while (true) {
			// ���̵� �Է�
			System.out.println("���̵��� �Է����ּ���\n -1�� �Է½� ��������");
			String inputData = sc.nextLine();
			int user = Integer.parseInt(inputData);
			// 1���� ���� �� ����
			if(user == -1) {
				System.out.println("������ ����˴ϴ�");
				break;
			}else if (user < 1) {
				System.out.println("�����Դϴ� ���Է����ּ���");
				continue;
			} else {
				// 1���� ũ�ų� ���� �� ����.
				int[] i = new int[user]; // �Է��� �� ��ŭ�� ũ�⸦ ���� int �迭
				int y = r.nextInt(user); // �迭 �ȿ� ���� ���� ���ϴ� ������ ��

				i[y] = 1; // �����/
				
				// 0~4

				int count = 0;
				while (true) {
					if(count++ >= 5) {
						System.out.println("�õ�Ƚ���ʰ�");
						break;
					}
					String x = sc.nextLine();
					int answer = Integer.parseInt(x) - 1;
					// 1  // 0

					if (answer == y) {
						System.out.println("�����Դϴ�");
						break;
					} else {
						System.out.println("Ʋ�Ƚ��ϴ�");
						continue;
					}
				}

//				for(int m = 0; m < i.length; m++) {
//					System.out.println(i[m]);
//				}

			}
		}
	}
}
