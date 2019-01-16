import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataBring {

	String[] name = {}; // 주유소 이름 저장시킬 배열

	int cnt = 0; // vertex 개수 저장

	public void priceData(String date, String[] oilst) throws IOException { // Excel Data 값 잘 출력되는지 확인용 메소드

		int column = 0;
		// String filePath = "c:\\test.xls";
		// FileInputStream fins = new FileInputStream(filePath); // 나중에 파일 여러 개 일 때 적용

		FileInputStream fis = new FileInputStream(new File("고속도로 주유소(20180101~20181016).xlsx"));

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		FormulaEvaluator forlulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

		int rowNum = sheet.getLastRowNum(); // 마지막 Row 수
		int cellNum = sheet.getRow(0).getLastCellNum(); // 첫 Row의 유효한 셀 수

		for (int a = 1; a <= rowNum; a++) { // 2행부터 출력
			XSSFRow row = sheet.getRow(a); // first index = 0

			XSSFCell cell1 = row.getCell(4);

			if ((cell1.toString().substring(5, 9)).equals(date)) {

				column = 2; // 3열만 (고속도로 주유소 이름)

				XSSFCell cell = row.getCell(column);
				String cellValue = cell.toString();
				System.out.print(cellValue);

				System.out.print("  ");

				column = 8; // 9열만 (기름값)

				XSSFCell cell2 = row.getCell(column);
				String cellValue1 = cell1.toString();
				System.out.print(cellValue1);

				System.out.println();
			}
		}
		System.out.println();

		System.out.println();
	}

	public int numOfVertex() throws IOException { // vertex 개수 계산해, 리턴하는 메소드

		String tmp = null;

		cnt = 0;

		FileInputStream fis = new FileInputStream(new File("고속도로 주유소(20180101~20181016).xlsx"));

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		FormulaEvaluator forlulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

		int rowNum = sheet.getLastRowNum(); // 마지막 Row 수
		int cellNum = sheet.getRow(0).getLastCellNum(); // 첫 Row의 유효한 셀 수

		for (int i = 1; i < rowNum; i++) {

			XSSFRow row = sheet.getRow(i);

			XSSFCell cell3 = row.getCell(2);

			String cellValue = cell3.toString();

			if (!(cellValue.equals(tmp))) { // vertex 이름 탐색 (겹치는 거 제외시키기)
				cnt++; // vertex 개수 세기
			}

			tmp = cellValue;

		}
		// System.out.println("numOfVertex 성공");
		return cnt;
	}

	public String[] nameOfVertex() throws IOException { // vertex 이름 리턴하는 메소드

		String tmp = null;
		int count = 0; // 지역번수로 만들어줄까

		String[] name = new String[cnt]; // vertex 개수인 cnt 갯수만큼 String 배열 생성

		FileInputStream fis = new FileInputStream(new File("고속도로 주유소(20180101~20181016).xlsx"));

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		FormulaEvaluator forlulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

		int rowNum = sheet.getLastRowNum(); // 마지막 Row 수
		int cellNum = sheet.getRow(0).getLastCellNum(); // 첫 Row의 유효한 셀 수

		for (int i = 1; i < rowNum; i++) {

			XSSFRow row = sheet.getRow(i);

			XSSFCell cell4 = row.getCell(2);

			String cellValue = cell4.toString();

			if (!(cellValue.equals(tmp))) { // vertex 이름 탐색 (겹치는 거 제외시키기)
				name[count] = cellValue;
				count++; // vertex 개수 세기
			}
			tmp = cellValue;
		}

		// System.out.println();
		// System.out.println("nameOfVertex 성공");
		// System.out.println();

		return name;

	}

	public double[] weight_1_OfVertex(int v_num, String date) throws IOException { // vertex의 기름값인, weight_1 값 리턴해주는 메소드

		double[] weight_1 = new double[v_num];

		String tmp = null;

		String[] name = new String[cnt]; // vertex 개수인 cnt 갯수만큼 String 배열 생성

		String[] GB = new String[20];
		String[] YD = new String[20];
		String[] DH = new String[20];
		String[] SYY = new String[20];
		String[] SUK = new String[20];
		String[] GRPC = new String[20];
		String[] SPTJCG = new String[20];
		String[] JBNL = new String[20];
		String[] SDKJLSH = new String[20];
		String[] JB = new String[20];
		String[] PYSH = new String[20];
		String[] SHA = new String[20];
		String[] TYDJ = new String[20];
		String[] NH = new String[20];
		String[] JA = new String[20];
		String[] PPOLP = new String[20];
		String[] JBNLJS = new String[20];
		String[] HN = new String[20];
		String[] SCWJ = new String[20];
		String[] GCDS = new String[20];
		String[] ISJS = new String[20];
		String[] DJYD = new String[20];
		String[] NSCA = new String[20];
		String[] SCGJ = new String[20];

		int[] GBweight_1 = new int[20];
		int[] YDweight_1 = new int[20];
		int[] DHweight_1 = new int[20];
		int[] SYYweight_1 = new int[20];
		int[] SUKweight_1 = new int[20];
		int[] GRPCweight_1 = new int[20];
		int[] SPTJCGweight_1 = new int[20];
		int[] JBNLweight_1 = new int[20];
		int[] SDKJLSHweight_1 = new int[20];
		int[] JBweight_1 = new int[20];
		int[] PYSHweight_1 = new int[20];
		int[] SHAweight_1 = new int[20];
		int[] TYDJweight_1 = new int[20];
		int[] NHweight_1 = new int[20];
		int[] JAweight_1 = new int[20];
		int[] PPOLPweight_1 = new int[20];
		int[] JBNLJSweight_1 = new int[20];
		int[] HNweight_1 = new int[20];
		int[] SCWJweight_1 = new int[20];
		int[] GCDSweight_1 = new int[20];
		int[] ISJSweight_1 = new int[20];
		int[] DJYDweight_1 = new int[20];
		int[] NSCAweight_1 = new int[20];
		int[] SCGJweight_1 = new int[20];

		int count = 0;
		int name_cnt = 0;
		int hwname_cnt = 0;

		int GB_cnt = 0; // 경부고속도로 배열 count
		int YD_cnt = 0; // 영동고속도로 배열 count
		int DH_cnt = 0; // 동해고속도로 배열 count
		int SYY_cnt = 0; // 서울양양고속도로 배열 count
		int SUK_cnt = 0; // 서울외곽순환고속도로 배열 count
		int GRPC_cnt = 0; // 구리포천고속도로 배열 count
		int SPTJCG_cnt = 0; // 서평택 제천간 고속도로 배열 count
		int JBNL_cnt = 0; // 중부내륙고속도로 배열 count
		int SDKJLSH_cnt = 0; // 수도권제2순환고속도로 배열 count
		int JB_cnt = 0; // 중부내륙고속도로 count
		int PTSH_cnt = 0; // 평택시흥고속도로 count
		int SHA_cnt = 0; // 서해안고속도로 count
		int TYDJ_cnt = 0; // 통영대전고속도로 count
		int NH_cnt = 0; // 남해고속도로 count
		int JA_cnt = 0; // 중앙고속도로 count
		int PPOLP_cnt = 0; // 88올림픽고속도로 count
		int JBNLJS_cnt = 0; // 중뷰내륙지선고속도로 count
		int HN_cnt = 0; // 호남고속도로 count
		int SCWJ_cnt = 0; // 순천완주고속도로 count
		int GCDS_cnt = 0; // 갑천도시고속도로 count
		int ISJS_cnt = 0; // 익산장수고속도로 count
		int DJYD_cnt = 0; // 당진영덕고속도로 count
		int NSCA_cnt = 0; // 논산천안고속도로 count
		int SCGJ_cnt = 0; // 서천공주고속도로 count

		int[] highway_cnt = { GB_cnt, YD_cnt, DH_cnt, SYY_cnt, SUK_cnt, GRPC_cnt, SPTJCG_cnt, JBNL_cnt, SDKJLSH_cnt,
				JB_cnt, PTSH_cnt, SHA_cnt, TYDJ_cnt, NH_cnt, JA_cnt, PPOLP_cnt, JBNLJS_cnt, HN_cnt, SCWJ_cnt, GCDS_cnt,
				ISJS_cnt, DJYD_cnt, NSCA_cnt, SCGJ_cnt };

		String[] highway_name = { "경부고속도로", "영동고속도로", "동해고속도로", "서울양양고속도로", "서울외곽순환고속도로", "구리포천고속도로", "서평택 제천간 고속도로",
				"중부내륙고속도로", "수도권제2순환고속도로", "중부내륙고속도로", "평택시흥고속도로", "서해안고속도로", "통영대전고속도로", "남해고속도로", "중앙고속도로",
				"88올림픽고속도로", "중뷰내륙지선고속도로", "호남고속도로", "순천완주고속도로", "갑천도시고속도로", "익산장수고속도로", "당진영덕고속도로", "논산천안고속도로",
				"서천공주고속도로" };

		FileInputStream fis = new FileInputStream(new File("고속도로 주유소(20180101~20181016).xlsx"));

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		FormulaEvaluator forlulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

		int rowNum = sheet.getLastRowNum(); // 마지막 Row 수
		int cellNum = sheet.getRow(0).getLastCellNum(); // 첫 Row의 유효한 셀 수

		for (int i = 1; i < rowNum; i++) {

			XSSFRow row = sheet.getRow(i);

			XSSFCell cell4 = row.getCell(2);

			String cellValue = cell4.toString();

			if (!(cellValue.equals(tmp))) { // vertex 이름 탐색 (겹치는 거 제외시키기)
				name[count] = cellValue;
				count++; // vertex 개수 세기
			}
			tmp = cellValue;

		}

		for (int a = 1; a <= rowNum; a++) { // 2행부터 출력
			XSSFRow row = sheet.getRow(a); // first index = 0

			XSSFCell cell5 = row.getCell(4);
			XSSFCell cell6 = row.getCell(2); // 3열만 (주유소명)
			XSSFCell cell7 = row.getCell(3); // 4열만 (주소)
			XSSFCell cell1 = row.getCell(8); // 9열만(기름값)

			String cellValue1 = cell1.toString();

			if (cell5.toString().substring(5, 9).equals(date)) {

				if (name[name_cnt].equals(cell6.toString())) {

					weight_1[name_cnt] = Double.parseDouble(cellValue1);

					
					
					// 여기서부터는 원래 Algorithm class에서 구현해야 되는데, 그러지 못해 if for 문이 너무 많아 지저분....

					
					
					if (cell7.toString().contains(highway_name[0])) {

						GB[highway_cnt[0]] = name[name_cnt];
						GBweight_1[highway_cnt[0]] = (int) weight_1[name_cnt];
						// System.out.println(GB[highway_cnt[0]]);
						highway_cnt[0]++;

					}

					else if (cell7.toString().contains(highway_name[1])) {

						YD[highway_cnt[1]] = name[name_cnt];
						YDweight_1[highway_cnt[1]] = (int) weight_1[name_cnt];
						highway_cnt[1]++;
					}

					else if (cell7.toString().contains(highway_name[2])) {

						DH[highway_cnt[2]] = name[name_cnt];
						DHweight_1[highway_cnt[2]] = (int) weight_1[name_cnt];
						highway_cnt[2]++;
					}

					else if (cell7.toString().contains(highway_name[3])) {

						SYY[highway_cnt[3]] = name[name_cnt];
						SYYweight_1[highway_cnt[3]] = (int) weight_1[name_cnt];
						highway_cnt[3]++;
					}

					else if (cell7.toString().contains(highway_name[4])) {

						SUK[highway_cnt[4]] = name[name_cnt];
						SUKweight_1[highway_cnt[4]] = (int) weight_1[name_cnt];
						highway_cnt[4]++;
					}

					else if (cell7.toString().contains(highway_name[5])) {

						GRPC[highway_cnt[5]] = name[name_cnt];
						GRPCweight_1[highway_cnt[5]] = (int) weight_1[name_cnt];
						highway_cnt[5]++;
					}

					else if (cell7.toString().contains(highway_name[6])) {

						SPTJCG[highway_cnt[6]] = name[name_cnt];
						SPTJCGweight_1[highway_cnt[6]] = (int) weight_1[name_cnt];
						highway_cnt[6]++;
					}

					else if (cell7.toString().contains(highway_name[7])) {

						JBNL[highway_cnt[7]] = name[name_cnt];
						JBNLweight_1[highway_cnt[7]] = (int) weight_1[name_cnt];
						highway_cnt[7]++;
					}

					else if (cell7.toString().contains(highway_name[8])) {

						SDKJLSH[highway_cnt[8]] = name[name_cnt];
						SDKJLSHweight_1[highway_cnt[8]] = (int) weight_1[name_cnt];
						highway_cnt[8]++;
					}

					else if (cell7.toString().contains(highway_name[9])) {

						JB[highway_cnt[9]] = name[name_cnt];
						JBweight_1[highway_cnt[9]] = (int) weight_1[name_cnt];
						highway_cnt[9]++;
					}

					else if (cell7.toString().contains(highway_name[10])) {

						PYSH[highway_cnt[10]] = name[name_cnt];
						PYSHweight_1[highway_cnt[10]] = (int) weight_1[name_cnt];
						highway_cnt[10]++;
					}

					else if (cell7.toString().contains(highway_name[11])) {

						SHA[highway_cnt[11]] = name[name_cnt];
						SHAweight_1[highway_cnt[11]] = (int) weight_1[name_cnt];
						highway_cnt[11]++;
					}

					else if (cell7.toString().contains(highway_name[12])) {

						TYDJ[highway_cnt[12]] = name[name_cnt];
						TYDJweight_1[highway_cnt[12]] = (int) weight_1[name_cnt];
						highway_cnt[12]++;
					}

					else if (cell7.toString().contains(highway_name[13])) {

						NH[highway_cnt[13]] = name[name_cnt];
						NHweight_1[highway_cnt[13]] = (int) weight_1[name_cnt];
						highway_cnt[13]++;
					}

					else if (cell7.toString().contains(highway_name[14])) {

						JA[highway_cnt[14]] = name[name_cnt];
						JAweight_1[highway_cnt[14]] = (int) weight_1[name_cnt];
						highway_cnt[14]++;
					}

					else if (cell7.toString().contains(highway_name[15])) {

						PPOLP[highway_cnt[15]] = name[name_cnt];
						PPOLPweight_1[highway_cnt[15]] = (int) weight_1[name_cnt];
						highway_cnt[15]++;
					}

					else if (cell7.toString().contains(highway_name[16])) {

						JBNLJS[highway_cnt[16]] = name[name_cnt];
						JBNLJSweight_1[highway_cnt[16]] = (int) weight_1[name_cnt];
						highway_cnt[16]++;
					}

					else if (cell7.toString().contains(highway_name[17])) {

						HN[highway_cnt[17]] = name[name_cnt];
						HNweight_1[highway_cnt[17]] = (int) weight_1[name_cnt];
						highway_cnt[17]++;
					}

					else if (cell7.toString().contains(highway_name[18])) {

						SCWJ[highway_cnt[18]] = name[name_cnt];
						SCWJweight_1[highway_cnt[18]] = (int) weight_1[name_cnt];
						highway_cnt[18]++;
					}

					else if (cell7.toString().contains(highway_name[19])) {

						GCDS[highway_cnt[19]] = name[name_cnt];
						GCDSweight_1[highway_cnt[19]] = (int) weight_1[name_cnt];
						highway_cnt[19]++;
					}

					else if (cell7.toString().contains(highway_name[20])) {

						ISJS[highway_cnt[20]] = name[name_cnt];
						ISJSweight_1[highway_cnt[20]] = (int) weight_1[name_cnt];
						highway_cnt[20]++;
					}

					else if (cell7.toString().contains(highway_name[21])) {

						DJYD[highway_cnt[21]] = name[name_cnt];
						DJYDweight_1[highway_cnt[21]] = (int) weight_1[name_cnt];
						highway_cnt[21]++;
					}

					else if (cell7.toString().contains(highway_name[22])) {

						NSCA[highway_cnt[22]] = name[name_cnt];
						NSCAweight_1[highway_cnt[22]] = (int) weight_1[name_cnt];
						highway_cnt[22]++;
					}

					else if (cell7.toString().contains(highway_name[23])) {

						SCGJ[highway_cnt[23]] = name[name_cnt];
						SCGJweight_1[highway_cnt[23]] = (int) weight_1[name_cnt];
						highway_cnt[23]++;
					}

					name_cnt++;

				}

				else if (!(name[name_cnt].equals(cell6.toString()))) {

					weight_1[name_cnt] = 9999.00;

					if (cell7.toString().contains(highway_name[0])) {

						GB[highway_cnt[0]] = name[name_cnt];
						GBweight_1[highway_cnt[0]] = (int) weight_1[name_cnt];
						highway_cnt[0]++;
					}

					else if (cell7.toString().contains(highway_name[1])) {

						YD[highway_cnt[1]] = name[name_cnt];
						YDweight_1[highway_cnt[1]] = (int) weight_1[name_cnt];
						highway_cnt[1]++;
					}

					else if (cell7.toString().contains(highway_name[2])) {

						DH[highway_cnt[2]] = name[name_cnt];
						DHweight_1[highway_cnt[2]] = (int) weight_1[name_cnt];
						highway_cnt[2]++;
					}

					else if (cell7.toString().contains(highway_name[3])) {

						SYY[highway_cnt[3]] = name[name_cnt];
						SYYweight_1[highway_cnt[3]] = (int) weight_1[name_cnt];
						highway_cnt[3]++;
					}

					else if (cell7.toString().contains(highway_name[4])) {

						SUK[highway_cnt[4]] = name[name_cnt];
						SUKweight_1[highway_cnt[4]] = (int) weight_1[name_cnt];
						highway_cnt[4]++;
					}

					else if (cell7.toString().contains(highway_name[5])) {

						GRPC[highway_cnt[5]] = name[name_cnt];
						GRPCweight_1[highway_cnt[5]] = (int) weight_1[name_cnt];
						highway_cnt[5]++;
					}

					else if (cell7.toString().contains(highway_name[6])) {

						SPTJCG[highway_cnt[6]] = name[name_cnt];
						SPTJCGweight_1[highway_cnt[6]] = (int) weight_1[name_cnt];
						highway_cnt[6]++;
					}

					else if (cell7.toString().contains(highway_name[7])) {

						JBNL[highway_cnt[7]] = name[name_cnt];
						JBNLweight_1[highway_cnt[7]] = (int) weight_1[name_cnt];
						highway_cnt[7]++;
					}

					else if (cell7.toString().contains(highway_name[8])) {

						SDKJLSH[highway_cnt[8]] = name[name_cnt];
						SDKJLSHweight_1[highway_cnt[8]] = (int) weight_1[name_cnt];
						highway_cnt[8]++;
					}

					else if (cell7.toString().contains(highway_name[9])) {

						JB[highway_cnt[9]] = name[name_cnt];
						JBweight_1[highway_cnt[9]] = (int) weight_1[name_cnt];
						highway_cnt[9]++;
					}

					else if (cell7.toString().contains(highway_name[10])) {

						PYSH[highway_cnt[10]] = name[name_cnt];
						PYSHweight_1[highway_cnt[10]] = (int) weight_1[name_cnt];
						highway_cnt[10]++;
					}

					else if (cell7.toString().contains(highway_name[11])) {

						SHA[highway_cnt[11]] = name[name_cnt];
						SHAweight_1[highway_cnt[11]] = (int) weight_1[name_cnt];
						highway_cnt[11]++;
					}

					else if (cell7.toString().contains(highway_name[12])) {

						TYDJ[highway_cnt[12]] = name[name_cnt];
						TYDJweight_1[highway_cnt[12]] = (int) weight_1[name_cnt];
						highway_cnt[12]++;
					}

					else if (cell7.toString().contains(highway_name[13])) {

						NH[highway_cnt[13]] = name[name_cnt];
						NHweight_1[highway_cnt[13]] = (int) weight_1[name_cnt];
						highway_cnt[13]++;
					}

					else if (cell7.toString().contains(highway_name[14])) {

						JA[highway_cnt[14]] = name[name_cnt];
						JAweight_1[highway_cnt[14]] = (int) weight_1[name_cnt];
						highway_cnt[14]++;
					}

					else if (cell7.toString().contains(highway_name[15])) {

						PPOLP[highway_cnt[15]] = name[name_cnt];
						PPOLPweight_1[highway_cnt[15]] = (int) weight_1[name_cnt];
						highway_cnt[15]++;
					}

					else if (cell7.toString().contains(highway_name[16])) {

						JBNLJS[highway_cnt[16]] = name[name_cnt];
						JBNLJSweight_1[highway_cnt[16]] = (int) weight_1[name_cnt];
						highway_cnt[16]++;
					}

					else if (cell7.toString().contains(highway_name[17])) {

						HN[highway_cnt[17]] = name[name_cnt];
						HNweight_1[highway_cnt[17]] = (int) weight_1[name_cnt];
						highway_cnt[17]++;
					}

					else if (cell7.toString().contains(highway_name[18])) {

						SCWJ[highway_cnt[18]] = name[name_cnt];
						SCWJweight_1[highway_cnt[18]] = (int) weight_1[name_cnt];
						highway_cnt[18]++;
					}

					else if (cell7.toString().contains(highway_name[19])) {

						GCDS[highway_cnt[19]] = name[name_cnt];
						GCDSweight_1[highway_cnt[19]] = (int) weight_1[name_cnt];
						highway_cnt[19]++;
					}

					else if (cell7.toString().contains(highway_name[20])) {

						ISJS[highway_cnt[20]] = name[name_cnt];
						ISJSweight_1[highway_cnt[20]] = (int) weight_1[name_cnt];
						highway_cnt[20]++;
					}

					else if (cell7.toString().contains(highway_name[21])) {

						DJYD[highway_cnt[21]] = name[name_cnt];
						DJYDweight_1[highway_cnt[21]] = (int) weight_1[name_cnt];
						highway_cnt[21]++;
					}

					else if (cell7.toString().contains(highway_name[22])) {

						NSCA[highway_cnt[22]] = name[name_cnt];
						NSCAweight_1[highway_cnt[22]] = (int) weight_1[name_cnt];
						highway_cnt[22]++;
					}

					else if (cell7.toString().contains(highway_name[23])) {

						SCGJ[highway_cnt[23]] = name[name_cnt];
						SCGJweight_1[highway_cnt[23]] = (int) weight_1[name_cnt];
						highway_cnt[23]++;
					}

					name_cnt++;
					a--;
				}

			}
		}

		String name_tmp;
		int weight_1_tmp;

		int GBlength;
		int YDlength;
		int DHlength;
		int SYYlength;
		int SUKlength;
		int GRPClength;
		int SPTJCGlength;
		int JBNLlength;
		int SDKJLSHlength;
		int JBlength;
		int PYSHlength;
		int SHAlength;
		int TYDJlength;
		int NHlength;
		int JAlength;
		int PPOLPlength;
		int JBNLJSlength;
		int HNlength;

		int SCWJlength;
		int GCDSlength;
		int ISJSlength;
		int DJYDlength;
		int NSCAlength;
		int SCGJlength;

		for (GBlength = 0; GB[GBlength] != null; GBlength++)
			;
		for (YDlength = 0; YD[YDlength] != null; YDlength++)
			;
		for (DHlength = 0; DH[DHlength] != null; DHlength++)
			;
		for (SYYlength = 0; SYY[SYYlength] != null; SYYlength++)
			;
		for (SUKlength = 0; SUK[SUKlength] != null; SUKlength++)
			;
		for (GRPClength = 0; GRPC[GRPClength] != null; GRPClength++)
			;
		for (SPTJCGlength = 0; SPTJCG[SPTJCGlength] != null; SPTJCGlength++)
			;
		for (JBNLlength = 0; JBNL[JBNLlength] != null; JBNLlength++)
			;
		for (SDKJLSHlength = 0; SDKJLSH[SDKJLSHlength] != null; SDKJLSHlength++)
			;
		for (JBlength = 0; JB[JBlength] != null; JBlength++)
			;
		for (PYSHlength = 0; PYSH[GBlength] != null; PYSHlength++)
			;
		for (SHAlength = 0; SHA[SHAlength] != null; SHAlength++)
			;
		for (TYDJlength = 0; TYDJ[TYDJlength] != null; TYDJlength++)
			;
		for (NHlength = 0; NH[NHlength] != null; NHlength++)
			;
		for (JAlength = 0; JA[JAlength] != null; JAlength++)
			;
		for (PPOLPlength = 0; PPOLP[PPOLPlength] != null; PPOLPlength++)
			;
		for (JBNLJSlength = 0; JBNLJS[GBlength] != null; JBNLJSlength++)
			;
		for (HNlength = 0; HN[HNlength] != null; HNlength++)
			;
		for (SCWJlength = 0; SCWJ[SCWJlength] != null; SCWJlength++)
			;
		for (GCDSlength = 0; GCDS[GCDSlength] != null; GCDSlength++)
			;
		for (ISJSlength = 0; ISJS[ISJSlength] != null; ISJSlength++)
			;
		for (DJYDlength = 0; DJYD[DJYDlength] != null; DJYDlength++)
			;
		for (NSCAlength = 0; NSCA[NSCAlength] != null; NSCAlength++)
			;
		for (SCGJlength = 0; SCGJ[SCGJlength] != null; SCGJlength++)
			;

		for (int j = 0; GB[j] != null; j++) {
			for (int k = 0; k < GBlength - 1; k++) {
				if (GBweight_1[k] > GBweight_1[k + 1]) {
					weight_1_tmp = GBweight_1[k];
					GBweight_1[k] = GBweight_1[k + 1];
					GBweight_1[k + 1] = weight_1_tmp;

					name_tmp = GB[k];
					GB[k] = GB[k + 1];
					GB[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; YD[j] != null; j++) {
			for (int k = 0; k < YDlength - 1; k++) {
				if (YDweight_1[k] > YDweight_1[k + 1]) {
					weight_1_tmp = YDweight_1[k];
					YDweight_1[k] = YDweight_1[k + 1];
					YDweight_1[k + 1] = weight_1_tmp;

					name_tmp = YD[k];
					YD[k] = YD[k + 1];
					YD[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; DH[j] != null; j++) {
			for (int k = 0; k < DHlength - 1; k++) {
				if (DHweight_1[k] > DHweight_1[k + 1]) {
					weight_1_tmp = DHweight_1[k];
					DHweight_1[k] = DHweight_1[k + 1];
					DHweight_1[k + 1] = weight_1_tmp;

					name_tmp = DH[k];
					DH[k] = DH[k + 1];
					DH[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; SYY[j] != null; j++) {
			for (int k = 0; k < SYYlength - 1; k++) {
				if (SYYweight_1[k] > SYYweight_1[k + 1]) {
					weight_1_tmp = SYYweight_1[k];
					SYYweight_1[k] = SYYweight_1[k + 1];
					SYYweight_1[k + 1] = weight_1_tmp;

					name_tmp = SYY[k];
					SYY[k] = SYY[k + 1];
					SYY[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; SUK[j] != null; j++) {
			for (int k = 0; k < SUKlength - 1; k++) {
				if (SUKweight_1[k] > SUKweight_1[k + 1]) {
					weight_1_tmp = SUKweight_1[k];
					SUKweight_1[k] = SUKweight_1[k + 1];
					SUKweight_1[k + 1] = weight_1_tmp;

					name_tmp = SUK[k];
					SUK[k] = SUK[k + 1];
					SUK[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; GRPC[j] != null; j++) {
			for (int k = 0; k < GRPClength - 1; k++) {
				if (GRPCweight_1[k] > GRPCweight_1[k + 1]) {
					weight_1_tmp = GRPCweight_1[k];
					GRPCweight_1[k] = GRPCweight_1[k + 1];
					GRPCweight_1[k + 1] = weight_1_tmp;

					name_tmp = GRPC[k];
					GRPC[k] = GRPC[k + 1];
					GRPC[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; SPTJCG[j] != null; j++) {
			for (int k = 0; k < SPTJCGlength - 1; k++) {
				if (SPTJCGweight_1[k] > SPTJCGweight_1[k + 1]) {
					weight_1_tmp = SPTJCGweight_1[k];
					SPTJCGweight_1[k] = SPTJCGweight_1[k + 1];
					SPTJCGweight_1[k + 1] = weight_1_tmp;

					name_tmp = SPTJCG[k];
					SPTJCG[k] = SPTJCG[k + 1];
					SPTJCG[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; JBNL[j] != null; j++) {
			for (int k = 0; k < JBNLlength - 1; k++) {
				if (JBNLweight_1[k] > JBNLweight_1[k + 1]) {
					weight_1_tmp = JBNLweight_1[k];
					JBNLweight_1[k] = JBNLweight_1[k + 1];
					JBNLweight_1[k + 1] = weight_1_tmp;

					name_tmp = JBNL[k];
					JBNL[k] = JBNL[k + 1];
					JBNL[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; SDKJLSH[j] != null; j++) {
			for (int k = 0; k < SDKJLSHlength - 1; k++) {
				if (SDKJLSHweight_1[k] > SDKJLSHweight_1[k + 1]) {
					weight_1_tmp = SDKJLSHweight_1[k];
					SDKJLSHweight_1[k] = SDKJLSHweight_1[k + 1];
					SDKJLSHweight_1[k + 1] = weight_1_tmp;

					name_tmp = SDKJLSH[k];
					SDKJLSH[k] = SDKJLSH[k + 1];
					SDKJLSH[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; JB[j] != null; j++) {
			for (int k = 0; k < JBlength - 1; k++) {
				if (JBweight_1[k] > JBweight_1[k + 1]) {
					weight_1_tmp = JBweight_1[k];
					JBweight_1[k] = JBweight_1[k + 1];
					JBweight_1[k + 1] = weight_1_tmp;

					name_tmp = JB[k];
					JB[k] = JB[k + 1];
					JB[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; PYSH[j] != null; j++) {
			for (int k = 0; k < PYSHlength - 1; k++) {
				if (PYSHweight_1[k] > PYSHweight_1[k + 1]) {
					weight_1_tmp = PYSHweight_1[k];
					PYSHweight_1[k] = PYSHweight_1[k + 1];
					PYSHweight_1[k + 1] = weight_1_tmp;

					name_tmp = PYSH[k];
					PYSH[k] = PYSH[k + 1];
					PYSH[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; SHA[j] != null; j++) {
			for (int k = 0; k < SHAlength - 1; k++) {
				if (SHAweight_1[k] > SHAweight_1[k + 1]) {
					weight_1_tmp = SHAweight_1[k];
					SHAweight_1[k] = SHAweight_1[k + 1];
					SHAweight_1[k + 1] = weight_1_tmp;

					name_tmp = SHA[k];
					SHA[k] = SHA[k + 1];
					SHA[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; TYDJ[j] != null; j++) {
			for (int k = 0; k < TYDJlength - 1; k++) {
				if (TYDJweight_1[k] > TYDJweight_1[k + 1]) {
					weight_1_tmp = TYDJweight_1[k];
					TYDJweight_1[k] = TYDJweight_1[k + 1];
					TYDJweight_1[k + 1] = weight_1_tmp;

					name_tmp = TYDJ[k];
					TYDJ[k] = TYDJ[k + 1];
					TYDJ[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; NH[j] != null; j++) {
			for (int k = 0; k < NHlength - 1; k++) {
				if (NHweight_1[k] > NHweight_1[k + 1]) {
					weight_1_tmp = NHweight_1[k];
					NHweight_1[k] = NHweight_1[k + 1];
					NHweight_1[k + 1] = weight_1_tmp;

					name_tmp = NH[k];
					NH[k] = NH[k + 1];
					NH[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; JA[j] != null; j++) {
			for (int k = 0; k < GBlength - 1; k++) {
				if (JAweight_1[k] > JAweight_1[k + 1]) {
					weight_1_tmp = JAweight_1[k];
					JAweight_1[k] = JAweight_1[k + 1];
					JAweight_1[k + 1] = weight_1_tmp;

					name_tmp = JA[k];
					JA[k] = JA[k + 1];
					JA[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; PPOLP[j] != null; j++) {
			for (int k = 0; k < PPOLPlength - 1; k++) {
				if (PPOLPweight_1[k] > PPOLPweight_1[k + 1]) {
					weight_1_tmp = PPOLPweight_1[k];
					PPOLPweight_1[k] = PPOLPweight_1[k + 1];
					PPOLPweight_1[k + 1] = weight_1_tmp;

					name_tmp = PPOLP[k];
					PPOLP[k] = PPOLP[k + 1];
					PPOLP[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; JBNLJS[j] != null; j++) {
			for (int k = 0; k < JBNLJSlength - 1; k++) {
				if (JBNLJSweight_1[k] > JBNLJSweight_1[k + 1]) {
					weight_1_tmp = JBNLJSweight_1[k];
					JBNLJSweight_1[k] = JBNLJSweight_1[k + 1];
					JBNLJSweight_1[k + 1] = weight_1_tmp;

					name_tmp = JBNLJS[k];
					JBNLJS[k] = JBNLJS[k + 1];
					JBNLJS[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; HN[j] != null; j++) {
			for (int k = 0; k < HNlength - 1; k++) {
				if (HNweight_1[k] > HNweight_1[k + 1]) {
					weight_1_tmp = HNweight_1[k];
					HNweight_1[k] = HNweight_1[k + 1];
					HNweight_1[k + 1] = weight_1_tmp;

					name_tmp = HN[k];
					HN[k] = HN[k + 1];
					HN[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; SCWJ[j] != null; j++) {
			for (int k = 0; k < SCWJlength - 1; k++) {
				if (SCWJweight_1[k] > SCWJweight_1[k + 1]) {
					weight_1_tmp = SCWJweight_1[k];
					SCWJweight_1[k] = SCWJweight_1[k + 1];
					SCWJweight_1[k + 1] = weight_1_tmp;

					name_tmp = SCWJ[k];
					SCWJ[k] = SCWJ[k + 1];
					SCWJ[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; GCDS[j] != null; j++) {
			for (int k = 0; k < GCDSlength - 1; k++) {
				if (GCDSweight_1[k] > GCDSweight_1[k + 1]) {
					weight_1_tmp = GCDSweight_1[k];
					GCDSweight_1[k] = GCDSweight_1[k + 1];
					GCDSweight_1[k + 1] = weight_1_tmp;

					name_tmp = GCDS[k];
					GCDS[k] = GCDS[k + 1];
					GCDS[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; ISJS[j] != null; j++) {
			for (int k = 0; k < ISJSlength - 1; k++) {
				if (ISJSweight_1[k] > ISJSweight_1[k + 1]) {
					weight_1_tmp = ISJSweight_1[k];
					ISJSweight_1[k] = ISJSweight_1[k + 1];
					ISJSweight_1[k + 1] = weight_1_tmp;

					name_tmp = ISJS[k];
					ISJS[k] = ISJS[k + 1];
					ISJS[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; DJYD[j] != null; j++) {
			for (int k = 0; k < DJYDlength - 1; k++) {
				if (DJYDweight_1[k] > DJYDweight_1[k + 1]) {
					weight_1_tmp = DJYDweight_1[k];
					DJYDweight_1[k] = DJYDweight_1[k + 1];
					DJYDweight_1[k + 1] = weight_1_tmp;

					name_tmp = DJYD[k];
					DJYD[k] = DJYD[k + 1];
					DJYD[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; NSCA[j] != null; j++) {
			for (int k = 0; k < NSCAlength - 1; k++) {
				if (NSCAweight_1[k] > NSCAweight_1[k + 1]) {
					weight_1_tmp = NSCAweight_1[k];
					NSCAweight_1[k] = NSCAweight_1[k + 1];
					NSCAweight_1[k + 1] = weight_1_tmp;

					name_tmp = NSCA[k];
					NSCA[k] = NSCA[k + 1];
					NSCA[k + 1] = name_tmp;
				}
			}
		}

		for (int j = 0; SCGJ[j] != null; j++) {
			for (int k = 0; k < SCGJlength - 1; k++) {
				if (SCGJweight_1[k] > SCGJweight_1[k + 1]) {
					weight_1_tmp = SCGJweight_1[k];
					SCGJweight_1[k] = SCGJweight_1[k + 1];
					SCGJweight_1[k + 1] = weight_1_tmp;

					name_tmp = SCGJ[k];
					SCGJ[k] = SCGJ[k + 1];
					SCGJ[k + 1] = name_tmp;
				}
			}
		}
		System.out.println();
		for (int i = 0; GB[i] != null; i++) {

			System.out
					.println(highway_name[0] + " 정보입니다. " + (i + 1) + " 위 " + GB[i] + " 기름값 : " + GBweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; YD[i] != null; i++) {

			System.out
					.println(highway_name[1] + " 정보입니다. " + (i + 1) + " 위 " + YD[i] + " 기름값 : " + YDweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; DH[i] != null; i++) {

			System.out
					.println(highway_name[2] + " 정보입니다. " + (i + 1) + " 위 " + DH[i] + " 기름값 : " + DHweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; SYY[i] != null; i++) {

			System.out.println(
					highway_name[3] + " 정보입니다. " + (i + 1) + " 위 " + SYY[i] + " 기름값 : " + SYYweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; SUK[i] != null; i++) {

			System.out.println(
					highway_name[4] + " 정보입니다. " + (i + 1) + " 위 " + SUK[i] + " 기름값 : " + SUKweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; GRPC[i] != null; i++) {

			System.out.println(
					highway_name[5] + " 정보입니다. " + (i + 1) + " 위 " + GRPC[i] + " 기름값 : " + GRPCweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; SPTJCG[i] != null; i++) {

			System.out.println(
					highway_name[6] + " 정보입니다. " + (i + 1) + " 위 " + SPTJCG[i] + " 기름값 : " + SPTJCGweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; JBNL[i] != null; i++) {

			System.out.println(
					highway_name[7] + " 정보입니다. " + (i + 1) + " 위 " + JBNL[i] + " 기름값 : " + JBNLweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; SDKJLSH[i] != null; i++) {

			System.out.println(
					highway_name[8] + " 정보입니다. " + (i + 1) + " 위 " + SDKJLSH[i] + " 기름값 : " + SDKJLSHweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; JB[i] != null; i++) {

			System.out
					.println(highway_name[9] + " 정보입니다. " + (i + 1) + " 위 " + JB[i] + " 기름값 : " + JBweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; PYSH[i] != null; i++) {

			System.out.println(
					highway_name[10] + " 정보입니다. " + (i + 1) + " 위 " + PYSH[i] + " 기름값 : " + PYSHweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; SHA[i] != null; i++) {

			System.out.println(
					highway_name[11] + " 정보입니다. " + (i + 1) + " 위 " + SHA[i] + " 기름값 : " + SHAweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; TYDJ[i] != null; i++) {

			System.out.println(
					highway_name[12] + " 정보입니다. " + (i + 1) + " 위 " + TYDJ[i] + " 기름값 : " + TYDJweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; NH[i] != null; i++) {

			System.out
					.println(highway_name[13] + " 정보입니다. " + (i + 1) + " 위 " + NH[i] + " 기름값 : " + NHweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; JA[i] != null; i++) {

			System.out
					.println(highway_name[14] + " 정보입니다. " + (i + 1) + " 위 " + JA[i] + " 기름값 : " + JAweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; PPOLP[i] != null; i++) {

			System.out.println(
					highway_name[15] + " 정보입니다. " + (i + 1) + " 위 " + PPOLP[i] + " 기름값 : " + PPOLPweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; JBNLJS[i] != null; i++) {

			System.out.println(
					highway_name[16] + " 정보입니다. " + (i + 1) + " 위 " + JBNLJS[i] + " 기름값 : " + JBNLJSweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; HN[i] != null; i++) {

			System.out
					.println(highway_name[17] + " 정보입니다. " + (i + 1) + " 위 " + HN[i] + " 기름값 : " + HNweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; SCWJ[i] != null; i++) {

			System.out.println(
					highway_name[18] + " 정보입니다. " + (i + 1) + " 위 " + SCWJ[i] + " 기름값 : " + SCWJweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; GCDS[i] != null; i++) {

			System.out.println(
					highway_name[19] + " 정보입니다. " + (i + 1) + " 위 " + GCDS[i] + " 기름값 : " + GCDSweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; ISJS[i] != null; i++) {

			System.out.println(
					highway_name[20] + " 정보입니다. " + (i + 1) + " 위 " + ISJS[i] + " 기름값 : " + ISJSweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; DJYD[i] != null; i++) {

			System.out.println(
					highway_name[21] + " 정보입니다. " + (i + 1) + " 위 " + DJYD[i] + " 기름값 : " + DJYDweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; NSCA[i] != null; i++) {

			System.out.println(
					highway_name[22] + " 정보입니다. " + (i + 1) + " 위 " + NSCA[i] + " 기름값 : " + NSCAweight_1[i] + "원");
		}

		System.out.println();

		for (int i = 0; SCGJ[i] != null; i++) {

			System.out.println(
					highway_name[23] + " 정보입니다. " + (i + 1) + " 위 " + SCGJ[i] + " 기름값 : " + SCGJweight_1[i] + "원");
		}

		System.out.println();

		return weight_1;

	}

}