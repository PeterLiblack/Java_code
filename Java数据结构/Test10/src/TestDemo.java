import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/28
 * @Time: 18:20
 * @Description
 */
public class TestDemo {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] array = {7,2,9,18,56,15,3};
        for (int i : array) {
            bsTree.insert(i);
        }
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
        System.out.println();
        System.out.println(bsTree.search(18).val);
        System.out.println("==========删除============");
        bsTree.remove(18);
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
        System.out.println();

    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();
        String actual = scanner.nextLine();

        HashSet<Character> setActual = new HashSet<>();
        for (char s : actual.toUpperCase().toCharArray()) {
            setActual.add(s);
        }
        HashSet<Character> setBroken = new HashSet<>();
        for (char ex :expected.toUpperCase().toCharArray()) {
            if(!setActual.contains(ex) && !setBroken.contains(ex)) {
                System.out.print(ex);
                setBroken.add(ex);
            }
        }
    }
}
