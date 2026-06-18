package com.github.mry114.skymmo_core.core.player.cache;

import com.github.mry114.skymmo_core.core.player.element.ElementData;

import java.util.*;

public class ElementCache {
    private final Map<UUID, List<ElementData>> elementMap = new HashMap<>();

    /**
     * プレイヤーのElementリストを取得する（安全な空のリストを返す）
     */
    public List<ElementData> getPlayerElementList(UUID uuid) {
        return this.elementMap.getOrDefault(uuid, List.of());
    }

    /**
     * プレイヤーにElementを追加する（Mapにリストがなければ自動生成する）
     */
    public void addElement(UUID uuid, ElementData statusElement) {
        this.elementMap.computeIfAbsent(uuid, k -> new ArrayList<>()).add(statusElement);
    }

    /**
     * プレイヤーの新規領域を作成します
     */
    public void createPlayer(UUID uuid) {
        elementMap.put(uuid, new ArrayList<>());
    }

    /**
     * プレイヤーがの持つデータを完全に消去する
     */
    public void removeElements(UUID uuid) {
        this.elementMap.get(uuid).clear();
    }

    /**
     * プレイヤーが自体のデータを完全に消去する
     */
    public void removePlayer(UUID uuid) {
        this.elementMap.remove(uuid);
    }
}
