public class SDecl {

    private Variable v;


    public SDecl(String name) {
        this.v = new Variable(name);
    }

    public Variable getVariabe() {
        return v;
    }

}
