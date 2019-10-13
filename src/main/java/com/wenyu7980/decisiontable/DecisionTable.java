package com.wenyu7980.decisiontable;

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

    public DecisionTable add(T result, Decision... decisions) {
        items.add(new DecisionTableItem(result, Arrays.asList(decisions)));
        return this;
    }

    public DecisionTable add(Decision... decisions) {
        return add(null, decisions);
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
        private List<Decision> decisions = new ArrayList<>();

        public DecisionTableItem(T result, List<Decision> decisions) {
            this.result = result;
            this.decisions = decisions;
        }

        public boolean match(Object... objects) {
            assert objects.length == decisions.size();
            for (int i = 0; i < objects.length; ++i) {
                if (!decisions.get(i).match(objects[i])) {
                    return false;
                }
            }
            return true;
        }
    }

}
