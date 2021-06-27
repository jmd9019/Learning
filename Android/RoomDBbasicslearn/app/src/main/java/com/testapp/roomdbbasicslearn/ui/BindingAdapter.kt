package com.testapp.roomdbbasicslearn.ui

import android.widget.Button
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["inputName","inputEmail"],requireAll = true)
fun bindEditTextName(button: Button,name:String?,email:String?) {
    button.isClickable = !(name.isNullOrEmpty() || email.isNullOrEmpty())
}