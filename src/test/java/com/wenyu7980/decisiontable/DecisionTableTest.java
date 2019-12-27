package com.wenyu7980.decisiontable;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.wenyu7980.decisiontable.DecisionMatches.*;

public class DecisionTableTest {
    @Test
    public void testTable() {
        DecisionTable<Integer> table = DecisionTable.of();
        table.add(1, EQ(BigDecimal.ONE), LT(5), GT(10));
        table.add(2, NE(BigDecimal.ONE), GE(5), LE(10));
        table.add(3, NE(BigDecimal.ONE), NOT_NULL(), NULL());
        table.add(4, NE(BigDecimal.ONE), NULL(), NOT_NULL());
        table.add(5, NE(BigDecimal.ONE), ANY(), NULL());
        Assert.assertEquals(Integer.valueOf(1),
                table.get(BigDecimal.valueOf(1.0), 4, 11).get());
        Assert.assertEquals(Integer.valueOf(2),
                table.get(BigDecimal.valueOf(2.0), 5, 10).get());
        Assert.assertEquals(Integer.valueOf(2),
                table.get(BigDecimal.valueOf(2.0), 6, 9).get());
        Assert.assertEquals(Integer.valueOf(3),
                table.get(BigDecimal.valueOf(2.0), 3, null).get());
        Assert.assertEquals(Integer.valueOf(4),
                table.get(BigDecimal.valueOf(2.0), null, 9).get());
        Assert.assertEquals(Integer.valueOf(5),
                table.get(BigDecimal.valueOf(2.0), null, null).get());
    }

    @Test
    public void testIn() {
        DecisionTable<Integer> table = DecisionTable.of();
        table.add(1, IN(1, 2, 3));
        table.add(2, NOT_IN(1, 2, 3));
        Assert.assertEquals(Integer.valueOf(1), table.get(1).get());
        Assert.assertEquals(Integer.valueOf(2), table.get(4).get());
    }

    @Test
    public void testGE() {
        Assert.assertTrue(GE(5).match(5));
    }
}
