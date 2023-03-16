package com.ivanovpv.signalgenerator.trends;

import java.util.ArrayList;
import java.util.List;

public class DiscreteTrend extends Trend {
    private int maxChanges;
    private int minChanges;
    private List<Integer> changesList;

    public DiscreteTrend(int minChanges, int maxChanges) {
        this.maxChanges = maxChanges;
        this.minChanges = minChanges;
        generateChangeList(); //генерируем список изменений
    }

    @Override
    public double getNextValue() {
        changeValue();
        return currentValue;
    }

    private void generateChangeList() { //генерирует список изменений
        int changesCount = random.nextInt(maxChanges) + minChanges; //генерируем количество изменений
        changesList = new ArrayList<>();
        int pos = 0;
        for (int i = 1; i <= changesCount; i++) {
            pos = random.nextInt(2 * length / changesCount) + pos; //добавляем случайную точку в список
            changesList.add(pos);
        }
        currentValue = random.nextInt(2);
    }

    private void changeValue() { //меняет значение сигнала, если это нужно
        if (!changesList.isEmpty() && changesList.get(0) < currentLine) { //если в списке есть изменения и позиция след. изменения < текущей позиции, то
            if (currentValue == 1) currentValue = 0;
            else currentValue = 1;
            changesList.remove(0);
        }
    }
}
