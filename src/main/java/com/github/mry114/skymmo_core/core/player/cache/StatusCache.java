package com.github.mry114.skymmo_core.core.player.cache;

import com.github.mry114.skymmo_core.core.player.status.StatusContainer;

import java.util.*;

public class StatusCache {
    private final Map<UUID, StatusContainer> statusMap = new HashMap<>();

    /**
     * プレイヤーのStatusリストを取得する
     */
    public StatusContainer getPlayerStatus(UUID uuid) {
        return this.statusMap.getOrDefault(uuid, new StatusContainer.Builder().build());
    }

    /**
     * プレイヤーにStatusを追加する
     */
    public void addStatus(UUID uuid, StatusContainer status) {
        if (status == null) return;

        this.statusMap.compute(uuid, (k, currentStatus) -> {
            if (currentStatus == null) {
                currentStatus = new StatusContainer.Builder().build();
            }
            return currentStatus.merge(status);
        });
    }

    /**
     * プレイヤーの新規領域を作成します
     */
    public void createPlayer(UUID uuid) {
        statusMap.put(uuid, new StatusContainer.Builder().build());
    }

    /**
     * プレイヤーがの持つデータを完全に消去する
     */
    public void removeStatus(UUID uuid) {
        this.statusMap.put(uuid, StatusContainer.EMPTY);
    }

    /**
     * プレイヤーが自体のデータを完全に消去する
     */
    public void removePlayer(UUID uuid) {
        this.statusMap.remove(uuid);
    }
}
