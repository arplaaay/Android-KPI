package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.lang.ClassCastException

class InputLangFragment : Fragment() {

    private lateinit var onLangSentListener: OnLangSent
    private lateinit var onShowStorageListener: ShowStorage

    interface OnLangSent {
        fun sendData(
            text: String
        )
    }

    interface ShowStorage {
        fun show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onLangSentListener = context as OnLangSent
            onShowStorageListener = context as ShowStorage
        } catch (e: ClassCastException) {
            throw ClassCastException(
                activity.toString()
                        + " must implement onLangSent"
            )
        }
    }

    private fun showStorage() {
        onShowStorageListener.show()
    }

    private fun passData(
        text: String
    ) {
        onLangSentListener.sendData(
            text
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_lang, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val spinner: Spinner = view?.findViewById(R.id.langSpinner) as Spinner
        val okButton: Button = view?.findViewById(R.id.okButton) as Button
        val cancelButton: Button = view?.findViewById(R.id.cancelButton) as Button
        val showStorageButton: Button = view?.findViewById(R.id.showButton) as Button

        this.context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.lang_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }

        okButton.setOnClickListener {
            val text = spinner.getSelectedItem().toString();
            passData(
                text
            )
            showStorage()
        }
        cancelButton.setOnClickListener {
            val text = ""
            passData(
                text
            )
            showStorage()
        }

        showStorageButton.setOnClickListener { showStorage() }
    }
}
