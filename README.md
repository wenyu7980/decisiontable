## 判定表

作者：彣彧 wenyu7980@163.com

> 判定表(Decision table)是另一种表达逻辑判断的工具。与结构化语言和判断树相比，判断表的优点是能把所有条件组合充分地表达出来；其缺点是判定表的建立过程较烦杂，且表达方式不如前两种简便。判定表在用于知识表达中，有许多其他方式所达不到的作用。

### 库组成

##### DecisionMatch

**匹配接口**

所有的判定项都要实现该接口

```java
public interface DecisionMatch {
    /**
     * 匹配
     * @param object
     * @return
     */
    boolean match(Object object);
}
```



#### DecisionTable

**判定表**

核心类，用于保存判定规则，判定比较，结果返回。

#### DecisionMatches

预定义的一些判定项

