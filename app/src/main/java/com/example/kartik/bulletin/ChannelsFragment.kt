package com.example.kartik.bulletin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.disposables.Disposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx


class ChannelsFragment : Fragment() {
    var disposable:Disposable?= null
    var recyclerView : RecyclerView? = null

    private var newsApiService = NewsApiService.create()
    var sourceData :Model.SourceData?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{
        var view = ChannelsFragment_UI<Fragment>().createView(AnkoContext.create(ctx, this))

        recyclerView = view.rootView.findViewById(R.id.recyclerview_all_sources)

        getSourceList()



        return view
    }

    private fun getSourceList() {
        val res = resources
        var apiKey = res.getString(R.string.apiKey)
        disposable = newsApiService.getSources("", apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {data: Model.SourceData? ->
                            sourceData = data
                            recyclerView?.adapter = SourceAdapter(sourceData!!.sources)
                            recyclerView?.layoutManager = LinearLayoutManager(ctx)})


    }

    private fun setView(){}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    companion object {
        fun newInstance(instance:Int):ChannelsFragment{
            var args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = ChannelsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
