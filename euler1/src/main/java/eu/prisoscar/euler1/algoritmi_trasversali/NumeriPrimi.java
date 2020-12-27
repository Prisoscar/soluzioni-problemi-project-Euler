package eu.prisoscar.euler1.algoritmi_trasversali;

import java.util.ArrayList;
import java.util.List;

//tutti gli algoritmi per trovare e maneggiare numeri primi si trovano in questa classe
public class NumeriPrimi {

    //i numeri primi verranno inserirti in una List, attenzione a non saturare la ram con questo algoritmo
    public static List<Long> trovaPrimi(long max) {

        List<Long> listaPrimi = new ArrayList<>();
        long maxDiv;
        boolean isPrimo = false;

        //Supponendo che 1 non è numero primo
        //fino a tre inserisco i primi in manbiera manuale
        if (max <= 1) {     //controllo sull'input
            return null;
        } /*else if (max == 1) {
            listaPrimi.add(max);
            return listaPrimi;
        }*/ else if (max == 2) {
           // listaPrimi.add(1L);
            listaPrimi.add(max);
            return listaPrimi;
        } else if (max == 3) {
           // listaPrimi.add(1L);
            listaPrimi.add(2L);
            listaPrimi.add(max);
            return listaPrimi;
        } else {
          //  listaPrimi.add(1L);
            listaPrimi.add(2L);
            listaPrimi.add(3L);
        }

        //algoritmo per trovare numeri primi sopra al 3
        for (long i = 3; i <= max; i += 2) {
            maxDiv = (i / 2) + 1;
            for (int j = 1; listaPrimi.get(j) < maxDiv; j++) {
                if (i % listaPrimi.get(j) == 0) {
                    isPrimo = false;
                    break;
                }
                maxDiv = (i / listaPrimi.get(j)) + 1;
            }
            if (isPrimo == true) {
                listaPrimi.add(i);
            } else {
                isPrimo = true;
            }
        }

        return listaPrimi;
    }

    //i numeri primi verranno inserirti in una List, attenzione a non saturare la ram con questo algoritmo
    public static List<Long> trovaPrimi(long min, long max) {

        List<Long> listaInteraPrimi;
        List<Long> listaPrimi = new ArrayList<>();

        if (min > max || min < 0) {
            return null;
        }

        listaInteraPrimi = trovaPrimi(max);

        if (min == max) {
            if (isPrimo(max)) {
                listaPrimi.add(max);
                return listaPrimi;
            } else {
                return null;
            }
        }
        for (long primo : listaInteraPrimi) {
            if (primo > max) {
                break;
            }
            if (primo >= min) {
                listaPrimi.add(primo);
            }
        }
        return listaPrimi;
    }

    //mi dice se un numero è primo
    //i numeri primi verranno inserirti in una List, attenzione a non saturare la ram con questo algoritmo
    public static boolean isPrimo(long num) {
        return trovaPrimi(num).contains(num);
    }
}
