package com.rhtech.extensions;

import org.gradle.api.internal.provider.DefaultPropertyState;

/**
 * This class is a total hack to overcome
 * toString() call which was returning "value: get()"
 * when used in the DSL
 */
public class StringProperty extends DefaultPropertyState
{
    public StringProperty()
    {
        super(String.class);
    }

    @Override public String toString()
    {
        return get().toString();
    }
}
