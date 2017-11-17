import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        int userOption = 0;

        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to your new PokeDex!\nHow many Pokemon are in your region: ");

        int numPokemon = scnr.nextInt();

        Pokedex newPokedex = new Pokedex(numPokemon);

        System.out.println("\nYour new Pokedex can hold " + numPokemon + " pokemon. Let's start using it!");


        while (userOption != 6) {

            System.out.println("\n1. List Pokemon\n2. Add Pokemon\n3. Check Pokemon Stats\n4. Evolve Pokemon\n5. Sort Pokemon\n6. Exit\n\nWhat would you like to do?");

            userOption = scnr.nextInt();

            switch (userOption) {

                case 1:

                    for (int i = 0; i < newPokedex.listPokemon().length; i++) {
                        if (newPokedex.listPokemon()[i] != null) {
                            System.out.println(i + 1 + ". " + newPokedex.listPokemon()[i]);
                        }
                    }

                    break;

                case 2:

                    System.out.println("\nPlease enter the Pokemon's Species: ");

                    String checkThisPokemon = scnr.next();

                    newPokedex.addPokemon(checkThisPokemon);

                    break;

                case 3:

                    System.out.println("\nPlease enter the Pokemon of interest: ");

                    String statPokemon = scnr.next();

                    newPokedex.checkStats(statPokemon);

                    break;

                case 4:

                    System.out.println("\nPlease enter the Pokemon of interest: ");

                    String pokemonToEvolve = scnr.next();

                    if (newPokedex.evolvePokemon(pokemonToEvolve)) {
                        System.out.println(pokemonToEvolve + " has evolved!");
                    }
                    else {
                        System.out.println("Missing");
                    }

                    break;

                case 5:

                    newPokedex.sortPokedex();

                    break;

                case 6:

                    break;

                default:

                    System.out.println("\nThat is not a valid choice. Try again.");
                    break;
            }




        }

    }
}

