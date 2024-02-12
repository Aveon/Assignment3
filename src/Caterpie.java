public class Caterpie extends Pokemon
{
    public Caterpie(int level)
    {
        super(level, 0.5);
    }
    @Override
    public String toString()
    {
        return "A level "+super.getLevel()+" Caterpie";
    }
}
