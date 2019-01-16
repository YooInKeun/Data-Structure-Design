class GraphNode {
	int vertex;
	String[] name; // vertex 즉, 주유소의 이름인 name
	double[] weight_1; // vertex의 기름값인 weight_1, main의 v_num 이용해서 개수 조정하자?
	double[] wieight_2; // vertex에서 넣어야 하는 기름의 양인 weight_2
	GraphNode link;
}