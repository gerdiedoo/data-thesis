public abstract class AbstractMap implements Map<String, String> {
    public boolean isEmpty() {
        return size() == 0;
    }

    protected static class MapEntry {
        private String k;
        private String v;

        public String getKey() {
            return k;
        }

        public String getValue() {
            return v;
        }

        protected void setKey(String key) {
            k = key;
        }

        protected String setValue(String value) {
            String old = v;
            v = value;
            return old;
        }
    }

}
