package sg.bigo.ads.common.h;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import sg.bigo.ads.common.u.a.e;
import sg.bigo.ads.common.u.g;
import sg.bigo.ads.common.u.h;

/* JADX INFO: loaded from: classes10.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13206a = "";
    public boolean b = false;
    protected int c = 0;
    protected boolean d = false;

    protected abstract String a();

    protected abstract String a(Context context);

    protected final void a(Context context, String str, String str2) {
        File file = new File(a(context));
        if (file.exists() || file.mkdir()) {
            try {
                FileWriter fileWriter = new FileWriter(new File(file, b()));
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
                sg.bigo.ads.common.t.a.a(0, 4, a(), "Write JS file successfully");
                a(str2);
            } catch (Exception e) {
                sg.bigo.ads.common.t.a.a(0, a(), "write JS file error: " + e.getMessage());
            }
        }
    }

    protected abstract void a(String str);

    public final void a(final String str, final Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(sg.bigo.ads.common.y.a.a(), new sg.bigo.ads.common.u.b.d(str), context);
        aVar.k = e.h();
        g.a(aVar, new sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.a, sg.bigo.ads.common.u.c.d>() { // from class: sg.bigo.ads.common.h.d.1
            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ sg.bigo.ads.common.u.c.c a(sg.bigo.ads.common.u.c.a aVar2) {
                return new sg.bigo.ads.common.u.c.d(aVar2);
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.c.c cVar2) {
                String strA = ((sg.bigo.ads.common.u.c.d) cVar2).a();
                if (TextUtils.isEmpty(strA) || !d.this.b(strA)) {
                    d.this.c(context);
                    return;
                }
                d.this.f13206a = strA;
                d.this.b = true;
                sg.bigo.ads.common.t.a.a(0, 4, d.this.a(), "Fetch js from network successfully");
                sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.common.h.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.a(context, d.this.f13206a, str);
                    }
                });
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, h hVar) {
                sg.bigo.ads.common.t.a.a(0, 5, d.this.a(), "fetch js from network fail: " + hVar.getMessage());
                d.this.c(context);
            }
        });
    }

    protected abstract boolean a(String str, String str2);

    protected abstract String b();

    public final void b(Context context) {
        if (a(d(), e())) {
            sg.bigo.ads.common.t.a.a(0, 3, a(), "start fetch newest js content: " + d());
            a(d(), context);
        }
    }

    protected abstract boolean b(String str);

    protected abstract String c();

    protected final void c(Context context) {
        if (this.b) {
            return;
        }
        if (this.c < 2) {
            sg.bigo.ads.common.t.a.a(0, 3, a(), "try to re-fetch JS content...");
            this.c++;
            a(c(), context);
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 5, a(), "the retry times has reached the limit");
        if (this.d) {
            return;
        }
        this.d = true;
        if (TextUtils.isEmpty(d())) {
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, a(), "start fetch newest js content: " + d());
        a(d(), context);
    }

    protected abstract String d();

    public final String d(Context context) {
        File file = new File(a(context) + File.separator + b());
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    fileInputStream.close();
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (Exception e) {
            sg.bigo.ads.common.t.a.a(0, a(), "get JS from file error: " + e.getMessage());
            return null;
        }
    }

    protected abstract String e();

    public final boolean e(Context context) {
        return new File(a(context) + File.separator + b()).exists();
    }
}
