/*
 *
 * Sadece bu sınıftan bir tane nesne oluşturulacak
 * */


public class SingletonObject {

    public static void main(String[] args) {
        /*Retrofit retrofit = new Retrofit();
        Retrofit retrofit2 = new Retrofit();
        retrofit.setBaseUrl("https://api.github.com/");
        retrofit.setBaseUrl("https://api.google.com/");
        String baseUrl = retrofit.getBaseUrl();
        String baseUrl2 = retrofit2.getBaseUrl();
        System.out.println(baseUrl);
        System.out.println(baseUrl2);*/

        Retrofit baseUrl = Retrofit.getNewInstance();
    }
}
