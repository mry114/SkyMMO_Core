package com.github.mry114.skymmo_core.core.player;

import java.util.*;

public class ModifyContainer {
    private final Map<UUID, List<StatusModify>> modifyMap = new HashMap<>();

    /**
     * プレイヤーのModifyリストを取得する（安全な空のリストを返す）
     */
    public List<StatusModify> getPlayerModifyList(UUID uuid) {
        return this.modifyMap.getOrDefault(uuid, new ArrayList<>());
    }

    /**
     * プレイヤーにModifyを追加する（Mapにリストがなければ自動生成する）
     */
    public void addModify(UUID uuid, StatusModify statusModify) {
        this.modifyMap.computeIfAbsent(uuid, k -> new ArrayList<>()).add(statusModify);
    }

    /**
     * プレイヤーから特定のModifyを削除する（リストが存在するときだけ処理する）
     */
    public void removeModify(UUID uuid, StatusModify statusModify) {
        List<StatusModify> list = this.modifyMap.get(uuid);
        if (list != null) {
            list.remove(statusModify);

            if (list.isEmpty()) {
                this.modifyMap.remove(uuid);
            }
        }
    }

    /**
     * プレイヤーの新規領域を作成します
     */
    public void createPlayer(UUID uuid) {
        modifyMap.put(uuid, new ArrayList<>());
    }

    /**
     * プレイヤーがログアウトした時にデータを完全に消去する（メモリリーク対策）
     */
    public void removePlayer(UUID uuid) {
        this.modifyMap.remove(uuid);
    }
}
