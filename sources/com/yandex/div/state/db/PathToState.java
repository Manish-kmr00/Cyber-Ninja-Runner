package com.yandex.div.state.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivStateEntity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/state/db/PathToState;", "", "path", "", "stateId", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getStateId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class PathToState {
    private final String path;
    private final String stateId;

    public static /* synthetic */ PathToState copy$default(PathToState pathToState, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pathToState.path;
        }
        if ((i & 2) != 0) {
            str2 = pathToState.stateId;
        }
        return pathToState.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStateId() {
        return this.stateId;
    }

    public final PathToState copy(String path, String stateId) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        return new PathToState(path, stateId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PathToState)) {
            return false;
        }
        PathToState pathToState = (PathToState) other;
        return Intrinsics.areEqual(this.path, pathToState.path) && Intrinsics.areEqual(this.stateId, pathToState.stateId);
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.stateId.hashCode();
    }

    public String toString() {
        return "PathToState(path=" + this.path + ", stateId=" + this.stateId + ')';
    }

    public PathToState(String path, String stateId) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        this.path = path;
        this.stateId = stateId;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getStateId() {
        return this.stateId;
    }
}
