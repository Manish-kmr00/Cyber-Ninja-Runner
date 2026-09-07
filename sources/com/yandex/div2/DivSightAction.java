package com.yandex.div2;

import android.net.Uri;
import com.yandex.div.json.expressions.Expression;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivSightAction.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Lcom/yandex/div2/DivSightAction;", "", "downloadCallbacks", "Lcom/yandex/div2/DivDownloadCallbacks;", "getDownloadCallbacks", "()Lcom/yandex/div2/DivDownloadCallbacks;", "isEnabled", "Lcom/yandex/div/json/expressions/Expression;", "", "()Lcom/yandex/div/json/expressions/Expression;", "logId", "", "getLogId", "logLimit", "", "getLogLimit", "payload", "Lorg/json/JSONObject;", "getPayload", "()Lorg/json/JSONObject;", "referer", "Landroid/net/Uri;", "getReferer", "scopeId", "getScopeId", "()Ljava/lang/String;", "typed", "Lcom/yandex/div2/DivActionTyped;", "getTyped", "()Lcom/yandex/div2/DivActionTyped;", "url", "getUrl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivSightAction {
    DivDownloadCallbacks getDownloadCallbacks();

    Expression<String> getLogId();

    Expression<Long> getLogLimit();

    JSONObject getPayload();

    Expression<Uri> getReferer();

    String getScopeId();

    DivActionTyped getTyped();

    Expression<Uri> getUrl();

    Expression<Boolean> isEnabled();
}
