package com.fumanix.framework.leaf.strategy;

public class StringGenerator extends AbstractGenerator {

    @Override
    public StringBuffer gen(StringBuffer sn, String... params) {
        return sn.append(params[0]);
    }
}
