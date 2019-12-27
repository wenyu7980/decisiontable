package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

/**
 * 不等于
 * @author:wenyu
 * @date:2019/12/27
 */
public class NotEqual implements DecisionMatch {
    private Object value;

    public NotEqual(Object value) {
        this.value = value;
    }

    @Override
    public boolean match(Object object) {
        return object != null && !(new Equal(value).match(object));
    }
}
