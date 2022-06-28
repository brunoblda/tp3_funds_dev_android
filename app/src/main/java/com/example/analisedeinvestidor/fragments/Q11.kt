package com.example.analisedeinvestidor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.analisedeinvestidor.R
import android.content.Intent
import android.widget.Toast
import com.example.analisedeinvestidor.ResultActivity
import com.example.analisedeinvestidor.databinding.FragmentQ11Binding
import com.example.analisedeinvestidor.punctuation
import com.example.analisedeinvestidor.q11


/**
 * A simple [Fragment] subclass.
 * Use the [Q11.newInstance] factory method to
 * create an instance of this fragment.
 */
class Q11 : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentQ11Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ11Binding.inflate(inflater, container, false)

        val fragment11 = binding.root

        binding.nextButton11.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q11 = points

                val showIntent = Intent(requireContext(), ResultActivity::class.java)
                startActivity(showIntent)
            }
        }

        return fragment11
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup11.checkedRadioButtonId) {
            R.id.q11a -> 0
            R.id.q11b -> 1
            R.id.q11c -> 2
            R.id.q11d -> 4
            R.id.q11e -> 5
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}