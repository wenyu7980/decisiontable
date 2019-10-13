package com.wenyu7980.decisiontable;

import java.util.Objects;

/**
 * @author wenyu
 */
public enum Compare {
    /** 等于 */
    EQ {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            Object object = objects[0];
            if (object instanceof Comparable && value != null
                    && value.getClass() == object.getClass()) {
                return ((Comparable) object).compareTo(value) == 0;
            } else {
                return Objects.equals(value, object);
            }
        }
    },
    /** 小于 */
    LT {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return ((Comparable) value).compareTo(objects[0]) < 0;
        }
    },
    /** 大于等于 */
    GE {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return !LT.compare(value, objects);
        }
    },
    /** 小于等于 */
    LE {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return LT.compare(value, objects) || EQ.compare(value, objects);
        }
    },
    /** 大于 */
    GT {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return !LE.compare(value, objects);
        }
    },
    /** 不等于 */
    NE {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return !EQ.compare(value, objects);
        }
    },
    /** 属于 */
    IN {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            for (int i = 0; i < objects.length; i++) {
                if (EQ.compare(value, new Object[] { objects[i] })) {
                    return true;
                }
            }
            return false;
        }
    },
    /** 不属于 */
    NOT_IN {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return !IN.compare(value, objects);
        }
    },
    /** 空 */
    NULL {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return value == null;
        }

        @Override
        protected boolean isNullFalse() {
            return false;
        }
    },
    /** 非空 */
    NOT_NULL {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return !NULL.compare(value, objects);
        }
    },
    /** 任意值 */
    ANY {
        @Override
        protected boolean compare(Object value, Object[] objects) {
            return true;
        }

        @Override
        protected boolean isNullFalse() {
            return false;
        }
    };

    protected abstract boolean compare(Object value, Object[] objects);

    protected boolean isNullFalse() {
        return true;
    }

    public boolean compareTo(Object value, Object[] objects) {
        if (value == null && isNullFalse()) {
            return false;
        }
        return this.compare(value, objects);
    }

}
