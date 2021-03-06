/*
 * Copyright (C) 2012 Matchbox committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */
package org.javafunk.matchbox.implementations;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static org.apache.commons.lang.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class MatchesMatcher<T> extends TypeSafeDiagnosingMatcher<Matcher<? super T>> {
    private final T sample;

    public MatchesMatcher(T sample) {
        this.sample = sample;
    }

    @Override
    protected boolean matchesSafely(Matcher<? super T> matcher, Description description) {
        if (!matcher.matches(sample)) {
            Description actualDescription = new StringDescription();
            matcher.describeMismatch(sample, actualDescription);
            description.appendText("got mismatch, description ").appendValue(actualDescription);
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("matcher to match ").appendValue(sample);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
