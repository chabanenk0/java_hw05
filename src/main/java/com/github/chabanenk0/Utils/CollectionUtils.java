package com.github.chabanenk0.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {


    private CollectionUtils() {
    }


    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) throws IllegalAccessException, InstantiationException {
        List result = elements.getClass().newInstance();
        for( E element: elements) {
            if (filter.test(element)) {
                result.add(element);
            }
        }
        return result;
    }


    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for( E element: elements) {
            if (predicate.test(element)) {
                return true;
            }
        }

        return false;
    }


    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for( E element: elements) {
            if (!predicate.test(element)) {
                return false;
            }
        }

        return true;
    }


    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        return !CollectionUtils.anyMatch(elements, predicate);
    }


    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) throws IllegalAccessException, InstantiationException {
        // @todo investigate how to determine the list type of 'elements'
        // and how to create the new list with the same list type
        List result = elements.getClass().newInstance();
        for(T element: elements) {
            result.add(mappingFunction.apply(element));
        }
        return result;

    }


    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        E max = elements.iterator().next();
        for(E element: elements) {
            if (comparator.compare(element, max) > 0) {
                max = element;
            }
        }
        return Optional.of(max);
    }


    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        E min = elements.iterator().next();
        for(E element: elements) {
            if (comparator.compare(element, min) < 0) {
                min = element;
            }
        }
        return Optional.of(min);
    }


    public static <E> List<E> distinct(List<E> elements) throws IllegalAccessException, InstantiationException {
        List result = elements.getClass().newInstance();
        for(E element: elements) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }


    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for(E element: elements) {
            consumer.accept(element);
        }
    }


    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        E result = null;
        for(E element: elements) {
            if (result == null) {
                result = element;
                continue;
            }
            result = accumulator.apply(result, element);
        }

        return Optional.of(result);
    }


    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        //TODO Implement me
        return null;
    }


    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        Map<Boolean, List<E>> result = new HashMap<Boolean, List<E>>();
        result.put(true, new LinkedList<E>());
        result.put(false, new LinkedList<E>());

        for(E element: elements) {
            boolean group = predicate.test(element);
            result.get(group).add(element);
        }
        return result;
    }


    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        //TODO Implement me
        return null;
    }


    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {
        //TODO Implement me
        return null;
    }
}
