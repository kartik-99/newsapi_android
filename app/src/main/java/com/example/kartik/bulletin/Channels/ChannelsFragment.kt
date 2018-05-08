package com.example.kartik.bulletin.Channels


import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kartik.bulletin.BaseFragment
import com.example.kartik.bulletin.Model
import com.example.kartik.bulletin.NewsApiService
import com.example.kartik.bulletin.R
import io.reactivex.disposables.Disposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh

class ChannelsFragment : Fragment() {
    var apiDisposable:Disposable?= null
    var dataDisposable:Disposable?= null
    var recyclerView : RecyclerView? = null

    private var newsApiService = NewsApiService.create()
    private var db = AppDatabase.getInstance(ctx)
    var sourceData : Model.SourceData?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{
        var view = ChannelsFragment_UI<Fragment>().createView(AnkoContext.create(ctx, this))
        recyclerView = view.rootView.find(R.id.recyclerview_all_sources)
        var swipeLayout : SwipeRefreshLayout = view.rootView.find(R.id.swipe_layout)
        swipeLayout.onRefresh {
            Handler().postDelayed(Runnable { swipeLayout.isRefreshing = false }, 5000)
        }




        getSourcesFromDb()



        return view
    }

    private fun getSourcesFromDb(){
    }

    private fun getSourcesFromApi() {
        val res = resources
        var apiKey = res.getString(R.string.apiKey)
        apiDisposable = newsApiService.getSources("", apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {data: Model.SourceData? ->
                            sourceData = data
                            recyclerView?.adapter = SourceAdapter(sourceData!!.sources)
                            recyclerView?.layoutManager = LinearLayoutManager(ctx)})


    }


    companion object {
        fun newInstance(instance:Int): ChannelsFragment {
            var args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = ChannelsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
