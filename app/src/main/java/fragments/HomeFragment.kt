package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.weekfouranimation.Model
import com.example.weekfouranimation.MyRecyclerViewAdapter
import com.example.weekfouranimation.R
import com.example.weekfouranimation.ViewPagerAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_home, container, false)
        // An array of images to be passed into the viewPager
        val images = listOf<Int>(
            R.drawable.victor,
            R.drawable.images5,
            R.drawable.images6,
            R.drawable.images7
        )
        //To connect the ViewPagerAdapter to the images it is to inflate into the view adapter
        val adapter = ViewPagerAdapter(images)
        view.findViewById<ViewPager2>(R.id.view_pager).adapter = adapter

        //viewPager animation
        var viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = ViewPagerAdapter(images)
        viewPager.setPadding(80, 0, 80, 0)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
        //setting viewpager transformation
        val viewPageTransformer = CompositePageTransformer()
        viewPageTransformer.addTransformer(MarginPageTransformer(45))
        viewPageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        viewPager.setPageTransformer(viewPageTransformer)

        //MyRecyclerViewAdapter
        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Seun Android", "11.12.2021", "2 days to go", R.drawable.vector1))
        arrayList.add(Model("Akeem Android", "12.09.2021", "3 days to go", R.drawable.vector2))
        arrayList.add(Model("Miracle Android", "30.06.2021", "4 days to go", R.drawable.vector3))
        arrayList.add(Model("Shak Android", "28.02.2021", "5 days to go", R.drawable.vector4))
//        arrayList.add(Model("Dubem Android", "15.06.2021", "6 days to go", R.drawable.image5 ))

        val myAdapter = this.context?.let { MyRecyclerViewAdapter (arrayList, it) }


        view.findViewById<RecyclerView>(R.id.recyclerview).layoutManager = LinearLayoutManager(this.context)
        view.findViewById<RecyclerView>(R.id.recyclerview).adapter = myAdapter

        return view
    }

}