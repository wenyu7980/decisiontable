package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

import java.util.stream.Stream;

/**
 * 不包含
 * @author:wenyu
 * @date:2019/12/27
 */
public class NotIn implements DecisionMatch {
    private Object[] values;

    public NotIn(Object... values) {
        this.values = values;
    }

    @Override
    public boolean match(Object object) {
        return Stream.of(values)
                .noneMatch(value -> new Equal(value).match(object));
    }
}
