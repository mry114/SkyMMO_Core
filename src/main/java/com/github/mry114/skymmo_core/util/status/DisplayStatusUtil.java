package com.github.mry114.skymmo_core.util.status;

import com.github.mry114.skymmo_core.data.type.Status;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

import java.awt.*;
import java.text.DecimalFormat;

public class DisplayStatusUtil {
    public static Component getDisplayStatus(Status status, double value) {
        DecimalFormat df = new DecimalFormat("0.#");

        String operator = "+";
        if (value < 0) {
            operator = "-";
        }

        int color = 0xC4C4C4;
        if (status.getIsPercent()) {
            if (value < 0) {
                color = 0xD31616;
            } else {
                color = 0x6ED316;
            }
        }

        String newValue = df.format(status.getIsPercent() ? value * 100 : value);
        return Component.text(status.getDisplayName() + ": ", TextColor.color(0xC4C4C4)).decoration(TextDecoration.ITALIC, false)
        .append(Component.text(operator + newValue + (status.getIsPercent() ? "%" : ""), TextColor.color(color)).decoration(TextDecoration.ITALIC, false));
    }
}
