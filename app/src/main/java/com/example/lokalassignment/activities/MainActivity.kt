package com.example.lokalassignment.activities

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.lokalassignment.R
import com.example.lokalassignment.adapter.DialogImagesAdapter
import com.example.lokalassignment.adapter.ProductAdapter
import com.example.lokalassignment.databinding.ActivityMainBinding
import com.example.lokalassignment.databinding.ProductDialogLayoutBinding
import com.example.lokalassignment.dataclasses.Product
import com.example.lokalassignment.viewmodel.ProductViewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: ProductViewModel by lazy {
        ViewModelProvider(this).get(ProductViewModel::class.java)
    }
    var mainAdapter= ProductAdapter()
    var dialogAdapter= DialogImagesAdapter()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recycMain.adapter=mainAdapter
        mainAdapter.setOnProductClickListener {
           showDialog(it)
        }
        viewModel.productResponse.observe(this){
           mainAdapter.setDataSet(it.products)
        }

        viewModel.getProducts {
            Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
        }
    }
    private fun showDialog(product: Product) {
        val _binding = ProductDialogLayoutBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this).setView(_binding.root).create()
        dialog.setCanceledOnTouchOutside(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
        _binding.product = product
        dialogAdapter = DialogImagesAdapter();
        _binding.recycDialog.adapter=dialogAdapter
        dialogAdapter.setDataSet(product.images)

        dialog.show()
    }
}
