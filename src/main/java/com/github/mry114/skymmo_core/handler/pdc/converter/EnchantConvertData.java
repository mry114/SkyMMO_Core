package com.github.mry114.skymmo_core.handler.pdc.converter;

import com.github.mry114.skymmo_core.api.pdc.IConvertData;

public class EnchantConvertData implements IConvertData<Integer> {
    private final int idDigit = 6;
    private final int levelDigit = 3;

    private int id;
    private int level;

    public EnchantConvertData(int data) {
        this.level = data % (int) Math.pow(10, levelDigit);
        this.id = data / (int) Math.pow(10, 9 - idDigit);
    }

    public EnchantConvertData(int id, int level) {
        this.id = id;
        this.level = level;
    }

    public int getId() {
        return id;
    }
    public int getLevel() {
        return level;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public Integer getData() {
        if (id > 999999 || level > 999) {
            throw new IllegalArgumentException(
                    "エンチャントデータが上限を超えています。IDは6桁(999999)、レベルは3桁(999)までです。現在の値 -> ID: " + id + ", Level: " + level
            );
        }
        return id * (int) Math.pow(10, levelDigit) + level;
    }
}
