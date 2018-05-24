package spandroid.dev.base.kotlin

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.content_base.*
import spandroid.dev.R
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.Gravity
import spandroid.dev.common.FragmentUtilsMain
import spandroid.dev.common.ui.CommonFragment


/**
 * Created by root on 5/18/18.
 */
abstract class KotlinBaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var fragmentPopped = false
    var manager = supportFragmentManager
    var ft = manager.beginTransaction()

    lateinit var fragment: Fragment

    companion object {
        public val TAG = "KotlinBaseActivity"
    }

    private var mDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)

        menuSelectedListener()

    }

    protected fun setLayout(layoutId: Int) {
        layoutInflater.inflate(layoutId, layout_container)

    }

    protected fun setHomeUpIndicator() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        if (supportActionBar != null)
            supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    protected fun setHomeUpIndicator(colorId: Int) {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, colorId))
        if (supportActionBar != null)
            supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    protected fun setHomeUpButtonColor(colorId: Int) {
        //  final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        //        if (getSupportActionBar() != null)
        //            getSupportActionBar().setHomeAsUpIndicator(ImageUtil.changeTintColor(this, upArrow, colorId));
    }


    protected fun initDrawer() {
        /*getSupportActionBar().setTitle("");*/


        // mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        initDrawerToggle()
    }

    protected fun lockDrawer() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    protected fun closeDrawer() {
        drawer_layout.closeDrawer(Gravity.LEFT)
    }


    private fun initDrawerToggle() {
        val mDrawerToggle = object : ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.app_name,
                R.string.abc_action_bar_home_description) {

            /** Called when a drawer has settled in a completely closed state.  */
            /* fun onDrawerClosed(view: View?) {
                 super.onDrawerClosed(view)


             }*/

            /** Called when a drawer has settled in a completely open state.  */
            /* override fun onDrawerOpened(drawerView: View?) {
                 super.onDrawerOpened(drawerView)
             }*/
        }
        drawer_layout.addDrawerListener(mDrawerToggle)
        if (supportActionBar != null)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        mDrawerToggle.syncState()
    }


    private fun menuSelectedListener() {
        navigation_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        fragmentPopped = false

        when (item.itemId) {

            R.id.action_menfassion -> {
                closeDrawer()
                supportFragmentManager.beginTransaction().add(R.id.layout_container, HomeKotlinFragment.newInstance(item!!.title.toString()), "HomeKotlinFragment").commit()
                showSnackbarMessage("Men clicked")
                return true
            }

            R.id.action_womenfassion -> {
                closeDrawer()
                supportFragmentManager.beginTransaction().add(R.id.layout_container, HomeKotlinFragment.newInstance(item!!.title.toString()), "HomeKotlinFragment").commit()
                showSnackbarMessage("Women clicked")
                return true
            }

            R.id.action_electronics -> {
                closeDrawer()
                supportFragmentManager.beginTransaction().add(R.id.layout_container, HomeKotlinFragment.newInstance(item!!.title.toString()), "HomeKotlinFragment").commit()
                showSnackbarMessage("Electronics clicked")
                return true
            }

            R.id.action_mobile -> {
                closeDrawer()
                supportFragmentManager.beginTransaction().add(R.id.layout_container, HomeKotlinFragment.newInstance(item!!.title.toString()), "HomeKotlinFragment").commit()
                showSnackbarMessage("Mobile clicked")
                return true
            }

            R.id.action_computers -> {
                closeDrawer()
                supportFragmentManager.beginTransaction()
                        .add(R.id.layout_container,
                                HomeKotlinFragment.newInstance(item!!.title.toString()),
                                HomeKotlinFragment.TAG)
                        .addToBackStack(null)
                        .commit()
                showSnackbarMessage("Computer clicked")
                return true
            }

            R.id.action_setting -> {
                closeDrawer()

                fragment = KotlinSettingFragmet.newInstance(item!!.title.toString())

                /*supportFragmentManager.beginTransaction()
                        .add(R.id.layout_container,
                                KotlinSettingFragmet.newInstance(item!!.title.toString()),
                                KotlinSettingFragmet.TAG)
                        .addToBackStack(null)
                        .commit()*/
                showSnackbarMessage("Setting clicked")
                return true
            }
            R.id.action_share -> {
                closeDrawer()

                fragment = HomeKotlinFragment.newInstance(item!!.title.toString())

                /*supportFragmentManager.beginTransaction()
                        .add(R.id.layout_container,
                                HomeKotlinFragment.newInstance(item!!.title.toString()),
                                "HomeKotlinFragment")
                        .addToBackStack(null)
                        .commit()*/
                showSnackbarMessage("Share clicked")
                return true
            }
            R.id.action_rateus -> {
                closeDrawer()
                supportFragmentManager.beginTransaction()
                        .add(R.id.layout_container,
                                CommonFragment.newInstance(item!!.title.toString()),
                                "HomeKotlinFragment")
                        .addToBackStack(null)
                        .commit()
                showSnackbarMessage("Rateus clicked")
                return true
            }
            R.id.action_logout -> {
                closeDrawer()
                showSnackbarMessage("logoput clicked")
                supportFragmentManager.beginTransaction()
                        .add(R.id.layout_container,
                                HomeKotlinFragment.newInstance(item!!.title.toString()),
                                "HomeKotlinFragment")
                        .addToBackStack(null)
                        .commit()
                return true
            }

            else -> {
                closeDrawer()
                return false
            }
        }

        addFragments(fragment)

    }

    fun addFragments(fragment: Fragment) {
        var backStateName = fragment.javaClass.getName()

        fragmentPopped = manager.popBackStackImmediate(backStateName, 0)
        if (!fragmentPopped) {
            ft.replace(R.id.layout_container, fragment)
        }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ft.addToBackStack(backStateName)
        ft.commit()
    }

    public fun showSnackbarMessage(message: String, lenth: Int = Snackbar.LENGTH_SHORT) {
        val snackbar = Snackbar
                .make(coordinator_layout, message, lenth)
        snackbar.show()
    }
}