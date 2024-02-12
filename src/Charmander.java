public class Charmander extends Pokemon
{
    public Charmander(int level)
    {
        super(level, 0.2);
    }
    @Override
    public String toString()
    {
        return "A level "+super.getLevel()+" Charmander";
    }
}
