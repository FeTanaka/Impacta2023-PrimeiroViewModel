package br.com.impacta.curso.primeiroviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PrimeiroViewModel: ViewModel() {

    private val _scoreCasa: MutableLiveData<Int> = MutableLiveData(0)
    private val _scoreFora: MutableLiveData<Int> = MutableLiveData(0)

    fun getScoreCasa(): LiveData<Int> = _scoreCasa
    fun getScoreFora(): LiveData<Int> = _scoreFora

    fun adicionarPontosCasa(quantidade: Int) {
        _scoreCasa.value = _scoreCasa.value?.plus(quantidade)
    }

    fun adicionarPontosFora(quantidade: Int) {
        _scoreFora.value = _scoreFora.value?.plus(quantidade)
    }

}