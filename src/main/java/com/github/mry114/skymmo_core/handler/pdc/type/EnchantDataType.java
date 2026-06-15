package com.github.mry114.skymmo_core.handler.pdc.type;

import com.github.mry114.skymmo_core.api.pdc.IConvertData;
import com.github.mry114.skymmo_core.api.pdc.IDataType;
import com.github.mry114.skymmo_core.handler.pdc.converter.EnchantConvertData;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.jetbrains.annotations.NotNull;

public class EnchantDataType implements IDataType<Integer, EnchantConvertData> {
    public static final EnchantDataType INSTANCE = new EnchantDataType();

    @Override
    public @NotNull Class<Integer> getPrimitiveType() {
        return Integer.class;
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Class<EnchantConvertData> getComplexType() {
        return (Class<EnchantConvertData>) (Class<?>) IConvertData.class;
    }

    @Override
    public @NotNull Integer toPrimitive(@NotNull EnchantConvertData complex, @NotNull PersistentDataAdapterContext context) {
        return complex.getData();
    }

    @Override
    public @NotNull EnchantConvertData fromPrimitive(@NotNull Integer primitive, @NotNull PersistentDataAdapterContext context) {
        return new EnchantConvertData(primitive);
    }
}
