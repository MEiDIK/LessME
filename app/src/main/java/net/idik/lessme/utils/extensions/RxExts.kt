package net.idik.lessme.utils.extensions

import android.app.Activity
import android.view.View
import com.gturedi.views.StatefulLayout
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by linshuaibin on 07/04/2017.
 */
fun <T> Observable<T>.withCommitting(activity: Activity) = compose {
    it
            .doOnNext {
                net.idik.lessme.utils.T.committing(activity)
            }
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterNext {
                net.idik.lessme.utils.T.dismissHub()
            }
}

fun <T> Observable<T>.with(statefulLayout: StatefulLayout, reloadCallback: (v: View) -> Unit) = compose {
    it
            .doOnSubscribe {
                statefulLayout.showLoading()
            }
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                statefulLayout.showError(reloadCallback)
            }
            .doAfterNext {
                statefulLayout.showContent()
            }
}

fun <T> Observable<T>.withLoading(activity: Activity) = compose {
    it
            .doOnSubscribe {
                net.idik.lessme.utils.T.loading(activity)
            }
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate {
                net.idik.lessme.utils.T.dismissHub()
            }
}

fun <T> Observable<T>.toastOnError(activity: Activity) = compose {
    it.observeOn(AndroidSchedulers.mainThread()).
            doOnError { ex ->
                net.idik.lessme.utils.T.error(activity, ex)
            }
}

fun <T> Observable<T>.subscribeOnUi(): Observable<T> = subscribeOn(AndroidSchedulers.mainThread())
fun <T> Observable<T>.subscribeOnIo(): Observable<T> = subscribeOn(Schedulers.io())
fun <T> Observable<T>.subscribeOnComputation(): Observable<T> = subscribeOn(Schedulers.computation())

fun <T> Observable<T>.ui(): Observable<T> = observeOn(AndroidSchedulers.mainThread())
fun <T> Observable<T>.io(): Observable<T> = observeOn(Schedulers.io())
fun <T> Observable<T>.computation(): Observable<T> = observeOn(Schedulers.computation())
