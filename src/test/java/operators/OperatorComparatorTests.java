package operators;

import org.junit.Assert;
import org.junit.Test;

public class OperatorComparatorTests {

    @Test
    public void testSameLevelOperators() {
        Operator add = new Add();
        Operator subtract = new Subtract();
        Assert.assertEquals(0, new OperatorComparator().compare(add, subtract));
    }

    @Test
    public void testDifferentLevelOperators() {
        Operator add = new Add();
        Operator stackSnapshot = new StackSnapshot();
        Assert.assertTrue(new OperatorComparator().compare(add, stackSnapshot) < 0);
        Assert.assertTrue(new OperatorComparator().compare(stackSnapshot, add) > 0);
    }
}
