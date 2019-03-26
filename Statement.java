public abstract class Statement {
    public abstract <T> T accept(Visitor<T> v);
}
