package com.example.kartik.bulletin.Search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.*
import com.example.kartik.bulletin.article.ArticleAdapter
import com.example.kartik.bulletin.BaseFragment
import com.example.kartik.bulletin.R
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.api.NewsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.ctx

class SearchFragment : Fragment() {

    var resultsRV : RecyclerView? = null
    var searchDisposable:Disposable? = null
    var searchData:Model.ArticleData? = null
    var newsApiService = NewsApiService.create()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = SearchFragmentUI<Fragment>().createView(AnkoContext.Companion.create(ctx, this))
        val searchView = view.rootView.find<SearchView>(R.id.searchview)
        searchView.isIconified = false
        searchView.queryHint = "Search here"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                performSearch(query)
                return false
            }

        })


        searchView.performClick()
        searchView.requestFocus()

        resultsRV = view.rootView.find(R.id.search_results_rv)
        return view
    }

    private fun performSearch(query:String) {
        val res = resources
        var apiKey = res.getString(R.string.apiKey)
        searchDisposable = newsApiService.getSearchResult(query, apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ data:Model.ArticleData? ->
                    searchData = data
                    resultsRV?.adapter = ArticleAdapter(searchData!!.articles, ctx)
                    resultsRV?.layoutManager = LinearLayoutManager(context)
                })
    }


    companion object {
        fun newInstance(instance:Int): SearchFragment {
            var args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = SearchFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
