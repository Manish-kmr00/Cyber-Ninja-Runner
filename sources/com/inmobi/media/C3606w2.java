package com.inmobi.media;

import android.content.ContentValues;
import com.inmobi.commons.core.configs.Config;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.w2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3606w2 extends D1 {
    public C3606w2() {
        super("config_db", "(account_id TEXT NOT NULL,config_value TEXT NOT NULL,config_type TEXT NOT NULL,update_ts INTEGER DEFAULT 0,UNIQUE(account_id,config_type))");
    }

    @Override // com.inmobi.media.D1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("config_value");
        if (asString == null) {
            return null;
        }
        String asString2 = contentValues.getAsString("account_id");
        Long asLong = contentValues.getAsLong("update_ts");
        C3464m2 c3464m2 = Config.Companion;
        String asString3 = contentValues.getAsString("config_type");
        Intrinsics.checkNotNullExpressionValue(asString3, "getAsString(...)");
        JSONObject jSONObject = new JSONObject(asString);
        Intrinsics.checkNotNull(asLong);
        long jLongValue = asLong.longValue();
        c3464m2.getClass();
        return C3464m2.a(asString3, jSONObject, asString2, jLongValue);
    }

    @Override // com.inmobi.media.D1
    public final ContentValues b(Object obj) {
        Config config = (Config) obj;
        Intrinsics.checkNotNullParameter(config, "config");
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_id", config.getAccountId$media_release());
        contentValues.put("config_value", config.toJson().toString());
        contentValues.put("config_type", config.getType());
        contentValues.put("update_ts", Long.valueOf(config.getLastUpdateTimeStamp()));
        return contentValues;
    }

    public final boolean b(String type, String accountId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        boolean z = false;
        try {
            z = !C3309b3.b(this.f3045a, null, "account_id=? AND config_type=?", new String[]{accountId, type}, null, null, null, null).isEmpty();
        } catch (Exception unused) {
        }
        return !z;
    }

    public final long a(String type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        String[] strArr = {str, type};
        C3592v2 transform = C3592v2.f3452a;
        Intrinsics.checkNotNullParameter(transform, "transform");
        Object objInvoke = null;
        try {
            List<ContentValues> listB = C3309b3.b(this.f3045a, null, "account_id=? AND config_type=?", strArr, null, null, null, null);
            if (!listB.isEmpty()) {
                objInvoke = transform.invoke(listB.get(0));
            }
        } catch (Exception unused) {
        }
        Long l = (Long) objInvoke;
        long jLongValue = l != null ? l.longValue() : 0L;
        Intrinsics.checkNotNullExpressionValue("w2", "TAG");
        return jLongValue;
    }
}
