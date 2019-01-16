import java.io.IOException;
import java.util.Scanner;

class DynamicGraph { // �ڵ� ����ȭ, Ŭ������, �Լ���, ����, ��ó ���� �������� �Ű澲��... ������ �켱!

	static String date; // ��¥ �Է� �� �ʿ��� date ��Ʈ��
	static DataBring oilPrice = new DataBring(); // main�� ������ ������ oilPrice ��ü
	static int v_num; // vertex ���� ������ ���� v_num
	static boolean execute_flag = true;

	// �� ���� ������ ����? �� static�� �ٿ���� ����?... �� ���̸� error �߳�

	public static void main(String args[]) throws IOException {

		AdjList LG1 = new AdjList(); // ���� ����Ʈ ����

		v_num = oilPrice.numOfVertex(); // Excel ���Ͽ� �ִ� vertex ���� ���ؼ� v_num�� ����

		// System.out.println();
		System.out.println("vertex ������ " + v_num + "�� �Դϴ�!");
		// System.out.println();

		for (int i = 0; i < v_num; i++) { // ���߿� ���� vertex�� ������ ����
			LG1.insertVertex(i);
		}

		for (int j = 0; j < v_num - 1; j++) { // edge ���� ��� �� ���� ���� �ʿ� (edge�� weight�� �Ÿ� �ο� ����)

			LG1.insertEdge(j, j + 1);
			LG1.insertEdge(j + 1, j);// ����� ǥ��?, �ӽ÷� edge ���� (�����)
		}

		// System.out.println("< ��ӵ��� �������� vertex�� ��������Ʈ > ");
		// System.out.println();

		// LG1.printAdjList(); // ��������Ʈ ��� (�����)

		// System.out.println();

		while (execute_flag) {

			System.out.println("\n�������� �⸧���� �˰� ���� ��¥�� �Է��ϼ���.(Data : 2018�� 01�� 01�� ~ 2018�� 10�� 15��)");
			System.out.println();
			System.out.println(
					"ex) 01�� 15�� -> 0115 �Է�, 05�� 17�� -> 0517 �Է�, 09�� 30�� -> 093E (*���� : ������ 0�� E�� �Է�, 0930 -> 093E)");
			System.out.println();
			System.out.println("(���α׷��� �����ϰ� ������ 0�� �Է��ϼ���.)\n");
			// ������ 0 E�� �Է��ؾ� �ϴ� �κп� ���ؼ� �˾ƺ� �ʿ�

			Scanner scan = new Scanner(System.in);
			date = scan.next();

			System.out.println(date.toString().substring(0, 2) + "�� " + date.toString().substring(2, 4) + "��"
					+ " ��ӵ��κ� ������ �⸧�� ��Ȳ�Դϴ�.\n");

			if (date.equals("0")) {

				System.out.println("���α׷��� �����մϴ�!");
				execute_flag = false;
			}

			LG1.insertWeight_1(oilPrice.weight_1_OfVertex(v_num, date)); // �⸧���� weight_1�� �� vertex�� inserting

			System.out.println();
			System.out.println(date.toString().substring(0, 2) + "�� " + date.toString().substring(2, 4) + "��"
					+ " ��� ��ӵ��� ������ �⸧�� ��Ȳ�Դϴ�.\n");
			System.out.println();
			LG1.printWeight_1(); // weight_1 �� �����ֱ�

		}
	}
}