package com.example.analisedeinvestidor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.analisedeinvestidor.R
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.analisedeinvestidor.databinding.FragmentQ5Binding
import com.example.analisedeinvestidor.punctuation
import com.example.analisedeinvestidor.q5




/**
 * A simple [Fragment] subclass.
 * Use the [Q5.newInstance] factory method to
 * create an instance of this fragment.
 */
class Q5 : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentQ5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ5Binding.inflate(inflater, container, false)

        val fragment5 = binding.root

        binding.nextButton5.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q5 = points

                Navigation.findNavController(fragment5)
                    .navigate(R.id.action_q5_to_q6)
            }
        }
        return fragment5
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup5.checkedRadioButtonId) {
            binding.q5a.id -> 0
            binding.q5b.id -> 2
            binding.q5c.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}