package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

import java.util.stream.Stream;

/**
 * 包含
 * @author:wenyu
 * @date:2019/12/27
 */
public class In implements DecisionMatch {
    private Object[] values;

    public In(Object... values) {
        this.values = values;
    }

    @Override
    public boolean match(Object object) {
        return Stream.of(values)
                .anyMatch(value -> new Equal(value).match(object));
    }
}
