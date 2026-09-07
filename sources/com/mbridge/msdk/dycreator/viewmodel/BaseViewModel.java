package com.mbridge.msdk.dycreator.viewmodel;

import com.mbridge.msdk.dycreator.viewobserver.c;
import com.mbridge.msdk.dycreator.viewobserver.d;
import com.mbridge.msdk.dycreator.viewobserver.f;
import com.mbridge.msdk.dycreator.viewobserver.h;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;

/* JADX INFO: loaded from: classes12.dex */
public interface BaseViewModel {
    void setClickSubject(c cVar);

    void setConcreteSubject(d dVar);

    void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener);

    void setEffectSubject(f fVar);

    void setModelDataAndBind();

    void setReportSubject(h hVar);
}
