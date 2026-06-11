package com.github.mry114.skymmo_core.core.player.element;

import java.util.*;

public class ElementContainer {
    private final Map<UUID, List<ElementData>> elementMap = new HashMap<>();

    /**
     * プレイヤーのElementリストを取得する（安全な空のリストを返す）
     */
    public List<ElementData> getPlayerElementList(UUID uuid) {
        return this.elementMap.getOrDefault(uuid, new ArrayList<>());
    }

    /**
     * プレイヤーにElementを追加する（Mapにリストがなければ自動生成する）
     */
    public void addElement(UUID uuid, ElementData statusElement) {
        this.elementMap.computeIfAbsent(uuid, k -> new ArrayList<>()).add(statusElement);
    }

    /**
     * プレイヤーから特定のElementを削除する（リストが存在するときだけ処理する）
     */
    public void removeElement(UUID uuid, ElementData statusElement) {
        List<ElementData> list = this.elementMap.get(uuid);
        if (list != null) {
            list.remove(statusElement);

            if (list.isEmpty()) {
                this.elementMap.remove(uuid);
            }
        }
    }

    /**
     * プレイヤーの新規領域を作成します
     */
    public void createPlayer(UUID uuid) {
        elementMap.put(uuid, new ArrayList<>());
    }

    /**
     * プレイヤーがログアウトした時にデータを完全に消去する（メモリリーク対策）
     */
    public void removePlayer(UUID uuid) {
        this.elementMap.remove(uuid);
    }
}
