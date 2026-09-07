package com.yandex.div.core.state;

import androidx.collection.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class DivViewState {
    private final Map<String, BlockState> mBlockStates;
    private final long mCurrentDivStateId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface BlockState {
    }

    DivViewState(long j) {
        this(j, new ArrayMap());
    }

    DivViewState(long j, Map<String, BlockState> map) {
        this.mCurrentDivStateId = j;
        this.mBlockStates = map;
    }

    public long getCurrentDivStateId() {
        return this.mCurrentDivStateId;
    }

    public <T extends BlockState> T getBlockState(String str) {
        return (T) this.mBlockStates.get(str);
    }

    public <T extends BlockState> void putBlockState(String str, T t) {
        this.mBlockStates.put(str, t);
    }

    public void reset() {
        this.mBlockStates.clear();
    }

    Map<String, BlockState> getBlockStates() {
        return this.mBlockStates;
    }
}
