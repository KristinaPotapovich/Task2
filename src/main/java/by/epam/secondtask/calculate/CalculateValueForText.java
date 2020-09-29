package by.epam.secondtask.calculate;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CalculateValueForText {
    public static final double VALUE_FOR_I = 12.0;
    public static final double VALUE_FOR_J = 22.0;

    private CalculateValueForText() {
    }

    public static String initValue(String formula) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("i", VALUE_FOR_I);
        vars.put("j", VALUE_FOR_J);
        Serializable serializable = MVEL.compileExpression(formula);
        formula = MVEL.executeExpression(serializable, vars).toString();
        return formula;
    }
}
