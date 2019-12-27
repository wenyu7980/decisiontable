package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

/**
 * 小于等于
 * @author:wenyu
 * @date:2019/12/27
 */
public class LessEqual<T extends Comparable<T>> implements DecisionMatch {
    private T value;

    public LessEqual(T value) {
        this.value = value;
    }

    @Override
    public boolean match(Object object) {
        return object != null && new Equal(this.value).match(object)
                || new LessThan<>(this.value).match(object);
    }
}
