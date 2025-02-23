package org.example

/*
* QRAniPayBaseFragment'ın nesnesine ihtiyacım olacak mı? Evet: Kesin olarak open, Hayır: open ya da abstract
* QRAniPayBaseFragment'ın içinde abstract başka member'lar var mı? Evet: Kesin olarak abstract, Hayır: open ya da abstract
* QRAniPayBaseFragment bir şablon görevi görüyor mu? Evet: Kesin olarak abstract, Hayır: open ya da abstract
* QRAniPayBaseFragment'ı miras alan child class'lar UI olarak aynı ama içerik olarak farklı mı?  Evet: abstract daha doğru ama zorunlu değil, Hayır: open ya da abstract
*
*
* */

abstract class QRAniPayBaseFragment :BaseFragment() {
    open val title: String = "asdsadad"
    val imageUrl: String = "www.asdasdsad.com"
    val buttonText: String = "Share"
    val buttonOnClickEvent = { view : View ->
    }
}