package eu.prisoscar.euler1.soluzioni;

import java.util.*;
import java.util.stream.Collectors;

/*
In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?
 */
public class Prbl_31_CoinSums {

    private static final int TARGET = 200;
    private static final Map<Integer, Integer> COINS = new HashMap<Integer, Integer>(){{
        put(0, 1);
        put(1, 2);
        put(2, 5);
        put(3, 10);
        put(4, 20);
        put(5, 50);
        put(6, 100);
    }};     //the 2 pounds coin can make 2 pounds only if taken alone, there is no sense to combine it with other coins
    private static final int COINS_MAP_LENGTH = COINS.size();

    public static int getSolution(){

     /*   int solution = 1;
        Set<AbstractMap.SimpleEntry<Integer, List<Integer>>> coinsCombinations;
        Set<AbstractMap.SimpleEntry<Integer, List<Integer>>> analyzedCoinsCombinations;

        long startTimer = System.currentTimeMillis();
        int counter = 0;
        List<Integer> nextSolution;

        coinsCombinations = COINS.entrySet().stream().map(analyzedEntry -> new AbstractMap.SimpleEntry<Integer, List<Integer>>(analyzedEntry.getKey(), Collections.singletonList(analyzedEntry.getValue()))).collect(Collectors.toSet());

        while (coinsCombinations.size() > 0){
            analyzedCoinsCombinations = new HashSet<>(coinsCombinations);
            coinsCombinations = new HashSet<>();
            int coinsSumValue;
            for (AbstractMap.SimpleEntry<Integer, List<Integer>> analyzedEntry : analyzedCoinsCombinations){
                for(int i = analyzedEntry.getKey(); i < COINS_MAP_LENGTH; i++){
                    nextSolution = new ArrayList<>(analyzedEntry.getValue());
                    nextSolution.add(COINS.get(i));
                    coinsSumValue = analyzedEntry.getValue().stream().reduce(0, Integer::sum) + COINS.get(i);
                    if(coinsSumValue < TARGET) coinsCombinations.add(new AbstractMap.SimpleEntry<>(i, nextSolution));
                    if(coinsSumValue == TARGET) {
                        //System.out.println(nextSolution);
                        solution++;
                        break;      //there is no reason to continue al other combinations will give a sum greater than our TARGET
                    }
                }
            }
            //System.out.println("iteration # " + counter++ + " array size = " + coinsCombinations.size());
        }
        System.out.println("Time required " + (System.currentTimeMillis()-startTimer));
        //return solution;*/

        int solution = 1;   //the 2 pounds coin taken alone
        List<AbstractMap.SimpleEntry<Integer, Integer>> coinsCombinations2;
        List<AbstractMap.SimpleEntry<Integer, Integer>> analyzedCoinsCombinations2;
        int counter2 = 0;
        //startTimer = System.currentTimeMillis();
        //initializing coinsCombinations
        coinsCombinations2 = new ArrayList<>(COINS.entrySet().stream().map(analyzedEntry -> new AbstractMap.SimpleEntry<Integer, Integer>(analyzedEntry.getKey(), analyzedEntry.getValue())).collect(Collectors.toSet()));

        //calculate all possible combinations
        while (coinsCombinations2.size() > 0){
            analyzedCoinsCombinations2 = new ArrayList<>(coinsCombinations2);
            coinsCombinations2 = new ArrayList<>();
            int coinsSumValue;
            for (AbstractMap.SimpleEntry<Integer, Integer> analyzedEntry : analyzedCoinsCombinations2){
                for(int i = analyzedEntry.getKey(); i < COINS_MAP_LENGTH; i++){
                    coinsSumValue = analyzedEntry.getValue() + COINS.get(i);
                    if(coinsSumValue < TARGET) coinsCombinations2.add(new AbstractMap.SimpleEntry<>(i, coinsSumValue));
                    if(coinsSumValue == TARGET) {
                        solution++;
                        break;      //there is no reason to continue al other combinations will give a sum greater than our TARGET
                    }
                }
            }
            //System.out.println("iteration # " + counter2++ + " array size = " + coinsCombinations2.size());
        }
       // System.out.println("Time required " + (System.currentTimeMillis()-startTimer));
        return solution;

    }
}
