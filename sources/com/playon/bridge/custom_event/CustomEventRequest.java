package com.playon.bridge.custom_event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.playon.bridge.AdUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomEventRequest.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0086\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u00069"}, d2 = {"Lcom/playon/bridge/custom_event/CustomEventRequest;", "Landroid/os/Parcelable;", "url", "", "eventId", "payload", "timeToReward", "", "eventCode", "rewardType", "Lcom/playon/bridge/AdUnit$RewardType;", IronSourceConstants.EVENTS_REWARD_AMOUNT, "", "callbackUrl", "maxVolume", "currentVolume", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/playon/bridge/AdUnit$RewardType;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCallbackUrl", "()Ljava/lang/String;", "getCurrentVolume", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEventCode", "getEventId", "getMaxVolume", "getPayload", "getRewardAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getRewardType", "()Lcom/playon/bridge/AdUnit$RewardType;", "getTimeToReward", "getUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/playon/bridge/AdUnit$RewardType;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/playon/bridge/custom_event/CustomEventRequest;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "playon_debug"}, k = 1, mv = {1, 1, 13})
public final /* data */ class CustomEventRequest implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();

    @SerializedName("reward_callback_url")
    private final String callbackUrl;

    @SerializedName("current_volume")
    private final Integer currentVolume;

    @SerializedName("event_code")
    private final Integer eventCode;

    @SerializedName("event_id")
    private final String eventId;

    @SerializedName("max_volume")
    private final Integer maxVolume;

    @SerializedName("payload")
    private final String payload;

    @SerializedName(CampaignEx.JSON_KEY_REWARD_AMOUNT)
    private final Float rewardAmount;

    @SerializedName("reward_type")
    private final AdUnit.RewardType rewardType;

    @SerializedName("time_to_reward")
    private final Integer timeToReward;
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new CustomEventRequest(in.readString(), in.readString(), in.readString(), in.readInt() != 0 ? Integer.valueOf(in.readInt()) : null, in.readInt() != 0 ? Integer.valueOf(in.readInt()) : null, in.readInt() != 0 ? (AdUnit.RewardType) Enum.valueOf(AdUnit.RewardType.class, in.readString()) : null, in.readInt() != 0 ? Float.valueOf(in.readFloat()) : null, in.readString(), in.readInt() != 0 ? Integer.valueOf(in.readInt()) : null, in.readInt() != 0 ? Integer.valueOf(in.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new CustomEventRequest[i];
        }
    }

    public CustomEventRequest() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getCurrentVolume() {
        return this.currentVolume;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getTimeToReward() {
        return this.timeToReward;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getEventCode() {
        return this.eventCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final AdUnit.RewardType getRewardType() {
        return this.rewardType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Float getRewardAmount() {
        return this.rewardAmount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCallbackUrl() {
        return this.callbackUrl;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getMaxVolume() {
        return this.maxVolume;
    }

    public final CustomEventRequest copy(String url, String eventId, String payload, Integer timeToReward, Integer eventCode, AdUnit.RewardType rewardType, Float rewardAmount, String callbackUrl, Integer maxVolume, Integer currentVolume) {
        return new CustomEventRequest(url, eventId, payload, timeToReward, eventCode, rewardType, rewardAmount, callbackUrl, maxVolume, currentVolume);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomEventRequest)) {
            return false;
        }
        CustomEventRequest customEventRequest = (CustomEventRequest) other;
        return Intrinsics.areEqual(this.url, customEventRequest.url) && Intrinsics.areEqual(this.eventId, customEventRequest.eventId) && Intrinsics.areEqual(this.payload, customEventRequest.payload) && Intrinsics.areEqual(this.timeToReward, customEventRequest.timeToReward) && Intrinsics.areEqual(this.eventCode, customEventRequest.eventCode) && Intrinsics.areEqual(this.rewardType, customEventRequest.rewardType) && Intrinsics.areEqual((Object) this.rewardAmount, (Object) customEventRequest.rewardAmount) && Intrinsics.areEqual(this.callbackUrl, customEventRequest.callbackUrl) && Intrinsics.areEqual(this.maxVolume, customEventRequest.maxVolume) && Intrinsics.areEqual(this.currentVolume, customEventRequest.currentVolume);
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.eventId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payload;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.timeToReward;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.eventCode;
        int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        AdUnit.RewardType rewardType = this.rewardType;
        int iHashCode6 = (iHashCode5 + (rewardType != null ? rewardType.hashCode() : 0)) * 31;
        Float f = this.rewardAmount;
        int iHashCode7 = (iHashCode6 + (f != null ? f.hashCode() : 0)) * 31;
        String str4 = this.callbackUrl;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num3 = this.maxVolume;
        int iHashCode9 = (iHashCode8 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.currentVolume;
        return iHashCode9 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "CustomEventRequest(url=" + this.url + ", eventId=" + this.eventId + ", payload=" + this.payload + ", timeToReward=" + this.timeToReward + ", eventCode=" + this.eventCode + ", rewardType=" + this.rewardType + ", rewardAmount=" + this.rewardAmount + ", callbackUrl=" + this.callbackUrl + ", maxVolume=" + this.maxVolume + ", currentVolume=" + this.currentVolume + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeString(this.eventId);
        parcel.writeString(this.payload);
        Integer num = this.timeToReward;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.eventCode;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        AdUnit.RewardType rewardType = this.rewardType;
        if (rewardType != null) {
            parcel.writeInt(1);
            parcel.writeString(rewardType.name());
        } else {
            parcel.writeInt(0);
        }
        Float f = this.rewardAmount;
        if (f != null) {
            parcel.writeInt(1);
            parcel.writeFloat(f.floatValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.callbackUrl);
        Integer num3 = this.maxVolume;
        if (num3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num4 = this.currentVolume;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
    }

    public CustomEventRequest(String str, String str2, String str3, Integer num, Integer num2, AdUnit.RewardType rewardType, Float f, String str4, Integer num3, Integer num4) {
        this.url = str;
        this.eventId = str2;
        this.payload = str3;
        this.timeToReward = num;
        this.eventCode = num2;
        this.rewardType = rewardType;
        this.rewardAmount = f;
        this.callbackUrl = str4;
        this.maxVolume = num3;
        this.currentVolume = num4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CustomEventRequest(String str, String str2, String str3, Integer num, Integer num2, AdUnit.RewardType rewardType, Float f, String str4, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str5;
        String str6;
        String str7;
        Integer num5;
        Integer num6;
        AdUnit.RewardType rewardType2;
        Float f2;
        String str8;
        Integer num7;
        Integer num8 = null;
        if ((i & 1) != 0) {
            str5 = null;
        } else {
            str5 = str;
        }
        if ((i & 2) != 0) {
            str6 = null;
        } else {
            str6 = str2;
        }
        if ((i & 4) != 0) {
            str7 = null;
        } else {
            str7 = str3;
        }
        if ((i & 8) != 0) {
            num5 = null;
        } else {
            num5 = num;
        }
        if ((i & 16) != 0) {
            num6 = null;
        } else {
            num6 = num2;
        }
        if ((i & 32) != 0) {
            rewardType2 = null;
        } else {
            rewardType2 = rewardType;
        }
        if ((i & 64) != 0) {
            f2 = null;
        } else {
            f2 = f;
        }
        if ((i & 128) != 0) {
            str8 = null;
        } else {
            str8 = str4;
        }
        if ((i & 256) != 0) {
            num7 = null;
        } else {
            num7 = num3;
        }
        if ((i & 512) != 0) {
        } else {
            num8 = num4;
        }
        this(str5, str6, str7, num5, num6, rewardType2, f2, str8, num7, num8);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final Integer getTimeToReward() {
        return this.timeToReward;
    }

    public final Integer getEventCode() {
        return this.eventCode;
    }

    public final AdUnit.RewardType getRewardType() {
        return this.rewardType;
    }

    public final Float getRewardAmount() {
        return this.rewardAmount;
    }

    public final String getCallbackUrl() {
        return this.callbackUrl;
    }

    public final Integer getMaxVolume() {
        return this.maxVolume;
    }

    public final Integer getCurrentVolume() {
        return this.currentVolume;
    }
}
