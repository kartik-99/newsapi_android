package com.example.kartik.bulletin.Bookmarks


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kartik.bulletin.BaseFragment
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx

class BookmarkFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View
            = BookmarkFragmentUI<Fragment>().createView(AnkoContext.create(ctx, this))


    companion object {
        fun newInstance(instance:Int): BookmarkFragment {
            var args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = BookmarkFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
