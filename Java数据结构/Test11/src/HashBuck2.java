import java.util.Objects;

/**
 * @Author Li_ZW
 * @Date: 2020/05/30
 * @Time: 14:20
 * @Description
 */

class Person {
    public int id;
    public Person(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }

        Person person = (Person) obj;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class HashBuck2<K, V> {
    static class Node<K, V> {
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key,V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K, V>[] array = (Node<K, V>[]) new Node[10];
    public int usedSize;
    public void put(K key, V val) {
        int hash = key.hashCode();
        int index = hash % array.length;
        for (Node<K,V> cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                cur.val = val;
                return;
            }
        }

        Node<K, V> node = new Node<>(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;

        for (Node<K, V> cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
        }
        return null;
    }

    public static void main1(String[] args) {
        Person person = new Person(12);
        Person person1 = new Person(12);
        HashBuck2<Person,String> map = new HashBuck2<>();

        map.put(person,"zs");
        System.out.println(map.get(person1));
    }

    public static void main(String[] args) {
        Person person = new Person(12);
        Person person1 = new Person(12);

        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());
        System.out.println(person.equals(person1));
    }
}
