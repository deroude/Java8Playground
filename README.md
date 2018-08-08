# Java 8 Playground

## The functional interface

Short version: an interface with just one (abstract) method. [Long version here](https://www.baeldung.com/java-8-functional-interfaces)

```java
public interface MyFunction<T,U>{
    T doSomething(U input);
}
```

So, what can you do with this?

- implement it: `public class MyFunctionImpl<T,U> implements MyFunction<T,U>{...}`
- implement it inline (anonymous): `MyFunction<T,U> aFunction = new MyFunction<T,U>(){ T doSomething(U input){...}}`
- and now, use it as a lambda: `MyFunction<T,U> aFunction = input -> output`

Note: Java 8 lets you use also 