package com.example.analisedeinvestidor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.analisedeinvestidor.R
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.analisedeinvestidor.databinding.FragmentQ3Binding
import com.example.analisedeinvestidor.punctuation
import com.example.analisedeinvestidor.q3


/**
 * A simple [Fragment] subclass.
 * Use the [Q3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Q3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentQ3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ3Binding.inflate(inflater, container, false)

        val fragment3 = binding.root

        binding.nextButton3.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q3 = points

                Navigation.findNavController(fragment3)
                    .navigate(R.id.action_q3_to_q4)
            }
        }
        return fragment3
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup3.checkedRadioButtonId) {
            binding.q3a.id -> 0
            binding.q3b.id -> 1
            binding.q3c.id -> 2
            binding.q3d.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}