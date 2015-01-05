package com.tinkerpop.gremlin.neo4j.process.graph;

import com.tinkerpop.gremlin.process.Path;
import com.tinkerpop.gremlin.process.T;
import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.Traverser;
import com.tinkerpop.gremlin.process.computer.GraphComputer;
import com.tinkerpop.gremlin.process.graph.ElementTraversal;
import com.tinkerpop.gremlin.process.graph.step.sideEffect.StartStep;
import com.tinkerpop.gremlin.structure.Direction;
import com.tinkerpop.gremlin.structure.Edge;
import com.tinkerpop.gremlin.structure.Element;
import com.tinkerpop.gremlin.structure.Property;
import com.tinkerpop.gremlin.structure.Vertex;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Neo4jElementTraversal<A extends Element> extends ElementTraversal<A> {

    //////////////////////////////////////////////////////////////////////

    public default Neo4jGraphTraversal<A, A> start() {
        final Neo4jGraphTraversal<A, A> traversal = Neo4jGraphTraversal.of();
        return (Neo4jGraphTraversal) traversal.addStep(new StartStep<>(traversal, this));
    }

    //////////////////////////////////////////////////////////////////////

    public default Neo4jGraphTraversal<A, Long> count() {
        return this.start().count();
    }

    public default Neo4jGraphTraversal<A, Double> sum() {
        return this.start().sum();
    }

    public default Neo4jGraphTraversal<A, A> submit(final GraphComputer graphComputer) {
        return this.start().submit(graphComputer);
    }

    ///////////////////// TRANSFORM STEPS /////////////////////

    public default <E2> Neo4jGraphTraversal<A, E2> map(final Function<Traverser<A>, E2> function) {
        return this.start().map(function);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> flatMap(final Function<Traverser<A>, Iterator<E2>> function) {
        return this.start().flatMap(function);
    }

    public default Neo4jGraphTraversal<A, A> identity() {
        return this.start().identity();
    }

    public default Neo4jGraphTraversal<A, Vertex> to(final Direction direction, final String... edgeLabels) {
        return this.start().to(direction, edgeLabels);
    }

    public default Neo4jGraphTraversal<A, Vertex> out(final String... edgeLabels) {
        return this.start().out(edgeLabels);
    }

    public default Neo4jGraphTraversal<A, Vertex> in(final String... edgeLabels) {
        return this.start().in(edgeLabels);
    }

    public default Neo4jGraphTraversal<A, Vertex> both(final String... edgeLabels) {
        return this.start().both(edgeLabels);
    }

    public default Neo4jGraphTraversal<A, Edge> toE(final Direction direction, final String... edgeLabels) {
        return this.start().toE(direction, edgeLabels);
    }

    public default Neo4jGraphTraversal<A, Edge> outE(final String... edgeLabels) {
        return this.start().outE(edgeLabels);
    }

    public default Neo4jGraphTraversal<A, Edge> inE(final String... edgeLabels) {
        return this.start().inE(edgeLabels);
    }

    public default Neo4jGraphTraversal<A, Edge> bothE(final String... edgeLabels) {
        return this.start().bothE(edgeLabels);
    }

    public default Neo4jGraphTraversal<A, Vertex> toV(final Direction direction) {
        return this.start().toV(direction);
    }

    public default Neo4jGraphTraversal<A, Vertex> inV() {
        return this.start().inV();
    }

    public default Neo4jGraphTraversal<A, Vertex> outV() {
        return this.start().outV();
    }

    public default Neo4jGraphTraversal<A, Vertex> bothV() {
        return this.start().bothV();
    }

    public default Neo4jGraphTraversal<A, Vertex> otherV() {
        return this.start().otherV();
    }

    public default Neo4jGraphTraversal<A, A> order() {
        return this.start().order();
    }

    public default Neo4jGraphTraversal<A, A> shuffle() {
        return this.start().shuffle();
    }

    public default <E2> Neo4jGraphTraversal<A, ? extends Property<E2>> properties(final String... propertyKeys) {
        return this.start().properties(propertyKeys);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> values(final String... propertyKeys) {
        return this.start().values(propertyKeys);
    }

    public default Neo4jGraphTraversal<A, Path> path() {
        return this.start().path();
    }

    public default <E2> Neo4jGraphTraversal<A, E2> back(final String stepLabel) {
        return this.start().back(stepLabel);
    }

    public default <E2> Neo4jGraphTraversal<A, Map<String, E2>> match(final String startLabel, final Traversal... traversals) {
        return this.start().match(startLabel, traversals);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> sack() {
        return this.start().sack();
    }

    public default <E2> Neo4jGraphTraversal<A, Map<String, E2>> select(final String... stepLabels) {
        return this.start().select(stepLabels);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> select(final String stepLabel) {
        return this.start().select(stepLabel);
    }

    public default Neo4jGraphTraversal<A, A> unfold() {
        return this.start().unfold();
    }

    public default Neo4jGraphTraversal<A, List<A>> fold() {
        return this.start().fold();
    }

    public default <E2> Neo4jGraphTraversal<A, E2> fold(final E2 seed, final BiFunction<E2, Traverser<A>, E2> foldFunction) {
        return this.start().fold(seed, foldFunction);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> local(final Traversal<A, E2> localTraversal) {
        return this.start().local(localTraversal);
    }

    ///////////////////// FILTER STEPS /////////////////////

    public default Neo4jGraphTraversal<A, A> filter(final Predicate<Traverser<A>> predicate) {
        return this.start().filter(predicate);
    }

    public default Neo4jGraphTraversal<A, A> inject(final Object... injections) {
        return this.start().inject((A[]) injections);
    }

    public default Neo4jGraphTraversal<A, A> dedup() {
        return this.start().dedup();
    }

    public default Neo4jGraphTraversal<A, A> except(final String sideEffectKey) {
        return this.start().except(sideEffectKey);
    }

    public default Neo4jGraphTraversal<A, A> except(final Object exceptionObject) {
        return this.start().except((A) exceptionObject);
    }

    public default Neo4jGraphTraversal<A, A> except(final Collection<A> exceptionCollection) {
        return this.start().except(exceptionCollection);
    }

    public default Neo4jGraphTraversal<A, A> has(final String key) {
        return this.start().has(key);
    }

    public default Neo4jGraphTraversal<A, A> has(final String key, final Object value) {
        return this.start().has(key, value);
    }

    public default Neo4jGraphTraversal<A, A> has(final T accessor, final Object value) {
        return this.start().has(accessor, value);
    }

    public default Neo4jGraphTraversal<A, A> has(final String key, final BiPredicate predicate, final Object value) {
        return this.start().has(key, predicate, value);
    }

    public default Neo4jGraphTraversal<A, A> has(final T accessor, final BiPredicate predicate, final Object value) {
        return this.start().has(accessor, predicate, value);
    }

    public default Neo4jGraphTraversal<A, A> has(final String label, final String key, final Object value) {
        return this.start().has(label, key, value);
    }

    public default Neo4jGraphTraversal<A, A> has(final String label, final String key, final BiPredicate predicate, final Object value) {
        return this.start().has(label, key, predicate, value);
    }

    public default Neo4jGraphTraversal<A, A> hasNot(final String key) {
        return this.start().hasNot(key);
    }

    public default <E2> Neo4jGraphTraversal<A, Map<String, E2>> where(final String firstKey, final String secondKey, final BiPredicate predicate) {
        return this.start().where(firstKey, secondKey, predicate);
    }

    public default <E2> Neo4jGraphTraversal<A, Map<String, E2>> where(final String firstKey, final BiPredicate predicate, final String secondKey) {
        return this.start().where(firstKey, predicate, secondKey);
    }

    public default <E2> Neo4jGraphTraversal<A, Map<String, E2>> where(final Traversal constraint) {
        return this.start().where(constraint);
    }

    public default Neo4jGraphTraversal<A, A> interval(final String key, final Comparable startValue, final Comparable endValue) {
        return this.start().interval(key, startValue, endValue);
    }

    public default Neo4jGraphTraversal<A, A> coin(final double probability) {
        return this.start().coin(probability);
    }

    public default Neo4jGraphTraversal<A, A> range(final long low, final long high) {
        return this.start().range(low, high);
    }

    public default Neo4jGraphTraversal<A, A> limit(final long limit) {
        return this.start().limit(limit);
    }

    public default Neo4jGraphTraversal<A, A> retain(final String sideEffectKey) {
        return this.start().retain(sideEffectKey);
    }

    public default Neo4jGraphTraversal<A, A> retain(final Object retainObject) {
        return this.start().retain((A) retainObject);
    }

    public default Neo4jGraphTraversal<A, A> retain(final Collection<A> retainCollection) {
        return this.start().retain(retainCollection);
    }

    public default Neo4jGraphTraversal<A, A> simplePath() {
        return this.start().simplePath();
    }

    public default Neo4jGraphTraversal<A, A> cyclicPath() {
        return this.start().cyclicPath();
    }

    public default Neo4jGraphTraversal<A, A> sample(final int amountToSample) {
        return this.start().sample(amountToSample);
    }

    ///////////////////// SIDE-EFFECT STEPS /////////////////////

    public default Neo4jGraphTraversal<A, A> sideEffect(final Consumer<Traverser<A>> consumer) {
        return this.start().sideEffect(consumer);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> cap(final String sideEffectKey) {
        return this.start().cap(sideEffectKey);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> cap() {
        return this.start().cap();
    }

    public default Neo4jGraphTraversal<A, A> subgraph(final String sideEffectKey, final Set<Object> edgeIdHolder, final Map<Object, Vertex> vertexMap, final Predicate<Edge> includeEdge) {
        return this.start().subgraph(sideEffectKey, edgeIdHolder, vertexMap, includeEdge);
    }

    public default Neo4jGraphTraversal<A, A> subgraph(final Set<Object> edgeIdHolder, final Map<Object, Vertex> vertexMap, final Predicate<Edge> includeEdge) {
        return this.start().subgraph(edgeIdHolder, vertexMap, includeEdge);
    }

    public default Neo4jGraphTraversal<A, A> subgraph(final String sideEffectKey, final Predicate<Edge> includeEdge) {
        return this.start().subgraph(sideEffectKey, includeEdge);
    }

    public default Neo4jGraphTraversal<A, A> subgraph(final Predicate<Edge> includeEdge) {
        return this.start().subgraph(includeEdge);
    }

    public default Neo4jGraphTraversal<A, A> aggregate() {
        return this.start().aggregate();
    }

    public default Neo4jGraphTraversal<A, A> aggregate(final String sideEffectKey) {
        return this.start().aggregate(sideEffectKey);
    }

    public default Neo4jGraphTraversal<A, A> group(final String sideEffectKey) {
        return this.start().group(sideEffectKey);
    }


    public default Neo4jGraphTraversal<A, A> group() {
        return this.start().group();
    }

    public default Neo4jGraphTraversal<A, A> groupCount(final String sideEffectKey) {
        return this.start().groupCount(sideEffectKey);
    }

    public default Neo4jGraphTraversal<A, A> groupCount() {
        return this.start().groupCount();
    }

    public default Neo4jGraphTraversal<A, Vertex> addE(final Direction direction, final String edgeLabel, final String stepLabel, final Object... propertyKeyValues) {
        return this.start().addE(direction, edgeLabel, stepLabel, propertyKeyValues);
    }

    public default Neo4jGraphTraversal<A, Vertex> addInE(final String edgeLabel, final String setLabel, final Object... propertyKeyValues) {
        return this.start().addInE(edgeLabel, setLabel, propertyKeyValues);
    }

    public default Neo4jGraphTraversal<A, Vertex> addOutE(final String edgeLabel, final String stepLabel, final Object... propertyKeyValues) {
        return this.start().addOutE(edgeLabel, stepLabel, propertyKeyValues);
    }

    public default Neo4jGraphTraversal<A, Vertex> addBothE(final String edgeLabel, final String stepLabel, final Object... propertyKeyValues) {
        return this.start().addBothE(edgeLabel, stepLabel, propertyKeyValues);
    }

    public default Neo4jGraphTraversal<A, A> timeLimit(final long timeLimit) {
        return this.start().timeLimit(timeLimit);
    }

    public default Neo4jGraphTraversal<A, A> tree(final String sideEffectKey) {
        return this.start().tree(sideEffectKey);
    }

    public default Neo4jGraphTraversal<A, A> tree() {
        return this.start().tree();
    }

    public default <V> Neo4jGraphTraversal<A, A> sack(final BiFunction<V, A, V> sackFunction) {
        return this.start().sack(sackFunction);
    }

    public default <V> Neo4jGraphTraversal<A, A> sack(final BinaryOperator<V> sackOperator, final String elementPropertyKey) {
        return this.start().sack(sackOperator, elementPropertyKey);
    }

    public default Neo4jGraphTraversal<A, A> store(final String sideEffectKey) {
        return this.start().store(sideEffectKey);
    }

    public default Neo4jGraphTraversal<A, A> store() {
        return this.start().store();
    }

    ///////////////////// BRANCH STEPS /////////////////////

    public default Neo4jGraphTraversal<A, A> branch() {
        return this.start().branch();
    }

    public default Neo4jGraphTraversal<A, A> jump(final String jumpLabel, final Predicate<Traverser<A>> ifPredicate, final Predicate<Traverser<A>> emitPredicate) {
        return this.start().jump(jumpLabel, ifPredicate, emitPredicate);
    }

    public default Neo4jGraphTraversal<A, A> jump(final String jumpLabel, final Predicate<Traverser<A>> ifPredicate) {
        return this.start().jump(jumpLabel, ifPredicate);
    }

    public default Neo4jGraphTraversal<A, A> jump(final String jumpLabel, final int loops, final Predicate<Traverser<A>> emitPredicate) {
        return this.start().jump(jumpLabel, loops, emitPredicate);
    }

    public default Neo4jGraphTraversal<A, A> jump(final String jumpLabel, final int loops) {
        return this.start().jump(jumpLabel, loops);
    }

    public default Neo4jGraphTraversal<A, A> jump(final String jumpLabel) {
        return this.start().jump(jumpLabel);
    }

    public default Neo4jGraphTraversal<A, A> until(final String breakLabel, final Predicate<Traverser<A>> breakPredicate, final Predicate<Traverser<A>> emitPredicate) {
        return this.start().until(breakLabel, breakPredicate, emitPredicate);
    }

    public default Neo4jGraphTraversal<A, A> until(final String breakLabel, final Predicate<Traverser<A>> breakPredicate) {
        return this.start().until(breakLabel, breakPredicate);
    }

    public default Neo4jGraphTraversal<A, A> until(final String breakLabel, final int loops, final Predicate<Traverser<A>> emitPredicate) {
        return this.start().until(breakLabel, loops, emitPredicate);
    }

    public default Neo4jGraphTraversal<A, A> until(final String breakLabel, final int loops) {
        return this.start().until(breakLabel, loops);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> choose(final Predicate<Traverser<A>> choosePredicate, final Traversal<A, E2> trueChoice, final Traversal<A, E2> falseChoice) {
        return this.start().choose(choosePredicate, trueChoice, falseChoice);
    }

    public default <E2, M> Neo4jGraphTraversal<A, E2> choose(final Function<Traverser<A>, M> mapFunction, final Map<M, Traversal<A, E2>> choices) {
        return this.start().choose(mapFunction, choices);
    }

    public default <E2> Neo4jGraphTraversal<A, E2> union(final Traversal<A, E2>... traversals) {
        return this.start().union(traversals);
    }

    public default Neo4jGraphTraversal<A, A> repeat(final Traversal<A, A> traversal) {
        return this.start().repeat(traversal);
    }

    public default Neo4jGraphTraversal<A, A> emit(final Predicate<Traverser<A>> emitPredicate) {
        return this.start().emit(emitPredicate);
    }

    public default Neo4jGraphTraversal<A, A> until(final Predicate<Traverser<A>> untilPredicate) {
        return this.start().until(untilPredicate);
    }

    public default Neo4jGraphTraversal<A, A> until(final int maxLoops) {
        return this.start().until(maxLoops);
    }

    public default Neo4jGraphTraversal<A, A> emit() {
        return this.start().emit();
    }

    ///////////////////// UTILITY STEPS /////////////////////

    public default Neo4jGraphTraversal<A, A> as(final String label) {
        return this.start().as(label);
    }

    public default Neo4jGraphTraversal<A, A> profile() {
        return this.start().profile();
    }

    public default Neo4jGraphTraversal<A, A> withSideEffect(final String key, final Supplier supplier) {
        return this.start().withSideEffect(key, supplier);
    }

    public default <B> Neo4jGraphTraversal<A, A> withSack(final Supplier<B> initialValue, final UnaryOperator<B> splitOperator) {
        return this.start().withSack(initialValue, splitOperator);
    }

    public default <B> Neo4jGraphTraversal<A, A> withSack(final Supplier<B> initialValue) {
        return this.start().withSack(initialValue);
    }

    public default Neo4jGraphTraversal<A, A> withPath() {
        return this.start().withPath();
    }
}
