package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
    Problem 60 https://projecteuler.net/problem=60
    The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating
    them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime.
    The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

    Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 */
public class Probl_60_PrimePairSets {

    public static Entry<Long, List<Long>> sumPrimeSet() {
        List<Long> analizedPrimes = PrimeNumbers.findPrimes(100000000_0);
        List<Long> primeSet = new ArrayList<>();
        Map<Long, List<Long>> primeSets = new HashMap<>();
        boolean areConcatenationsPrimes;
        long setSum = Long.MAX_VALUE;
        //String primeSetString;
        Entry<Long, List<Long>> solution = null;
        long skipped = 0L;

        for (int i = 1; analizedPrimes.get(i) < 100L; i++) {
            skipped = analizedPrimes.get(i + 1);
            for (int j = i + 1; analizedPrimes.get(j) < 100L; j = analizedPrimes.indexOf(skipped)) {
                primeSet.clear();
                primeSet.add(analizedPrimes.get(i));
                for (int k = j + 1; k < analizedPrimes.size() && primeSet.size() <= 5 && analizedPrimes.get(k) < 10000_0L; k++) {
                    areConcatenationsPrimes = true;
                    for (Long primo : primeSet) {
                        if (!areConcatenationsPrime(primo, analizedPrimes.get(k), analizedPrimes)) {
                            areConcatenationsPrimes = false;
                            break;
                        }
                    }
                    if (areConcatenationsPrimes) {
                        primeSet.add(analizedPrimes.get(k));
                    }
                }
                System.out.println(primeSet);
                if (primeSet.size() == 5) {
                    setSum = primeSet.stream().map(primo -> primo).reduce(setSum, (accumulator, _item) -> accumulator + _item);     //dovrebbe sommare tutti gli elementi di primeSet
                    primeSets.put(setSum, primeSet);
                }
                try {
                    skipped = primeSet.get(1);
                } catch (IndexOutOfBoundsException ex) {
                    break;
                }
            }
        }
        for (Entry<Long, List<Long>> entryPrimeSets : primeSets.entrySet()) {
            if (entryPrimeSets.getKey() < setSum) {
                setSum = entryPrimeSets.getKey();
                //primeSetString = entryPrimeSets.getValue().toString();
                solution = entryPrimeSets;
            }
        }
        return solution;
    }

    public static boolean areConcatenationsPrime(long num1, long num2, List<Long> primiAnalizati) {
        return primiAnalizati.contains(Long.parseLong(String.valueOf(num1).concat(String.valueOf(num2)))) && primiAnalizati.contains(Long.parseLong(String.valueOf(num2).concat(String.valueOf(num1))));
    }
}
