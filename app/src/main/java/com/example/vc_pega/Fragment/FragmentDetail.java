package com.example.vc_pega.Fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.vc_pega.Model.Typess;
import com.example.vc_pega.R;
import com.example.vc_pega.activity.MainActivity;
import com.example.vc_pega.databinding.FragmentDetailBinding;

public class FragmentDetail extends Fragment {

    private FragmentDetailBinding fragmentDetailBinding;
    private PopupWindow popupMenu;
    private ClipboardManager clipboard;
    private ClipData clipData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        init();
        backClick();
        forwardClick();
        back();
        setHasOptionsMenu(true);
        popUpWindow();
        return fragmentDetailBinding.getRoot();
    }

    public String getUrl() {
        String url = getArguments().getString("url");
        return url;
    }

    private void init() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentDetailBinding.toolbar);

        fragmentDetailBinding.webview.getSettings().setLoadsImagesAutomatically(true);
        fragmentDetailBinding.webview.getSettings().setJavaScriptEnabled(true);
        fragmentDetailBinding.webview.loadUrl(getUrl());

        fragmentDetailBinding.webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                fragmentDetailBinding.contentLoad.setProgress(newProgress);
                fragmentDetailBinding.contentLoad.setProgress(newProgress);
                if (newProgress == 100) {
                    fragmentDetailBinding.contentLoad.setVisibility(View.GONE);
                }
            }
        });

        fragmentDetailBinding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                fragmentDetailBinding.edtUrl.setText(url);

                if (fragmentDetailBinding.webview.canGoBack()) {
                    Glide.with(getContext()).load(R.drawable.ic_back_true).into(fragmentDetailBinding.imgBack);
                } else {
                    Glide.with(getContext()).load(R.drawable.ic_back_false).into(fragmentDetailBinding.imgBack);
                }

                if (fragmentDetailBinding.webview.canGoForward()) {
                    Glide.with(getContext()).load(R.drawable.ic_forward_true).into(fragmentDetailBinding.imgForward);
                } else {
                    Glide.with(getContext()).load(R.drawable.ic_forward_false).into(fragmentDetailBinding.imgForward);
                }
            }
        });

    }

    private void backClick() {
        fragmentDetailBinding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentDetailBinding.webview.goBack();
            }
        });
    }

    private void forwardClick() {
        fragmentDetailBinding.imgForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentDetailBinding.webview.goForward();
            }
        });
    }

    private void back() {
        fragmentDetailBinding.imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() == null) {
                    return;
                }
                ((MainActivity) getActivity()).deleteDetail();
            }
        });
    }

    private void popUpWindow() {
        setPopUpWindow();
        fragmentDetailBinding.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.showAsDropDown(v, -140, 0);
            }
        });
    }

    private void setPopUpWindow() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_menu_detail, null);
        popupMenu = new PopupWindow(view, 550, ConstraintLayout.LayoutParams.WRAP_CONTENT, true);
        ImageView imgreload = view.findViewById(R.id.img_reload);
        ImageView imgshare = view.findViewById(R.id.img_share);
        TextView imgopen = view.findViewById(R.id.txt_openwweb);
        TextView imgcopy = view.findViewById(R.id.txt_copy);
        menuClick(imgreload, imgshare, imgopen, imgcopy);
    }

    private void menuClick(ImageView imgreload, ImageView imgshare, TextView txtopen, TextView txtcopy) {
        imgreload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.dismiss();
                fragmentDetailBinding.webview.reload();
            }
        });

        imgshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.dismiss();
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                share.putExtra(Intent.EXTRA_SUBJECT, "");
                share.putExtra(Intent.EXTRA_TEXT, fragmentDetailBinding.edtUrl.getText().toString());
                startActivity(Intent.createChooser(share, ""));
            }
        });

        txtopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fragmentDetailBinding.edtUrl.getText().toString()));
                startActivity(browserIntent);
                popupMenu.dismiss();
            }
        });

        txtcopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.dismiss();
                copyUrl();
            }
        });
    }

    private void copyUrl() {
        clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        clipData = ClipData.newPlainText(Typess.tag3, fragmentDetailBinding.edtUrl.getText().toString());
        clipboard.setPrimaryClip(clipData);
    }
}
