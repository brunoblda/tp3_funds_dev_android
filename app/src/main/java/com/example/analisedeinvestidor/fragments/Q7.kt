package com.example.analisedeinvestidor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.analisedeinvestidor.R
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.analisedeinvestidor.databinding.FragmentQ7Binding
import com.example.analisedeinvestidor.punctuation
import com.example.analisedeinvestidor.q7


/**
 * A simple [Fragment] subclass.
 * Use the [Q7.newInstance] factory method to
 * create an instance of this fragment.
 */
class Q7 : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentQ7Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ7Binding.inflate(inflater, container, false)

        val fragment7 = binding.root

        binding.nextButton7.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q7 = points

                Navigation.findNavController(fragment7)
                    .navigate(R.id.action_q7_to_q10)
            }
        }
        return fragment7
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup7.checkedRadioButtonId) {
            binding.q7a.id -> 0
            binding.q7b.id -> 2
            binding.q7c.id -> 3
            binding.q7d.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}