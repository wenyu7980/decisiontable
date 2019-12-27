package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

import java.util.Objects;

/**
 * 小于
 * @author:wenyu
 * @date:2019/12/27
 */
public class LessThan<T extends Comparable<T>> implements DecisionMatch {

    private T value;

    public LessThan(T value) {
        assert Objects.nonNull(value);
        this.value = value;
    }

    @Override
    public boolean match(Object object) {
        return object != null && value.compareTo((T) object) > 0;
    }
}
