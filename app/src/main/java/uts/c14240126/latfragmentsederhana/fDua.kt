package uts.c14240126.latfragmentsederhana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class fDua : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_f_dua, container, false)

        val btnOpenFDua = view.findViewById<Button>(R.id.btnOpenFDua)
        btnOpenFDua.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fSatu())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val _tvHasil = view.findViewById<TextView>(R.id.tvHasil)

        var namaDiterima = ""
        var alamatDiterima = ""

        arguments?.let {
            namaDiterima = it.getString("Nama") ?: ""
            alamatDiterima = it.getString("Alamat") ?: ""
        }

        if (namaDiterima != "") {
            _tvHasil.text = "Halo $namaDiterima! Alamat Anda $alamatDiterima"
        }
    }
}
