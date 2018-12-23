package com.wipro.java.fullstack.employer.mapper;

public interface TwoWayMapper<T, F> {
    public T mapTo(F from);

    public F mapFrom(T to);
}
