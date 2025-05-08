package com.codingtu.cooltu.data.entity;

import com.codingtu.cooltu.data.base.BaseDataObj;
import com.codingtu.cooltu.lib4j.data.symbol.Symbol;

public class User extends BaseDataObj implements Symbol {
    public String id;

    @Override
    public String obtainSymbol() {
        return id;
    }
}
