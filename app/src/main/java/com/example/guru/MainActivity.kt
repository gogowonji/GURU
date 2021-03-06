package com.example.guru

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    private val fragmentManager: FragmentManager = supportFragmentManager

    // 4개의 메뉴에 들어갈 Fragment들
    private val menu1Fragment: Fragment1 = Fragment1()
    private val menu2Fragment: Fragment2 = Fragment2()
    private val menu3Fragment: Fragment3 = Fragment3()
    private val menu4Fragment: Fragment4 = Fragment4()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_login_start_view)
//        // login 완료시 R.layout.activity_main 으로 넘어가기

        setContentView(R.layout.activity_main) //setContentview 실행시 가장 먼저 나오는 화면


        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottom_navi)
        // 첫 화면 지정
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss()

        // bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            when (item.itemId) {
                R.id.todo  -> {
                    transaction.replace(R.id.frame_layout, menu1Fragment)
                        .commitAllowingStateLoss()
                }
                R.id.timer -> {
                    transaction.replace(R.id.frame_layout, menu2Fragment)
                        .commitAllowingStateLoss()
                }
                R.id.diary -> {
                    transaction.replace(R.id.frame_layout, menu3Fragment)
                        .commitAllowingStateLoss()
                }
                R.id.dday -> {
                    transaction.replace(R.id.frame_layout, menu4Fragment)
                        .commitAllowingStateLoss()
                }
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.logout, menu)
        return true
    }
}




