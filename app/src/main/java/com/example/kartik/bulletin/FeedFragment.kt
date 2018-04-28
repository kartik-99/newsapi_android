package com.example.kartik.bulletin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx

class FeedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View
            = FeedFragment_UI<Fragment>().createView(AnkoContext.create(ctx, this))

    companion object {
        fun newInstance(instance:Int):FeedFragment{
            var args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = FeedFragment()
            fragment.arguments = args
            return fragment
        }
    }


}
