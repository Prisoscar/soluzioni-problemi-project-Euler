package eu.prisoscar.euler1.soluzioni;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

/*
    By using each of the digits from the set, {1, 2, 3, 4}, exactly once, and making use of the four arithmetic
    operations (+, −, *, /) and brackets/parentheses, it is possible to form different positive integer targets.

    For example,

    8 = (4 * (1 + 3)) / 2
    14 = 4 * (3 + 1 / 2)
    19 = 4 * (2 + 3) − 1
    36 = 3 * 4 * (2 + 1)

    Note that concatenations of the digits, like 12 + 34, are not allowed.

    Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one different target numbers of which 36 is the maximum,
    and each of the numbers 1 to 28 can be obtained before encountering the first non-expressible number.

    Find the set of four distinct digits, a < b < c < d, for which the longest set of consecutive positive integers, 1 to n,
    can be obtained, giving your answer as a string: abcd.
    */
public class Prbl_93_ArithmeticExpressions {

    private static final byte DIGITS_SET_SIZE = 4;
    /*
    idea 1
        1-find all possible sets o 4 distinct digits
        2-then find all digits positions combinations
        3-then find all possible combinations of arithmetic expressions with repetitions between digits
        4-then find all possible brackets combinations
        5-then combine all together in all possible ways and evaluate the obtained expressions
     */
    public static AbstractMap.SimpleEntry<Integer,Integer> findSet (){
        AbstractMap.SimpleEntry<Integer,Integer> solution = new AbstractMap.SimpleEntry<>(0,0);      //solution
        List<? extends Collection<? extends Number>> temporaryList;     //multi-step attribute
        List<Set<Integer>> listOfDigitsSets = new ArrayList<>();        //step 1
        List<Set<Integer>> listOfDigitsPositionsSets = new ArrayList<>();        //step 2
        //step 3
        List<List<Integer>> listOfArithmeticOperatorsSets = new ArrayList<>();
        Map<Integer, String> arithmeticOperatorsMap = new HashMap<Integer, String>(){{
            put(0, "+");
            put(1, "-");
            put(2, "*");
            put(3, "/");
        }};
        //end step 3
        List<AbstractMap.SimpleEntry<List<Integer>,List<Integer>>> listOfBracketsPairs = new ArrayList<>();   //step 4
        //mega-step 5
        int biggestConsecutiveNaturalResults = 0;
        StringBuilder equation;
        List<String> listOfDigitsSetEquations;
        Set<Integer> listOfNatuaralSolutions;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        //end mega-step 5

        //step 1
        //initialize listOfDigitsSets
        for (int i = 9; i > -1; i--){
            listOfDigitsSets.add(new LinkedHashSet<>(Collections.singletonList(i)));
        }
        //find all 0-9 4 distinct digit set
        for (int i = 1; i < DIGITS_SET_SIZE; i++){
            temporaryList = new ArrayList<>(listOfDigitsSets);
            listOfDigitsSets = new ArrayList<>();
            for (Collection<?> analyzedSet : temporaryList) {
                for (int j = analyzedSet.stream().mapToInt(v -> (int) v).min().orElseThrow(NoSuchElementException::new); j >= 0; j--) {
                    Set<Integer> digitsSet = new LinkedHashSet<>();
                    analyzedSet.forEach(number -> digitsSet.add((int)number));
                    digitsSet.add(j);
                    if(digitsSet.size() == (i + 1)) {
                        listOfDigitsSets.add(digitsSet);
                    }
                }
            }
        }
        //listOfDigitsSets.forEach(System.out::println);
        //System.out.println(listOfDigitsSets.size() + " digits sets");

        //step 2
        //initialize listOfDigitsSets
        for (int i = 0; i < 4; i++){
            listOfDigitsPositionsSets.add(new HashSet<>(Collections.singletonList(i)));
        }
        /*
        0 = a
        1 = b
        2 = c
        3 = d
         */
        //find all possible combinations of digit positions within equation (abcd-abdc-adbc-...)
        for (int i = 1; i < DIGITS_SET_SIZE; i++){
            temporaryList = new ArrayList<>(listOfDigitsPositionsSets);
            listOfDigitsPositionsSets = new ArrayList<>();
            for (Collection<?> analyzedSet : temporaryList){
                for (int j = 0; j < DIGITS_SET_SIZE; j++){
                    Set<Integer> digitsPositionsSet = new LinkedHashSet<>();
                    analyzedSet.forEach(number -> digitsPositionsSet.add((int)number));
                    digitsPositionsSet.add(j);
                    if (digitsPositionsSet.size() == i+1){
                        listOfDigitsPositionsSets.add(digitsPositionsSet);
                    }
                }
            }
        }
        //listOfDigitsPositionsSets.forEach(System.out::println);
        //System.out.println(listOfDigitsPositionsSets.size() + " digits positions combinations");

        //step 3
        //initialize listOfArithmeticOperatorsSets
        for (int i = 0; i <= 3; i++){
            listOfArithmeticOperatorsSets.add(new ArrayList<>(Collections.singletonList(i)));
        }
        /*
        0 = +
        1 = -
        2 = *
        3 = /
         */
        //find all possible arithmetic operations combinations with repetitions
        for (int i = 0; i < 2; i++){
            temporaryList =new ArrayList<>(listOfArithmeticOperatorsSets);
            listOfArithmeticOperatorsSets = new ArrayList<>();
            for (Collection<?> analyzedSet : temporaryList)
                    for(int j = 0; j < 4; j++){
                        List<Integer> operatorsSet = new ArrayList<>();
                        analyzedSet.forEach(number -> operatorsSet.add((int) number));
                        operatorsSet.add(j);
                        listOfArithmeticOperatorsSets.add(operatorsSet);
                    }
        }
        //listOfArithmeticOperatorsSets.forEach(System.out::println);
        //System.out.println(listOfArithmeticOperatorsSets.size() + " operators sets");

        //step 4
        //find all brackets combinations
        //will write all manually because of complication of finding all possible combinations
        {
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList())));    //* * * *
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(0)), new ArrayList<>(Arrays.asList(1))));    // (* *) * *
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(2)), new ArrayList<>(Arrays.asList(3))));    //* * (* *)
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(2))));    //* (* *) *
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(0,2)), new ArrayList<>(Arrays.asList(1,3))));    //(* *) (* *)
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(0)), new ArrayList<>(Arrays.asList(2))));    //(* * *) *
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(3))));    //* (* * *)
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(0,0)), new ArrayList<>(Arrays.asList(1,2))));    //((* *) *) *
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(0,1)), new ArrayList<>(Arrays.asList(2,2))));    //(* (* *)) *
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(1,1)), new ArrayList<>(Arrays.asList(2,3))));    //* ((* *) *)
            listOfBracketsPairs.add(new AbstractMap.SimpleEntry<>(new ArrayList<>(Arrays.asList(1,2)), new ArrayList<>(Arrays.asList(3,3))));    //* (* (* *))
            //System.out.println(listOfBracketsPairs.size() + " brackets combinations");
        }

        //mega-step 5
        //find and evaluate all equations of all 4 digits sets
        //every integer result will be put in a set and a loop 1 to 9*8*7*6 will check the maximum consecutive integer that is element of the set
        int loadCounter = 1;
        for (Set<Integer> analyzedDigitsSet : listOfDigitsSets){
            System.out.println("step " + loadCounter + " out of " + listOfDigitsSets.size());
            loadCounter++;
            List<Integer> analyzedDigitsSetList = new ArrayList<>(analyzedDigitsSet);
            int maxSolutionPossible = 1;
            boolean _1 = false;
            for (int i = DIGITS_SET_SIZE - 1; i >=0; i--){
                if(analyzedDigitsSetList.get(i) == 0){
                    continue;
                }
                if(analyzedDigitsSetList.get(i) == 1){
                    _1 = true;
                    continue;
                }
                if(_1){
                    maxSolutionPossible *= (analyzedDigitsSetList.get(i) + 1);
                    _1 = false;
                }else{
                    maxSolutionPossible *= analyzedDigitsSetList.get(i);
                }
            }
            if(solution.getValue() >= maxSolutionPossible){
                continue;
            }
            listOfDigitsSetEquations = new ArrayList<>();
            for (Set<Integer> analyzedDigitsPositionsSet : listOfDigitsPositionsSets){
                List<Integer> analyzedDigitsPositionsSetList = new ArrayList<>(analyzedDigitsPositionsSet);
                for (List<Integer> analyzedArithmeticOperatorSet : listOfArithmeticOperatorsSets){
                    for (AbstractMap.SimpleEntry<List<Integer>,List<Integer>> analyzedBracketsPair : listOfBracketsPairs){
                        equation = new StringBuilder();
                        for(int i = 0; i < DIGITS_SET_SIZE; i++){
                            //first will add open brackets if there are
                            if(analyzedBracketsPair.getKey().contains(i)){
                                if (Collections.frequency(analyzedBracketsPair.getKey(), i) == 1){
                                    equation.append("(");
                                }else {
                                    equation.append("((");
                                }
                            }
                            //second will add the digit
                            equation.append(String.valueOf(analyzedDigitsSetList.get(analyzedDigitsPositionsSetList.get(i))));
                            //third will add closed brackets if there are
                            if(analyzedBracketsPair.getValue().contains(i)){
                                if (Collections.frequency(analyzedBracketsPair.getValue(), i) == 1){
                                    equation.append(")");
                                }else {
                                    equation.append("))");
                                }
                            }
                            //fourth will ad the operator if there is
                            if(i < analyzedArithmeticOperatorSet.size()){
                                equation.append(arithmeticOperatorsMap.get(analyzedArithmeticOperatorSet.get(i)));
                            }
                        }
                        listOfDigitsSetEquations.add(equation.toString());
                        //System.out.println(equation);
                        //if equation contains only + - or only * / will consider only no-brackets case
                        if((!analyzedArithmeticOperatorSet.contains(0) && !analyzedArithmeticOperatorSet.contains(1))
                                ||
                                (!analyzedArithmeticOperatorSet.contains(2) && !analyzedArithmeticOperatorSet.contains(3))){
                            break;
                        }
                    }
                }
            }
            listOfNatuaralSolutions = new HashSet<>();
            for (String analyzedEquation : listOfDigitsSetEquations){
                Object equationSolution = null;
                try {
                    equationSolution = engine.eval(analyzedEquation);
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
                if(equationSolution instanceof Integer){
                    listOfNatuaralSolutions.add((int) equationSolution);
                }else if (equationSolution instanceof Double && (Double) equationSolution % 1 == 0){
                    listOfNatuaralSolutions.add(((Double) equationSolution).intValue());
                }
            }
            int consecutiveNaturalResults = 0;
            for(int i = 1; i <= listOfNatuaralSolutions.size(); i++){
                if (listOfNatuaralSolutions.contains(i)){
                    consecutiveNaturalResults = i;
                }else{
                    if (consecutiveNaturalResults > biggestConsecutiveNaturalResults){
                        biggestConsecutiveNaturalResults = consecutiveNaturalResults;
                        StringBuilder solutionSting = new StringBuilder();
                        for (Integer digit : analyzedDigitsSetList){
                            solutionSting.append(digit);
                        }
                        solution = new AbstractMap.SimpleEntry<>(Integer.parseInt(solutionSting.reverse().toString()), biggestConsecutiveNaturalResults);
                    }
                    break;
                }
            }
        }
        return solution;
    }
}