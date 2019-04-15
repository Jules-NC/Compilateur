import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;

public class TypeCheckerVisitor extends Visitor{

    public Type TYPE;
    public LinkedList<HashMap<String, Variable>> scopeVars;
    
    
    public TypeCheckerVisitor (){
        this.scopeVars = new LinkedList<>();
        this.scopeVars.push(new HashMap<String, Variable>());
    }

    public void visit(Scope o){
        this.scopeVars.push(new HashMap<>());
        ArrayList<Statement> statements = o.getStatements();
      
        for(Statement s: o.getStatements())
            s.accept(this);
           
        this.scopeVars.pop();   
        this.TYPE = Type.P_Void;
    }

    public void visit(SExpression o){
        o.getExpression().accept(this);
        this.TYPE = Type.P_Void;
    }

    // TYPE ID ";"
    public void visit(SDecl decl) {
        decl.getVariabe().accept(this);
        String str = decl.getVariabe().getName();
        if(this.scopeVars.peek().containsKey(str)){
            throw new RuntimeException("Double declaration");
        }
        else{
            Variable v = new Variable(str);
            v.setValeur(decl.getVariabe().getValeur());
            this.scopeVars.peek().put(str, v);
        }
    }

    // TYPE ID "=" Expr ";"
    public void visit(SInit i) {
        i.getVariabe().accept(this);
        Type t1 = this.TYPE;
        i.getExpression().accept(this);
        Type t2 = this.TYPE;
        String str = i.getVariabe().getName();
        
        if(this.scopeVars.peek().containsKey(str)){
            throw new RuntimeException("Double declaration");
        }
        
        Variable v = new Variable(str);
        
        this.scopeVars.peek().put(str, v);
        
        if(t1==t2){
            this.TYPE = Type.P_Void;
        }
        else{
            throw new RuntimeException("Invalid Type");
        }
        
    }

    public void visit(SAssign a){
        a.getVariable().accept(this);
        Type t1 = this.TYPE;
        a.getExpression().accept(this);
        Type t2 = this.TYPE;

        if(t1==t2){
            this.TYPE = Type.P_Void;
        }
        else{
            throw new RuntimeException("Invalid Type");
        }

    }
    
    public void visit(Variable v){
        String str = v.getName();
        boolean flag=false;
        for(HashMap<String, Variable> hm : this.scopeVars){
            if(hm.containsKey(str)){
                flag=true;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("Variable not declared");
        }
        this.TYPE = Type.P_Int;
        
    }
    
    public void visit(ID i){
        this.TYPE = Type.P_Int;
    }

    public void visit(Print var1){
        var1.getExpression().accept(this);
        this.TYPE = var1.getExpression().getType();
    }

    public void visit(IfThenElse o){
        o.getCondition().accept(this);
        o.getThenStatement().accept(this);
        o.getElseStatement().accept(this);
        this.TYPE = Type.P_Void;
    }
    
    public void visit(WhileDo w){
        w.getCondition().accept(this);
        w.getDoStatement().accept(this);
        this.TYPE = Type.P_Void;
    }

    public void visit(PString o){
        this.TYPE = Type.P_String;
    }

    public void visit(Num n){
        this.TYPE = Type.P_Int;
    }

    public void visit(Add a){
        a.getOp1().accept(this);
        Type t1 = this.TYPE;
        a.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            a.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Sub a){
        a.getOp1().accept(this);
        Type t1 = this.TYPE;
        a.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            a.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Mul m){
        m.getOp1().accept(this);
        Type t1 = this.TYPE;
        m.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            m.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Div d){
        d.getOp1().accept(this);
        Type t1 = this.TYPE;
        d.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            d.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Negative n){
        n.getExpression().accept(this);
        Type t1 = this.TYPE;

        if(t1 != Type.P_String){
            n.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Equal e){
        e.getOp1().accept(this);
        Type t1 = this.TYPE;
        e.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            e.setType(Type.P_Int);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(NotEqual n){
        n.getOp1().accept(this);
        Type t1 = this.TYPE;
        n.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            n.setType(Type.P_Int);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Less l){
        l.getOp1().accept(this);
        Type t1 = this.TYPE;
        l.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            l.setType(Type.P_Int);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Greater g){
        g.getOp1().accept(this);
        Type t1 = this.TYPE;
        g.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            g.setType(Type.P_Int);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(LessOrEqual l){
        l.getOp1().accept(this);
        Type t1 = this.TYPE;
        l.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            l.setType(Type.P_Int);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(GreaterOrEqual g){
        g.getOp1().accept(this);
        Type t1 = this.TYPE;
        g.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            g.setType(Type.P_Int);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }
}
