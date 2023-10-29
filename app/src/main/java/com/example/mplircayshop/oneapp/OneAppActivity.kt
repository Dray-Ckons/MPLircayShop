package com.example.mplircayshop.oneapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.mplircayshop.R
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.oneapp.adapter.ProductosAdapter
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView


class OneAppActivity : AppCompatActivity() {



    lateinit var navegation : BottomNavigationView
    private val mOnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener{ item ->

        when(item.itemId){

            R.id.itemFragment1 ->{
                supportFragmentManager.commit{
                    replace<PrimerFragment>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack( "replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.itemFragment2 ->{
                supportFragmentManager.commit{
                    replace<SegundoFragment>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack( "replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.itemFragment3 ->{
                supportFragmentManager.commit{
                    replace<TercerFragment>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack( "replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.itemFragment4 ->{
                supportFragmentManager.commit{
                    replace<CuartoFragment>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack( "replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

        }
        false

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_app)
        //initRecycleView()


        navegation = findViewById(R.id.navMenu)
        navegation.setOnNavigationItemSelectedListener (mOnNavMenu)


        supportFragmentManager.commit {

            replace<PrimerFragment>(R.id.frameContainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")

        }


    }




}





