package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import java.util.HashMap;

//used formula taken from here: http://utenti.quipo.it/base5/pitagora/ternepit.htm
public class Prbl_75_SingularIntegerRightTriangles {

    private static final int MAX_PERIMETER_VALUE = 1_500_000;

    public static int getSolution() {

        HashMap<Integer, Integer> perimetersMap = new HashMap<>();
        long actualPerimeter;
        for (int n = 1; n < MAX_PERIMETER_VALUE / 3; n++){
            for (int m = n + 1;; m++){
                if(!(PrimeNumbers.areRelativelyPrime(n, m) && (m+n) % 2 == 1)) continue;
                Triple<Long, Long, Long> pythagoreanTriple = getPythagoreanTriple(m, n);
                actualPerimeter = getPerimeter(pythagoreanTriple);
                if(actualPerimeter > MAX_PERIMETER_VALUE) break;
                addOrUpdate(perimetersMap, (int) actualPerimeter);
                for (int i = 2;; i++){
                    Triple<Long, Long, Long> derivedPythagoreanTriple = getDerivedPythagoreanTriple(pythagoreanTriple, i);
                    actualPerimeter = getPerimeter(derivedPythagoreanTriple);
                    if (actualPerimeter > MAX_PERIMETER_VALUE) break;
                    addOrUpdate(perimetersMap, (int) actualPerimeter);
                }
            }
        }
        return (int) perimetersMap.entrySet().stream().filter(entry -> entry.getValue() == 1).count();
    }

    private static Triple<Long, Long, Long> getPythagoreanTriple (long m, long n){
        if(n >= m) throw new RuntimeException("Prbl_75: n have to be less or equal than m");
        long a = m*m - n*n;
        long b = 2*m*n;
        long c = m*m + n*n;
        return new ImmutableTriple<>(a, b, c);
    }

    private static long getPerimeter(Triple<Long, Long, Long> pythagoreanTriple) {
        return pythagoreanTriple.getLeft() + pythagoreanTriple.getMiddle() + pythagoreanTriple.getRight();
    }

    private static Triple<Long, Long, Long> getDerivedPythagoreanTriple (Triple<Long, Long, Long> pythagoreanTriple, int multiple) {
        return new ImmutableTriple<>(
                pythagoreanTriple.getLeft() * multiple,
                pythagoreanTriple.getMiddle() * multiple,
                pythagoreanTriple.getRight() * multiple
        );
    }

    private static void addOrUpdate (HashMap<Integer, Integer> perimetersMap, int newPerimeter){
        perimetersMap.computeIfPresent(newPerimeter, (k, v) -> v + 1);
        perimetersMap.putIfAbsent(newPerimeter, 1);
    }
}
