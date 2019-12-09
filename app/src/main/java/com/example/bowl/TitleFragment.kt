
package com.example.bowl

import androidx.navigation.findNavController


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.bowl.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
           R.layout.fragment_title,container,false)

        binding.enter_button.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_titleFragment2_to_movieFragment)
        }
        return binding.root
    }


}
