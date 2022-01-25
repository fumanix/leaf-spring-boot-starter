package com.fumanix.framework.leaf.strategy;

import com.fumanix.framework.leaf.support.GeneratorType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @create: 2021-07-28 14:46
 */
public class GeneratorFactory {

    private static Map<GeneratorType, AbstractGenerator> generatorStrategy;

    private GeneratorFactory(){
        defaultGenerator();
    }

    private static class Singleton{
        private static GeneratorFactory instance = new GeneratorFactory();
    }

    public static GeneratorFactory getInstance(){
        return Singleton.instance;
    }

    private void defaultGenerator() {
        generatorStrategy = new ConcurrentHashMap<>();
        generatorStrategy.put(GeneratorType.str, new StringGenerator());
        generatorStrategy.put(GeneratorType.date, new DateTimeGenerator());
        generatorStrategy.put(GeneratorType.seq, new SequenceGenerator());
        generatorStrategy.put(GeneratorType.random, new RandomGenerator());
        generatorStrategy.put(GeneratorType.trade, new TradingGenerator());
    }

    public AbstractGenerator getGenerator(GeneratorType type) {
        return (null == generatorStrategy) ? null : generatorStrategy.get(type);
    }
}
