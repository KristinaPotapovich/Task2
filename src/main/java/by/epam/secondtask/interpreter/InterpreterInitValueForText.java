package by.epam.secondtask.interpreter;

import org.mvel2.MVEL;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InterpreterInitValueForText {
    public static final double VALUE_FOR_I = 12.0;
    public static final double VALUE_FOR_J = 22.0;

    private InterpreterInitValueForText() {
    }

    public static String initValue(String formula) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("i", VALUE_FOR_I);
        vars.put("j", VALUE_FOR_J);
        Serializable s = MVEL.compileExpression(formula);
        formula = MVEL.executeExpression(s, vars).toString();
        return formula;
    }
}
