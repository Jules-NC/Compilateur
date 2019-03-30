import java.util.ArrayList;

public abstract class Test{
    public static Statement test(){
        Variable v = new Variable("lol");
        Expression n = new Num(3);
        Statement si = new SInit(v, n);
        Scope s = new Scope();
        s.addStatement(si);
        
        Expression exp2 = new Variable("lol");
        Statement st2 = new SExpression(exp2);
        s.addStatement(st2);
        
        EvaluateVisitor ev = new EvaluateVisitor();
        PrettyPrintVisitor ppv = new PrettyPrintVisitor();
        
        ev.visit(s);
        ppv.visit(s);
        
        System.out.println(ppv.STR_VALUE);
        return s;
   }
} 
