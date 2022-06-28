package com.example.analisedeinvestidor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.analisedeinvestidor.R
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.analisedeinvestidor.databinding.FragmentQ4Binding
import com.example.analisedeinvestidor.punctuation
import com.example.analisedeinvestidor.q4


/**
 * A simple [Fragment] subclass.
 * Use the [Q4.newInstance] factory method to
 * create an instance of this fragment.
 */
class Q4 : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentQ4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ4Binding.inflate(inflater, container, false)

        val fragment4 = binding.root

        binding.nextButton4.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q4 = points

                Navigation.findNavController(fragment4)
                    .navigate(R.id.action_q4_to_q5)
            }
        }
        return fragment4
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup4.checkedRadioButtonId) {
            binding.q4a.id -> 0
            binding.q4b.id -> 2
            binding.q4c.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}