import java.util.Objects;

/**
 * @Author Li_ZW
 * @Date: 2020/05/26
 * @Time: 14:11
 * @Description
 * equals方法
 */

class Card {
    public int rank;
    public String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

public class TestDemo {

    public static void main(String[] args) {
        Card card1 = new Card(5,"♠");
        Card card2 = new Card(5,"♠");
        System.out.println(card1 == card2);
        System.out.println(card1.equals(card2));
        System.out.println(card1.hashCode());
    }
}
