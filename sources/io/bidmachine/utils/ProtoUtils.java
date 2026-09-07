package io.bidmachine.utils;

import android.location.Location;
import android.text.TextUtils;
import android.util.Base64;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.MessageLite;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Timestamp;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.adcom.Context;
import com.explorestack.protobuf.adcom.EventType;
import com.explorestack.protobuf.adcom.LocationType;
import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.TrackEventType;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.AdExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ProtoUtils {
    public static boolean isBannerPlacement(Placement placement, BannerSize bannerSize) {
        Placement.DisplayPlacement display = placement.getDisplay();
        return !display.getInstl() && bannerSize.width == display.getW() && bannerSize.height == display.getH();
    }

    public static boolean isInterstitialPlacement(Placement placement) {
        if (isRewardedPlacement(placement)) {
            return false;
        }
        Placement.DisplayPlacement display = placement.getDisplay();
        if (display == Placement.DisplayPlacement.getDefaultInstance() || !display.getInstl()) {
            return isVideoPlacement(placement);
        }
        return true;
    }

    public static boolean isVideoPlacement(Placement placement) {
        return placement.getVideo() != Placement.VideoPlacement.getDefaultInstance();
    }

    public static boolean isRewardedPlacement(Placement placement) {
        return placement.getReward();
    }

    public static boolean isNativePlacement(Placement placement) {
        return placement.getDisplay().getNativefmt().getAssetCount() > 0;
    }

    public static Context.Geo.Builder createGeoBuilderWithLocation(android.content.Context context, Location location, Location location2, boolean z) {
        Context.Geo.Builder builderNewBuilder = Context.Geo.newBuilder();
        fillGeoBuilder(builderNewBuilder, Utils.getBestLocation(context, location, location2), z);
        return builderNewBuilder;
    }

    public static void fillGeoBuilder(Context.Geo.Builder builder, Location location, boolean z) {
        if (z) {
            builder.setUtcoffset(Utils.getUtcOffsetMinutes());
        }
        if (location != null) {
            builder.setType(getLocationType(location));
            builder.setLat((float) location.getLatitude());
            builder.setLon((float) location.getLongitude());
            builder.setAccur((int) location.getAccuracy());
            builder.setLastfix(location.getTime());
        }
    }

    public static LocationType getLocationType(Location location) {
        if (location != null) {
            if ("gps".equals(location.getProvider())) {
                return LocationType.LOCATION_TYPE_GPS;
            }
            if ("network".equals(location.getProvider()) || "passive".equals(location.getProvider())) {
                return LocationType.LOCATION_TYPE_IP;
            }
        }
        return LocationType.LOCATION_TYPE_INVALID;
    }

    public static void prepareEvents(Map<TrackEventType, List<String>> map, List<Ad.Event> list) {
        TrackEventType trackEventTypeFromNumber;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Ad.Event event : list) {
            if (event.getType() == EventType.EVENT_TYPE_IMPRESSION) {
                trackEventTypeFromNumber = TrackEventType.Show;
            } else {
                trackEventTypeFromNumber = TrackEventType.fromNumber(event.getTypeValue());
            }
            if (trackEventTypeFromNumber != null) {
                addEvent(map, trackEventTypeFromNumber, event.getUrl());
            }
        }
    }

    public static void addEvent(Map<TrackEventType, List<String>> map, TrackEventType trackEventType, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<String> arrayList = map.get(trackEventType);
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            map.put(trackEventType, arrayList);
        }
        arrayList.add(str);
    }

    public static AdExtension findFirstAdExtension(Ad ad) {
        int extProtoCount = ad.getExtProtoCount();
        if (extProtoCount <= 0) {
            return null;
        }
        for (int i = 0; i < extProtoCount; i++) {
            try {
                Any extProto = ad.getExtProto(i);
                if (extProto.is(AdExtension.class)) {
                    return (AdExtension) extProto.unpack(AdExtension.class);
                }
                continue;
            } catch (Throwable th) {
                Logger.w(th);
            }
        }
        return null;
    }

    public static boolean isEmpty(Struct struct) {
        return struct == null || struct.getFieldsCount() <= 0;
    }

    public static boolean isEmpty(ListValue listValue) {
        return listValue == null || listValue.getValuesCount() <= 0;
    }

    public static String encodeToString(MessageLite messageLite) {
        if (messageLite == null) {
            return null;
        }
        try {
            return Base64.encodeToString(messageLite.toByteArray(), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, Object> toMap(Struct struct) {
        Map<String, Object> mapOrNull = toMapOrNull(struct);
        return mapOrNull != null ? mapOrNull : new HashMap();
    }

    public static Map<String, Object> toMapOrNull(Struct struct) {
        Object objectOrNull;
        if (isEmpty(struct)) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, Value> entry : struct.getFieldsMap().entrySet()) {
            String key = entry.getKey();
            Value value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && (objectOrNull = toObjectOrNull(value)) != null) {
                map.put(key, objectOrNull);
            }
        }
        return map;
    }

    public static List<Object> toList(ListValue listValue) {
        List<Object> listOrNull = toListOrNull(listValue);
        return listOrNull != null ? listOrNull : new ArrayList();
    }

    public static List<Object> toListOrNull(ListValue listValue) {
        if (isEmpty(listValue)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Value> it = listValue.getValuesList().iterator();
        while (it.hasNext()) {
            Object objectOrNull = toObjectOrNull(it.next());
            if (objectOrNull != null) {
                arrayList.add(objectOrNull);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: io.bidmachine.utils.ProtoUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$explorestack$protobuf$Value$KindCase;

        static {
            int[] iArr = new int[Value.KindCase.values().length];
            $SwitchMap$com$explorestack$protobuf$Value$KindCase = iArr;
            try {
                iArr[Value.KindCase.NUMBER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Value$KindCase[Value.KindCase.STRING_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Value$KindCase[Value.KindCase.BOOL_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Value$KindCase[Value.KindCase.STRUCT_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Value$KindCase[Value.KindCase.LIST_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Object toObjectOrNull(Value value) {
        if (value == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$explorestack$protobuf$Value$KindCase[value.getKindCase().ordinal()];
        if (i == 1) {
            return Double.valueOf(value.getNumberValue());
        }
        if (i == 2) {
            return value.getStringValue();
        }
        if (i == 3) {
            return Boolean.valueOf(value.getBoolValue());
        }
        if (i == 4) {
            return toMapOrNull(value.getStructValue());
        }
        if (i != 5) {
            return null;
        }
        return toListOrNull(value.getListValue());
    }

    public static Struct.Builder toStructBuilderOrNull(Map<?, ?> map) {
        Value.Builder valueBuilderOrNull;
        if (map == null || map.isEmpty()) {
            return null;
        }
        Struct.Builder builderNewBuilder = Struct.newBuilder();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key != null) {
                String strValueOf = String.valueOf(key);
                if (!TextUtils.isEmpty(strValueOf) && (valueBuilderOrNull = toValueBuilderOrNull(entry.getValue())) != null) {
                    builderNewBuilder.putFields(strValueOf, valueBuilderOrNull.build());
                }
            }
        }
        return builderNewBuilder;
    }

    public static Value.Builder toValueBuilderOrNull(Object obj) {
        Struct.Builder structBuilderOrNull;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return Value.newBuilder().setStringValue((String) obj);
        }
        if (obj instanceof Number) {
            return Value.newBuilder().setNumberValue(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return Value.newBuilder().setBoolValue(((Boolean) obj).booleanValue());
        }
        if (obj instanceof List) {
            ListValue.Builder listValueBuilderOrNull = toListValueBuilderOrNull((List) obj);
            if (listValueBuilderOrNull != null) {
                return Value.newBuilder().setListValue(listValueBuilderOrNull);
            }
        } else if ((obj instanceof Map) && (structBuilderOrNull = toStructBuilderOrNull((Map) obj)) != null) {
            return Value.newBuilder().setStructValue(structBuilderOrNull);
        }
        return null;
    }

    public static ListValue.Builder toListValueBuilderOrNull(List<?> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ListValue.Builder builderNewBuilder = ListValue.newBuilder();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Value.Builder valueBuilderOrNull = toValueBuilderOrNull(it.next());
            if (valueBuilderOrNull != null) {
                builderNewBuilder.addValues(valueBuilderOrNull);
            }
        }
        return builderNewBuilder;
    }

    public static Timestamp msToProtobufTimestamp(long j) {
        return Timestamp.newBuilder().setSeconds(j / 1000).setNanos(((int) (j % 1000)) * 1000000).build();
    }
}
