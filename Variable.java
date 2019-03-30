public class Variable extends Expression {
    private int valeur;
    private String name;

    public Variable(String name) {
        this.valeur = 0;
        this.name = name;
        this.type = Type.P_Int;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int v){
        this.valeur = v;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
