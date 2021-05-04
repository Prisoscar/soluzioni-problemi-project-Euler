package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;
import java.util.List;

/*
    problem 49 https://projecteuler.net/problem=49
    The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330,
    is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

    There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
    exhibiting this property, but there is one other 4-digit increasing sequence.

    What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Prbl_49_PrimePermutations {

    public static Long getSolution() {

        List<Long> listaPrimi = PrimeNumbers.findPrimes(1000, 10000);
        String numeroEsaminato;
        String numeriPermutati;

        //questo ciclo prende in esame tutti i numeri primi a 4 cifre
        for (int i = 0; i < listaPrimi.size(); i++) {
            numeriPermutati = listaPrimi.get(i).toString();
            //questo ciclo confronta il primo preso in esame con tutti i primi maggiori di tale numero
            for (int j = i + 1; j < listaPrimi.size(); j++) {
                numeroEsaminato = listaPrimi.get(i).toString();
                //questo ciclo esamina se il numero preso in esame è una permutazione del numero che stiamo esaminando
                for (int k = 0; k < 4; k++) {
                    if (numeroEsaminato.contains(listaPrimi.get(j).toString().substring(k, k + 1))) {
                        numeroEsaminato = numeroEsaminato.replaceFirst(listaPrimi.get(j).toString().substring(k, k + 1), "");
                    } else {
                        break;
                    }
                    if (numeroEsaminato.length() == 0 && (listaPrimi.get(j) - listaPrimi.get(i) == 3330 || listaPrimi.get(j) - listaPrimi.get(i) == 6660)) {
                        numeriPermutati = numeriPermutati.concat(listaPrimi.get(j).toString());
                    }
                }
            }
            if (numeriPermutati.length() == 12 && !"148748178147".equals(numeriPermutati)) {
                return Long.parseLong(numeriPermutati);
            }
        }
        return null;
    }
}
