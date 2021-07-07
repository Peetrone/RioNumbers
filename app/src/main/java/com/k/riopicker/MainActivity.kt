package com.k.riopicker

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import kotlin.math.abs

class MainActivity : AppCompatActivity(), OnSnapPositionChangeListener  {

    private lateinit var behavior: SnapOnScrollListener.Behavior
    private lateinit var resultCode1: TextView
    private lateinit var resultCode2: TextView
    private lateinit var resultCode3: TextView
    private lateinit var resultCode4: TextView
    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var recyclerView4: RecyclerView
    private lateinit var linearLayoutManager1: LinearLayoutManager
    private lateinit var linearLayoutManager2: LinearLayoutManager
    private lateinit var linearLayoutManager3: LinearLayoutManager
    private lateinit var linearLayoutManager4: LinearLayoutManager
    private val numberItem = ArrayList<NumberItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        resultCode1 = findViewById(R.id.result_code_1)
        resultCode2 = findViewById(R.id.result_code_2)
        resultCode3 = findViewById(R.id.result_code_3)
        resultCode4 = findViewById(R.id.result_code_4)

        recyclerView1 = findViewById(R.id.recycler_view_1)
        recyclerView2 = findViewById(R.id.recycler_view_2)
        recyclerView3 = findViewById(R.id.recycler_view_3)
        recyclerView4 = findViewById(R.id.recycler_view_4)

        linearLayoutManager1 = LinearLayoutManager(this)
        linearLayoutManager2 = LinearLayoutManager(this)
        linearLayoutManager3 = LinearLayoutManager(this)
        linearLayoutManager4 = LinearLayoutManager(this)

        recyclerView1.layoutManager = linearLayoutManager1
        recyclerView2.layoutManager = linearLayoutManager2
        recyclerView3.layoutManager = linearLayoutManager3
        recyclerView4.layoutManager = linearLayoutManager4

        //20 x set (0-9) = 200 numbers
        val multiple = 20
        // (100 numbers down, 100 numbers up) start position 100
        val startPosition = (multiple * 10 / 2) - 1

        //creating adapters
        val adapter1 = RecyclerViewAdapter(newDataSet(multiple))
        val adapter2 = RecyclerViewAdapter(newDataSet(multiple))
        val adapter3 = RecyclerViewAdapter(newDataSet(multiple))
        val adapter4 = RecyclerViewAdapter(newDataSet(multiple))

        //now adding the adapters to recyclerviews
        recyclerView1.adapter = adapter1
        recyclerView2.adapter = adapter2
        recyclerView3.adapter = adapter3
        recyclerView4.adapter = adapter4

        linearLayoutManager1.scrollToPositionWithOffset(startPosition, 0)
        linearLayoutManager2.scrollToPositionWithOffset(startPosition, 0)
        linearLayoutManager3.scrollToPositionWithOffset(startPosition, 0)
        linearLayoutManager4.scrollToPositionWithOffset(startPosition, 0)

        val snapHelper1: SnapHelper = LinearSnapHelper()
        val snapHelper2: SnapHelper = LinearSnapHelper()
        val snapHelper3: SnapHelper = LinearSnapHelper()
        val snapHelper4: SnapHelper = LinearSnapHelper()

        //snapHelpers
        snapHelper1.attachToRecyclerView(recyclerView1)
        snapHelper2.attachToRecyclerView(recyclerView2)
        snapHelper3.attachToRecyclerView(recyclerView3)
        snapHelper4.attachToRecyclerView(recyclerView4)

        behavior = SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL

        //listeners
        recyclerView1.attachSnapHelperWithListener(snapHelper1, behavior, this)
        recyclerView2.attachSnapHelperWithListener(snapHelper2, behavior, this)
        recyclerView3.attachSnapHelperWithListener(snapHelper3, behavior, this)
        recyclerView4.attachSnapHelperWithListener(snapHelper4, behavior, this)

    }

    /**
     * create set 0-9
     */
    private fun createOneSet(): ArrayList<NumberItem> {
        val oneSet = ArrayList<NumberItem>()
        for (j in 0 until 10) {
            numberItem.add(NumberItem(j))
        }
        return oneSet
    }

    /**
     * multiple set(0-9) for one adapter
     */
    private fun newDataSet(multiple: Int): ArrayList<NumberItem> {
        for (j in 0 until multiple) {
            createOneSet()
        }
        return numberItem
    }

    override fun onSnapPositionChange1(position: Int) {
        resultCode1.text = (abs(position) % 10).toString()
    }

    override fun onSnapPositionChange2(position: Int) {
        resultCode2.text = (abs(position) % 10).toString()
    }

    override fun onSnapPositionChange3(position: Int) {
        resultCode3.text = (abs(position) % 10).toString()
    }

    override fun onSnapPositionChange4(position: Int) {
        resultCode4.text = (abs(position) % 10).toString()
    }


}