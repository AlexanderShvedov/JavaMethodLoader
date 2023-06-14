//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package clojure;

import clojure.lang.AFunction;
import clojure.lang.Reflector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public final class core$bean$fn__6906$fn__6907 extends AFunction {
    Object x;
    Object method;
    Object pd;

    public core$bean$fn__6906$fn__6907(Object var1, Object var2, Object var3) {
        this.x = var1;
        this.method = var2;
        this.pd = var3;
    }

    public Object invoke() {
        Class var10000 = (Class)((PropertyDescriptor)this.pd).getPropertyType();
        Object var10001 = ((Method)this.method).invoke(this.x, (Object[])null);
        Object var1 = null;
        return Reflector.prepRet(var10000, var10001);
    }
}