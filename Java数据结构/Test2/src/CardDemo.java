import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author Li_ZW
 * @Date: 2020/05/12
 * @Time: 15:24
 * @Description
 * 扑克牌练习
 */

class Card {
    public int rank;
    public String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]",suit,rank);
    }
}

public class CardDemo {

    public static final String[] SUITS = {"♥","♠","♦","♣"};

    //买牌
    public static List<Card> buyDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(j,SUITS[i]);
                deck.add(card);
            }
        }
        return deck;
    }

    private static void swap(List<Card> deck,int index,int i) {
        Card tmp = deck.get(index);
        deck.set(index,deck.get(i));
        deck.set(i,tmp);
    }

    //洗牌
    public static void shuffle(List<Card> deck) {
        Random random = new Random();
        for (int i = deck.size()-1; i > 0; i--) {
           // Random random = new Random();
            int index = random.nextInt(i);
            swap(deck,index,i);
        }
    }

    public static void main(String[] args) {
        List<Card> deck = buyDeck();
        System.out.println(deck);
        System.out.println("洗牌：");
        shuffle(deck);
        System.out.println(deck);

        //3个人 轮流 每人揭牌5张
        List<List<Card>> hand = new ArrayList<>();
        List<Card> hands1 = new ArrayList<>();
        List<Card> hands2 = new ArrayList<>();
        List<Card> hands3 = new ArrayList<>();
        hand.add(hands1);
        hand.add(hands2);
        hand.add(hands3);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = deck.remove(0);
                hand.get(j).add(card);
            }
        }

        System.out.println("第一个人的牌：");
        System.out.println(hands1);
        System.out.println("第二个人的牌：");
        System.out.println(hands2);
        System.out.println("第三个人的牌：");
        System.out.println(hands3);
        System.out.println("剩下的牌：");
        System.out.println(deck);
    }
}
