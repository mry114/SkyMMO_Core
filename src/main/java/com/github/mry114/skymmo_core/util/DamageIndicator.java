package com.github.mry114.skymmo_core.util;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.apache.maven.artifact.repository.metadata.Plugin;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

import java.util.concurrent.ThreadLocalRandom;

public class DamageIndicator {

    /** モブ周辺に散らばらせる際の最小・最大半径(ブロック) */
    private static final double MIN_SCATTER_RADIUS = 0.25;
    private static final double MAX_SCATTER_RADIUS = 0.6;

    /** 表示してから消えるまでの時間(tick数。20tick = 1秒) */
    private static final int LIFETIME_TICKS = 18;

    /** 1tickごとに上昇させる速度 */
    private static final double RISE_SPEED = 0.045;

    private DamageIndicator() {
        // ユーティリティクラスのためインスタンス化不可
    }

    /**
     * ダメージインジケーターを生成して表示する。
     *
     * @param target   ダメージを受けたモブ(表示位置の基準)
     * @param damage   表示するダメージ量
     * @param critical クリティカルかどうか(true:黄色＋強調 / false:白)
     */
    public static void spawn(Entity target, double damage, boolean critical) {
        Location spawnLoc = randomLocationAround(target);

        TextDisplay display = (TextDisplay) target.getWorld().spawnEntity(spawnLoc, EntityType.TEXT_DISPLAY);

        NamedTextColor color = critical ? NamedTextColor.YELLOW : NamedTextColor.WHITE;
        Component text = Component.text(formatDamage(damage), color);
        if (critical) {
            text = text.decoration(TextDecoration.BOLD, true);
        }
        display.text(text);

        // 見た目の調整
        display.setBillboard(Display.Billboard.CENTER); // 常にプレイヤー側を向く
        display.setBackgroundColor(Color.fromARGB(0, 0, 0, 0)); // 背景を透明に
        display.setShadowed(true);
        display.setSeeThrough(false);
        display.setDefaultBackground(false);
        display.setPersistent(false); // チャンクアンロード等で残留しないように

        if (critical) {
            // クリティカル時は少し大きく表示して強調する
            display.setTransformation(new Transformation(
                    new Vector3f(0f, 0f, 0f),
                    new AxisAngle4f(0f, 0f, 0f, 1f),
                    new Vector3f(1.25f, 1.25f, 1.25f),
                    new AxisAngle4f(0f, 0f, 0f, 1f)
            ));
        }

        animate(display);
    }

    /**
     * モブのバウンディングボックスを基準に、体の中段〜上部あたりに
     * ランダムなオフセットを加えた位置を返す。
     * ダメージごとに位置をずらすことで複数表示が重なりにくくなる。
     */
    private static Location randomLocationAround(Entity target) {
        BoundingBox box = target.getBoundingBox();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        double angle = random.nextDouble() * Math.PI * 2;
        double radius = MIN_SCATTER_RADIUS + random.nextDouble() * (MAX_SCATTER_RADIUS - MIN_SCATTER_RADIUS);
        double offsetX = Math.cos(angle) * radius;
        double offsetZ = Math.sin(angle) * radius;
        double offsetY = box.getHeight() * (0.3 + random.nextDouble() * 0.5); // 足元基準で体の30%〜80%の高さ

        Location base = box.getCenter().toLocation(target.getWorld());
        return base.add(offsetX, offsetY - box.getHeight() / 2.0, offsetZ);
    }

    /** 表示テキストを上昇させながら一定時間後に消去する */
    private static void animate(TextDisplay display) {
        Vector velocity = new Vector(0, RISE_SPEED, 0);

        new BukkitRunnable() {
            int ticks = 0;

            @Override
            public void run() {
                if (!display.isValid() || ticks >= LIFETIME_TICKS) {
                    display.remove();
                    cancel();
                    return;
                }
                display.teleport(display.getLocation().add(velocity));
                ticks++;
            }
        }.runTaskTimer(SkyMMO_Core.getInstance(), 1L, 1L);
    }

    /** ダメージ量を整数なら整数表記、小数なら小数第1位までに整形する */
    private static String formatDamage(double damage) {
        if (damage == Math.rint(damage)) {
            return String.valueOf((long) damage);
        }
        return String.format("%.1f", damage);
    }
}
