package com.playon.bridge.common.privacy;

import com.playon.bridge.common.util.Preconditions;
import java.io.Serializable;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes12.dex */
public class AdvertisingId implements Serializable {
    final String mAdvertisingId;
    final boolean mDoNotTrack;
    final String mPlayOnId;

    AdvertisingId(String str, String str2, boolean z) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.mAdvertisingId = str;
        this.mPlayOnId = str2;
        this.mDoNotTrack = z;
    }

    public String getAdvertiserIdentifier() {
        return this.mAdvertisingId;
    }

    public String getPlayOnIdentifier() {
        return this.mPlayOnId;
    }

    public boolean isDoNotTrack() {
        return this.mDoNotTrack;
    }

    static AdvertisingId generateFreshAdvertisingId() {
        return new AdvertisingId("00000000-0000-0000-0000-000000000000", generateIdString(), false);
    }

    static String generateIdString() {
        return UUID.randomUUID().toString();
    }

    public String toString() {
        return "AdvertisingId{, mAdvertisingId='" + this.mAdvertisingId + "', mPlayOnId='" + this.mPlayOnId + "', mDoNotTrack=" + this.mDoNotTrack + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertisingId)) {
            return false;
        }
        AdvertisingId advertisingId = (AdvertisingId) obj;
        if (this.mDoNotTrack == advertisingId.mDoNotTrack && this.mAdvertisingId.equals(advertisingId.mAdvertisingId)) {
            return this.mPlayOnId.equals(advertisingId.mPlayOnId);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mAdvertisingId.hashCode() * 31) + this.mPlayOnId.hashCode()) * 31) + (this.mDoNotTrack ? 1 : 0);
    }
}
