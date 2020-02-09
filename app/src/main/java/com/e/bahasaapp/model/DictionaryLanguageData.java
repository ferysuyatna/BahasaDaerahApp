package com.e.bahasaapp.model;

import com.e.bahasaapp.R;

import java.util.ArrayList;

public class DictionaryLanguageData { // array to store data that will be displayed on RecyclerView
        public static String[] data = new String[] {
                "Bahasa Sunda",
                "Bahasa Bali",
                "Bahasa Bugis",
                "Bahasa Jawa",
                "Bahasa Aceh",
                "Bahasa Padang",
                "Bahasa NTT",
                "Bahasa Betawi"
        };

    private static int[] languageImages = new int[]{
            R.drawable.icon_bandung,
            R.drawable.icon_bali,
            R.drawable.sulawesi,
            R.drawable.jawa,
            R.drawable.aceh,
            R.drawable.padang,
            R.drawable.ntt,
            R.drawable.jakarta
    };

    public static ArrayList<DictionaryLanguage> getListData() {
        ArrayList<DictionaryLanguage> list = new ArrayList<>();
        for (int position = 0; position < data.length; position++) {
            DictionaryLanguage language = new DictionaryLanguage();
            language.setName(data[position]);
            language.setPhoto(languageImages[position]);
            list.add(language);
        }
        return list;
    }

}
