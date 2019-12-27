package com.wenyu7980.decisiontable.match;

import com.wenyu7980.decisiontable.DecisionMatch;

/**
 * 非空
 * @author:wenyu
 * @date:2019/12/27
 */
public class NonNull implements DecisionMatch {
    @Override
    public boolean match(Object object) {
        return object != null;
    }
}
