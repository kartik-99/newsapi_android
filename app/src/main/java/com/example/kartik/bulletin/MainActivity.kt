package com.example.kartik.bulletin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavSwitchController
import com.ncapdevi.fragnav.FragNavTransactionOptions
import com.ncapdevi.fragnav.tabhistory.FragNavTabHistoryController
import kotlinx.android.synthetic.main.activity_main.*
import com.roughike.bottombar.BottomBar


const val INDEX_FEED = FragNavController.TAB1
const val INDEX_CHANNELS = FragNavController.TAB2
const val INDEX_BOOKMARKS = FragNavController.TAB3
const val INDEX_SEARCH = FragNavController.TAB4
class MainActivity : AppCompatActivity(), FragNavController.TransactionListener, FragNavController.RootFragmentListener, BaseFragment.FragmentNavigation{


    var fragNavController:FragNavController? = null
    //var mNavController:Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var builder = FragNavController.newBuilder(savedInstanceState, supportFragmentManager, R.id.containerView)



        builder.rootFragmentListener(this, 4)
        fragNavController = builder.build()

        bottomBar.setOnTabSelectListener({ tabId ->
            when (tabId) {
                R.id.navigation_feed -> fragNavController?.switchTab(INDEX_FEED)
                R.id.navigation_channels -> fragNavController?.switchTab(INDEX_CHANNELS)
                R.id.navigation_bookmarks -> fragNavController?.switchTab(INDEX_BOOKMARKS)
                R.id.navigation_search -> fragNavController?.switchTab(INDEX_SEARCH)
            }
        })



    }

    override fun onFragmentTransaction(p0: Fragment?, p1: FragNavController.TransactionType?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (fragNavController!=null){
            fragNavController?.onSaveInstanceState(outState!!)
        }
    }

    override fun onTabTransaction(p0: Fragment?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRootFragment(index: Int): Fragment {
        when(index){
            INDEX_FEED -> return FeedFragment.newInstance(0)
            INDEX_CHANNELS  -> return ChannelsFragment.newInstance(0)
            INDEX_BOOKMARKS -> return BookmarkFragment.newInstance(0)
            INDEX_SEARCH -> return SearchFragment.newInstance(0)
        }
        throw IllegalStateException("Invalid tab index")
    }


    override fun pushFragment(fragment: Fragment) {
        fragNavController?.pushFragment(fragment)
    }

}
