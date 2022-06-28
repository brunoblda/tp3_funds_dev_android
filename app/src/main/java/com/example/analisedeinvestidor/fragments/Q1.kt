package com.example.analisedeinvestidor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.analisedeinvestidor.R
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.analisedeinvestidor.databinding.FragmentQ1Binding
import com.example.analisedeinvestidor.punctuation
import com.example.analisedeinvestidor.q1

/**
 * A simple [Fragment] subclass.
 * Use the [Q1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Q1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentQ1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ1Binding.inflate(inflater, container, false)

        val fragment1 = binding.root

        binding.nextButton.setOnClickListener {
            val points = select()

            punctuation += points
            if (points >= 0) {
                q1 = points

                Navigation.findNavController(fragment1)
                    .navigate(R.id.action_q1_to_q2)
            }
        }
        return fragment1
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup1.checkedRadioButtonId) {
            binding.q1a.id -> 0
            binding.q1b.id -> 2
            binding.q1c.id -> 3
            binding.q1d.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}