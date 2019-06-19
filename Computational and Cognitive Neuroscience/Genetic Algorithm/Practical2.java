import java.util.Random;

/**
 * Some very basic stuff to get you started. It shows basically how each
 * chromosome is built.
 *
 * @author Jo Stevens
 * @author Alard Roebroeck
 * @author Victor Franke
 * @author Laurenz Ohnemüller
 * @version 1.2, 21 Nov 2018
 */

public class Practical2 {

    static final String TARGET = "HELLO WORLD";
    static char[] alphabet = new char[27];

    /**
     * @param args
     */
    public static void main(String[] args) {
        int popSize = 100;
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet[c - 'A'] = c;
        }
        alphabet[26] = ' ';

        Random generator = new Random(System.currentTimeMillis());
        Individual[] population = new Individual[popSize];
        // we initialize the population with random characters
        for (int i = 0; i < popSize; i++) {
            char[] tempChromosome = new char[TARGET.length()];
            for (int j = 0; j < TARGET.length(); j++) {
                tempChromosome[j] = alphabet[generator.nextInt(alphabet.length)]; //choose a random letter in the alphabet
            }
            population[i] = new Individual(tempChromosome);
        }
        // What does the population look like?
        for (int i = 0; i < population.length; i++) {

            System.out.println(population[i].genoToPhenotype());
        }
        int generation = 0;
        boolean noHit = true;
        // as long as we don't have 'HELLO WORLD' loop goes on
        while (noHit == true) {

            //for loop through population
            for (int i = 0; i < popSize; i++) {
                double fitnessadd = 0;

                //for loop through characters
                for (int j = 0; j < 11; j++) {

                    //add fitness score, if a individual has a character/chromosome on the right spot
                    if (TARGET.charAt(j) == population[i].genoToPhenotype().charAt(j)) {
                        fitnessadd++;
                    }
                }
                //give every individual his fitness
                population[i].setFitness(fitnessadd);
            }
            for (int i = 0; i < popSize; i++) {

                //if a Individual scores 11 fitness points='HELLO WORLD' -> stop the loop
                if (population[i].getFitness() == 11) {
                    noHit = false;
                }
            }
            //get the sorted array
            HeapSort.sort(population);

            //Selection Elitist, we only take the best 20
            Individual[] sortedpop = new Individual[20];

            //printing the sorted pop
            for (int i = 0; i < 20; i++) {
                sortedpop[i] = population[i];
                System.out.println(sortedpop[i].genoToPhenotype());
            }
            System.out.println();

            int childnumber = 0;
            Individual[] population2 = new Individual[popSize];
            int mother;
            // where we make the crossover (randomly)
            int crosspoint;
            //where we make the mutation (randomly)
            int mutationpoint;
            double mutationrate;

            // every 'father' crosses with 5 'mothers'. But not with himself
            for (int father = 0; father < 20; father++) {

                for (int j = 0; j < 5; j++) {

                    char[] child = new char[TARGET.length()];

                    //random number, which will give us the mother(in the sorted array)
                    mother = (int) (Math.random() * 19) + 1;
                    crosspoint = (int) (Math.random() * 10) + 1;
                    // intended case: we don't want to cross the same Individual
                    if (mother != father) {
                        // child gets genes of father until and including crosspoint
                        for (int x = 0; x < crosspoint + 1; x++) {

                            child[x] = population[father].genoToPhenotype().charAt(x);
                        }
                        //the rest of the genes are taken from the mother
                        for (int y = crosspoint + 1; y < TARGET.length(); y++) {

                            child[y] = population[mother].genoToPhenotype().charAt(y);
                        }
                    }
                    //if however mother and father are the same Individual we take a new mother - one less than before
                    //note: father starts at 0, where as mother starts at 1
                    if (mother == father) {
                        mother--;

                        for (int x = 0; x < crosspoint + 1; x++) {

                            child[x] = population[father].genoToPhenotype().charAt(x);
                        }
                        for (int y = crosspoint + 1; y < TARGET.length(); y++) {

                            child[y] = population[mother].genoToPhenotype().charAt(y);
                        }
                    }
                    //genereate random number, which will give us the index that we will mutate
                    mutationpoint = (int) (Math.random() * 11);

                    // mutation rate: only 5% gets mutated
                    // if x greater than 0.9, mutate child
                    if (Math.random() > 0.95) {

                        mutationpoint = (int) (Math.random() * 11);
                        // mutate on exactly one index always
                        child[mutationpoint] = alphabet[generator.nextInt(alphabet.length)];
                    }
                    population2[childnumber] = new Individual(child);
                    childnumber++;
                }
            }
            generation++;
            System.out.println("Generation: " + generation);
            System.out.println();

            // give population the values in every index from  population2
            for (int i = 0; i < population.length; i++) {
                population[i] = population2[i];
            }
        }
    }
}


/**
 * Some general programming remarks and hints:
 * - A crucial point is to set each individual's fitness (by the setFitness() method) before sorting. When is an individual fit?
 * How do you encode that into a double (between 0 and 1)?
 * - Decide when to stop, that is: when the algorithm has converged. And make sure you  terminate your loop when it does.
 * - print the whole population after convergence and print the number of generations it took to converge.
 * - print lots of output (especially if things go wrong).
 * - work in an orderly and structured fashion (use tabs, use methods,..)
 * - DONT'T make everything private. This will only complicate things. Keep variables local if possible
 * - A common error are mistakes against pass-by-reference (this means that you pass the
 * address of an object, not a copy of the object to the method). There is a deepclone method included in the
 * Individual class.Use it!
 * - You can compare your chromosome and your target string, using for eg. TARGET.charAt(i) == ...
 * - Check your integers and doubles (eg. don't use ints for double divisions).
 */