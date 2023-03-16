package com.ivanovpv.signalgenerator.trends;

import java.util.ArrayList;
import java.util.List;

public class StandardTrend extends Trend {

    private boolean noised; //будет ли шум
    private boolean wideNoised; //будет ли "широкий шум" (более заметные в болшем масштабе искажения по форме)

    private double amplitude; //текущая амплитуда
    private double shiftLine; //отметка по времени с которой генерируется текущий участок
    private double shiftValue; //отметка по амплитуде с которой генерируется текущий участок
    private int type; //текущий тип графика, 1 - апериодический ПП, 2 - колебательный ПП;

    private boolean changes; //есть ли смена графика
    private byte maxChanges; //макс. число смен
    private byte minChanges; //мин. число смен
    private List<Integer> changesList; //список, в котором хранятся позиции, в которых нужно сменить вид графика

    private double maxAmplitude; //максимальная амплитуда (коэф. усиления)
    private double minAmplitude; //минимальная амплитуда (коэф. усиления)
    
    private double timeKF; //временной коэффициент (вся настройка и подбор производились для 100к записей, нужен для того, чтобы всё работало для любого числа записей)


    public StandardTrend(boolean noised, boolean wideNoised, boolean changes, byte maxChanges, byte minChanges, double maxAmplitude, double minAmplitude) {
        this.noised = noised;
        this.wideNoised = wideNoised;
        this.changes = changes;
        this.maxChanges = maxChanges;
        this.minChanges = minChanges;
        this.maxAmplitude = maxAmplitude;
        this.minAmplitude = minAmplitude;

        currentValue = random.nextDouble() * 8; //генерируем начальное значение
        shiftValue = currentValue; // сдвиги изначально = 0
        shiftLine = 0;
        type = random.nextInt(2) + 1; //генерируем вид графика

        if (changes) {
            generateChangeList(); //если опция изменений вкл., то генерируем лист изменений
        }
    }

    @Override
    public double getNextValue() {
        if (changes) { //если изменения включены, то проверяем не надо ли менять
            changeType();
        }

        switch (type) { //исходя из текущего типа обновляем значения
            case 1:
                currentValue = resumeAperiodic();
                break;
            case 2:
                currentValue = resumeOscillatory();
                break;
        }
        
        if (noised) { //если шумы включены, то добавляем их
            currentValue += getNoise();
        }
        if (wideNoised) {
            currentValue += getWideNoise();
        }
        
        return currentValue;
    }

    private void generateChangeList() { //генерация позиций, в которых нужно сменить вид графика
        //количество смен
        int changesCount = random.nextInt(maxChanges) + minChanges; //генерируем количество изменений
        changesList = new ArrayList<>();
        int pos = 0;
        for (int i = 1; i <= changesCount; i++) {
            pos = random.nextInt(2 * length / changesCount) + pos; //добавляем случайную точку в список
            changesList.add(pos);
        }
    }

    private void changeType() {
        if (!changesList.isEmpty() && changesList.get(0) < currentLine) { //если в списке есть изменения и позиция след. изменения < текущей позиции, то
            shiftLine = currentLine; //сдвиговые значения обновляем
            shiftValue = currentValue;

            type = random.nextInt(2) + 1; //меняем тип линии случайным образом
            changesList.remove(0); //удаляем позицию этого изменения из списка

            amplitude = random.nextDouble() * (maxAmplitude - minAmplitude) + minAmplitude; //генерируем амплитуду случайно
        }
    }

    private double resumeAperiodic() {
        return (-Math.exp(-0.001 * (currentLine - shiftLine)) + 1) * amplitude + shiftValue; //новое значения апериодического ПП
    }

    private double resumeOscillatory() { //новое значения колебательного ПП
        return (-Math.exp(-0.001 * (currentLine - shiftLine)) + 1) * amplitude + shiftValue + (Math.exp(-0.001 * (currentLine - shiftLine))) * amplitude * Math.sin(0.0025 * (currentLine - shiftLine));
    }

    private double getNoise() { //генерируем шум (до +-0,5% от размаха мин и макс амплитуд)
        return 2*(random.nextDouble()-0.5)*(maxAmplitude-minAmplitude)*0.0085;
    }

    private double getWideNoise() { //генерируем широкий шум - некоторая сумма синусов-косинусов, до 8 процентов от размаха амплитуд
        return (maxAmplitude-minAmplitude)*0.01*(0.93*Math.sin(0.00075*currentLine)-1.05*Math.cos(0.0011*currentLine)+0.9*Math.sin(0.00063*currentLine));
    }
}
