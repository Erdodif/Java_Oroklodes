package hu.petrik;

import java.util.Objects;

public class Palack {
    private String ital;
    private int maxUrtartalom;
    private int jelenlegiUrtartalom;

    public Palack(String ital, int maxUrtartalom) {
        this.ital = ital;
        this.maxUrtartalom = maxUrtartalom;
        this.jelenlegiUrtartalom = 1;
    }

    public Palack(String ital, int maxUrtartalom, int jelenlegiUrtartalom) {
        this.ital = ital;
        this.maxUrtartalom = maxUrtartalom;
        this.jelenlegiUrtartalom = jelenlegiUrtartalom;
    }

    public String getItal(){
        return this.ital;
    }

    public int getMaxUrtartalom() {
        return maxUrtartalom;
    }

    public int getJelenlegiUrtartalom() {
        return jelenlegiUrtartalom;
    }

    public void setJelenlegiUrtartalom(int jelenlegiUrtartalom) {
        if (jelenlegiUrtartalom > this.maxUrtartalom) {
            jelenlegiUrtartalom = maxUrtartalom;
        }
        if (jelenlegiUrtartalom < 0) {
            this.ital = null;
            jelenlegiUrtartalom = 0;
        }
        this.jelenlegiUrtartalom = jelenlegiUrtartalom;
    }

    public int getSuly() {
        return (maxUrtartalom / 35) + jelenlegiUrtartalom;
    }

    public void hozzaOnt(Palack palack) {
        int kulombseg = maxUrtartalom - jelenlegiUrtartalom;
        this.setJelenlegiUrtartalom(palack.getJelenlegiUrtartalom());
        palack.setJelenlegiUrtartalom(palack.getJelenlegiUrtartalom() - kulombseg);
        if (getItal()==null){
            this.ital = palack.getItal();
        } else if(!palack.getItal().equals(getItal())){
            this.ital = "keverék";
        }
    }

    @Override
    public String toString() {
        return "Palack, benne levő ital: " + ital +
                ", jelenleg " + jelenlegiUrtartalom +
                "ml van benne, maximum " + maxUrtartalom +
                "ml fér bele";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palack palack = (Palack) o;
        return getMaxUrtartalom() == palack.getMaxUrtartalom() &&
                getJelenlegiUrtartalom() == palack.getJelenlegiUrtartalom() &&
                getItal().equals(palack.getItal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItal(), getMaxUrtartalom(), getJelenlegiUrtartalom());
    }
}
