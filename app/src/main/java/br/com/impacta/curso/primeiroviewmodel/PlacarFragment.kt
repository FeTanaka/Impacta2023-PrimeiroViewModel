package br.com.impacta.curso.primeiroviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.impacta.curso.primeiroviewmodel.databinding.FragmentPlacarBinding


class PlacarFragment : Fragment() {

    private var _binding: FragmentPlacarBinding? = null
    private val binding get() = _binding!!

    private val primeiroViewModel: PrimeiroViewModel by viewModels()

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentPlacarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val observadorTimeCasa = Observer<Int> { pontos -> binding.placarTimeCasaTextView.text = pontos.toString() }
        val observadorTimeFora = Observer<Int> { pontos -> binding.placarTimeForaTextView.text = pontos.toString() }

        primeiroViewModel.getScoreCasa().observe(viewLifecycleOwner, observadorTimeCasa)
        primeiroViewModel.getScoreFora().observe(viewLifecycleOwner, observadorTimeFora)

        binding.timeCasa3PontosButton.setOnClickListener {
            primeiroViewModel.adicionarPontosCasa(3)
        }

        binding.timeCasa2PontosButton.setOnClickListener {
            primeiroViewModel.adicionarPontosCasa(2)
        }

        binding.timeCasa1PontoButton.setOnClickListener {
            primeiroViewModel.adicionarPontosCasa(1)
        }

        binding.timeFora3PontosButton.setOnClickListener {
            primeiroViewModel.adicionarPontosFora(3)
        }

        binding.timeFora2PontosButton.setOnClickListener {
            primeiroViewModel.adicionarPontosFora(2)
        }

        binding.timeFora1PontoButton.setOnClickListener {
            primeiroViewModel.adicionarPontosFora(1)
        }
    }


}