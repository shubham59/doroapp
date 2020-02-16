package onkar.com.duraapp.activites

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import onkar.com.duraapp.fragments.AdoptFragment
import onkar.com.duraapp.fragments.HomeFragment
import onkar.com.duraapp.fragments.PostsFragment
import onkar.com.duraapp.R

class HomeActivity : AppCompatActivity(), HomeFragment.OnHomeFragmentInteraction {
    override fun onAdoptClick() {
        navigation.selectedItemId = R.id.navigation_dashboard
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment.newInstance()).commitAllowingStateLoss()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, AdoptFragment.newInstance()).commitAllowingStateLoss()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, PostsFragment.newInstance()).commitAllowingStateLoss()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home
    }
}
