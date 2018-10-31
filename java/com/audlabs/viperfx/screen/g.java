package com.audlabs.viperfx.screen;

import android.text.Editable;
import android.text.TextWatcher;

class g implements TextWatcher {
    final /* synthetic */ ConvolverFragment a;

    g(ConvolverFragment convolverFragment) {
        this.a = convolverFragment;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.a(charSequence + "");
    }
}
