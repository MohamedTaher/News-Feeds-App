package com.taher.views

import android.content.Context
import com.taher.views.R
import com.taher.views.custom.SweetAlert.SweetAlertDialog

object DialogUtils {

    fun showLoadingDialog(context: Context, alertDialog: SweetAlertDialog?) {
        if (alertDialog == null) {
            return
        }

        if (alertDialog.isShowing) {
            alertDialog.hide()
        }

        alertDialog.titleText = context.getString(R.string.loading)
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun showConfirmDialog(context: Context, content: String, title:String, confirmBtn: String, cancelBtn: String, listener: SweetAlertDialog.OnSweetClickListener){
        SweetAlertDialog(context, SweetAlertDialog.NORMAL_TYPE)
            .setTitleText(title)
            .setContentText(content)
            .setConfirmText(confirmBtn)
            .setCancelText(cancelBtn)
            .setConfirmClickListener(listener)
            .show()
    }

    fun showErrorPopupDialogWithAction(context: Context, content: String?, positiveBtn: String, listener: SweetAlertDialog.OnSweetClickListener) {
        SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText(context.getString(R.string.error))
            .setContentText(content?:"")
            .setConfirmText(positiveBtn)
            .setConfirmClickListener(listener)
            .show()
    }

    fun showWarningDialog(context: Context, content: String, confirmBtn: String, cancelBtn: String, listener: SweetAlertDialog.OnSweetClickListener){
        SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
            .setTitleText(context.getString(R.string.warning))
            .setContentText(content)
            .setConfirmText(confirmBtn)
            .setCancelText(cancelBtn)
            .setConfirmClickListener(listener)
            .show()
    }

    fun hideLoadingDialog(alertDialog: SweetAlertDialog?) {
        if (alertDialog == null) {
            return
        }

        if (alertDialog.isShowing) {
            alertDialog.dismiss()
            //alertDialog = null
        }

    }

    fun showErrorPopupDialog(context: Context, content: String?, positiveBtn: String, listener: SweetAlertDialog.OnSweetClickListener?=null) {
        SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText(context.getString(R.string.error))
            .setContentText(content?:"")
            .setConfirmText(positiveBtn)
            .setConfirmClickListener(listener)
            .show()
    }

    fun showSuccessfulPopupDialog(context: Context, content: String?, positiveBtn: String, listener: SweetAlertDialog.OnSweetClickListener) {
        SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText(content?:"")
            .setConfirmText(positiveBtn)
            .setConfirmClickListener(listener)
            .show()
    }

}