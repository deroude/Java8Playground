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

Note: Java 8 lets you use also the double colon `::` operator when providing a lambda implementation.
This operator correctness and its applicability will be inferred by Java, based on the interface being implemented.

For example, if the interface is `(int, int) -> int`, you can provide `Math::max` as lambda implementation -- because, indeed, the static method `max` can be applied to two `ints` and will yeld an `int`.
So, in this case, `Math::max` is equivalent to `(int1,int2) -> Math.max(int1,int2)`, or in pre-Java-8 syntax:

```java
new MyFunction {
    int getMax(int int1, int int2){
        return Math.max(int1,int2);
    }
}
```  

This inference applies also to non-static methods of classes. For example `String::length` can be a valid implementation for a `(String) -> int` interface.

## The Spliterator

Short version: an iterator better suited for parallelism and for (effectively) infinite data sets. [Long version here](https://www.baeldung.com/java-spliterator)

As part of its name says, a Spliterator can be `split` or, more specifically `trySplit`.
This is the main source of parallelism and practically the major advantage of the Java Stream API.

That's not to say we were not able to process Collections on parallel threads before Java 8, just that now we have a standard API for this, that also takes away the boilerplate and management of multi-threaded collection traversal.

With the addition of Lambdas, that is the ability to apparently pass a Function as an argument, Java has also introduced a more fluent manner of processing Collections.

We can now chain operations on Streams, which replace the traditional `for (Item i : MyCollection)`

For example:

```java
List<String> results = new LinkedList();
for(Item i : myCollection){
    if(i.attrX>5){
        results.add(i.toString());
    }
}
```

is translated into:

```java
List<String> results = myCollection.stream()
    .filter(i -> i.attrX > 5)
    .map(Item::toString)
    .collect(Collectors.toList());
```

The result (aside for being a one-liner) is far more expressive and it can be parallelized with just an additional call of a method:

```java
List<String> results = myCollection.stream().unordered().parallel()
    .filter(i -> i.attrX > 5)
    .map(Item::toString)
    .collect(Collectors.toList());
```

`unordered` releases the API from the order contract, which, if possible to use, improves performance.

Be aware that, while expressive and cool, the Stream API will not improve the performance of every Collection processing operation.

Please find a benchmark exercise [here](https://jaxenter.com/java-performance-tutorial-how-fast-are-the-java-8-streams-118830.html). 
One of many, surely.

Arratys (`int[]`) are much faster than Collections (naturally, they have less features). 
Good old `for` loops are faster than streams for simple iteration, because Spliterators come with an overhead.
Making a stream operation parallel also adds overhead, for splitting tasks and joining results, so, if the actual task is very small, the performance will actually be worse than with sequential processing.