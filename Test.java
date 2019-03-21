import static java.lang.System.out;

public abstract class Test
{
   public static void Test() {
       Expression trois = new Num(3);
       Expression deux = new Num(2);
       Expression plus = new Add(trois, deux);
       Expression dix = new Num(10);
       Expression mul = new Equal(plus, dix);
       
       PrettyPrintVisitor pp = new PrettyPrintVisitor();
       EvaluateVisitor v = new EvaluateVisitor();
       //System.out.println(mul instanceof Mul);
       
       
       Integer res2 = v.visit(mul);
       
       System.out.println(res2 + "\n");
    }
} 
