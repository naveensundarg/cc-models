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
import java.util.List;
import java.util.Optional;

public class Run {

    public static void main(String[] args) throws Exception {

        runFromProblemFile();
    }

    static ColoredPrinter colorPrinter = new ColoredPrinter.Builder(1, false)
            .foreground(Ansi.FColor.WHITE).background(Ansi.BColor.BLACK)   //setting format
            .build();

    private static void runFromProblemFile() throws Exception {


        String fileName = "phi1.clj";


        List<Problem> problems = ProblemReader.readFrom(Run.class.getResourceAsStream(fileName));

        Problem firstProblem = problems.get(0);

        Prover prover =  SnarkWrapper.getInstance();


        Optional<Justification> justificationOptional = prover.prove(firstProblem.getAssumptions(), firstProblem.getGoal());

        if (justificationOptional.isPresent()) {
            colorPrinter.print( "SUCCESS", Ansi.Attribute.BOLD, Ansi.FColor.BLACK, Ansi.BColor.GREEN);
        } else {
            System.out.println("Failure");

        }

    }
}