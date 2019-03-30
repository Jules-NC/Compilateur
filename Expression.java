public abstract class Expression extends Statement{
    protected Type type;

    public void setType(Type t){
        this.type = t;
    }

    public Type getType(){
        return this.type;
    }
}
