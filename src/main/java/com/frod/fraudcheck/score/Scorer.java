package com.frod.fraudcheck.score;

/**
 * Scorer interface.
 * Functional interface that defines a method that returns a score for a certain type.
 */
public interface Scorer<T> {

    /**
     * Returns a floating point score of the input argument.
     * @param data Data to be tested.
     * @return The result of the evaluation.
     */
    double score(T data);
}
