package com.github.mry114.skymmo_core.core.player.element;

import com.github.mry114.skymmo_core.api.system.IIgniterEvent;
import com.github.mry114.skymmo_core.core.player.modify.StatusModify;

import java.util.List;

public abstract class ElementData implements IIgniterEvent {
    public abstract List<StatusModify> getStatusModify();
}
