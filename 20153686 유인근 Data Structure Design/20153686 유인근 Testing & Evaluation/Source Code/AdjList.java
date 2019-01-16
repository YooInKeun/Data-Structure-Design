import java.io.IOException;

class AdjList {

	GraphNode gNode = new GraphNode();
	private GraphNode head[] = new GraphNode[150]; // vertex�� head ����, main�� v_num �̿��ؼ� ���� ��������?
	private int totalV = 0; // vertex �� ���� �����ϴ� totalV
	DataBring stationName = new DataBring(); // �����Ҹ� ������ �ҷ��� stationName ��ü

	String[] oilst = new String[150]; // �����Ҹ� ������ string �迭 oilst (�����)

	public void insertVertex(int v) {// vertex �����ϴ� �޼ҵ� (vertex �� ������ totalV ���)

		totalV++;
	}

	public void insertEdge(int v1, int v2) { // vertex���� edge �����ϴ� �޼ҵ�
		if (v1 >= totalV || v2 >= totalV)
			System.out.println("�׷����� ���� �����Դϴ�!!");
		else { // head[]�� ���� ����Ǵ� �ǰ� ����?
				// GraphNode gNode = new GraphNode();
			gNode.vertex = v2;
			gNode.link = head[v1];
			head[v1] = gNode;
		}
	}

	public void printAdjList() throws IOException { // vertex ��� �� ��������Ʈ ��� �޼ҵ�

		GraphNode gNode = new GraphNode(); // �̰� ���ָ� ���� �߳�?

		String[] oilst = new String[stationName.numOfVertex()];

		oilst = stationName.nameOfVertex();

		System.out.println("vertex ����� ������ �����ϴ�");
		System.out.println();

		for (int i = 0; i < totalV; i++) {
			System.out.println(oilst[i]);

		}

		System.out.println();
		System.out.println("��������Ʈ ����� ������ �����ϴ�.");
		// System.out.println();

		for (int i = 0; i < totalV; i++) {
			System.out.printf("\n%s ", oilst[i]);
			gNode = head[i]; // head�� �ִ� ���� gNode�� �����ؼ�?
			while (gNode != null) {
				System.out.printf("-> %s", oilst[gNode.vertex]);
				gNode = gNode.link;
			}
		}
	}

	public void insertWeight_1(double[] w) { // main���� ������ �ִ� weight_1 ���� �ҷ��ͼ� �迭�� �Ҵ��ϴ� �޼ҵ�

		gNode.weight_1 = w;
	}

	public void printWeight_1() throws IOException { // �����Һ� �⸧���� weight_1 ��� �޼ҵ�

		String[] oilst = new String[stationName.numOfVertex()];

		oilst = stationName.nameOfVertex();

		String name_tmp;
		double weight_1_tmp;

		for (int i = 0; i < totalV; i++) { // �������� ���� (���� ���ϱ� ����)

			for (int j = 0; j < totalV - 1; j++) {

				if (gNode.weight_1[j] > gNode.weight_1[j + 1]) {

					weight_1_tmp = gNode.weight_1[j];
					gNode.weight_1[j] = gNode.weight_1[j + 1];
					gNode.weight_1[j + 1] = weight_1_tmp;

					name_tmp = oilst[j];
					oilst[j] = oilst[j + 1];
					oilst[j + 1] = name_tmp;
				}
			}
		}

		for (int i = 0; i < totalV; i++) {

			System.out.println((i + 1) + " �� " + oilst[i] + " �⸧�� : " + gNode.weight_1[i] + "��");

		}

	}
}