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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 判定表
 * @author wenyu
 */
public class DecisionTable<T> {
    private List<DecisionTableItem> items = new ArrayList<>();

    private DecisionTable() {
    }

    public static <T> DecisionTable<T> of() {
        return new DecisionTable<>();
    }

    public DecisionTable add(T result, DecisionMatch... decisionMatches) {
        items.add(
                new DecisionTableItem(result, Arrays.asList(decisionMatches)));
        return this;
    }

    public DecisionTable add(DecisionMatch... decisionMatches) {
        return add(null, decisionMatches);
    }

    public boolean match(Object... objects) {
        return this.get(objects).isPresent();
    }

    public Optional<T> get(Object... objects) {
        for (DecisionTableItem<T> item : items) {
            if (item.match(objects)) {
                return Optional.ofNullable(item.result);
            }
        }
        return Optional.empty();
    }

    protected static class DecisionTableItem<T> {
        private T result;
        private List<DecisionMatch> decisionMatches = new ArrayList<>();

        public DecisionTableItem(T result,
                List<DecisionMatch> decisionMatches) {
            this.result = result;
            this.decisionMatches = decisionMatches;
        }

        public boolean match(Object... objects) {
            assert objects.length == decisionMatches.size();
            for (int i = 0; i < objects.length; ++i) {
                if (!decisionMatches.get(i).match(objects[i])) {
                    return false;
                }
            }
            return true;
        }
    }

}
