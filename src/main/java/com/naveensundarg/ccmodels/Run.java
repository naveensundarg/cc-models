package  com.naveensundarg.ccmodels;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import com.naveensundarg.shadow.prover.core.Prover;
import com.naveensundarg.shadow.prover.core.SnarkWrapper;
import com.naveensundarg.shadow.prover.core.ccprovers.CognitiveCalculusProver;
import com.naveensundarg.shadow.prover.core.proof.Justification;
import com.naveensundarg.shadow.prover.utils.Problem;
import com.naveensundarg.shadow.prover.utils.ProblemReader;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Run {

    public static void main(String[] args) throws Exception {

        runFromProblemFile();
       // runFromProblemFile();

    }

    static ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
            .foreground(Ansi.FColor.WHITE).background(Ansi.BColor.BLACK)   //setting format
            .build();

    private static void runFromProblemFile() throws Exception {

        boolean[] status = new boolean[5];
        long[] time = new long[5];
        for(int i = 5; i<= 5; i++) {

            System.out.println("------------- Level "+  i + " ----------------------");

            String fileName = "./infinitary-false-beliefs/FBT-" + i +".clj";


            List<Problem> problems = ProblemReader.readFrom(Run.class.getResourceAsStream(fileName));

            Problem firstProblem = problems.get(0);

            Prover prover =  new CognitiveCalculusProver(i+1);


            long start = System.currentTimeMillis();

            Optional<Justification> justificationOptional = prover.prove(firstProblem.getAssumptions(), firstProblem.getGoal());
            long end = System.currentTimeMillis();

            time[i-1] = end -start;
            if (justificationOptional.isPresent()) {
                colorPrinter.print( "SUCCESS", Ansi.Attribute.BOLD, Ansi.FColor.BLACK, Ansi.BColor.GREEN);
                status[i-1] = true;
            } else {
                System.out.println("Failure");
                status[i-1] = false;


            }

           // System.out.println("-----------------------------------");

        }

     /*   for(int i = 0; i< 5; i++) {

            System.out.println("TIME: " + i + " --> " + time[i] );
            System.out.println("STATUS: " + i + " --> " + status[i] );


        }*/

    }
}