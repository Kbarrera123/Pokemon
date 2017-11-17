import java.util.Arrays;
import java.util.Comparator;

public class Pokedex {

    private Pokemon[] arrayOfPokemon;

    public Pokedex(int arraySize) {
        arrayOfPokemon = new Pokemon[arraySize];

    }

    public String[] listPokemon() {

        String[] stringArray = new String[arrayOfPokemon.length];

        for (int i = 0; i < arrayOfPokemon.length; i++) {
            if (arrayOfPokemon[i] != null) {
                stringArray[i] = arrayOfPokemon[i].getSpecies();
                }
            }

        return stringArray;
    }

    public boolean addPokemon(String species) {
        for (int i = 0; i < arrayOfPokemon.length; i++) {
            if (arrayOfPokemon[i] == null) {
                arrayOfPokemon[i] = new Pokemon(species);
                return true;
            }
            else if (species.equalsIgnoreCase(arrayOfPokemon[i].getSpecies())) {
                System.out.println("Duplicate");
                return false;
            }
            else if (i + 1 == arrayOfPokemon.length) {
                System.out.println("Max");
            }
        }
        return false;
    }

    public int[] checkStats(String species) {
        int[] statArray = new int[3];
        int speciesNum;

        for (int i = 0; i < arrayOfPokemon.length; i++) {
            if (arrayOfPokemon[i] == null) {
                System.out.println("Missing");
                break;
            }
            else if (species.equals(arrayOfPokemon[i].getSpecies())) {

                speciesNum = i;

                statArray[0] = arrayOfPokemon[speciesNum].getAttack();
                statArray[1] = arrayOfPokemon[speciesNum].getDefense();
                statArray[2] = arrayOfPokemon[speciesNum].getSpeed();

                System.out.println("\nThe stats for " + species + " are: ");
                System.out.println("Attack: " + statArray[0]);
                System.out.println("Defense: " + statArray[1]);
                System.out.println("Speed: " + statArray[2]);

                break;

            }

        }

        return statArray;

    }

    public boolean evolvePokemon(String species) {
        int speciesNum = 0;

        for (int i = 0; i < arrayOfPokemon.length; i++) {
            if (arrayOfPokemon[i] != null && species.equals(arrayOfPokemon[i].getSpecies())) {
                speciesNum = i;
            }
        }

        if (species.equals(arrayOfPokemon[speciesNum].getSpecies())) {
            arrayOfPokemon[speciesNum].evolve();
            return true;
        }
        else {
            return false;
        }

    }

    public void sortPokedex() {

        Arrays.sort(arrayOfPokemon, Comparator.nullsLast(Comparator.naturalOrder()));

    }


}

