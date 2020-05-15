/**
 * Author Li_ZW
 * Date: 2020/05/15
 * Time: 19:33
 * Description：
 *
 * 二叉树
 */
public class TestMain {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();

        binaryTree.indOrderTraversal(root);
        System.out.println();

        binaryTree.postOrderTraversal(root);
        //System.out.print(root);
        System.out.println();

        binaryTree.getSize1(root);
        System.out.println("节点个数为：" + BinaryTree.size);

        System.out.println(binaryTree.getSize2(root));

        binaryTree.getLeafSize1(root);
        System.out.println("叶子节点数：" + BinaryTree.leafSize);

        System.out.println(binaryTree.getLeafSize2(root));
    }
}
