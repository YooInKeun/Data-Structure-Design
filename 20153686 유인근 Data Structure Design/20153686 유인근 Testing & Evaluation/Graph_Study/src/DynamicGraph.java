import java.io.IOException;
import java.util.Scanner;

class DynamicGraph { // 코드 최적화, 클래스명, 함수명, 구조, 출처 등은 마지막게 신경쓰자... 구현이 우선!

	static String date; // 날짜 입력 시 필요한 date 스트링
	static DataBring oilPrice = new DataBring(); // main에 데이터 가져올 oilPrice 객체
	static int v_num; // vertex 개수 저장할 변수 v_num
	static boolean execute_flag = true;

	// 왜 전역 변수로 선언? 왜 static을 붙여줘야 하지?... 안 붙이면 error 뜨네

	public static void main(String args[]) throws IOException {

		AdjList LG1 = new AdjList(); // 인접 리스트 생성

		v_num = oilPrice.numOfVertex(); // Excel 파일에 있는 vertex 개수 구해서 v_num에 저장

		// System.out.println();
		System.out.println("vertex 개수는 " + v_num + "개 입니다!");
		// System.out.println();

		for (int i = 0; i < v_num; i++) { // 나중에 도시 vertex도 생성할 예정
			LG1.insertVertex(i);
		}

		for (int j = 0; j < v_num - 1; j++) { // edge 연결 방법 및 개수 수정 필요 (edge의 weight로 거리 부여 예정)

			LG1.insertEdge(j, j + 1);
			LG1.insertEdge(j + 1, j);// 양방향 표현?, 임시로 edge 연결 (실험용)
		}

		// System.out.println("< 고속도로 주유소의 vertex와 인접리스트 > ");
		// System.out.println();

		// LG1.printAdjList(); // 인접리스트 출력 (실험용)

		// System.out.println();

		while (execute_flag) {

			System.out.println("\n주유소의 기름값을 알고 싶은 날짜를 입력하세요.(Data : 2018년 01월 01일 ~ 2018년 10월 15일)");
			System.out.println();
			System.out.println(
					"ex) 01월 15일 -> 0115 입력, 05월 17일 -> 0517 입력, 09월 30일 -> 093E (*주의 : 마지막 0은 E로 입력, 0930 -> 093E)");
			System.out.println();
			System.out.println("(프로그램을 종료하고 싶으면 0을 입력하세요.)\n");
			// 마지막 0 E로 입력해야 하는 부분에 대해서 알아볼 필요

			Scanner scan = new Scanner(System.in);
			date = scan.next();

			System.out.println(date.toString().substring(0, 2) + "월 " + date.toString().substring(2, 4) + "일"
					+ " 고속도로별 주유소 기름값 현황입니다.\n");

			if (date.equals("0")) {

				System.out.println("프로그램을 종료합니다!");
				execute_flag = false;
			}

			LG1.insertWeight_1(oilPrice.weight_1_OfVertex(v_num, date)); // 기름값인 weight_1을 각 vertex에 inserting

			System.out.println();
			System.out.println(date.toString().substring(0, 2) + "월 " + date.toString().substring(2, 4) + "일"
					+ " 모든 고속도로 주유소 기름값 현황입니다.\n");
			System.out.println();
			LG1.printWeight_1(); // weight_1 값 보여주기

		}
	}
}