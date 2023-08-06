package com.example.jtech;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class FAQFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_share, container, false);

        FAQItem[] faqItems = {
                new FAQItem("What are the available payment methods?", "We accept various payment methods, including credit/debit cards, PayPal, and cash on delivery for select areas."),
                new FAQItem("Do you offer international shipping?", "Currently, we only offer shipping within Lebanon."),
                new FAQItem("What is your return policy?", "We have a hassle-free return policy. If you're not satisfied with your purchase, you can return the product within 30 days for a full refund or exchange. Please ensure the item is in its original condition with all accessories and packaging."),
                new FAQItem("Are all products brand new?", "Yes, all our products are brand new and come with their respective warranties (if applicable)."),
                new FAQItem("How can I contact customer support?", "You can reach our friendly customer support team through email at support@jtech.com or by calling our helpline at +961 69696969. We're here to assist you with any queries or concerns."),
                new FAQItem("Can I place an order over the phone?", "Yes, you can place an order over the phone by calling our sales team at +961 44556089. They'll be happy to assist you with your purchase."),
                new FAQItem("Do you provide technical assistance for products?", "Absolutely! Our knowledgeable technical support team is available to help you with any product-related queries or troubleshooting. You can contact them through email or by visiting our store.")
        };

        ArrayList<FAQItem> faqItemList = new ArrayList<>(Arrays.asList(faqItems));

        ListView listView = rootView.findViewById(R.id.faqListView);
        FAQAdapter adapter = new FAQAdapter(requireContext(), faqItemList);

        listView.setAdapter(adapter);

        return rootView;
    }
}
