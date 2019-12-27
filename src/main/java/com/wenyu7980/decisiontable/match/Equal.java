package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

/**
 * 等于
 * @author:wenyu
 * @date:2019/12/27
 */
public class Equal implements DecisionMatch {
    private Object value;

    public Equal(Object value) {
        assert value != null;
        this.value = value;
    }

    @Override
    public boolean match(Object object) {
        return value.equals(object) || (object != null
                && value instanceof Comparable
                && ((Comparable) value).compareTo(object) == 0);
    }
}
