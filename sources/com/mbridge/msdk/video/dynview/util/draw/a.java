package com.mbridge.msdk.video.dynview.util.draw;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.video.dynview.c;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ChoiceOneDrawBitBg.java */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    private static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f5754a;
    private Bitmap b;
    private Bitmap c;

    /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.util.draw.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChoiceOneDrawBitBg.java */
    class RunnableC0512a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f5755a;
        final /* synthetic */ int b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;

        /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.util.draw.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ChoiceOneDrawBitBg.java */
        class RunnableC0513a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.mbridge.msdk.video.dynview.shape.a.b f5756a;

            RunnableC0513a(com.mbridge.msdk.video.dynview.shape.a.b bVar) {
                this.f5756a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f5754a == null || this.f5756a.a() == null) {
                    return;
                }
                a.this.f5754a.setBackground(this.f5756a.a());
            }
        }

        RunnableC0512a(Bitmap bitmap, int i, float f, float f2) {
            this.f5755a = bitmap;
            this.b = i;
            this.c = f;
            this.d = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bitmap bitmapA = y.a(this.f5755a, 10);
                Bitmap bitmapA2 = y.a(this.f5755a, 10);
                com.mbridge.msdk.video.dynview.shape.a.b bVarA = com.mbridge.msdk.video.dynview.shape.a.a();
                bVarA.a(this.b).b(bitmapA).a(bitmapA2);
                if (this.b == 2) {
                    float f = this.c;
                    float f2 = this.d;
                    if (f > f2) {
                        bVarA.b(f).a(this.d);
                    } else {
                        bVarA.b(f2).a(this.c);
                    }
                } else {
                    bVarA.b(this.c).a(this.d);
                }
                if (a.this.f5754a != null) {
                    a.this.f5754a.post(new RunnableC0513a(bVarA));
                }
            } catch (Exception e) {
                o0.b("ChoiceOneDrawBitBg", e.getMessage());
            }
        }
    }

    private a() {
    }

    public void b() {
        if (this.f5754a != null) {
            this.f5754a = null;
        }
        Bitmap bitmap = this.b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.b.recycle();
            this.b = null;
        }
        Bitmap bitmap2 = this.c;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.c.recycle();
        this.c = null;
    }

    public static a a() {
        a aVar;
        if (d != null) {
            return d;
        }
        synchronized (a.class) {
            if (d == null) {
                d = new a();
            }
            aVar = d;
        }
        return aVar;
    }

    public void a(Map<String, Bitmap> map, c cVar, View view) {
        if (view == null || cVar == null || map == null || map.size() == 0 || map.size() < 2 || cVar.b() == null || cVar.b().size() < 2) {
            return;
        }
        this.f5754a = view;
        int iH = cVar.h();
        float fM = cVar.m();
        float fK = cVar.k();
        try {
            List<CampaignEx> listB = cVar.b();
            String md5 = listB.get(0) != null ? SameMD5.getMD5(listB.get(0).getImageUrl()) : "";
            String md6 = listB.get(1) != null ? SameMD5.getMD5(listB.get(1).getImageUrl()) : "";
            Bitmap bitmap = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
            Bitmap bitmap2 = (TextUtils.isEmpty(md6) || !map.containsKey(md6)) ? null : map.get(md6);
            if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            a(iH, fM, fK, bitmap, bitmap2);
        } catch (Exception e) {
            o0.b("ChoiceOneDrawBitBg", e.getMessage());
        }
    }

    private synchronized void a(int i, float f, float f2, Bitmap bitmap, Bitmap bitmap2) {
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.a().execute(new RunnableC0512a(bitmap, i, f, f2));
        } catch (Exception e) {
            o0.a("ChoiceOneDrawBitBg", e.getMessage());
        }
    }
}
