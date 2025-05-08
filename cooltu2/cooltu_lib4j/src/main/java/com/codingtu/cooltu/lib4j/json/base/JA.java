package com.codingtu.cooltu.lib4j.json.base;

import com.codingtu.cooltu.lib4j.es.BaseEs;

import java.util.List;

public interface JA {
    <T> BaseEs<T> toDataObjs(Class<T> tClass);

    int size();

    JO getJO(int index);
}