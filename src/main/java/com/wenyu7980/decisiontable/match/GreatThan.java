package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

/**
 * 大于
 * @author:wenyu
 * @date:2019/12/27
 */
public class GreatThan<T extends Comparable<T>> implements DecisionMatch {
    private T value;

    public GreatThan(T value) {
        this.value = value;
    }

    @Override
    public boolean match(Object object) {
        return object != null && !(new LessEqual<>(value).match(object));
    }
}
