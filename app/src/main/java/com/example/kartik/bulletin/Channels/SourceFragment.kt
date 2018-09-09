package com.example.kartik.bulletin.Channels


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kartik.bulletin.BaseFragment
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.R
import com.example.kartik.bulletin.data.BulletinDb
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh

class SourceFragment : Fragment() {

    var recyclerView : RecyclerView? = null
    var db : BulletinDb? = null
    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this).get(SourceViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{

        db = BulletinDb.get(ctx)
        val view = SourceFragment_UI<Fragment>().createView(AnkoContext.create(ctx, this))
        val adapter = SourceAdapter(arrayListOf())

        recyclerView = view.rootView.find(R.id.recyclerview_all_sources)
        recyclerView!!.layoutManager = LinearLayoutManager(ctx)
        recyclerView!!.adapter = adapter

        viewModel.getSources().observe(this, Observer {
            sources -> adapter.updateSources(sources as ArrayList<Model.Source>)
        })

        val swipeLayout : SwipeRefreshLayout = view.rootView.find(R.id.swipe_layout)
        swipeLayout.onRefresh {
            swipeLayout.isRefreshing = true
            viewModel.updateSourcesTable()
            swipeLayout.isRefreshing = false
        }
        return view
    }

    companion object {
        fun newInstance(instance:Int): SourceFragment {
            var args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = SourceFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
