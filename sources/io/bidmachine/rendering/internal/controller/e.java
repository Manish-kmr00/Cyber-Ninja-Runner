package io.bidmachine.rendering.internal.controller;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import io.bidmachine.rendering.Rendering;
import io.bidmachine.rendering.internal.h;
import io.bidmachine.rendering.internal.k;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.q;
import io.bidmachine.rendering.internal.r;
import io.bidmachine.rendering.internal.s;
import io.bidmachine.rendering.internal.t;
import io.bidmachine.rendering.internal.u;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AdElementType;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.AppearanceParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MethodParams;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.NetworkRequest;
import io.bidmachine.rendering.utils.Tag;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.rendering.utils.VisibilityChanger;
import io.bidmachine.rendering.utils.taskmanager.CancelableTask;
import io.bidmachine.rendering.utils.taskmanager.TaskManager;
import io.bidmachine.util.Executable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class e implements io.bidmachine.rendering.internal.controller.d {
    private final Context b;
    private final AdPhaseParams c;
    private final io.bidmachine.rendering.internal.controller.f d;
    final io.bidmachine.rendering.internal.event.c h;
    io.bidmachine.rendering.internal.controller.g n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Tag f12354a = new Tag("AdPhaseController");
    private final TaskManager e = new io.bidmachine.rendering.internal.b();
    private final io.bidmachine.rendering.internal.c f = new io.bidmachine.rendering.internal.d();
    private final io.bidmachine.rendering.internal.repository.a g = new io.bidmachine.rendering.internal.repository.b();
    private final u i = new g(a("system"));
    private final List j = new CopyOnWriteArrayList();
    private final List k = new CopyOnWriteArrayList();
    private final List l = new CopyOnWriteArrayList();
    private final Map m = new ConcurrentHashMap();

    private class b extends AbstractC0789e {
        private b() {
            super();
        }

        @Override // io.bidmachine.rendering.internal.controller.e.AbstractC0789e, io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a aVar, Error error) {
            super.b(aVar, error);
            e eVar = e.this;
            eVar.a(aVar, eVar.k);
        }

        @Override // io.bidmachine.rendering.internal.controller.e.AbstractC0789e, io.bidmachine.rendering.internal.adform.c
        public void c(io.bidmachine.rendering.internal.adform.a aVar, Error error) {
            super.c(aVar, error);
            e eVar = e.this;
            eVar.a(aVar, eVar.k);
        }

        @Override // io.bidmachine.rendering.internal.controller.e.AbstractC0789e, io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a aVar) {
            super.b(aVar);
            if (!e.this.a(aVar)) {
                c(aVar, new Error("Failed to setup ad element (" + aVar + ")"));
            }
            if (e.this.m.isEmpty()) {
                e.this.i();
            }
        }
    }

    private static class c extends CancelableTask {
        private final io.bidmachine.rendering.internal.a b;

        public c(io.bidmachine.rendering.internal.a aVar) {
            this.b = aVar;
        }

        @Override // io.bidmachine.rendering.utils.taskmanager.CancelableTask
        public void runTask() {
            try {
                this.b.c();
            } catch (Throwable th) {
                m.b(th);
            }
        }
    }

    private class d extends AbstractC0789e {
        private d() {
            super();
        }

        @Override // io.bidmachine.rendering.internal.controller.e.AbstractC0789e, io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a aVar, Error error) {
            super.b(aVar, error);
            e.this.a(error);
        }

        @Override // io.bidmachine.rendering.internal.controller.e.AbstractC0789e, io.bidmachine.rendering.internal.adform.c
        public void c(io.bidmachine.rendering.internal.adform.a aVar, Error error) {
            super.c(aVar, error);
            e.this.a(error);
        }

        @Override // io.bidmachine.rendering.internal.controller.e.AbstractC0789e, io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a aVar) {
            super.b(aVar);
            if (!e.this.a(aVar)) {
                c(aVar, new Error("Failed to setup ad element (" + aVar + ")"));
            } else if (e.this.m.isEmpty()) {
                e.this.i();
            }
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.controller.e$e, reason: collision with other inner class name */
    private abstract class AbstractC0789e implements io.bidmachine.rendering.internal.adform.c {
        private AbstractC0789e() {
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void a(io.bidmachine.rendering.internal.adform.a aVar, Error error) {
            m.a(e.this.f12354a, "AdsElement (%s) - onAdFormFailToShow - %s", aVar, error);
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a aVar, Error error) {
            m.a(e.this.f12354a, "AdsElement (%s) - onAdFormExpired - %s", aVar, error);
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void c(io.bidmachine.rendering.internal.adform.a aVar, Error error) {
            m.a(e.this.f12354a, "AdsElement (%s) - onAdFormFailToLoad - %s", aVar, error);
            e.this.m.remove(aVar);
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void a(io.bidmachine.rendering.internal.adform.a aVar) {
            m.b(e.this.f12354a, "AdsElement (%s) - onAdFormShown", aVar);
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a aVar) {
            m.b(e.this.f12354a, "AdsElement (%s) - onAdFormLoaded", aVar);
            e.this.m.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class f implements io.bidmachine.rendering.internal.event.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f12356a;

        public f(Context context) {
            this.f12356a = context.getApplicationContext();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Boolean bool) {
            io.bidmachine.rendering.internal.controller.g gVar = e.this.n;
            if (gVar != null) {
                gVar.c();
            }
        }

        private void j(String str) {
            io.bidmachine.rendering.internal.controller.g gVar = e.this.n;
            if (gVar != null) {
                gVar.a();
            }
            UrlHandler.openUrl(this.f12356a, str, new k() { // from class: io.bidmachine.rendering.internal.controller.e$f$$ExternalSyntheticLambda1
                @Override // io.bidmachine.util.SafeExecutable
                public final void onExecute(Object obj) {
                    this.f$0.a((Boolean) obj);
                }
            });
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void b() {
            e.this.a(h.class, new Executable() { // from class: io.bidmachine.rendering.internal.controller.e$f$$ExternalSyntheticLambda0
                @Override // io.bidmachine.util.Executable
                public final void execute(Object obj) {
                    ((h) obj).b();
                }
            });
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void c(String str) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - mute, target object (%s) not found", str);
            } else if (objD instanceof o) {
                ((o) objD).l();
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void d(String str) {
            j(str);
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void e(String str) {
            io.bidmachine.rendering.internal.controller.g gVar = e.this.n;
            if (gVar != null) {
                gVar.d();
            }
            j(str);
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void f() {
            e.this.a(s.class, new Executable() { // from class: io.bidmachine.rendering.internal.controller.e$f$$ExternalSyntheticLambda2
                @Override // io.bidmachine.util.Executable
                public final void execute(Object obj) {
                    ((s) obj).f();
                }
            });
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void g(String str) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - simulateClick, target object (%s) not found", str);
            } else if (objD instanceof io.bidmachine.rendering.internal.a) {
                ((io.bidmachine.rendering.internal.a) objD).n();
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void h(String str) {
            new NetworkRequest.Builder(str, NetworkRequest.Method.Get).setUserAgent(Rendering.getUserAgent()).send();
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void i(String str) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - unmute, target object (%s) not found", str);
            } else if (objD instanceof o) {
                ((o) objD).j();
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void a(String str, boolean z) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - lockVisibility, target object (%s) not found", str);
            } else if (objD instanceof VisibilityChanger) {
                ((VisibilityChanger) objD).lockVisibility(z);
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void b(String str) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - hide, target object (%s) not found", str);
            } else if (objD instanceof VisibilityChanger) {
                ((VisibilityChanger) objD).setVisibility(false);
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void f(String str) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - unlockVisibility, target object (%s) not found", str);
            } else if (objD instanceof VisibilityChanger) {
                ((VisibilityChanger) objD).unlockVisibility();
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void a(PrivacySheetParams privacySheetParams) {
            io.bidmachine.rendering.internal.controller.g gVar = e.this.n;
            if (gVar != null) {
                gVar.a(privacySheetParams);
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void a(String str, long j, long j2, float f) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - progress, target object (%s) not found", str);
            } else if (objD instanceof q) {
                ((q) objD).a(j, j2, f);
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void a(String str, long j) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - schedule, target object (%s) not found", str);
            } else if (objD instanceof r) {
                ((r) objD).a(j);
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void a(String str) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - show, target object (%s) not found", str);
            } else if (objD instanceof VisibilityChanger) {
                ((VisibilityChanger) objD).setVisibility(true);
            }
        }

        @Override // io.bidmachine.rendering.internal.event.c
        public void a(String str, String str2) {
            Object objD = e.this.d(str);
            if (objD == null) {
                m.a(e.this.f12354a, "EventTask - start, target object (%s) not found", str);
            } else if (objD instanceof t) {
                ((t) objD).a(str2);
            }
        }
    }

    private class g extends u {
        public g(io.bidmachine.rendering.internal.event.a aVar) {
            super(aVar);
        }

        @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.h
        public void b() {
            io.bidmachine.rendering.internal.controller.g gVar = e.this.n;
            if (gVar != null) {
                gVar.b();
            }
        }

        @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.s
        public void f() {
            io.bidmachine.rendering.internal.controller.g gVar = e.this.n;
            if (gVar != null) {
                gVar.f();
            }
        }

        @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.o
        public void j() {
            p().c();
        }

        @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.o
        public void l() {
            p().f();
        }

        @Override // io.bidmachine.rendering.internal.u
        public String q() {
            return p().g();
        }
    }

    public e(Context context, AdPhaseParams adPhaseParams, io.bidmachine.rendering.internal.controller.f fVar) {
        this.b = context.getApplicationContext();
        this.c = adPhaseParams;
        this.d = fVar;
        this.h = new f(context);
        c(adPhaseParams.getMethodParamsList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        io.bidmachine.rendering.internal.a aVarB = b(str);
        if (aVarB != null) {
            return aVarB;
        }
        n nVarC = c(str);
        if (nVarC != null) {
            return nVarC;
        }
        if (this.i.q().equals(str)) {
            return this.i;
        }
        return null;
    }

    private void e(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            try {
                ((io.bidmachine.rendering.internal.a) it.next()).d();
            } catch (Throwable th) {
                m.b(th);
            }
        }
    }

    private void j() {
        if (this.f.h()) {
            this.i.p().n();
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public AdPhaseParams f() {
        return this.c;
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public List g() {
        return this.j;
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public List h() {
        return this.k;
    }

    void i() {
        if (this.f.a(true)) {
            this.d.a(this);
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public void onShown() {
        j();
    }

    public String toString() {
        return this.f12354a.toString();
    }

    private void b(Collection collection) {
        if (collection == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            a((u) it.next());
        }
        collection.clear();
    }

    private void c(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            MethodParams methodParams = (MethodParams) it.next();
            this.l.add(new n(methodParams, a(methodParams.getName())));
        }
    }

    private void d(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            io.bidmachine.rendering.internal.a aVar = (io.bidmachine.rendering.internal.a) it.next();
            m.b(this.f12354a, "Load AdElement - %s", aVar.i().getName());
            c cVar = new c(aVar);
            this.m.put(aVar, cVar);
            this.e.execute(cVar);
        }
    }

    private void f(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            try {
                ((io.bidmachine.rendering.internal.a) it.next()).e();
            } catch (Throwable th) {
                m.b(th);
            }
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public void e() {
        this.f.k();
        f(this.j);
        f(this.k);
        a(r.class, new Executable() { // from class: io.bidmachine.rendering.internal.controller.e$$ExternalSyntheticLambda1
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                ((r) obj).m();
            }
        });
    }

    private io.bidmachine.rendering.internal.a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        io.bidmachine.rendering.internal.a aVarA = a(g(), str);
        return aVarA == null ? a(h(), str) : aVarA;
    }

    private n c(String str) {
        for (n nVar : this.l) {
            if (nVar.r().getName().equals(str)) {
                return nVar;
            }
        }
        return null;
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public void d() {
        e(this.j);
        e(this.k);
        a(r.class, new Executable() { // from class: io.bidmachine.rendering.internal.controller.e$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                ((r) obj).pause();
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public boolean b() {
        return this.f.b();
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public void c() {
        List<AdElementParams> adsList = this.c.getAdsList();
        if (adsList.isEmpty()) {
            this.d.a(this, new Error("AdPhase does not contain any ads part"));
            return;
        }
        if (b()) {
            this.d.a(this);
        } else if (this.f.c()) {
            a(this.b, adsList);
            b(this.b, this.c.getControlsList());
        }
    }

    private void b(Context context, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            AdElementParams adElementParams = (AdElementParams) it.next();
            String name = adElementParams.getName();
            m.b(this.f12354a, "Create AdElement - %s", name);
            io.bidmachine.rendering.internal.adform.a aVarA = io.bidmachine.rendering.internal.adform.b.a(context, this.g, adElementParams, new b(), a(name));
            if (aVarA != null) {
                this.k.add(aVarA);
            }
        }
        d(this.k);
    }

    private io.bidmachine.rendering.internal.event.a a(String str) {
        return new io.bidmachine.rendering.internal.event.b(str, this.h, this.c.getEventTypeMap(str));
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public void a() {
        this.f.a();
        a(this.i);
        b(this.l);
        a(this.j);
        a(this.k);
        Iterator it = this.m.values().iterator();
        while (it.hasNext()) {
            this.e.cancel((CancelableTask) it.next());
        }
        this.m.clear();
        this.n = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.bidmachine.rendering.internal.a aVar, Collection collection) {
        if (collection != null) {
            collection.remove(aVar);
        }
        try {
            aVar.a();
        } catch (Throwable th) {
            m.b(th);
        }
    }

    private void a(Collection collection) {
        if (collection == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            try {
                ((io.bidmachine.rendering.internal.a) it.next()).a();
            } catch (Throwable th) {
                m.b(th);
            }
        }
        collection.clear();
    }

    private void a(u uVar) {
        if (uVar == null) {
            return;
        }
        try {
            uVar.a();
        } catch (Throwable th) {
            m.b(th);
        }
    }

    private void a(Class cls, Executable executable, Object obj) {
        if (cls.isInstance(obj)) {
            try {
                executable.execute(obj);
            } catch (Throwable th) {
                m.b(th);
            }
        }
    }

    private io.bidmachine.rendering.internal.a a(Collection collection, String str) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            io.bidmachine.rendering.internal.a aVar = (io.bidmachine.rendering.internal.a) it.next();
            if (aVar.i().getName().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private void a(Context context, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            AdElementParams adElementParams = (AdElementParams) it.next();
            String name = adElementParams.getName();
            m.b(this.f12354a, "Create AdElement - %s", name);
            io.bidmachine.rendering.internal.adform.a aVarA = io.bidmachine.rendering.internal.adform.b.a(context, this.g, adElementParams, new d(), a(name));
            if (aVarA != null) {
                this.j.add(aVarA);
            }
        }
        if (this.j.isEmpty()) {
            a(new Error("No supported ads found for the given parameters"));
        } else {
            d(this.j);
        }
    }

    void a(Error error) {
        if (this.f.a(false)) {
            this.d.a(this, error);
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.d
    public void a(io.bidmachine.rendering.internal.controller.g gVar) {
        this.n = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Class cls, Executable executable) {
        Iterator it = g().iterator();
        while (it.hasNext()) {
            a(cls, executable, (io.bidmachine.rendering.internal.a) it.next());
        }
        Iterator it2 = h().iterator();
        while (it2.hasNext()) {
            a(cls, executable, (io.bidmachine.rendering.internal.a) it2.next());
        }
        Iterator it3 = this.l.iterator();
        while (it3.hasNext()) {
            a(cls, executable, (n) it3.next());
        }
        a(cls, executable, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(io.bidmachine.rendering.internal.adform.a aVar) {
        View viewK = aVar.k();
        if (viewK == 0) {
            return false;
        }
        AdElementParams adElementParamsI = aVar.i();
        viewK.setId(UiUtils.generateViewId());
        viewK.setTag(adElementParamsI.getName());
        AppearanceParams appearanceParams = adElementParamsI.getAppearanceParams();
        Boolean clickable = appearanceParams.getClickable();
        if (clickable != null && clickable.booleanValue()) {
            viewK.setOnClickListener(aVar);
        }
        Boolean visible = appearanceParams.getVisible();
        if (visible != null) {
            aVar.setVisibility(visible.booleanValue());
        }
        Float opacity = appearanceParams.getOpacity();
        if (opacity != null) {
            viewK.setAlpha(opacity.floatValue());
        }
        if (viewK instanceof io.bidmachine.rendering.internal.f) {
            ((io.bidmachine.rendering.internal.f) viewK).a(appearanceParams);
            return true;
        }
        if (aVar.i().getAdElementType() == AdElementType.Image) {
            return true;
        }
        UiUtils.safeSetBackgroundColor(viewK, appearanceParams.getBackgroundColor());
        return true;
    }
}
