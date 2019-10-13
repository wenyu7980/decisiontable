package com.wenyu7980.decisiontable;

/**
 * 比较
 * @author wenyu
 */
public class DecisionCompare {
    /**
     * 等于
     * @param object
     * @return
     */
    public static Decision EQ(Object object) {
        return Decision.of(Compare.EQ, object);
    }

    public static <T extends Comparable<T>> Decision GE(T t) {
        return Decision.of(Compare.GE, t);
    }

    public static <T extends Comparable<T>> Decision LT(T t) {
        return Decision.of(Compare.LT, t);
    }

    public static <T extends Comparable<T>> Decision LE(T t) {
        return Decision.of(Compare.LE, t);
    }

    public static <T extends Comparable<T>> Decision GT(T t) {
        return Decision.of(Compare.GT, t);
    }

    public static Decision NE(Object object) {
        return Decision.of(Compare.NE, object);
    }

    public static Decision IN(Object... objects) {
        return Decision.of(Compare.IN, objects);
    }

    public static Decision NOT_IN(Object... objects) {
        return Decision.of(Compare.NOT_IN, objects);
    }

    public static Decision NULL() {
        return Decision.of(Compare.NULL);
    }

    public static Decision NOT_NULL() {
        return Decision.of(Compare.NOT_NULL);
    }

    public static Decision ANY() {
        return Decision.of(Compare.ANY);
    }
}
