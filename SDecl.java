public class SDecl extends Statement {

    private ID v;


    public SDecl(String name) {
        this.v = new ID(name);
    }

    public ID getVariabe() {
        return v;
    }
    
    public void accept(Visitor v){
        v.visit(this);
    }

}
