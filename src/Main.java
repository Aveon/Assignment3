import java.util.Scanner;
import java.util.Random;
public class Main
{
    Scanner scan = new Scanner(System.in);

    public static Pokemon spawn()
    {
        Random rand = new Random();
        int level = rand.nextInt(21);
        int whoIsIt = rand.nextInt(4);
        Pokemon ash;
        switch(whoIsIt)
        {
            case 1:
                ash = new Bulbasaur(level);
                break;
            case 2:
                ash = new Charmander(level);
                break;
            default:
                ash = new Caterpie(level);
                break;
        }
        System.out.println("You encounter " + ash.toString());
        return ash;
    }
    public static float throwBall()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What type of ball do you wish to use? (Poke, Great, Ultra)");
        String ball = scan.next();
        float ballMultiplier = 0;
        switch(ball.toLowerCase())
        {
            case "poke":
                ballMultiplier = 1f;
                break;
            case "great":
                ballMultiplier = 1.5f;
                break;
            case "ultra":
                ballMultiplier = 2f;
                break;
        }
        System.out.println("What berry do you wish to use? (None, Razz, SilverPinap, GoldenRazz)");
        String berry = scan.next();
        float berryMultiplier = 0;
        switch(berry.toLowerCase())
        {
            case "razz":
                berryMultiplier = 1.5f;
                break;
            case "silverpinap":
                berryMultiplier = 1.8f;
                break;
            case "goldenrazz":
                berryMultiplier = 2.5f;
                break;
            default:
                berryMultiplier = 1;
                break;
        }
        System.out.println("Is this a curveball? (Yes or No)");
        String ans = scan.next();
        float curveMultiplier = 0;
        switch(ans.toLowerCase())
        {
            case "yes":
                curveMultiplier = 1.7f;
                break;
            default:
                curveMultiplier = 1;
        }
        float total = ballMultiplier*berryMultiplier*curveMultiplier;
        return total;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Pokedex myDex = new Pokedex();
        boolean pokeCaught = false;
        String continueGame = "y";

        while(continueGame.equalsIgnoreCase("y"))
        {
            Pokemon myPal = spawn();
            double cpm = 0.49985844;

            while(!pokeCaught)
            {
                float multiplier = throwBall();
                double BCR = myPal.getBaseCatchRate();
                double catchProbablity = 1 - Math.pow(1 - BCR*cpm, multiplier);

                if(Math.random() < catchProbablity)
                {
                    System.out.println(myPal.toString() + " Caught!");
                    myDex.addToDex(myPal);
                    pokeCaught = true;
                }
                else
                {
                    System.out.println("Oops " +myPal.toString()+" jumped out, try again!");
                }
            }
            System.out.println("Continue catching Pokemon? (Y/N)");
            continueGame = scan.next();
            if(continueGame.equalsIgnoreCase("y"))
            {
                pokeCaught = false;
            }

        }
        System.out.println("You have the following Pokemon:");
        System.out.println(myDex.toString());

    }
}