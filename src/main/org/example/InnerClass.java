package main.org.example;

public class InnerClass<T, U> {
    private static class InnerClass$2<R> {

        private static class InnerClassV3<R> {

        }
        public R getValue() {
            return valueV2;
        }

        public void setValue(R valueV2) {
            this.valueV2 = valueV2;
        }

        private R valueV2;
        private InnerClass$2(R value) {
            this.valueV2 = value;
        }
    }
    private T value;
    private InnerClass$2<U> value2;

    public InnerClass(T value, U value2) {
        this.value = value;
        this.value2 = new InnerClass$2<>(value2);
    }

    public T getValue() {
        return value;
    }

    public InnerClass$2<U> getValue2() {
        return value2;
    }

    public void setValue2(InnerClass$2<U> value2) {
        this.value2 = value2;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
