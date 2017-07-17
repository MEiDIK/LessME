package net.idik.anyme.model.base.bus

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

/**
 * Created by linshuaibin on 23/02/2017.
 */
class RxBus {

    val defaultBus = RxBus()

    private val bus: Subject<Any> = PublishSubject.create<Any>().toSerialized()

    fun post(event: Any) {
        bus.onNext(event)
    }

    fun <T> toObservable(eventClass: Class<T>): Observable<T> {
        return bus.ofType(eventClass)
    }

    fun <E, T> toAutoLifecycleObservable(provider: LifecycleProvider<E>, eventClass: Class<T>, untilEvent: E? = null): Observable<T> {
        val observable = bus.ofType(eventClass)
        if (untilEvent == null) {
            observable.bindToLifecycle(provider)
        } else {
            observable.bindUntilEvent(provider, untilEvent)
        }
        return observable
    }

}
