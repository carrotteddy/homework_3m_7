package com.example.homework_3m_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_3m_7.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit  var binding: FragmentMainBinding
    private  var personArrayList: ArrayList<Person> = ArrayList()
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val recyclerView: RecyclerView = binding.rvPersons
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        navController = NavHostFragment.findNavController(this)
        val adapter = PersonListAdapter(personArrayList, navController)
        recyclerView.adapter = adapter
    }

    private fun loadData(){
        personArrayList.clear()
        val person = Person("Rick","Alive","https://w7.pngwing.com/pngs/438/395/png-transparent-rick-and-morty-illustration-rick-sanchez-morty-smith-television-show-rick-and-morty-season-3-rick-and-morty-television-angle-mammal.png" )
        personArrayList.add(person)
        personArrayList.add(Person("Morty", "ALive", "https://i.ytimg.com/vi/oR-UB8z6ChE/maxresdefault.jpg"))
        personArrayList.add(Person("Jerry Smith", "ALive", "https://i.imgur.com/7o5w2lx.png"))
        personArrayList.add(Person("Albert Einstein", "Dead", "https://assets.audiomack.com/mixaels/3aa54aa86a3070c9d716cb2f535afb2908ef9d96ebf0256cb0fe37afd68c72b7.jpeg"))

    }

}