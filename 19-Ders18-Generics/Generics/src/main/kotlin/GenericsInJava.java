
/*
 * Öncelikli olarak Java'da Generic'ler invariant(değişmez) olarak bulunurlar.
 * Bunun anlamı List<String>, List<Object> nin bir alt tipi değildir.
 * Eğer List'ler invariant olmasaydı Java'daki array'lerden bir farkı kalmazdı
 * */

import java.util.ArrayList;
import java.util.List;

public class GenericsInJava {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>();

        //compile time hatası alırız Type Dismatch
//        List<Object> objs = strs;

        //eğer hata almasaydık, int bir değeri string bir liste atayabilirdik çünkü arayüzü object olacaktı.
        //her tipi kabul edebilecekti.
//        objs.add(1);

        //spnrasında string listten eleman alırklen aslında int alacaktık ve bunu string değşkene vermeye çalış
        //bu noktada da ClassCastException alırdık. Integer can not cast to String gibi
        //Java runtime safety'i sağlamak için bunu engelliyor.
        String s = strs.get(0);
    }

    void copyAll(Collection<Object> to, Collection<String> from) {
//        Collection<String> , Collection<Object> nin bir alt tipi olmadığından bunu yapamıyoruz
//        to.addAll(from);
    }

    void copyAll2(Collection2<Object> to, Collection2<String> from) {
//        Collection<String> , Collection<Object> nin bir alt tipi olmadığından bunu yapamıyoruz
        to.addAll(from);
//        from.addAll(to);
    }

    void copyAll3(Collection3<Object> to, Collection3<String> from) {
//        Collection<String> , Collection<Object> nin bir alt tipi olmadığından bunu yapamıyoruz
        from.addAll(to);
    }

    //Java'da collection arayüzü böyle birşey
    interface Collection<E> {
        void addAll(java.util.Collection<E> items);
    }

    //Bu sebeplerle Collection arayüzü gerçekte böyle bir şey
    interface Collection2<E> {
        void addAll(Collection2<? extends E> items);
    }

    interface Collection3<E> {
        void addAll(Collection3<? super E> items);
    }

    /*
     * Bıradaki ? extends E ifaesi E tipinde bir değişkeni ya da E'nin alt tiplerini de(subtype) kabul ettiğini
     * Bu sebeple String normalde Object'in bir alt sınıfı olduğundan yukarıdaki copyAll2 methodunda
     * Object tipiş veya onun alt tipleri kabul edilmiş oluyor.
     * Bu sebeple wildcard'ların extends-bound (upper bound) kullanımı burada tiğpi "Covariant" yapıyor.
     * Özetle üst tipe sahip bir listeye alt türü de atayabilmek şeklinde söyleyebiliriz.
     *
     * Java'da ayrıca ? super String gibi wildcard kullanımı da vardır.
     * Bu da String ve super type'larını kabul ediyorum demektir. Buna da Contra-variance denmektedir.
     * */
}
