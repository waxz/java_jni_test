package ros;

public class ros implements AutoCloseable {

    private long peer;

    static {
        System.loadLibrary("ros_lib_java");
    }
    public ros() {
        initialize();
    }
    protected native void initialize();
    public native void close();

    public native long add(long a, long b);
    public native long subtract(long a, long b);
    public native boolean hello(String[] msgs);

    public native boolean ok();


    public static native void ros_init(String[] args);
}
