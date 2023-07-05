package test.java;

import main.org.example.Downloader;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void ObjectTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<java.lang.Object: boolean equals(java.lang.Object)>";
        String signature1 = "<java.lang.Object: java.lang.String toString()>";

        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);

        assertNotNull(body0);
        assertNotNull(body1);
    }

    @Test
    public void Comparator() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<java.util.Comparator: int compare(java.lang.Object,java.lang.Object)>";

        String body0 = downloader.find(path, signature0);

        assertNotNull(body0);
    }

    @Test
    public void HashMapTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<java.util.HashMap$TreeNode: java.util.HashMap$TreeNode putTreeVal(java.util.HashMap,java.util.HashMap$Node[],int,java.lang.Object,java.lang.Object)>";
        String signature1 = "<java.util.HashMap: java.util.HashMap$Node newNode(int,java.lang.Object,java.lang.Object,java.util.HashMap$Node)>";
        String signature2 = "<java.util.HashMap: java.lang.Object putVal(int,java.lang.Object,java.lang.Object,boolean,boolean)>";
        String signature3 = "<java.util.HashMap: void readObject(java.io.ObjectInputStream)>";
        String signature4 = "<java.util.HashMap: java.util.HashMap$Node[] resize()>";

        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);
        String body2 = downloader.find(path, signature2);
        String body3 = downloader.find(path, signature3);
        String body4 = downloader.find(path, signature4);

        assertNotNull(body0);
        assertNotNull(body1);
        assertNotNull(body2);
        assertNotNull(body3);
        assertNotNull(body4);
    }

    @Test
    public void PriorityQueueTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<java.util.PriorityQueue: void readObject(java.io.ObjectInputStream)>";
        String signature1 = "<java.util.PriorityQueue: void heapify()>";
        String signature2 = "<java.util.PriorityQueue: java.lang.Object poll()>";
        String signature3 = "<java.util.PriorityQueue: void siftDown(int,java.lang.Object)>";
        String signature4 = "<java.util.PriorityQueue: void initFromCollection(java.util.Collection)>";

        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);
        String body2 = downloader.find(path, signature2);
        String body3 = downloader.find(path, signature3);
        String body4 = downloader.find(path, signature4);

        assertNotNull(body0);
        assertNotNull(body1);
        assertNotNull(body2);
        assertNotNull(body3);
        assertNotNull(body4);
    }

    @Test
    public void ClojureTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<clojure.lang.LazySeq: clojure.lang.ISeq seq()>";
        String signature1 = "<clojure.core$bean$fn__6906$fn__6907: java.lang.Object invoke()>";
        //constructor test
        String signature2 = "<clojure.core$bean$fn__6906$fn__6907: void <init>(java.lang.Object,java.lang.Object,java.lang.Object)>";

        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);
        String body2 = downloader.find(path, signature2);

        assertNotNull(body0);
        assertNotNull(body1);
        assertNotNull(body2);
    }

    @Test
    public void CustomLambdaTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<org.example.LambdaApp: int lambda$func$6(int)>";

        String body0 = downloader.find(path, signature0);

        assertEquals(body0, "() -> x + y + z");
    }

    @Test
    public void JsonPathTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<com.jayway.jsonpath.internal.filter.ValueNodes$PathNode: com.jayway.jsonpath.internal.filter.ValueNodes$PathNode asExistsCheck(boolean)>";
        String signature1 = "<com.jayway.jsonpath.internal.filter.ValueNodes$PathNode: com.jayway.jsonpath.internal.filter.ValueNode evaluate(com.jayway.jsonpath.Predicate$PredicateContext)>";
        String signature2 = "<com.jayway.jsonpath.internal.filter.ValueNodes$ValueListNode: void <init>(java.util.Collection)>";
        String signature3 = "<com.jayway.jsonpath.internal.function.latebinding.PathLateBindingValue: void <init>(com.jayway.jsonpath.internal.Path,java.lang.Object,com.jayway.jsonpath.Configuration)>";
        String signature4 = "<com.jayway.jsonpath.internal.path.ScanPathToken$FilterPathTokenPredicate: boolean matches(java.lang.Object)>";
        String signature5 = "<com.jayway.jsonpath.spi.mapper.GsonMappingProvider: void <init>(java.util.concurrent.Callable)>";
        String signature6 = "<com.jayway.jsonpath.spi.mapper.GsonMappingProvider: void <init>(com.google.gson.Gson)>";


        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1); //wrong
        String body2 = downloader.find(path, signature2);
        String body3 = downloader.find(path, signature3);
        String body4 = downloader.find(path, signature4); //wrong
        String body5 = downloader.find(path, signature5);
        String body6 = downloader.find(path, signature6);

        assertNotNull(body0);
        assertNotNull(body1);
        assertNotNull(body2);
        assertNotNull(body3);
        assertNotNull(body4);
        assertNotNull(body5);
        assertNotNull(body6);
    }

    @Test
    public void GsonTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<com.google.gson.internal.bind.TypeAdapters$23: java.lang.Object read(com.google.gson.stream.JsonReader)>";
        String signature1 = "<com.google.gson.internal.bind.TypeAdapters$3: java.lang.Object read(com.google.gson.stream.JsonReader)>";
        String signature2 = "<com.google.gson.internal.bind.TypeAdapters$3: java.lang.Object read(com.google.gson.stream.JsonReader)>";
        String signature3 = "<com.google.gson.internal.bind.TypeAdapters$4: void write(com.google.gson.stream.JsonWriter,java.lang.Object)>";
        String signature4 = "<com.google.gson.internal.bind.TypeAdapters$28: void write(com.google.gson.stream.JsonWriter,java.lang.Object)>";
        String signature5 = "<com.google.gson.internal.bind.TypeAdapters: com.google.gson.TypeAdapterFactory newFactory(java.lang.Class,com.google.gson.TypeAdapter)>";
        String signature6 = "<com.google.gson.Gson: void <init>(com.google.gson.internal.Excluder,com.google.gson.FieldNamingStrategy,java.util.Map,boolean,boolean,boolean,boolean,com.google.gson.FormattingStyle,boolean,boolean,boolean,com.google.gson.LongSerializationPolicy,java.lang.String,int,int,java.util.List,java.util.List,java.util.List,com.google.gson.ToNumberStrategy,com.google.gson.ToNumberStrategy,java.util.List)>";


        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1); //wrong
        String body2 = downloader.find(path, signature2);
        String body3 = downloader.find(path, signature3);
        String body4 = downloader.find(path, signature4); //wrong
        String body5 = downloader.find(path, signature5);
        String body6 = downloader.find(path, signature6);

        assertNotNull(body0);
        assertNotNull(body1);
        assertNotNull(body2);
        assertNotNull(body3);
        assertNotNull(body4);
        assertNotNull(body5);
        assertNotNull(body6);
    }




}
