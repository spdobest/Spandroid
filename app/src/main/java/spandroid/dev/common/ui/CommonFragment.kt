package spandroid.dev.common.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

import spandroid.dev.R
import spandroid.dev.base.java.base_adapter.UsersAdapter
import spandroid.dev.base.java.base_adapter.listeners.OnRecyclerObjectClickListener
import spandroid.dev.base.java.base_adapter.model.UserModelForAdapter
import spandroid.dev.kotlin.base.BaseKotlinFragment

import kotlinx.android.synthetic.main.fragment_common.*

class CommonFragment : BaseKotlinFragment() {



    val listUser = ArrayList<UserModelForAdapter>()



    override fun initializeResources() {


    }

    override fun setListeners() {
    }

    override fun getToolBarTitle(): String {
        return "Sibaprasad"
    }

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        var fragmentView:View = inflater.inflate(R.layout.fragment_common, container, false)

        var recyclerviewCommon: RecyclerView = fragmentView.findViewById(R.id.recyclerviewCommon)


        // setLayout(R.layout.fragment_common)

        for ( i in 1..20){
            listUser.add(UserModelForAdapter("name ${i}", "https://homepages.cae.wisc.edu/~ece533/images/monarch.png", ""))
        }

        var adapter = UsersAdapter(activity)
        //  adapter.setListener(this);
        recyclerviewCommon.setAdapter(adapter);
        recyclerviewCommon.setLayoutManager( LinearLayoutManager(getActivity()));

        adapter.items = listUser



        return fragmentView//super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        fun newInstance(param1: String): CommonFragment {
            val fragment = CommonFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
