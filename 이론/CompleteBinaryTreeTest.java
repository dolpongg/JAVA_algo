
public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
	
		CompleteBinaryTree tree = new CompleteBinaryTree(9);
		for(int i = 0; i < 9; i++) {
			tree.add((char)('1'+i));
		}
		
//		tree.bfs();
//		tree.bfs2();
//		tree.dfs();
		
//		tree.dfsByPreOrder(1);
//		System.out.println();
		tree.dfsByInOrder(1);
//		System.out.println();
//		
//		tree.dfsByPostOrder(1);
	}

}
