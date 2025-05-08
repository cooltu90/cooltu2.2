package com.codingtu.cooltu.lib4j.function;

public interface OnConvert<SRC, TARGET> {
    TARGET convert(SRC src);
}
