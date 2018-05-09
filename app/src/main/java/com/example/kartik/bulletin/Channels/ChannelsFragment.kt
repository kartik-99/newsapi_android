package com.example.kartik.bulletin.Channels


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
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.api.NewsApiService
import com.example.kartik.bulletin.R
import com.example.kartik.bulletin.architecture.AviewModel
import com.example.kartik.bulletin.architecture.ViewModelFactory
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

    private lateinit var viewModelFactory : ViewModelFactory
    private lateinit var viewModel : AviewModel

    private var newsApiService = NewsApiService.create()

    var sourceData : Model.SourceData?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{
        var view = ChannelsFragment_UI<Fragment>().createView(AnkoContext.create(ctx, this))

        recyclerView = view.rootView.find(R.id.recyclerview_all_sources)
        var swipeLayout : SwipeRefreshLayout = view.rootView.find(R.id.swipe_layout)
        swipeLayout.onRefresh {
            Handler().postDelayed(Runnable { swipeLayout.isRefreshing = false }, 5000)
        }

        /*db injection code
        viewModelFactory = Injection.provideViewModelFactory(ctx)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AviewModel::class.java)
        getSourcesFromDb()*/

        //filling rv with api data
        getSourcesFromApi()
        return view
    }

    private fun getSourcesFromDb(){
        dataDisposable = viewModel.getSources()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
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

    override fun onStop() {
        super.onStop()
        dataDisposable?.dispose()
        apiDisposable?.dispose()
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
