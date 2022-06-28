package com.example.analisedeinvestidor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.analisedeinvestidor.R
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.analisedeinvestidor.databinding.FragmentQ10Binding
import com.example.analisedeinvestidor.punctuation
import com.example.analisedeinvestidor.q1

/**
 * A simple [Fragment] subclass.
 * Use the [Q10.newInstance] factory method to
 * create an instance of this fragment.
 */
class Q10 : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentQ10Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ10Binding.inflate(inflater, container, false)

        val fragment10 = binding.root

        binding.nextButton10.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q1 = points

                Navigation.findNavController(fragment10)
                    .navigate(R.id.action_q10_to_q11)
            }
        }
        return fragment10
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup10.checkedRadioButtonId) {
            binding.q10a.id -> 0
            binding.q10b.id -> 1
            binding.q10c.id -> 2
            binding.q10d.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}