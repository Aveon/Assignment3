public class Bulbasaur extends Pokemon
{
    public Bulbasaur(int level)
    {

        super(level, 0.2);
    }
    @Override
    public String toString()
    {
        return "A level "+super.getLevel() +" Bulbasaur";
    }
}


