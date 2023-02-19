package cases;

import casesolver.Case;
import casesolver.Suspect;
import casesolver.logic.expressions.BooleanExpression;

import static casesolver.logic.FormulaBuilder.*;

public class IshinMochiCase {

    public static void solveCase() {
        final String higashihara = "Higashihara";
        final String nishiyama = "Nishiyama";
        final String nakagawa = "Nakagawa";
        final String minamino = "Minamino";
        final String kitajima = "Kitajima";

        final BooleanExpression varHigashihara = variable(higashihara);
        final BooleanExpression varNishiyama = variable(nishiyama);
        final BooleanExpression varNakagawa = variable(nakagawa);
        final BooleanExpression varMinamino = variable(minamino);
        final BooleanExpression varKitajima = variable(kitajima);

        Case theCase = new Case(
            2,
            new Suspect(
                higashihara,
                /*
                    One of the culprits must be Kitajima
                    Saw him with his hands on the thing
                 */
                varKitajima
            ),
            new Suspect(
                nishiyama,
                /*
                    Higashihara and Minamino had keys to snack room
                    One of them or both
                 */
                or(varHigashihara, varMinamino)
            ),
            new Suspect(
                nakagawa,
                /*
                    Saw Minamino with mochi filling on mouth
                    Nishiyama is clean
                 */
                and(varMinamino, not(varNishiyama))
            ),
            new Suspect(
                minamino,
                // Must be Nishiyama, had daifuku powder on clothes
                varNishiyama
            ),
            new Suspect(
                kitajima,
                // Either Nakagawa or Minamino, but not both
                xor(varNakagawa, varMinamino)
            )
        );

        for (Suspect suspect : theCase.solve()) {
            System.out.println(suspect.getName());
        }
    }

}
