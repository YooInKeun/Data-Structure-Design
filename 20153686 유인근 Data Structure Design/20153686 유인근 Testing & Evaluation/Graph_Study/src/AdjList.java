import java.io.IOException;

class AdjList {

	GraphNode gNode = new GraphNode();
	private GraphNode head[] = new GraphNode[150]; // vertex의 head 정보, main의 v_num 이용해서 개수 조정하자?
	private int totalV = 0; // vertex 총 개수 저장하는 totalV
	DataBring stationName = new DataBring(); // 주유소명 데이터 불러올 stationName 객체

	String[] oilst = new String[150]; // 주유소명 저장할 string 배열 oilst (실험용)

	public void insertVertex(int v) {// vertex 생성하는 메소드 (vertex 총 개수인 totalV 계산)

		totalV++;
	}

	public void insertEdge(int v1, int v2) { // vertex간의 edge 연결하는 메소드
		if (v1 >= totalV || v2 >= totalV)
			System.out.println("그래프에 없는 정점입니다!!");
		else { // head[]에 정보 저장되는 건가 보네?
				// GraphNode gNode = new GraphNode();
			gNode.vertex = v2;
			gNode.link = head[v1];
			head[v1] = gNode;
		}
	}

	public void printAdjList() throws IOException { // vertex 목록 및 인접리스트 출력 메소드

		GraphNode gNode = new GraphNode(); // 이거 없애면 에러 뜨네?

		String[] oilst = new String[stationName.numOfVertex()];

		oilst = stationName.nameOfVertex();

		System.out.println("vertex 목록은 다음과 같습니다");
		System.out.println();

		for (int i = 0; i < totalV; i++) {
			System.out.println(oilst[i]);

		}

		System.out.println();
		System.out.println("인접리스트 목록은 다음과 같습니다.");
		// System.out.println();

		for (int i = 0; i < totalV; i++) {
			System.out.printf("\n%s ", oilst[i]);
			gNode = head[i]; // head에 있는 정보 gNode에 저장해서?
			while (gNode != null) {
				System.out.printf("-> %s", oilst[gNode.vertex]);
				gNode = gNode.link;
			}
		}
	}

	public void insertWeight_1(double[] w) { // main에서 엑셀에 있는 weight_1 값을 불러와서 배열에 할당하는 메소드

		gNode.weight_1 = w;
	}

	public void printWeight_1() throws IOException { // 주유소별 기름값인 weight_1 출력 메소드

		String[] oilst = new String[stationName.numOfVertex()];

		oilst = stationName.nameOfVertex();

		String name_tmp;
		double weight_1_tmp;

		for (int i = 0; i < totalV; i++) { // 오름차순 정렬 (순위 구하기 위해)

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

			System.out.println((i + 1) + " 위 " + oilst[i] + " 기름값 : " + gNode.weight_1[i] + "원");

		}

	}
}