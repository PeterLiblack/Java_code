//map 和 set 练习

/**
 * 只出现一次的数字:
 * 
 * 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i:nums){
           res ^= i;
       }
       return res;
    }
}


/**
 * 复制带随机指针的链表:
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，
 * 该指针可以指向链表中的任何节点或空节点。
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        Node cur = head;
        Map<Node,Node> map = new HashMap<>();

        while(cur != null) {
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}


/**
 * 宝石与石头:
 *
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 */
class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();

        for(char j : J.toCharArray()) {
            set.add(j);
        }

        int count = 0;
        for(char s : S.toCharArray()) {
            if(set.contains(s)) {
                count++;
            }
        }
        return count;
    }
}


/**
 * 坏键盘打字:
 *
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
 * 现在给出应该输入的一段文字、以及实际被输入的文字，请你列肯定坏掉的那些键。
 */
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();
        String actual = scanner.nextLine();
        
        HashSet<Character> setActual = new HashSet<>();
        for (char s : actual.toUpperCase().toCharArray()) {
            setActual.add(s);
        }
        
        HashSet<Character> setBroken = new HashSet<>();
        for (char ex : expected.toUpperCase().toCharArray()) {
            if(!setActual.contains(ex) && !setBroken.contains(ex)) {
                System.out.print(ex);
            setBroken.add(ex);
            }
        }
    }
}


/**
 * 前K个高频单词:
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(words.length);
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            Integer o1Count = map.get(o1);
            Integer o2Count = map.get(o2);
            if (o1Count.equals(o2Count)) {
                return o2.compareTo(o1);
            } else {
                return o1Count - o2Count;
            }
        });
        
        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        LinkedList<String> stack = new LinkedList<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        };
        return stack;
    }
}


/**
 * 统计10w个数据中 重复数字及出现的次数
 * @param args
 */
public static void main(String[] args) {
    Random random = new Random();
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < 10_0000; i++) {
        list.add(random.nextInt(6000));
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    //key --> 关键字重复的数字
    //value--> 重复的数字出现的次数
    for (Integer key : list) {
        if(map.get(key) == null) {
            map.put(key,1);
        }else {
            Integer val = map.get(key);
            map.put(key,val+1);
        }
    }

    for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey()+"这个数字出现了"+entry.getValue()+"次！");
    }
}


/**
 * 去除10w个数据中重复的元素
 * @param args
 */
public static void main4(String[] args) {
    Random random = new Random();
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < 10_0000; i++) {
        list.add(random.nextInt(6000));
    }
    HashSet<Integer> set = new HashSet<>();
    for (Integer val : list) {
        set.add(val);
    }
    System.out.println(set);
}


/**
 * 找出10W个数据中，第一个重复的元素
 * @param args
 */
public static void main3(String[] args) {
    Random random = new Random();
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < 10_0000; i++) {
        list.add(random.nextInt(6000));
    }

    /*for (int i = 0; i < 10; i++) {
        list.add(random.nextInt(6));
    }
    System.out.println(list);*/

    HashSet<Integer> set = new HashSet<>();
    for (Integer val : list) {
        if (set.contains(val)) {
            System.out.println("找到了第一个重复的元素" + val);
            return;
        }else {
            set.add(val);
        }
    }
}