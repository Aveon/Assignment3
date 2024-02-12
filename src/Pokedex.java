import java.util.ArrayList;

public class Pokedex
{
    private ArrayList<Pokemon> myPokedex = new ArrayList<>();

    public void addToDex(Pokemon brock)
    {
        myPokedex.add(brock);
    }
    @Override
    public String toString()
    {
        String name = "";

        for(Pokemon pokemon : myPokedex)
        {
            name += pokemon.toString() + "\n";
        }
        return name;
    }

}
