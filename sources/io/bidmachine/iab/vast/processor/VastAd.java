package io.bidmachine.iab.vast.processor;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.tags.AdVerificationsExtensionTag;
import io.bidmachine.iab.vast.tags.AppodealExtensionTag;
import io.bidmachine.iab.vast.tags.CompanionTag;
import io.bidmachine.iab.vast.tags.LinearCreativeTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import io.bidmachine.iab.vast.tags.VideoClicksTag;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class VastAd implements Parcelable {
    public static final Parcelable.Creator<VastAd> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearCreativeTag f12310a;
    private final MediaFileTag b;
    private VastRequest c;
    private ArrayList d;
    private ArrayList e;
    private ArrayList f;
    private ArrayList g;
    private ArrayList h;
    private EnumMap i;
    private AppodealExtensionTag j;
    private List k = new ArrayList();

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VastAd createFromParcel(Parcel parcel) {
            return new VastAd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VastAd[] newArray(int i) {
            return new VastAd[i];
        }
    }

    protected VastAd(Parcel parcel) {
        this.f12310a = (LinearCreativeTag) parcel.readSerializable();
        this.b = (MediaFileTag) parcel.readSerializable();
        this.d = (ArrayList) parcel.readSerializable();
        this.e = parcel.createStringArrayList();
        this.f = parcel.createStringArrayList();
        this.g = parcel.createStringArrayList();
        this.h = parcel.createStringArrayList();
        this.i = (EnumMap) parcel.readSerializable();
        this.j = (AppodealExtensionTag) parcel.readSerializable();
        parcel.readList(this.k, AdVerificationsExtensionTag.class.getClassLoader());
    }

    void a(VastSpecError vastSpecError) {
        VastRequest vastRequest = this.c;
        if (vastRequest != null) {
            vastRequest.sendVastSpecError(vastSpecError);
        }
    }

    void b(ArrayList arrayList) {
        this.d = arrayList;
    }

    void c(ArrayList arrayList) {
        this.f = arrayList;
    }

    void d(ArrayList arrayList) {
        this.e = arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdParameters() {
        return this.f12310a.getAdParameters();
    }

    public List<AdVerificationsExtensionTag> getAdVerificationsExtensionList() {
        return this.k;
    }

    public AppodealExtensionTag getAppodealExtension() {
        return this.j;
    }

    public CompanionTag getBanner(Context context) {
        ArrayList arrayList = this.d;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (CompanionTag companionTag : this.d) {
                int width = companionTag.getWidth();
                int height = companionTag.getHeight();
                if (width > -1 && height > -1) {
                    if (Utils.isTablet(context) && width == 728 && height == 90) {
                        return companionTag;
                    }
                    if (!Utils.isTablet(context) && width == 320 && height == 50) {
                        return companionTag;
                    }
                }
            }
        }
        return null;
    }

    public String getClickThroughUrl() {
        VideoClicksTag videoClicksTag = this.f12310a.getVideoClicksTag();
        if (videoClicksTag != null) {
            return videoClicksTag.getClickThroughUrl();
        }
        return null;
    }

    public List<String> getClickTrackingUrlList() {
        return this.g;
    }

    public CompanionTag getCompanion(int targetWidth, int targetHeight) {
        ArrayList arrayList = this.d;
        if (arrayList != null && !arrayList.isEmpty()) {
            HashMap map = new HashMap();
            for (CompanionTag companionTag : this.d) {
                int width = companionTag.getWidth();
                int height = companionTag.getHeight();
                if (width > -1 && height > -1) {
                    float fMax = Math.max(width, height) / Math.min(width, height);
                    if (Math.min(width, height) >= 250 && fMax <= 2.5d && companionTag.hasCreative()) {
                        map.put(Float.valueOf(width / height), companionTag);
                    }
                }
            }
            if (!map.isEmpty()) {
                float f = targetWidth / targetHeight;
                Set setKeySet = map.keySet();
                float fFloatValue = ((Float) setKeySet.iterator().next()).floatValue();
                Iterator it = setKeySet.iterator();
                while (it.hasNext()) {
                    float fFloatValue2 = ((Float) it.next()).floatValue();
                    if (Math.abs(fFloatValue - f) > Math.abs(fFloatValue2 - f)) {
                        fFloatValue = fFloatValue2;
                    }
                }
                return (CompanionTag) map.get(Float.valueOf(fFloatValue));
            }
            a(VastSpecError.GENERAL_COMPANION);
        }
        return null;
    }

    public Float getDurationSec() {
        return this.f12310a.getDurationSec();
    }

    public List<String> getErrorUrlList() {
        return this.f;
    }

    public List<String> getImpressionUrlList() {
        return this.e;
    }

    public MediaFileTag getPickedMediaFileTag() {
        return this.b;
    }

    public int getSkipOffsetSec() {
        return this.f12310a.getSkipOffsetSec();
    }

    public Map<TrackingEvent, List<String>> getTrackingEventListMap() {
        return this.i;
    }

    public ArrayList<String> getWrapperCompanionClickTrackingUrlList() {
        return this.h;
    }

    public void setAdVerificationsExtensionList(List<AdVerificationsExtensionTag> adVerificationsExtensionTagList) {
        this.k = adVerificationsExtensionTagList;
    }

    public void setVastRequest(VastRequest vastRequest) {
        this.c = vastRequest;
    }

    public void setWrapperCompanionClickTrackingUrlList(ArrayList<String> wrapperCompanionClickTrackingUrlList) {
        this.h = wrapperCompanionClickTrackingUrlList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.f12310a);
        dest.writeSerializable(this.b);
        dest.writeSerializable(this.d);
        dest.writeStringList(this.e);
        dest.writeStringList(this.f);
        dest.writeStringList(this.g);
        dest.writeStringList(this.h);
        dest.writeSerializable(this.i);
        dest.writeSerializable(this.j);
        dest.writeList(this.k);
    }

    VastAd(LinearCreativeTag linearCreativeTag, MediaFileTag mediaFileTag) {
        this.f12310a = linearCreativeTag;
        this.b = mediaFileTag;
    }

    void a(AppodealExtensionTag appodealExtensionTag) {
        this.j = appodealExtensionTag;
    }

    void a(ArrayList arrayList) {
        this.g = arrayList;
    }

    void a(EnumMap enumMap) {
        this.i = enumMap;
    }
}
