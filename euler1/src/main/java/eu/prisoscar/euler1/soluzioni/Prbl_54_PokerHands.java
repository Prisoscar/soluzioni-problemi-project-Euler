package eu.prisoscar.euler1.soluzioni;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

    High Card: Highest value card.
    One Pair: Two cards of the same value.
    Two Pairs: Two different pairs.
    Three of a Kind: Three cards of the same value.
    Straight: All cards are consecutive values.
    Flush: All cards of the same suit.
    Full House: Three of a kind and a pair.
    Four of a Kind: Four cards of the same value.
    Straight Flush: All cards are consecutive values of same suit.
    Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; for example,
a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens,
then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared,
and so on.

Consider the following five hands dealt to two players:
Hand	 	Player 1	 	Player 2	 	Winner
1	 	5H 5C 6S 7S KD
Pair of Fives
	 	2C 3S 8S 8D TD
Pair of Eights
	 	Player 2
2	 	5D 8C 9S JS AC
Highest card Ace
	 	2C 5C 7D 8S QH
Highest card Queen
	 	Player 1
3	 	2D 9C AS AH AC
Three Aces
	 	3D 6D 7D TD QD
Flush with Diamonds
	 	Player 2
4	 	4D 6S 9H QH QC
Pair of Queens
Highest card Nine
	 	3D 6D 7H QD QS
Pair of Queens
Highest card Seven
	 	Player 1
5	 	2H 2D 4C 4D 4S
Full House
With Three Fours
	 	3C 3D 3S 9S 9D
Full House
with Three Threes
	 	Player 1

