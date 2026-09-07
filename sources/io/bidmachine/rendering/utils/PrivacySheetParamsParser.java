package io.bidmachine.rendering.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.util.UtilsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lio/bidmachine/rendering/utils/PrivacySheetParamsParser;", "", "", "json", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "parseJson", "typeName", "Lio/bidmachine/rendering/model/PrivacySheetParams$ActionType;", "a", "base64Png", "Landroid/graphics/Bitmap;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "<init>", "()V", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1})
public final class PrivacySheetParamsParser {
    public static final PrivacySheetParamsParser INSTANCE = new PrivacySheetParamsParser();

    private PrivacySheetParamsParser() {
    }

    private final PrivacySheetParams.ActionType a(String typeName) {
        for (PrivacySheetParams.ActionType actionType : PrivacySheetParams.ActionType.values()) {
            if (StringsKt.equals(actionType.name(), typeName, true)) {
                return actionType;
            }
        }
        return null;
    }

    private final Bitmap b(String base64Png) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            byte[] bytes = base64Png.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] bArrDecodeBase64$default = UtilsKt.decodeBase64$default(bytes, 0, 1, null);
            objM7904constructorimpl = Result.m7904constructorimpl(bArrDecodeBase64$default == null ? null : BitmapFactory.decodeByteArray(bArrDecodeBase64$default, 0, bArrDecodeBase64$default.length));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        return (Bitmap) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    @JvmStatic
    public static final PrivacySheetParams parseJson(String json) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(json, "json");
        PrivacySheetParamsParser privacySheetParamsParser = INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(json);
            String title = jSONObject.optString("title");
            String subtitle = jSONObject.optString("subtitle");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("actions");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            } else {
                Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "rootObject.optJSONArray(\"actions\") ?: JSONArray()");
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                String strOptString = jSONObject2.optString("type");
                Intrinsics.checkNotNullExpressionValue(strOptString, "actionObject.optString(\"type\")");
                PrivacySheetParams.ActionType actionTypeA = privacySheetParamsParser.a(strOptString);
                if (actionTypeA != null) {
                    String actionTitle = jSONObject2.optString("title");
                    String data = jSONObject2.optString("data");
                    String it = jSONObject2.optString("icon");
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (StringsKt.isBlank(it)) {
                        it = null;
                    }
                    Bitmap bitmapB = it != null ? privacySheetParamsParser.b(it) : null;
                    Intrinsics.checkNotNullExpressionValue(actionTitle, "actionTitle");
                    Intrinsics.checkNotNullExpressionValue(data, "data");
                    arrayList.add(new PrivacySheetParams.Action(actionTypeA, actionTitle, data, bitmapB));
                }
            }
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(subtitle, "subtitle");
            objM7904constructorimpl = Result.m7904constructorimpl(new PrivacySheetParams(title, subtitle, arrayList));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        return (PrivacySheetParams) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }
}
