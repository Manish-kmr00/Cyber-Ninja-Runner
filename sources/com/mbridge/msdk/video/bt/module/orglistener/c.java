package com.mbridge.msdk.video.bt.module.orglistener;

import com.mbridge.msdk.foundation.tools.o0;

/* JADX INFO: compiled from: H5ShowRewardListener.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends b {
    private com.mbridge.msdk.video.bt.module.listener.b c;
    private String d;

    public c(com.mbridge.msdk.video.bt.module.listener.b bVar, String str) {
        this.c = bVar;
        this.d = str;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.c != null) {
            o0.a("H5ShowRewardListener", "onAdShow");
            this.c.a(this.d);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void b(String str, String str2) {
        if (this.c != null) {
            o0.a("H5ShowRewardListener", "onVideoComplete");
            this.c.a(this.d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z, com.mbridge.msdk.videocommon.entity.c cVar2) {
        if (this.c != null) {
            o0.a("H5ShowRewardListener", "onAdClose");
            this.c.a(this.d, z, cVar2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
        if (this.c != null) {
            o0.a("H5ShowRewardListener", "onShowFail");
            this.c.a(this.d, str);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z, String str, String str2) {
        if (this.c != null) {
            o0.a("H5ShowRewardListener", "onVideoAdClicked");
            this.c.b(this.d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(String str, String str2) {
        if (this.c != null) {
            o0.a("H5ShowRewardListener", "onEndcardShow");
            this.c.c(this.d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(int i, String str, String str2) {
        if (this.c != null) {
            o0.a("H5ShowRewardListener", "onAutoLoad");
            this.c.a(this.d, i, str, str2);
        }
    }
}
