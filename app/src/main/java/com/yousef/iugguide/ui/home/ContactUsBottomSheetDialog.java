package com.yousef.iugguide.ui.home;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.R;
import com.yousef.iugguide.helpers.DataHelper;
import com.yousef.iugguide.models.Contact;

import java.util.ArrayList;

public class ContactUsBottomSheetDialog extends BottomSheetDialogFragment {

    private CardView contactCard;

    private TextView titleTextView;
    private TextView urlTextView;
    private TextView emailTextView;
    private TextView aboutTextView;

    private AutoCompleteTextView spinner1;
    private AutoCompleteTextView spinner2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bottomsheet_contact_us, container, false);

        contactCard = rootView.findViewById(R.id.contact_card);

        titleTextView = rootView.findViewById(R.id.title);
        urlTextView = rootView.findViewById(R.id.url);
        emailTextView = rootView.findViewById(R.id.email);
        aboutTextView = rootView.findViewById(R.id.about);

        spinner1 = rootView.findViewById(R.id.spinner1);
        spinner2 = rootView.findViewById(R.id.spinner2);

        spinner1.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, new String[]{"الكليات", "العمادات", "المراكز"}));

        ArrayList<String> emails = new ArrayList<>();

        spinner1.setOnItemClickListener((parent, arg1, pos, id) -> {
            emails.clear();
            contactCard.setVisibility(View.GONE);

            for (int j = 0; j < AppClass.contactsArrayList.size(); j++) {
                switch (pos) {
                    case 0:
                        if (AppClass.contactsArrayList.get(j).getType().equals("faculty"))
                            emails.add(AppClass.contactsArrayList.get(j).getTitle());
                        break;

                    case 1:
                        if (AppClass.contactsArrayList.get(j).getType().equals("deanship"))
                            emails.add(AppClass.contactsArrayList.get(j).getTitle());
                        break;

                    case 2:
                        if (AppClass.contactsArrayList.get(j).getType().equals("center"))
                            emails.add(AppClass.contactsArrayList.get(j).getTitle());
                        break;

                    default:
                        emails.clear();
                        break;
                }
            }
        });
        spinner2.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, emails));

        spinner2.setOnItemClickListener((adapterView, view, i, l) -> {
            showContactInfo(emails.get(i));
        });

        return rootView;
    }

    private void showContactInfo(String title) {
        Contact contact = DataHelper.findContactByTitle(title);
        if (contact != null) {
            contactCard.setVisibility(View.VISIBLE);
            titleTextView.setText(contact.getTitle());
            urlTextView.setText("اضغط هنا");
            emailTextView.setText(contact.getEmail());
            aboutTextView.setText(contact.getAbout());

            urlTextView.setOnClickListener(view -> openWebPageFromUrl(contact.getUrl()));

            emailTextView.setOnClickListener(view -> {
                Intent email = new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse("mailto:" + contact.getEmail()));
                getContext().startActivity(email);
            });
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setOnShowListener(dialogInterface -> {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
            setupFullHeight(bottomSheetDialog);
        });
        return dialog;
    }

    private void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
        FrameLayout bottomSheet = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();

        int windowHeight = getWindowHeight();
        if (layoutParams != null)
            layoutParams.height = windowHeight;

        bottomSheet.setLayoutParams(layoutParams);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        behavior.setSkipCollapsed(true);
        behavior.setDraggable(false);
    }

    private int getWindowHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void openWebPageFromUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}