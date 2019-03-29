public class PString extends Expression{

    String s;

    public PString(String s){
        this.type = Type.P_String;
        this.s = s;
    }

    public String getValue() {
        return s;
    }

    public void accept(Visitor v){  v.visit(this);
    }
}
