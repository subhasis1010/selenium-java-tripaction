/*
Utility methods for certain operations during test case execution
 */

package tripAction.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Utility {

    public int generateRandomNumber() {
        Random r = new Random();
        return r.nextInt(2);
    }

    public float dataConversion(String rates) {
        return Float.parseFloat(rates.replace(",", "").substring(1));

    }

    public float sortRates(ArrayList<Float> al) {
        Collections.sort(al);
        return al.get(0);
    }


}

