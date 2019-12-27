package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

/**
 * 大于等于
 * @author:wenyu
 * @date:2019/12/27
 */
public class GreatEqual<T extends Comparable<T>> implements DecisionMatch {
    private T value;

    public GreatEqual(T value) {
        this.value = value;
    }

    @Override
    public boolean match(Object object) {
        return object != null && !(new LessThan<>(value).match(object));
    }
}
