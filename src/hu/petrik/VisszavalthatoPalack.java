package hu.petrik;

public class VisszavalthatoPalack extends Palack{

    private int palacDij;

    public VisszavalthatoPalack(String ital, int maxUrtartalom){
        super(ital,maxUrtartalom);
        this.palacDij = 25;
    }
    public VisszavalthatoPalack(String ital, int maxUrtartalom, int palacDij){
        super(ital,maxUrtartalom);
        this.palacDij = palacDij;
    }
    public VisszavalthatoPalack(String ital, int maxUrtartalom, int jelenlegiUrtartalom, int palacDij) {
        super(ital,maxUrtartalom,jelenlegiUrtartalom);
        this.palacDij = palacDij;
    }

    public int getPalacDij(){
        return this.palacDij;
    }

    @Override
    public String toString() {
        return "Visszavalthato" + super.toString();
    }
}
