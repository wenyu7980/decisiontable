package com.wenyu7980.decisiontable;
/**
 * Copyright wenyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.wenyu7980.decisiontable.match.*;

/**
 * 比较
 * @author wenyu
 */
public class DecisionMatches {
    /**
     * 等于
     * @param object
     * @return
     */
    public static DecisionMatch EQ(Object object) {
        return new Equal(object);
    }

    public static <T extends Comparable<T>> DecisionMatch GE(T t) {
        return new GreatEqual<>(t);
    }

    public static <T extends Comparable<T>> DecisionMatch LT(T t) {
        return new LessThan<>(t);
    }

    public static <T extends Comparable<T>> DecisionMatch LE(T t) {
        return new LessEqual<>(t);
    }

    public static <T extends Comparable<T>> DecisionMatch GT(T t) {
        return new GreatThan<>(t);
    }

    public static DecisionMatch NE(Object object) {
        return new NotEqual(object);
    }

    public static DecisionMatch IN(Object... objects) {
        return new In(objects);
    }

    public static DecisionMatch NOT_IN(Object... objects) {
        return new NotIn(objects);
    }

    public static DecisionMatch NULL() {
        return new IsNull();
    }

    public static DecisionMatch NOT_NULL() {
        return new NonNull();
    }

    public static DecisionMatch ANY() {
        return (Object object) -> true;
    }
}
