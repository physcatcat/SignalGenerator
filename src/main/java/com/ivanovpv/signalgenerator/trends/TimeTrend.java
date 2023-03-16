package com.ivanovpv.signalgenerator.trends;

public class TimeTrend extends Trend {
    private double step; //шаг времени

    public TimeTrend(double step) {
        this.step = step;
    }

    @Override
    public double getNextValue() {
        return currentValue += step;
    }
}
