package com.yandex.div.state.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivStateEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/state/db/DivStateEntity;", "", "id", "", "cardId", "", "path", "stateId", "modificationTime", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCardId", "()Ljava/lang/String;", "getId", "()I", "getModificationTime", "()J", "getPath", "getStateId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class DivStateEntity {
    private final String cardId;
    private final int id;
    private final long modificationTime;
    private final String path;
    private final String stateId;

    public static /* synthetic */ DivStateEntity copy$default(DivStateEntity divStateEntity, int i, String str, String str2, String str3, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = divStateEntity.id;
        }
        if ((i2 & 2) != 0) {
            str = divStateEntity.cardId;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = divStateEntity.path;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = divStateEntity.stateId;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            j = divStateEntity.modificationTime;
        }
        return divStateEntity.copy(i, str4, str5, str6, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCardId() {
        return this.cardId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStateId() {
        return this.stateId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getModificationTime() {
        return this.modificationTime;
    }

    public final DivStateEntity copy(int id, String cardId, String path, String stateId, long modificationTime) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        return new DivStateEntity(id, cardId, path, stateId, modificationTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DivStateEntity)) {
            return false;
        }
        DivStateEntity divStateEntity = (DivStateEntity) other;
        return this.id == divStateEntity.id && Intrinsics.areEqual(this.cardId, divStateEntity.cardId) && Intrinsics.areEqual(this.path, divStateEntity.path) && Intrinsics.areEqual(this.stateId, divStateEntity.stateId) && this.modificationTime == divStateEntity.modificationTime;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.cardId.hashCode()) * 31) + this.path.hashCode()) * 31) + this.stateId.hashCode()) * 31) + Long.hashCode(this.modificationTime);
    }

    public String toString() {
        return "DivStateEntity(id=" + this.id + ", cardId=" + this.cardId + ", path=" + this.path + ", stateId=" + this.stateId + ", modificationTime=" + this.modificationTime + ')';
    }

    public DivStateEntity(int i, String cardId, String path, String stateId, long j) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        this.id = i;
        this.cardId = cardId;
        this.path = path;
        this.stateId = stateId;
        this.modificationTime = j;
    }

    public final int getId() {
        return this.id;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getStateId() {
        return this.stateId;
    }

    public final long getModificationTime() {
        return this.modificationTime;
    }
}
