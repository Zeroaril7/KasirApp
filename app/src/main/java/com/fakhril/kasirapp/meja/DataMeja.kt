package com.fakhril.kasirapp.meja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fakhril.kasirapp.MainActivity
import com.fakhril.kasirapp.data.adapter.TableAdapter
import com.fakhril.kasirapp.data.entity.Meja
import com.fakhril.kasirapp.data.viewmodel.TableViewModel
import com.fakhril.kasirapp.databinding.ActivityDataMejaBinding

class DataMeja : AppCompatActivity() {

    private lateinit var binding :  ActivityDataMejaBinding
    private lateinit var tableViewModel: TableViewModel
    private var  tables = ArrayList<Meja>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataMejaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        tableViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[TableViewModel::class.java]

        initRvTable()

        binding.dataTableIbBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.dataTableFabAdd.setOnClickListener {
            startActivity(Intent(this, AddMeja::class.java))
            finish()
        }
    }

    private fun initRvTable() {
        val tableAdapter = TableAdapter(this, tables, tableViewModel)

        val rvTable = binding.dataTableRvTable
        rvTable.setHasFixedSize(true)
        rvTable.layoutManager = LinearLayoutManager(this)
        rvTable.adapter = tableAdapter

        tableViewModel.getTable.observe(this) { list ->
            list?.let {
                tables = it as ArrayList<Meja>
                tableAdapter.updateTable(tables)
            }
        }
    }
}

