package com.example.strongheart.kedditapp.commons

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable


open class RxBaseFragment : Fragment() {

    protected var disposables = CompositeDisposable()

    override fun onPause() {
        super.onPause()
        disposables.clear() //clear will clear all, but can accept new disposable.
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
        //dispose will clear all and set isDisposed = true, so it will not accept any new disposable
    }
}