package com.example.weekfouranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import fragments.GiftFragment
import fragments.HomeFragment
import fragments.PeopleFragment

class MainActivity : AppCompatActivity() {

    private var homeFragment = HomeFragment()
    private var peopleFragment = PeopleFragment()
    private var giftFragment = GiftFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(homeFragment)

        var home = findViewById<BottomNavigationItemView>(R.id.home)
        home.setOnClickListener{
            replaceFragment(homeFragment)
        }

        var people = findViewById<BottomNavigationItemView>(R.id.people)
        people.setOnClickListener{
            replaceFragment(peopleFragment)
        }

        var gift = findViewById<BottomNavigationItemView>(R.id.gift)
        gift.setOnClickListener{
            replaceFragment(giftFragment)
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}