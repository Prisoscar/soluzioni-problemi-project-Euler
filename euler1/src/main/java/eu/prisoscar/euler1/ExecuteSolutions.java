package eu.prisoscar.euler1;

import eu.prisoscar.euler1.soluzioni.*;

import javax.script.ScriptException;
import java.io.FileNotFoundException;

public class ExecuteSolutions {
    public static void main(String[] args) throws ScriptException {

        //Problem 1 https://projecteuler.net/problem=1
        System.out.println("solution of problem 1 is: " + Prbl_1_Multiples_3_5.getSolution());
/*
        //Problem 2 https://projecteuler.net/problem=2
        System.out.println("solution of problem 2 is: " + Prbl_2_EvenFibonacciNumbers.getSolution());

        //Problem 3 https://projecteuler.net/problem=3
        System.out.println("solution of problem 3 is: " + Prbl_3_LargestPrimeFactor.getSolution());

        //Problem 4 https://projecteuler.net/problem=4
        int [] solution4 = Prbl_4_LargestPalindromeProduct.getSolution();
        System.out.println("solution of problem 4 is: " + solution4[0] + " obtained from: " + solution4[1] + " * " + solution4[2]);

        //Problem 5 https://projecteuler.net/problem=5
        System.out.println("solution of problem 5 is: " + Prbl_5_SmallestMultiple.getSolution());

        //Problem 6 https://projecteuler.net/problem=6
        System.out.println("solution of problem 6 is: " + Prbl_6_SumSquareDifference.getSolution());

        //Problem 7 https://projecteuler.net/problem=7
        System.out.println("solution of problem 7 is: " + Prbl_7_10001stPrime.getSolution());

        //Problem 8 https://projecteuler.net/problem=8
        AbstractMap.SimpleEntry<String, Long> solution8 = Prbl_8_LargestProductInASeries.getSolution();
        System.out.println("solution of problem 8 is: " + solution8.getValue() + " obtained from this series: " + solution8.getKey());

        //Problem 9 https://projecteuler.net/problem=9
        AbstractMap.SimpleEntry<String, Integer> solution9 = Prbl_9_SpecialPythagoreanTriplet.getSolution();
        System.out.println("solution of problem 9 is: " + solution9.getValue() + " obtained from these numbers: " + solution9.getKey());

        //Problem 10 https://projecteuler.net/problem=10
        System.out.println("solution of problem 10 is: " + Prbl_10_SummationOfPrimes.getSolution());

        //Problem 11 https://projecteuler.net/problem=11
        AbstractMap.SimpleEntry<int[], Long> solution11 = Prbl_11_LargestProductInAGrid.getSolution();
        System.out.println("solution of problem 11 is: " + solution11.getValue() + " obtained from these numbers: " + Arrays.toString(solution11.getKey()));

        //Problem 12 https://projecteuler.net/problem=12
        AbstractMap.SimpleEntry<Long, Integer> solution12 = Prbl_12_HighlyDivisibleTriangularNumber.getSolution();
        System.out.println("solution of problem 12 is: " + solution12.getKey() + " which is the " + solution12.getValue() + "th triangular number.");

        //Problem 13 https://projecteuler.net/problem=13
        String solution13 = Prbl_13_LargeSum.getSolution();
        System.out.println("solution of problem 13 is: " + solution13.substring(0, 10) + ", the whole result is: " + solution13);

        //Problem 14 https://projecteuler.net/problem=14
        System.out.println("solution of problem 14 is: " + Prbl_14_LongestCollatzSequence.getSolution());

        //Problem 15 https://projecteuler.net/problem=15
       // try {
            System.out.println("solution of problem 15 is: " + Prbl_15_LatticePaths.getSolution());
       // }catch (IOException e){
       //     System.out.println("problem 15 thrown IOException: " + e.getMessage());
       // }

        //Problem 16 https://projecteuler.net/problem=16
        System.out.println("solution of problem 16 is: " + Prbl_16_PowerDigitSum.getSolution());

        //Problem 17 https://projecteuler.net/problem=17
        System.out.println("solution of problem 17 is: " + Prbl_17_NumberLetterCounts.getSolution());

        //Problem 18 https://projecteuler.net/problem=18
        System.out.println("solution of problem 18 is: " + Prbl_18_MaximumPathSumI.getSolution(Prbl_18_MaximumPathSumI.TRIANGLE));

        //Problem 19 https://projecteuler.net/problem=19
        System.out.println("solution of problem 19 is: " + Prbl_19_CountingSundays.getSolution());

        //Problem 20 https://projecteuler.net/problem=20
        System.out.println("solution of problem 20 is: " + Prbl_20_FactorialDigitSum.getSolution());

        //Problem 21 https://projecteuler.net/problem=21
        System.out.println("solution of problem 21 is: " + Prbl_21_AmicableNumbers.getSolution());

        try {
            //Problem 22 https://projecteuler.net/problem=22
            System.out.println("solution of problem 22 is: " + Prbl_22_NamesScores.getSolution());
        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException thrown at problem 22");
        }

        //Problem 23 https://projecteuler.net/problem=23
        System.out.println("solution of problem 23 is: " + Prbl_23_NonAbundantSums.getSolution());

        //Problem 24 https://projecteuler.net/problem=24
        System.out.println("solution of problem 24 is: " + Arrays.stream(Prbl_24_LexicographicPermutations.getSolution()).mapToLong(num -> (long) num).reduce(0L, (longSolution, lastNumber) -> Long.parseLong(String.valueOf(longSolution) + lastNumber)));

        //Problem 25 https://projecteuler.net/problem=25
        System.out.println("solution of problem 25 is: " + Prbl_25_1000DigitsFibonacciNumber.getSolution());

        //Problem 26 https://projecteuler.net/problem=26
        //System.out.println("solution of problem 26 is: " + Prbl_26_ReciprocalCycles.getSolution());

        //Problem 27 https://projecteuler.net/problem=27
        System.out.println("solution of problem 27 is: " + Prbl_27_QuadraticPrimes.getSolution());

        //Problem 28 https://projecteuler.net/problem=28
        System.out.println("solution of problem 28 is: " + Prbl_28_NumberSpiralDiagonals.getSolution());

        //Problem 29 https://projecteuler.net/problem=29
        System.out.println("solution of problem 29 is: " + Prbl_29_DistinctPowers.getSolution());

        //Problem 30 https://projecteuler.net/problem=30
        System.out.println("solution of problem 30 is: " + Prbl_30_DigitFifthPowers.getSolution());

        //Problem 31 https://projecteuler.net/problem=31
        System.out.println("solution of problem 31 is: " + Prbl_31_CoinSums.getSolution());

        //Problem 32 https://projecteuler.net/problem=32
        System.out.println("solution of problem 32 is: " + Prbl_32_PandigitalProducts.getSolution());

        //Problem 33 https://projecteuler.net/problem=33
        System.out.println("solution of problem 33 is: " + Prbl_33_DigitCancellingFractions.getSolution());

        //Problem 34 https://projecteuler.net/problem=34
        System.out.println("solution of problem 34 is: " + Prbl_34_DigitFactorial.getSolution());

        //Problem 35 https://projecteuler.net/problem=35
        System.out.println("solution of problem 35 is: " + Prbl_35_CircularPrimes.getSolution());

        //Problem 36 https://projecteuler.net/problem=36
        System.out.println("solution of problem 36 is: " + Prbl_36_DoubleBasePalindromes.getSolution());

        //Problem 37 https://projecteuler.net/problem=37
        System.out.println("solution of problem 37 is: " + Prbl_37_TruncatablePrimes.getSolution());

        //Problem 38 https://projecteuler.net/problem=38
        System.out.println("solution of problem 38 is: " + Prbl_38_PandigitalMultiples.getSolution());

        //Problem 39 https://projecteuler.net/problem=39
        System.out.println("solution of problem 39 is: " + Prbl_39_InnerRightTriangles.getSolution());

        //Problem 40 https://projecteuler.net/problem=40
        System.out.println("solution of problem 40 is: " + Prbl_40_Champernowne_sConstant.getSolution());

        //Problem 41 https://projecteuler.net/problem=41
        System.out.println("solution of problem 41 is: " + Prbl_41_PandigitalPrime.getSolution());

        try {
            //Problem 42 https://projecteuler.net/problem=42
            System.out.println("solution of problem 42 is: " + Prbl_42_CodedTriangleNumbers.getSolution());
        }catch (FileNotFoundException e){
           System.out.println("FileNotFoundException thrown at problem 42");
        }

        //Problem 43 https://projecteuler.net/problem=43
        System.out.println("solution of problem 43 is: " + Prbl_43_SubStringDivisibility.getSolution());

//        //slow (1-2 minutes)
//        //Problem 44 https://projecteuler.net/problem=44
//        System.out.println("solution of problem 44 is: " + Prbl_44_PentagonNumbers.getSolution());

        //Problem 45 https://projecteuler.net/problem=45
        System.out.println("solution of problem 45 is: " + Prbl_45_TriangularPentagonalAndHexagonal.getSolution());

        //Problem 46 https://projecteuler.net/problem=46
        System.out.println("solution of problem 46 is: " + Prbl_46_Goldback_sOtherConjecture.getSolution());

        //Problem 47 https://projecteuler.net/problem=47
        System.out.println("solution of problem 47 is: " + Prbl_47_DistinctPrimeFactors.getSolution());

        //Problem 48 https://projecteuler.net/problem=48
        System.out.println("solution of problem 48 is: " + Prbl_48_SelfPowers.getSolution());

        //Problem 49 https://projecteuler.net/problem=49
        System.out.println("solution of problem 49 is: " + Prbl_49_PrimePermutations.getSolution());

        //Problem 50 https://projecteuler.net/problem=50
        System.out.println("solution of problem 50 is: " + Prbl_50_ConsecutivePrimeSum.getSolution());

        //Problem 51 https://projecteuler.net/problem=51
        List<Long> solution51 = Prbl_51_PrimeDigitsReplacements.getSolution();
        System.out.println("solution of problem 51 is: " + solution51.get(0) + " the whole list is: " + solution51);

        //Problem 52 https://projecteuler.net/problem=52
        System.out.println("solution of problem 52 is: " + Prbl_52_PermutedMultiples.getSolution());

        //Problem 53 https://projecteuler.net/problem=53
        System.out.println("solution of problem 53 is: " + Prbl_53_CombinatoricSelections.getSolution());

        //Problem 54 https://projecteuler.net/problem=54
        try {
            System.out.println("solution of problem 54 is: " + Prbl_54_PokerHands.getSolution());
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException thrown at problem 54");
        }

        //Problem 55 https://projecteuler.net/problem=55
        System.out.println("solution of problem 55 is: " + Prbl_55_LycherelNumbers.getSolution());

        //Problem 56 https://projecteuler.net/problem=56
        System.out.println("solution of problem 56 is: " + Prbl_56_PowerfulDigitSum.getSolution());

        //Problem 57 https://projecteuler.net/problem=57
        System.out.println("solution of problem 57 is: " + Prbl_57_SquareRootConvergents.getSolution());

        //Problem 58 https://projecteuler.net/problem=58
        System.out.println("solution of problem 58 is: " + Prbl_58_SpiralPrimes.getSolution());

        //Problem 59 https://projecteuler.net/problem=59
        try {
            System.out.println("solution of problem 59 is: " + Prbl_59_XORDecryption.getSolution());
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException thrown at problem 54");
        }

//        //Problem 60 https://projecteuler.net/problem=60
//        //slow
//        Map.Entry<Long, List<Long>> solution = Prbl_60_PrimePairSets.getSolution();
//        System.out.println("solution of problem 60 is: " + solution.getKey() + "obtained from the following prime numbers: " + solution.getValue());

        //Problem 61 https://projecteuler.net/problem=61
        System.out.println("solution of problem 61 is: " + Prbl_61_CyclicalFigurateNumbers.getSolution());

        //Problem 62 https://projecteuler.net/problem=62
        System.out.println("solution of problem 62 is: " + Prbl_62_CubicPermutations.getSolution());

        //Problem 63 https://projecteuler.net/problem=63
        System.out.println("solution of problem 63 is: " + Prbl_63_PowerfulDigitCounts.getSolution());

        //Problem 64 https://projecteuler.net/problem=64
        System.out.println("solution of problem 64 is: " + Prbl_64_OddPeriodSquareRoots.getSolution());

        //Problem 65 https://projecteuler.net/problem=65
        System.out.println("solution of problem 65 is: " + Prbl_65_ConvergentsOfE.getSolution());

        //Problem 66 https://projecteuler.net/problem=66
        System.out.println("solution of problem 66 is: " + Prbl_66_DiophantineEquation.getSolution());

        //Problem 67 https://projecteuler.net/problem=67
        System.out.println("solution of problem 67 is: " + Prbl_67_MaximunPathSum_II.getSolution(Prbl_67_MaximunPathSum_II.TRIANGLE));

        //Problem 68 https://projecteuler.net/problem=68
        System.out.println("solution of problem 68 is: " + Prbl_68_Magic_5_gonRing.getSolution());

        //Problem 69 https://projecteuler.net/problem=69
        System.out.println("solution of problem 69 is: " + Prbl_69_TotientMaximum.getSolution());*/

        //Problem 70 https://projecteuler.net/problem=70
        //slow(~10 min)
        System.out.println("solution of problem 70 is: " + Prbl_70_TotientPermutation.getSolution());

        //Problem 71 https://projecteuler.net/problem=71
        System.out.println("solution of problem 71 is: " + Prbl_71_OrderedFractions.getSolution());

//        //Problem 93 https://projecteuler.net/problem=93
//        //too damn slow (30-60 minutes)
//        //solution of problem 93 is 1258, max natural number obtained is 51
//        AbstractMap.SimpleEntry<Integer, Integer> solution93 = Prbl_93_ArithmeticExpressions.getSolution();
//        System.out.println("solution of problem 93 is " + solution93.getKey() + ", max natural number obtained is " + solution93.getValue());

    }
}