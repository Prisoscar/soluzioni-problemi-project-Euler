package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.NumberSequences;

import java.util.*;
import java.util.stream.Collectors;

/*
Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers are all figurate (polygonal) numbers and are generated
by the following formulae:
Triangle 	  	P3,n=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
Square 	  	P4,n=n2 	  	1, 4, 9, 16, 25, ...
Pentagonal 	  	P5,n=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
Hexagonal 	  	P6,n=n(2n−1) 	  	1, 6, 15, 28, 45, ...
Heptagonal 	  	P7,n=n(5n−3)/2 	  	1, 7, 18, 34, 55, ...
Octagonal 	  	P8,n=n(3n−2) 	  	1, 8, 21, 40, 65, ...

The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three interesting properties.

    The set is cyclic, in that the last two digits of each number is the first two digits of the next number
    (including the last number with the first).
    Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and pentagonal (P5,44=2882),
    is represented by a different number in the set.
    This is the only set of 4-digit numbers with this property.

Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type: triangle, square, pentagonal,
hexagonal, heptagonal, and octagonal, is represented by a different number in the set.
 */
public class Prbl_61_CyclicalFigurateNumbers {

    private static final int POLYGONAL_TARGET_VALUE = 140;
    private static final int SET_SIZE  = 6;

    public static long getSolution(){
        List<Long> [] sequencesList = (List<Long>[]) new List<?>[]{
                NumberSequences.triangleNumbersSequence(POLYGONAL_TARGET_VALUE),
                NumberSequences.squareNumbersSequence(POLYGONAL_TARGET_VALUE),
                NumberSequences.pentagonalNumbersSequence(POLYGONAL_TARGET_VALUE),
                NumberSequences.hexagonalNumbersSequence(POLYGONAL_TARGET_VALUE),
                NumberSequences.heptagonalNumbersSequence(POLYGONAL_TARGET_VALUE),
                NumberSequences.octagonalNumbersSequence(POLYGONAL_TARGET_VALUE)
        };
        sequencesList = Arrays.stream(sequencesList).map(sequenceList ->
                sequenceList.stream().filter(Prbl_61_CyclicalFigurateNumbers::sequencesFilter).collect(Collectors.toList())
        ).toArray(List[]::new);
        List<AbstractMap.SimpleEntry<Integer, Long>> sequencesMap = new ArrayList<>();
        for(int i = 0; i <sequencesList.length; i++) {
            for (long sequenceNumber : sequencesList[i]) {
                sequencesMap.add(new AbstractMap.SimpleEntry<>(i, sequenceNumber));
            }
        }
        Set<AbstractMap.SimpleEntry<Integer, Long>> analyzedSet;
        List<List<AbstractMap.SimpleEntry<Integer, Long>>> analyzedNumberSets;
        List<List<AbstractMap.SimpleEntry<Integer, Long>>> temporaryNumberSets;
        for(AbstractMap.SimpleEntry<Integer, Long> analyzedEntry: sequencesMap){
            analyzedNumberSets = new ArrayList<>();
            for (AbstractMap.SimpleEntry<Integer, Long> analyzedEntryToCompare: sequencesMap) {
                if(analyzedEntry.getKey().equals(analyzedEntryToCompare.getKey())) continue;
                if (isSetPartiallyCyclical(new HashSet<>(Arrays.asList(analyzedEntry.getValue(), analyzedEntryToCompare.getValue())))) analyzedNumberSets.add(Arrays.asList(analyzedEntry, analyzedEntryToCompare));
            }
            for(int j = 2; j <= 5; j++) {
                temporaryNumberSets = new ArrayList<>(analyzedNumberSets);
                analyzedNumberSets = new ArrayList<>();
                for (List<AbstractMap.SimpleEntry<Integer, Long>> analyzedListEntries: temporaryNumberSets){
                    for (AbstractMap.SimpleEntry<Integer, Long> analyzedEntryToCompare: sequencesMap){
                        if(isListAlreadyConsidered(analyzedListEntries, analyzedEntryToCompare)) continue;
                        List<AbstractMap.SimpleEntry<Integer, Long>> newCombination = new ArrayList<>(analyzedListEntries);
                        newCombination.add(analyzedEntryToCompare);
                        if (isSetPartiallyCyclical(new HashSet<>(Arrays.asList(analyzedListEntries.get(analyzedListEntries.size() - 1).getValue(), analyzedEntryToCompare.getValue())))) analyzedNumberSets.add(newCombination);
                    }
                }
            }
            List<List<Long>> possibleSolution = analyzedNumberSets
                    .stream()
                    .map(entryList -> entryList.stream().map(AbstractMap.SimpleEntry::getValue).collect(Collectors.toList()))
                    .filter(Prbl_61_CyclicalFigurateNumbers::isSetCyclical)
                    .collect(Collectors.toList());
            if (possibleSolution.size() > 0) return possibleSolution.get(0).stream().reduce(0L, Long::sum);
        }

        return 0;
    }

    private static boolean isListAlreadyConsidered(List<AbstractMap.SimpleEntry<Integer, Long>> analyzedListEntries,
                                                   AbstractMap.SimpleEntry<Integer, Long> analyzedEntryToCompare) {
        return analyzedListEntries.stream().anyMatch(entry -> entry.getKey().equals(analyzedEntryToCompare.getKey()));
    }

    private static boolean isSetCyclical(List<Long> set){
        for (long analyzedNumber: set){
            if (!((set.stream().filter(setNumber -> String.valueOf(setNumber).substring(0, 2).equals(String.valueOf(analyzedNumber).substring(0, 2))).count() == set.stream().filter(setNumber -> String.valueOf(setNumber).substring(0, 2).equals(String.valueOf(analyzedNumber).substring(2))).count())
                    &&
                    (set.stream().filter(setNumber -> String.valueOf(setNumber).substring(0, 2).equals(String.valueOf(analyzedNumber).substring(2))).count() == set.stream().filter(setNumber -> String.valueOf(setNumber).substring(2).equals(String.valueOf(analyzedNumber).substring(2))).count()))) return false;
        }
        return true;
    }

    private static boolean isSetPartiallyCyclical(Set<Long> set){
        for (long analyzedNumber: set){
            if (!((set.stream().filter(setNumber -> String.valueOf(setNumber).substring(2).equals(String.valueOf(analyzedNumber).substring(0, 2))).count() > 0)
                    ||
                    (set.stream().filter(setNumber -> String.valueOf(setNumber).substring(0, 2).equals(String.valueOf(analyzedNumber).substring(2))).count() > 0))) return false;
        }
        return true;
    }

    private static boolean sequencesFilter(Long sequenceNumber){
        return String.valueOf(sequenceNumber).length() == 4;
    }
}
