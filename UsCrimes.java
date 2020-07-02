import java.lang.String;

//Autumn Capasso
//UMUC
//CMIA 141

public class UsCrimes{

    public static void main(String[] args) {
        long timeStarted = System.currentTimeMillis();
        UsCrimeStats stats = new UsCrimeStats(args[0]);
        stats.openFile();
        stats.readFile();
        stats.runProgram();
        System.out.println("Elapsed time in seconds was: " + (System.currentTimeMillis() - timeStarted));
    }

}

