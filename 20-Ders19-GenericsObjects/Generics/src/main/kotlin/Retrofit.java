public class Retrofit {
    private String baseUrl = "www.google.com";
    private static Retrofit newInstance;

    private Retrofit(){

    }
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static Retrofit getNewInstance(){
        newInstance = new Retrofit();
        return newInstance;
    }
}
