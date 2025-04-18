public class Retrofit {
    private String baseUrl = "www.google.com";
    private volatile static Retrofit newInstance;

    private Retrofit() {

    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public synchronized static Retrofit getNewInstance() {
        if (newInstance == null)
            newInstance = new Retrofit();
        return newInstance;
    }
}
