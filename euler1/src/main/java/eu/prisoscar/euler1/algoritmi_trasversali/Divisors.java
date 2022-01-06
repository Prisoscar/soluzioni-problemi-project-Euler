package eu.prisoscar.euler1.algoritmi_trasversali;

import java.util.*;

public class Divisors {

    /**
     * returns the list of all factors of given number (including 1 and the number itself)
     * @param number Long
     * @return List (Long)
     */
    public static List<Long> getFactorsList(Long number){
        List<Long> divisorsList = new LinkedList<>();
        if (number == 1) {
            divisorsList.add(1L);
            return divisorsList;
        }
        if (number < 1) return new ArrayList<>();
        divisorsList.add(1L);
        divisorsList.add(number);
        for (long i = 2L; i < number / i; i++){
            if (number % i == 0) divisorsList.addAll(Arrays.asList(i, number/i));
        }
        if (Math.sqrt(number) % 1 == 0) divisorsList.add((long)Math.sqrt(number));
        divisorsList.sort(Long::compare);
        return divisorsList;
    }

    /**
     * returns the list of all prime factors of given number (excluding 1 and the number itself)
     * @param number Long
     * @return List (Long)
     */
    public static List<Long> getPrimeFactorsList(Long number){
        List<Long> factors = getFactorsList(number);
        factors.remove(factors.size() - 1);
        factors.removeIf(factor -> !PrimeNumbers.isPrime(factor));
        return factors;
    }
}
