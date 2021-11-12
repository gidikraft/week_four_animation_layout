package com.example.weekfouranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
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
// call function to initiate homeFragment as welcome page
        replaceFragment(homeFragment)
//setOnClickListener to call home button when clicked
        val home = findViewById<BottomNavigationItemView>(R.id.home)
        home.setOnClickListener{
            replaceFragment(homeFragment)
        }
//setOnClickListener to call people button when clicked
        val people = findViewById<BottomNavigationItemView>(R.id.people)
        people.setOnClickListener{
            replaceFragment(peopleFragment)
        }
//setOnClickListener to call gift button when clicked
        val gift = findViewById<BottomNavigationItemView>(R.id.gift)
        gift.setOnClickListener{
            replaceFragment(giftFragment)
        }
    }
//function to replace fragment
    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}