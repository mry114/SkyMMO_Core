package com.github.mry114.skymmo_core.api.player;

import com.github.mry114.skymmo_core.api.system.IIgniterEvent;
import com.github.mry114.skymmo_core.core.player.StatusModify;

import java.util.List;

public interface IElementData extends IIgniterEvent {
    List<StatusModify> getStatusModify();
}
