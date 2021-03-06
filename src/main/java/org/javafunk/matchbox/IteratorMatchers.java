/*
 * Copyright (C) 2012 Matchbox committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */
package org.javafunk.matchbox;

import org.hamcrest.Matcher;
import org.javafunk.matchbox.implementations.IsIteratorWithSameElementsAsMatcher;

import java.util.Iterator;

public class IteratorMatchers {
    public static <E> Matcher<? super Iterator<E>> isIteratorWithSameElementsAs(final Iterator<E> expected) {
        return new IsIteratorWithSameElementsAsMatcher<E>(expected);
    }
}