The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards
(separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards.
You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order,
and in each hand there is a clear winner.

How many hands does Player 1 win?

 */
public class Prbl_54_PokerHands {

    private static final File POKER_HANDS_FILE = new File(System.getProperty("user.dir") + "/p054_poker.txt");

    public static int getSolution() throws FileNotFoundException {
        int solution = 0;
        Map<String [], String []> pokerHandsMap = getHands();
        String [] player1Hand;
        String [] player2Hand;
        int player1Score;
        int player2Score;
        for (Map.Entry<String [], String []> hand: pokerHandsMap.entrySet()){
            player1Hand = hand.getKey();
            player2Hand = hand.getValue();
            player1Score = getScore(player1Hand);
            player2Score = getScore(player2Hand);
            if (player1Score > player2Score){
                solution++;
                continue;
            }
            if (player1Score == player2Score && sameHandWinner(player1Hand, player2Hand, player1Score) == 1) solution++;
                }
        return solution;
    }

    private static int sameHandWinner(String[] player1Hand, String[] player2Hand, int playersScore) {
        int winner = playersScore == 9 ? higherHighestCardWinner(player1Hand, player2Hand) :
                        playersScore == 8 ? higherPair(player1Hand, player2Hand) :
                            playersScore == 7 ? higherThreeOfAKind(player1Hand, player2Hand) :
                                playersScore == 6 ? higherHighestCardWinner(player1Hand, player2Hand) :
                                    playersScore == 5 ? higherHighestCardWinner(player1Hand, player2Hand) :
                                        playersScore == 4 ? higherThreeOfAKind(player1Hand, player2Hand) :
                                            playersScore == 3 ? higherTwoPair(player1Hand, player2Hand) :
                                                playersScore == 2 ? higherPair(player1Hand, player2Hand) : higherValueWinner(player1Hand, player2Hand);
        return winner == 0 ? higherValueWinner(player1Hand, player2Hand) : winner;
    }

    private static int higherPair(String[] player1Hand, String[] player2Hand) {
        int player1PairValue = getPairValue(player1Hand);
        int player2PairValue = getPairValue(player2Hand);
        return Integer.compare(player1PairValue, player2PairValue);
    }

    private static int higherTwoPair(String[] player1Hand, String[] player2Hand) {
        int player1PairValue = getPairValue(player1Hand);
        int player2PairValue = getPairValue(player2Hand);
        if (player1PairValue == player2PairValue){
            player1Hand = deletePair(player1Hand, player1PairValue);
            player2Hand = deletePair(player2Hand, player1PairValue);
            player1PairValue = getPairValue(player1Hand);
            player2PairValue = getPairValue(player2Hand);
        }
        return Integer.compare(player1PairValue, player2PairValue);
    }

    private static int getPairValue(String[] playerHand) {
        for (int i = 0; i < playerHand.length; i++){
            if(cardValue(playerHand [i]) == cardValue(playerHand [i + 1]) && !playerHand[i].isEmpty()) return cardValue(playerHand[i]);
        }
        return -1;
    }

    private static String[] deletePair(String[] playerHand, int playerPairValue) {
        for (int i = 0; i < playerHand.length; i++) {
            if (cardValue(playerHand [i]) == playerPairValue) playerHand [i] = "";
        }
        return playerHand;
    }

    private static int higherThreeOfAKind(String[] player1Hand, String[] player2Hand) {
        int player1ThreeOfAKindValue = cardValue(player1Hand [0]) == cardValue(player1Hand [1]) && cardValue(player1Hand [1]) == cardValue(player1Hand [2]) ? cardValue(player1Hand [0]) : cardValue(player1Hand [player1Hand.length - 1]);
        int player2ThreeOfAKindValue = cardValue(player2Hand [0]) == cardValue(player2Hand [1]) && cardValue(player2Hand [1]) == cardValue(player2Hand [2]) ? cardValue(player2Hand [0]) : cardValue(player2Hand [player2Hand.length - 1]);
        return Integer.compare(player1ThreeOfAKindValue, player2ThreeOfAKindValue);
    }

    //9 = straight flush
    private static int getScore(String[] playerHand) {
        return isStraightFlush(playerHand) ? 9 :
                    isFourOfAKind(playerHand) ? 8 :
                        isFullHouse(playerHand) ? 7 :
                            isFlush(playerHand) ? 6 :
                                isStraight(playerHand) ? 5 :
                                    isThreeOfAKind(playerHand) ? 4 :
                                        isTwoPairs(playerHand) ? 3 :
                                            isPair(playerHand) ? 2 : 1;
    }

    private static boolean isStraightFlush(String[] playerHand) {
        if (!isFlush(playerHand)) return false;
        if(!isStraight(playerHand)) return false;
        return true;
    }

    private static boolean isFourOfAKind(String[] playerHand) {
        int counter = 0;
        int lastCardValue = cardValue(playerHand [0]);
        int actualCardValue;
        for (String card: playerHand){
            actualCardValue = cardValue(card);
            if (actualCardValue == lastCardValue) counter++;
            else {
                counter = 1;
            }
            if (counter == 4) return true;
            lastCardValue = actualCardValue;
        }
        return counter == 4;
    }

    private static boolean isFullHouse(String[] playerHand) {
        return isThreeOfAKind(playerHand) && isTwoPairs(playerHand);
    }

    private static boolean isFlush(String[] playerHand) {
        String referenceSuit = playerHand [0].substring(playerHand [0].length() - 1);
        String actualSuit;
        for (String suit: playerHand){
            actualSuit = suit.substring(suit.length() - 1);
            if (!referenceSuit.equals(actualSuit)) return false;
        }
        return true;
    }

    private static boolean isStraight(String[] playerHand) {
        int biggestCard = cardValue(playerHand [0]) + 1;
        int actualCard;
        for (String card : playerHand) {
            actualCard = cardValue(card);
            if (actualCard + 1 != biggestCard) return false;
            biggestCard = actualCard;
        }
        return true;
    }

    private static boolean isThreeOfAKind(String[] playerHand) {
        int counter = 0;
        int lastCardValue = cardValue(playerHand [0]);
        int actualCardValue;
        for (String card: playerHand){
            actualCardValue = cardValue(card);
            if (actualCardValue == lastCardValue) counter++;
            else {
                counter = 1;
            }
            if (counter == 3) return true;
            lastCardValue = actualCardValue;
        }
        return counter == 3;
    }

    private static boolean isTwoPairs(String[] playerHand) {
        return countPairs(playerHand) == 2;
    }

    private static boolean isPair(String[] playerHand) {
        return countPairs(playerHand) == 1;
    }

    private static int countPairs(String[] playerHand) {
        int pairsCounter = 0;
        for (int i = 0; i < playerHand.length - 1; i++){
            if (cardValue(playerHand [i]) == cardValue(playerHand [i + 1])) {
                pairsCounter++;
                i++;        //in order to avoid a three of a kind to counted as two pairs
            }
        }
        return pairsCounter;
    }


    private static int higherHighestCardWinner(String[] player1Hand, String[] player2Hand) {
        return Integer.compare(cardValue(player1Hand [0]), cardValue(player2Hand [0]));
    }

    private static int higherValueWinner(String[] player1Hand, String[] player2Hand) {
        int comparingValue = 0;
        for (int i = 0; i < player1Hand.length; i++){
            comparingValue = Integer.compare(cardValue(player1Hand [i]), cardValue(player2Hand [i]));
            if (comparingValue != 0) return comparingValue;
        }
        return comparingValue;
    }

    protected static int cardValue(String card) {
        return card.length() == 2 ? Integer.parseInt(card.substring(0, 1)) : Integer.parseInt(card.substring(0, 2));
    }

    private static Map<String [], String []> getHands() throws FileNotFoundException {
        Scanner pokerHandsScanner = new Scanner(POKER_HANDS_FILE);
        Map<String [], String []> pokerHands = new HashMap<>();
        String [] player1Hand = new String[5];
        String [] player2Hand = new String[5];
        while (pokerHandsScanner.hasNext()) {
                for (int i = 0; i < 10; i++){
                    if (i < 5) player1Hand [i] =  replaceWithNumbers(pokerHandsScanner.next());
                    if (i >= 5 ) player2Hand [i - 5] = replaceWithNumbers(pokerHandsScanner.next());
                }
                pokerHands.put(
                        Arrays.stream(player1Hand).sorted(new CardComparator()).toArray(String[]::new),
                        Arrays.stream(player2Hand).sorted(new CardComparator()).toArray(String[]::new)
                );
                player1Hand = new String[5];
                player2Hand = new String[5];
        }
        return pokerHands;
    }

    private static String replaceWithNumbers (String card){
        card = card.replace("T", "10");
        card = card.replace("J", "11");
        card = card.replace("Q", "12");
        card = card.replace("K", "13");
        card = card.replace("A", "14");
        return card;
    }
}

class CardComparator implements Comparator<String>{

    @Override
    public int compare(String a, String b) {
        return Integer.compare(Prbl_54_PokerHands.cardValue(b), Prbl_54_PokerHands.cardValue(a));
    }
}
