package com.wenyu7980.decisiontable;

/**
 * 判定项
 * @author wenyu
 */
public class Decision {
    private Compare compare;
    private Object[] objects;

    private Decision(Compare compare, Object[] objects) {
        this.compare = compare;
        this.objects = objects;
    }

    public static Decision of(Compare compare, Object[] objects) {
        return new Decision(compare, objects);
    }

    public static Decision of(Compare compare, Object object) {
        return new Decision(compare, new Object[] { object });
    }

    public static Decision of(Compare compare) {
        return new Decision(compare, null);
    }

    public boolean match(Object object) {
        return compare.compareTo(object, this.objects);
    }
}
