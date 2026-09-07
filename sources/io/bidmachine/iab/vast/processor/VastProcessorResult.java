package io.bidmachine.iab.vast.processor;

import android.os.Bundle;
import android.text.TextUtils;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.VastUrlProcessorRegistry;
import io.bidmachine.iab.vast.tags.AdContentTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class VastProcessorResult {
    private VastAd b;
    private VastSpecError c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f12312a = new ArrayList();
    private boolean d = true;

    List a() {
        return this.f12312a;
    }

    boolean b() {
        return this.d;
    }

    public VastAd getVastAd() {
        return this.b;
    }

    public VastSpecError getVastSpecError() {
        return this.c;
    }

    public boolean hasVastAd() {
        return this.b != null;
    }

    void a(AdContentTag adContentTag, VastSpecError vastSpecError) {
        a(vastSpecError);
        Bundle bundle = new Bundle();
        bundle.putInt(VastRequest.PARAMS_ERROR_CODE, vastSpecError.getCode());
        List<String> errorUrlList = adContentTag.getErrorUrlList();
        if (errorUrlList == null || errorUrlList.isEmpty()) {
            return;
        }
        Iterator<String> it = errorUrlList.iterator();
        while (it.hasNext()) {
            String strProcessUrl = VastUrlProcessorRegistry.processUrl(it.next(), bundle);
            if (!TextUtils.isEmpty(strProcessUrl)) {
                this.f12312a.add(strProcessUrl);
            }
        }
    }

    void a(boolean z) {
        this.d = z;
    }

    void a(VastAd vastAd) {
        this.b = vastAd;
    }

    void a(VastSpecError vastSpecError) {
        this.c = vastSpecError;
    }
}
