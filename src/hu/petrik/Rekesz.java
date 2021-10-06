package hu.petrik;

import java.util.ArrayList;
import java.util.List;

public class Rekesz {
    int max_teherbiras;
    List<Palack> palackok;

    public Rekesz(int max_teherbiras) {
        this.max_teherbiras = max_teherbiras;
        palackok = new ArrayList();
    }

    public int getSuly() {
        int sum = 0;
        for (Palack palack : palackok) {
            sum += palack.getSuly();
        }
        return sum;
    }

    public List<Palack> getPalackok() {
        return palackok;
    }

    public void uj_palack(Palack palack) {
        if (palack.getSuly() + getSuly() < max_teherbiras) {
            palackok.add(palack);
        }
    }

    public int osszes_penz() {
        int sum = 0;
        for (Palack palack : palackok) {
            if (palack.getClass() == VisszavalthatoPalack.class){
                sum += ((VisszavalthatoPalack) palack).getPalacDij();
            }
        }
        return sum;
    }
}
