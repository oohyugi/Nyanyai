package com.oohyugi.nyanyai

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.oohyugi.nyanyai.helper.FragmentHelper
import com.oohyugi.nyanyai.helper.PrefHelper
import com.oohyugi.nyanyai.utils.BottomNavigationHelper
import com.oohyugi.nyanyai.view.calendar.CalendarFragment
import com.oohyugi.nyanyai.view.create.CreateFragment
import com.oohyugi.nyanyai.view.find.FindFragment
import com.oohyugi.nyanyai.view.login.LoginActivity
import com.oohyugi.nyanyai.view.wishlist.WishListFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {


    private var mSelectedItem = 0
    private val SELECTED_ITEM = "selected_item"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        BottomNavigationHelper().disableShiftMode(navigation)
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        initBottomNavigasi(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SELECTED_ITEM, mSelectedItem)
        Log.e("onSaveInstanceState: ", mSelectedItem.toString())
        super.onSaveInstanceState(outState)
    }
    private fun initBottomNavigasi(savedInstanceState: Bundle?) {
        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            selectedFragment(item)

            true
        })

        val selectedItem: MenuItem

        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0)
            selectedItem = navigation.getMenu().findItem(mSelectedItem)


        } else {
            selectedItem = navigation.getMenu().getItem(0)
        }
        selectedFragment(selectedItem)
    }

    private fun selectedFragment(item: MenuItem) {
        var fragment : Fragment? = null
        when (item.itemId){
            R.id.navFind->{
                fragment = FindFragment.newsInstance()
                supportActionBar!!.title = "Find"
            }
            R.id.navWishlist->{
                fragment = WishListFragment.newsInstance()
                supportActionBar!!.title = "Wishlist"
            }
            R.id.navCalander->{
                fragment = CalendarFragment.newsInstance()
                supportActionBar!!.title = "Calendar"
            }
            R.id.navCreate->{
                fragment = CreateFragment.newsInstance()
                supportActionBar!!.title = "Create"
            }
            R.id.navLogout->{
                showDialogLogout()
            }





        }
        mSelectedItem = item.itemId
        if (fragment!=null){
            FragmentHelper.replaceFragment(this,fragment,R.id.container)
        }


    }

    private fun showDialogLogout() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Logout")
        dialog.setMessage("Are you sure for logout?")
        dialog.setPositiveButton("Sure") { p0, p1 ->
            PrefHelper.saveLoggedUser(this@MainActivity,null)
            p0!!.dismiss()
            LoginActivity.startThisActivity(this)
        }
        dialog.setNegativeButton("Cancel") { p0, p1 ->
            p0!!.dismiss()
        }

        dialog.show()
    }

    companion object {
        fun startThisActivity(context: Context){
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

}
