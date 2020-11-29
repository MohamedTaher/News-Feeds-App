package com.taher.views

import java.util.regex.Pattern

object TextUtilise {

    fun isEmailValid(email: String): Pair<Boolean, Int> {
        var message = R.string.error
        var isValid = true
        val regExpn =
            "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"

        val pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        if (!matcher.matches()) {
            message = R.string.email_not_valid
            isValid = false
        }
        return Pair(isValid, message)
    }

    fun isPhoneValid(text: String): Boolean {
        if (text.count() < 12) {
            return false
        }
//        return when {
//            text.matches(Regex("[+][\\d]+")) -> true
//            //validating phone number with -, . or spaces
//            text.matches(Regex("\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}")) -> true
//            //validating phone number with extension length from 3 to 5
//            text.matches(Regex("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) -> true
//            //validating phone number where area code is in braces ()
//            text.matches(Regex("\\(\\d{3}\\)-\\d{3}-\\d{4}")) -> true
//            //return false if nothing matches the input
//            else -> false
//        }
        return true
    }

    fun isPasswordValid(password: String): Pair<Boolean, Int> {
        var message = R.string.error
        var isValid = true
        if (password.length < 6) {
            message = R.string.password_length_not_valid
            isValid = false
        }
        return Pair(isValid, message)
    }

    fun isRePasswordValid(password: String, passwordConfirm: String): Boolean {
        return password == passwordConfirm && passwordConfirm.isNotEmpty()
    }

    fun isTextHasMail(text: String): Boolean {
        val regExpn = "[\\w]+[\\d\\w]*(@)[\\w]+[\\w\\d]*(\\.)[\\w]+"
        val pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(text)
        if (!matcher.matches()) {
            return false
        }

        return true
    }

    fun isTextHasPhoneNumber(text: String): Boolean {
        return when {
            text.matches(Regex("[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]*\\d{10}[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]*")) -> true
            //validating phone number with -, . or spaces
            text.matches(Regex("[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]*\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]*")) -> true
            //validating phone number with extension length from 3 to 5
            text.matches(Regex("[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]*\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]*")) -> true
            //validating phone number where area code is in braces ()
            text.matches(Regex("[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]*\\(\\d{3}\\)-\\d{3}-\\d{4}[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]*")) -> true
            //return false if nothing matches the input
            else -> false
        }
    }
}